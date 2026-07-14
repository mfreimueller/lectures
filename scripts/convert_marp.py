#!/usr/bin/env python3
"""
Recursively convert Marp slide decks under a directory to HTML or PDF,
using the Spengergasse Marp theme by default.

A "Marp deck" is any *.md file whose front matter contains `marp: true`
(this correctly skips the many other *.md files in this repo - plan.md,
tasks.md, external.md, katas, etc.).

Output is written as index.<ext> next to the source file, matching the
convention used throughout this repo (<slides-dir>/<name>.md compiles
to <slides-dir>/index.html).

Usage:
    scripts/convert_marp.py <directory>
    scripts/convert_marp.py <directory> --format pdf
    scripts/convert_marp.py <directory> --format html --theme other-theme.css

Requires Node/npx on PATH (marp-cli is fetched on demand via npx).
"""
import argparse
import subprocess
import sys
from pathlib import Path

DEFAULT_THEME = Path(__file__).resolve().parent.parent / "resources" / "marp-theme.css"


def is_marp_markdown(path: Path) -> bool:
    try:
        with path.open("r", encoding="utf-8") as f:
            head = f.read(1000)
    except (UnicodeDecodeError, OSError):
        return False
    if not head.lstrip().startswith("---"):
        return False
    end = head.find("\n---", 3)
    frontmatter = head[:end] if end != -1 else head
    return "marp: true" in frontmatter


def find_marp_decks(root: Path):
    return sorted(p for p in root.rglob("*.md") if is_marp_markdown(p))


def convert(md_path: Path, fmt: str, theme: Path) -> bool:
    ext = "pdf" if fmt == "pdf" else "html"
    out_path = md_path.parent / f"index.{ext}"
    cmd = [
        "npx", "--yes", "@marp-team/marp-cli@latest", str(md_path),
        "--theme", str(theme),
        "--allow-local-files",
        "-o", str(out_path),
        "--pdf" if fmt == "pdf" else "--html",
    ]
    result = subprocess.run(cmd, capture_output=True, text=True)
    if result.returncode != 0:
        print(f"FAIL {md_path}\n{result.stderr.strip()}", file=sys.stderr)
        return False
    print(f"OK   {md_path} -> {out_path.name}")
    return True


def main():
    parser = argparse.ArgumentParser(
        description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter
    )
    parser.add_argument("directory", type=Path, help="Directory to search recursively for Marp decks")
    parser.add_argument("--format", choices=["html", "pdf"], default="html", help="Output format (default: html)")
    parser.add_argument("--theme", type=Path, default=DEFAULT_THEME, help="Path to the Marp theme CSS")
    args = parser.parse_args()

    if not args.directory.is_dir():
        print(f"error: {args.directory} is not a directory", file=sys.stderr)
        sys.exit(1)
    if not args.theme.is_file():
        print(f"error: theme file not found: {args.theme}", file=sys.stderr)
        sys.exit(1)

    decks = find_marp_decks(args.directory)
    if not decks:
        print(f"No Marp decks found under {args.directory}")
        return

    print(f"Found {len(decks)} Marp deck(s) under {args.directory}\n")
    failures = sum(1 for md in decks if not convert(md, args.format, args.theme))

    print(f"\n{len(decks) - failures}/{len(decks)} converted successfully")
    if failures:
        sys.exit(1)


if __name__ == "__main__":
    main()
