#!/usr/bin/env python3
"""
Recursively build AsciiDoc slide decks under a directory into reveal.js HTML
(or PDF), using the Spengergasse reveal.js theme from resources/
(docinfo-revealjs.html) - matching the
convention of convert_marp.py and convert_adoc.py.

A "reveal.js deck" is any *.adoc file whose header sets a `:revealjs_` attribute
(this skips the regular AsciiDoc documents built by convert_adoc.py).

Output is written next to the source file as index.html (matching the
convention the course landing pages link to), and for --format pdf as
<lecture-dir>.pdf, e.g. 04_Streams_Intermediate/04_Streams_Intermediate.pdf.

Usage:
    scripts/convert_revealjs.py <directory>
    scripts/convert_revealjs.py <directory> --format pdf

Requires `asciidoctor-revealjs` on PATH (gem install asciidoctor-revealjs).
reveal.js itself is loaded from a CDN. --format pdf additionally needs
Node/npx (decktape is fetched on demand via npx).
"""
import argparse
import subprocess
import sys
from pathlib import Path

RESOURCES_DIR = Path(__file__).resolve().parent.parent / "resources"
REVEALJS_DIR = "https://cdn.jsdelivr.net/npm/reveal.js@4.1.2"
# Replaces the reveal.js highlight plugin's default monokai (dark) theme
HIGHLIGHTJS_THEME = "https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/styles/github.min.css"


def is_revealjs_deck(path: Path) -> bool:
    try:
        head = path.read_text(encoding="utf-8")[:2000]
    except (UnicodeDecodeError, OSError):
        return False
    return ":revealjs_" in head


def find_decks(root: Path):
    return sorted(p for p in root.rglob("*.adoc") if is_revealjs_deck(p))


def build_html(adoc_path: Path) -> Path:
    out_path = adoc_path.parent / "index.html"
    subprocess.run([
        "asciidoctor-revealjs",
        "-a", f"revealjsdir={REVEALJS_DIR}",
        "-a", f"highlightjs-theme={HIGHLIGHTJS_THEME}",
        "-a", "docinfo=shared",
        "-a", f"docinfodir={RESOURCES_DIR}",
        "-o", str(out_path),
        str(adoc_path),
    ], capture_output=True, text=True, check=True)
    return out_path


def build_pdf(html_path: Path) -> Path:
    out_path = html_path.parent / f"{html_path.parent.name}.pdf"
    subprocess.run([
        "npx", "--yes", "decktape@3.12.0", "reveal", "--size", "1280x720",
        html_path.resolve().as_uri(), str(out_path),
    ], capture_output=True, text=True, check=True)
    return out_path


def convert(adoc_path: Path, fmt: str) -> bool:
    try:
        out_path = build_html(adoc_path)
        if fmt == "pdf":
            out_path = build_pdf(out_path)
    except subprocess.CalledProcessError as e:
        print(f"FAIL {adoc_path}\n{(e.stderr or e.stdout).strip()}", file=sys.stderr)
        return False
    print(f"OK   {adoc_path} -> {out_path.name}")
    return True


def main():
    parser = argparse.ArgumentParser(
        description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter
    )
    parser.add_argument("directory", type=Path, help="Directory to search recursively for reveal.js decks")
    parser.add_argument("--format", choices=["html", "pdf"], default="html", help="Output format (default: html)")
    args = parser.parse_args()

    if not args.directory.is_dir():
        print(f"error: {args.directory} is not a directory", file=sys.stderr)
        sys.exit(1)

    decks = find_decks(args.directory)
    if not decks:
        print(f"No reveal.js decks found under {args.directory}")
        return

    print(f"Found {len(decks)} reveal.js deck(s) under {args.directory}\n")
    failures = sum(1 for adoc in decks if not convert(adoc, args.format))

    print(f"\n{len(decks) - failures}/{len(decks)} converted successfully")
    if failures:
        sys.exit(1)


if __name__ == "__main__":
    main()
