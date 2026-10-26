#!/usr/bin/env python3
"""
Convert Marp slide decks (*.md with `marp: true`) into AsciiDoc decks for
asciidoctor-revealjs. The .adoc file is written next to the source .md
(same stem); build it with scripts/convert_revealjs.py.

Mapping (covers every Marp construct used in this repo):

    front matter (lang, paginate)          -> document header attributes
    <!-- _class: lead --> # T / ## S       -> doc title "T | S" (reveal title slide)
    <!-- _class: invert/lead -->           -> [.invert] / [.lead] slide role
    --- + ## Heading                       -> == Heading
    slide without heading                  -> == !
    ![bg contain alt](img)                 -> background-image / background-size
    ![width:Npx alt](img)                  -> image::img[alt,width=N]
    <div|aside class="highlight-box ..."> -> [.highlight-box.variant] open block
    other raw HTML blocks                  -> ++++ passthrough (reported)
    everything else                        -> pandoc (markdown -> asciidoc)

Usage:
    scripts/marp_to_adoc.py <file-or-directory> [...]
    scripts/marp_to_adoc.py <directory> --force   # overwrite existing .adoc

Requires `pandoc` on PATH.
"""
import argparse
import re
import subprocess
import sys
from dataclasses import dataclass, field
from pathlib import Path
from typing import Optional

PANDOC_MD = "markdown+lists_without_preceding_blankline+hard_line_breaks-implicit_figures-smart"

FENCE_RE = re.compile(r"^\s*(```|~~~)")
DIRECTIVE_RE = re.compile(r"^\s*<!--\s*(_?[a-zA-Z]+)\s*:\s*(.*?)\s*-->\s*$")
HEADING_RE = re.compile(r"^(#{1,2})\s+(.*?)\s*#*\s*$")
BG_RE = re.compile(r"^\s*!\[bg\b([^\]]*)\]\(([^)]+)\)\s*$")
IMG_SIZE_RE = re.compile(r"!\[\s*(width|height|w|h):(\d+)(?:px)?\s*([^\]]*)\]\(([^)]+)\)")
BOX_RE = re.compile(r'<(div|aside) class="highlight-box\s*([\w\s-]*)">(.*?)</\1>', re.S)
BR_RE = re.compile(r"\s*<br\s*/?>\s*")
HTML_BLOCK_START_RE = re.compile(r"^<(table|div|details|figure|iframe|section|ul|ol|p)\b", re.I)


@dataclass
class Slide:
    roles: list = field(default_factory=list)
    attrs: dict = field(default_factory=dict)
    title: Optional[str] = None
    body: str = ""


def parse_front_matter(text: str):
    if not text.startswith("---"):
        return {}, text
    end = text.find("\n---", 3)
    fm = {}
    for line in text[3:end].splitlines():
        if ":" in line:
            k, v = line.split(":", 1)
            fm[k.strip()] = v.strip()
    return fm, text[end + 4:]


def split_slides(body: str):
    """Split on `---` separator lines that are not inside a code fence."""
    slides, cur, in_fence = [], [], False
    for line in body.splitlines():
        if FENCE_RE.match(line):
            in_fence = not in_fence
        if not in_fence and line.strip() == "---":
            slides.append("\n".join(cur))
            cur = []
        else:
            cur.append(line)
    slides.append("\n".join(cur))
    return [s for s in slides if s.strip()]


def parse_slide(raw: str, warnings: list) -> Slide:
    slide = Slide()
    out, in_fence = [], False
    for line in raw.splitlines():
        if FENCE_RE.match(line):
            in_fence = not in_fence
        if in_fence:
            out.append(line)
            continue
        if m := DIRECTIVE_RE.match(line):
            key, val = m.groups()
            if key.lstrip("_") == "class":
                slide.roles += val.split()
            else:
                warnings.append(f"unsupported directive {key}: {val}")
            continue
        if m := BG_RE.match(line):
            opts, src = m.groups()
            slide.attrs["background-image"] = src
            words = opts.split()
            size = next((w for w in words if w in ("contain", "cover", "fit")), None)
            if size:
                slide.attrs["background-size"] = "contain" if size == "fit" else size
            if any(w in ("left", "right") or w.startswith("left:") or w.startswith("right:") for w in words):
                warnings.append(f"split background not supported: {line.strip()}")
            continue
        if slide.title is None and (m := HEADING_RE.match(line)) and not "".join(out).strip():
            slide.title = m.group(2)
            continue
        out.append(line)
    slide.body = "\n".join(out).strip()
    return slide


def protect_html(body: str, boxes: list, raw_blocks: list, warnings: list) -> str:
    """Swap highlight boxes and raw HTML blocks for placeholder paragraphs."""
    def box_sub(m):
        boxes.append((m.group(2).split(), m.group(3).strip()))
        return f"\n\nMARPBOX{len(boxes) - 1}X\n\n"

    # boxes may span lines, so work on joined text segments outside code fences
    out, in_fence, segments, buf = [], False, [], []
    for line in body.splitlines():
        if FENCE_RE.match(line):
            if not in_fence:
                segments.append(("text", "\n".join(buf)))
                buf = []
            in_fence = not in_fence
            buf.append(line)
            if not in_fence:
                segments.append(("code", "\n".join(buf)))
                buf = []
            continue
        buf.append(line)
    segments.append(("code" if in_fence else "text", "\n".join(buf)))

    for kind, seg in segments:
        if kind == "code":
            out.append(seg)
            continue
        seg = BOX_RE.sub(box_sub, seg)
        seg = BR_RE.sub("\n", seg)
        # remaining raw HTML blocks: from an opening tag at line start to the next blank line
        seg_lines, j, kept = seg.splitlines(), 0, []
        while j < len(seg_lines):
            if HTML_BLOCK_START_RE.match(seg_lines[j].lstrip()):
                block = []
                while j < len(seg_lines) and seg_lines[j].strip():
                    block.append(seg_lines[j])
                    j += 1
                raw_blocks.append("\n".join(block))
                warnings.append(f"raw HTML passed through: {block[0].strip()[:60]}")
                kept += ["", f"MARPRAW{len(raw_blocks) - 1}X", ""]
                continue
            kept.append(seg_lines[j])
            j += 1
        out.append("\n".join(kept))
    return "\n".join(out)


def pandoc(text: str, src_format: str) -> str:
    result = subprocess.run(
        ["pandoc", "-f", src_format, "-t", "asciidoc", "--wrap=none"],
        input=text, capture_output=True, text=True, check=True,
    )
    return result.stdout


def size_images(text: str) -> str:
    def sub(m):
        kind, n, alt, src = m.groups()
        attr = "width" if kind in ("width", "w") else "height"
        return f"![{alt.strip()}]({src}){{{attr}={n}}}"
    return IMG_SIZE_RE.sub(sub, text)


def postprocess(adoc: str) -> str:
    """Standalone inline images become block images; body headings become discrete."""
    out, in_listing = [], False
    for line in adoc.splitlines():
        if line == "----":
            in_listing = not in_listing
        if not in_listing:
            if re.fullmatch(r"image:[^:\s].*\]", line):
                line = "image::" + line[len("image:"):]
            elif re.match(r"^=+ ", line):
                out.append("[discrete]")
        out.append(line)
    return "\n".join(out)


ROLE_BACKGROUNDS = {"invert": "#1A1A1A", "lead": "#ED1944"}


def attr_list(slide: Slide) -> str:
    # reveal.js paints slide backgrounds outside the section, so roles alone can't color them
    for role in slide.roles:
        if role in ROLE_BACKGROUNDS:
            slide.attrs.setdefault("background-color", ROLE_BACKGROUNDS[role])
    parts = ["." + ".".join(slide.roles)] if slide.roles else []
    parts += [f'{k}="{v}"' for k, v in slide.attrs.items()]
    return f"[{','.join(parts)}]\n" if parts else ""


def convert_deck(md_path: Path):
    warnings = []
    fm, body = parse_front_matter(md_path.read_text(encoding="utf-8"))
    slides = [parse_slide(s, warnings) for s in split_slides(body)]

    title, subtitle = md_path.stem, None
    if slides and "lead" in slides[0].roles:
        lead = slides.pop(0)
        title = lead.title or title
        sub = HEADING_RE.match(lead.body.splitlines()[0]) if lead.body else None
        if sub:
            subtitle = sub.group(2)
            rest = "\n".join(lead.body.splitlines()[1:]).strip()
            if rest:
                warnings.append("extra content on title slide dropped")

    boxes, raw_blocks = [], []
    md = "\n\n".join(
        f"MARPSLIDE{i}X\n\n" + protect_html(size_images(s.body), boxes, raw_blocks, warnings)
        for i, s in enumerate(slides)
    )
    converted = postprocess(pandoc(md, PANDOC_MD))

    if boxes:
        box_html = "\n".join(f"<p>MARPBOXSEP{i}X</p>\n{inner}" for i, (_, inner) in enumerate(boxes))
        box_adoc = re.split(r"MARPBOXSEP\d+X\n", pandoc(box_html, "html"))[1:]
        for i, ((variants, _), content) in enumerate(zip(boxes, box_adoc)):
            role = ".".join(["highlight-box", *variants])
            block = f"[.{role}]\n--\n{content.strip()}\n--"
            converted = converted.replace(f"MARPBOX{i}X", block, 1)
    for i, raw in enumerate(raw_blocks):
        converted = converted.replace(f"MARPRAW{i}X", f"++++\n{raw}\n++++", 1)

    bodies = re.split(r"^MARPSLIDE\d+X\n", converted, flags=re.M)[1:]

    header = [f"= {title}" + (f" | {subtitle}" if subtitle else "")]
    header += [
        ":title-separator: |",
        f":lang: {fm.get('lang', 'de')}",
        ":revealjs_theme: white",
        ":revealjs_width: 1280",
        ":revealjs_height: 720",
        ":revealjs_transition: none",
        ":revealjs_hash: true",
        ":source-highlighter: highlightjs",
        f":title-slide-background-color: {ROLE_BACKGROUNDS['lead']}",
    ]
    if fm.get("paginate") == "true":
        header.append(":revealjs_slideNumber: c/t")

    parts = ["\n".join(header)]
    for slide, content in zip(slides, bodies):
        parts.append(f"{attr_list(slide)}== {slide.title or '!'}\n\n{content.strip()}".rstrip())
    adoc = "\n\n".join(parts) + "\n"
    return adoc, warnings


def is_marp_markdown(path: Path) -> bool:
    try:
        head = path.read_text(encoding="utf-8")[:1000]
    except (UnicodeDecodeError, OSError):
        return False
    return head.startswith("---") and "marp: true" in head[: head.find("\n---", 3)]


def main():
    parser = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    parser.add_argument("paths", nargs="+", type=Path, help="Marp .md files or directories to search recursively")
    parser.add_argument("--force", action="store_true", help="Overwrite existing .adoc files")
    args = parser.parse_args()

    decks = []
    for p in args.paths:
        decks += sorted(q for q in p.rglob("*.md") if is_marp_markdown(q)) if p.is_dir() else [p]

    failures = 0
    for md in decks:
        out = md.with_suffix(".adoc")
        if out.exists() and not args.force:
            print(f"SKIP {out} (exists, use --force)")
            continue
        try:
            adoc, warnings = convert_deck(md)
        except subprocess.CalledProcessError as e:
            print(f"FAIL {md}\n{e.stderr.strip()}", file=sys.stderr)
            failures += 1
            continue
        out.write_text(adoc, encoding="utf-8")
        print(f"OK   {md} -> {out.name}")
        for w in warnings:
            print(f"     warn: {w}")

    print(f"\n{len(decks) - failures}/{len(decks)} converted")
    sys.exit(1 if failures else 0)


if __name__ == "__main__":
    main()
