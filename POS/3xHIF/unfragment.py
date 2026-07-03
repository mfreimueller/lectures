#!/usr/bin/env python3
"""
unfragment.py — Remove class="fragment" from <li> inside Agenda and Learning
                 Objectives sections in all 3xHIF slide files.

Produces slide decks where those bullet lists are visible on slide entry
rather than stepped in one-by-one.
"""

import re
from pathlib import Path

HIF = Path(__file__).resolve().parent

pattern = re.compile(
    r'(<section[^>]*>\s*<h2>(?:Agenda|Learning Objectives).*?</section>)',
    re.DOTALL,
)

changed = 0
total = 0

for f in sorted(HIF.rglob("slides/index.html")):
    total += 1
    content = f.read_text(encoding="utf-8")

    def strip_fragment(m):
        sec = m.group(1)
        return re.sub(r'<li\s+class="fragment"', "<li", sec)

    new = pattern.sub(strip_fragment, content)
    if new != content:
        f.write_text(new, encoding="utf-8")
        print(f"✓ {f.relative_to(HIF)}")
        changed += 1

print(f"\nDone — {changed} of {total} file(s) modified.")
