#!/usr/bin/env python3
"""Wrap bare text inside <div class="highlight-box"> in <p> tags."""

import re
from pathlib import Path

HIF = Path(__file__).resolve().parent

div_re = re.compile(
    r'(<div class="highlight-box[^"]*">)\s*(.*?)\s*(</div>)',
    re.DOTALL,
)

changed = 0
total = 0

for f in sorted(HIF.rglob("slides/index.html")):
    total += 1
    content = f.read_text(encoding="utf-8")

    def wrap(m):
        inner = m.group(2).strip()
        if inner and not inner.startswith("<"):
            return m.group(1) + "<p>" + inner + "</p>" + m.group(3)
        return m.group(0)

    new = div_re.sub(wrap, content)
    if new != content:
        f.write_text(new, encoding="utf-8")
        print(f"✓ {f.relative_to(HIF)}")
        changed += 1

print(f"\nDone — {changed} of {total} file(s) modified.")
