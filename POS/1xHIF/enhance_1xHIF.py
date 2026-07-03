#!/usr/bin/env python3
"""
enhance_1xHIF.py — Add Agenda and Lernziele slides to 1xHIF lessons,
wrap bare text in highlight-box, and normalize title dashes.

Usage:
  python3 enhance_1xHIF.py                     # all 23 lessons
  python3 enhance_1xHIF.py 05_Verzweigung       # single lesson
"""

import re
import sys
from pathlib import Path

HIF = Path(__file__).resolve().parent

# ---------------------------------------------------------------------------
# Helpers
# ---------------------------------------------------------------------------

def _strip_html(html: str) -> str:
    s = re.sub(r'</?code>', '', html)
    s = re.sub(r'</?strong>', '', html)
    return s


def _first_lower(text: str) -> str:
    """Lowercase first letter; preserve acronyms and German nouns."""
    if not text:
        return text
    if len(text) > 1 and text[1].isupper():
        return text
    return text[0].lower() + text[1:]


def _clean_dashes(text: str) -> str:
    """Normalize — and -- to - in plain text (not HTML)."""
    text = re.sub(r'\s*[—–]+\s*', ' - ', text)
    text = re.sub(r'\s*[-]{2,}\s*', ' - ', text)
    return text


def extract_headings(html: str) -> list[str]:
    """Return content <h2> texts, excluding structural slides."""
    headings = re.findall(r'<h2>(.*?)</h2>', html)
    exclude = {"Summary", "Zusammenfassung", "Agenda", "Lernziele", "Ausblick", "Übungen"}
    result = []
    for h in headings:
        text = _strip_html(h).strip()
        if text and not any(text.startswith(e) for e in exclude):
            result.append(h)
    return result


# ---------------------------------------------------------------------------
# Lernziele from h2 headings  (reliable, no Summary transformation)
# ---------------------------------------------------------------------------

def heading_to_lernziel(text: str) -> str:
    """Convert a single h2 heading into an 'Ich kann …' statement."""
    raw = text
    text = _clean_dashes(text)

    # 1 — Question patterns
    m = re.match(r'^Was ist (?:ein |eine |der |die |das )?(.+?)\??$', text)
    if m:
        return f"Ich kann erklären, was {m.group(1)} ist"

    m = re.match(r'^Was sind (.+?)\??$', text)
    if m:
        return f"Ich kann erklären, was {m.group(1)} sind"

    m = re.match(r'^(Warum|Wozu|Wofür) (.+?)\??$', text)
    if m:
        q = "warum" if m.group(1) == "Warum" else "wozu"
        return f"Ich kann erklären, {q} {_first_lower(m.group(2))}"

    # 2 — "Wiederholung: X" → "Ich kann X wiederholen"
    # Must come BEFORE generic colon rule
    m = re.match(r'^Wiederholung:\s+(.+)$', text)
    if m:
        return f"Ich kann {m.group(1)} wiederholen"

    # 3 — "Problem: X" → "Ich kann das Problem X beschreiben"
    m = re.match(r'^Problem:\s+(.+)$', text)
    if m:
        return f"Ich kann das Problem {_first_lower(m.group(1))} beschreiben"

    # 4 — "Häufige/r Fehler: X" → "Ich kann X vermeiden"
    m = re.match(r'^Häufige[rn]?\s+Fehler:?\s*(.+)$', text)
    if m:
        return f"Ich kann {_first_lower(m.group(1))} vermeiden"

    # 5 — "Beispiel: X" → "Ich kann ein Beispiel zu X umsetzen"
    m = re.match(r'^Beispiel:\s+(.+)$', text)
    if m:
        return f"Ich kann ein Beispiel zu {m.group(1)} umsetzen"

    # 6 — "X: Y" generic colon — only apply when Y is short (≤70 chars)
    m = re.match(r'^([^:].+?):\s+(.{,70})$', text)
    if m:
        topic, detail = m.group(1), m.group(2)
        return f"Ich kann {detail} im Bereich {topic} erklären"

    # 6 — "Der/Die/Das X" → "Ich kann X erklären/anwenden"
    m = re.match(r'^(Der|Die|Das|Ein|Eine)\s+(.+)$', text)
    if m:
        noun = m.group(2)
        verb = "anwenden" if '<' in raw else "erklären"
        return f"Ich kann {noun} {verb}"

    # 7 — "X vs. Y" → "Ich kann X und Y unterscheiden"
    m = re.match(r'^(.+?)\s+vs\.\s+(.+)$', text)
    if m:
        return f"Ich kann {_first_lower(m.group(1))} und {m.group(2)} unterscheiden"

    # 9 — Everything else → "Ich kann X erklären"
    return f"Ich kann {text} erklären"


# ---------------------------------------------------------------------------
# HTML builders
# ---------------------------------------------------------------------------

def build_agenda(headings: list[str]) -> str:
    """Agenda (1/2) / (2/2) from h2 headings."""
    items = [_clean_dashes(_strip_html(h).strip()) for h in headings]
    if not items:
        return ""

    MAX = 7
    parts = [items[i:i + MAX] for i in range(0, len(items), MAX)]
    result = ""
    for idx, chunk in enumerate(parts):
        label = f"Agenda ({idx + 1}/{len(parts)})" if len(parts) > 1 else "Agenda"
        start = f' start="{idx * MAX + 1}"' if idx > 0 else ""
        lis = "\n".join(f"<li>{item}</li>" for item in chunk)
        result += f"""            <section>
                <h2>{label}</h2>
                <ol{start}>
{lis}
                </ol>
            </section>

"""
    return result


def build_lernziele(headings: list[str], lesson_folder: str) -> str:
    """Lernziele slide from h2 headings, with lesson-specific overrides."""
    overrides = {
        "16_Übung_REPL": [
            "Ich kann erklären, was eine REPL ist und wofür sie verwendet wird",
            "Ich kann die vier Schritte Read-Eval-Print-Loop beschreiben",
            "Ich kann eine REPL in Java mit einer while-Schleife umsetzen",
            "Ich kann eine Echo-REPL programmieren",
            "Ich kann eine REPL im Dungeon Crawler Projekt einsetzen",
        ],
    }
    if lesson_folder in overrides:
        items = overrides[lesson_folder]
    else:
        items = []
        for h in headings:
            text = _strip_html(h).strip()
            if text:
                items.append(heading_to_lernziel(text))
        # Remove duplicates
        seen = set()
        unique = []
        for i in items:
            if i not in seen:
                seen.add(i)
                unique.append(i)
        items = unique


    if not items:
        return ""

    lis = "\n".join(f"<li>{item}</li>" for item in items)
    return f"""            <section>
                <h2>Lernziele</h2>
                <ul>
{lis}
                </ul>
            </section>

"""


# ---------------------------------------------------------------------------
# Transformations applied to full HTML
# ---------------------------------------------------------------------------

def wrap_highlight_text(html: str) -> str:
    """Wrap bare text inside <div class="highlight-box"> with <p>."""
    def _wrap(m):
        inner = m.group(2).strip()
        if inner and not inner.startswith("<"):
            return m.group(1) + "<p>" + inner + "</p>" + m.group(3)
        return m.group(0)

    return re.sub(
        r'(<div class="(?:fragment )?highlight-box(?: fragment)?">)\s*(.*?)\s*(</div>)',
        _wrap,
        html,
        flags=re.DOTALL,
    )


def normalize_dashes(html: str) -> str:
    """Normalize — (em dash) and -- to - in title, h1, h2."""
    html = re.sub(r'(<(?:title|h[12])>[^<]*?)\s*[—–]+\s*', r'\1 - ', html)
    html = re.sub(r'(<(?:title|h[12])>[^<]*?)\s*[-]{2,}\s*', r'\1 - ', html)
    return html


# ---------------------------------------------------------------------------
# Main
# ---------------------------------------------------------------------------

def process_file(path: Path) -> bool:
    """Insert Agenda + Lernziele, wrap bare text, fix dashes."""
    content = path.read_text(encoding="utf-8")
    changed = False
    lesson_folder = path.parent.parent.name

    # 1 — Extract data
    headings = extract_headings(content)

    # 2 — Build new slides
    agenda_html = build_agenda(headings)
    lernziele_html = build_lernziele(headings, lesson_folder)
    new_slides = agenda_html + lernziele_html

    # 3 — Insert after title slide
    if new_slides:
        m = re.search(r'(</section>)\s*', content)
        if m:
            pos = m.end()
            content = content[:pos] + "\n" + new_slides + content[pos:]
            changed = True

    # 4 — Wrap bare text in highlight-box
    before = content
    content = wrap_highlight_text(content)
    if content != before:
        changed = True

    # 5 — Normalize dashes
    before = content
    content = normalize_dashes(content)
    if content != before:
        changed = True

    if changed:
        path.write_text(content, encoding="utf-8")
        return True
    return False


def main():
    args = sys.argv[1:]
    targets = [HIF / a for a in args] if args else [HIF]

    changed = total = 0
    for t in targets:
        if not t.exists():
            print(f"⚠  {t} not found", file=sys.stderr)
            continue
        files = [t] if t.is_file() else sorted(t.rglob("slides/index.html"))
        for f in files:
            total += 1
            if process_file(f):
                print(f"✓ {f.relative_to(HIF)}")
                changed += 1

    print(f"\nDone — {changed} of {total} file(s) modified.")


if __name__ == "__main__":
    main()
