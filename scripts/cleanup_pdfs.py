#!/usr/bin/env python3
"""
Recursively delete all PDF files under a directory (default: the repo root).
PDFs in this repo are build outputs (convert_revealjs.py, convert_marp.py,
convert_adoc.py --format pdf) and can always be regenerated.

Usage:
    scripts/cleanup_pdfs.py               # whole repo
    scripts/cleanup_pdfs.py <directory>
    scripts/cleanup_pdfs.py --dry-run     # only list what would be deleted
"""
import argparse
import sys
from pathlib import Path

REPO_ROOT = Path(__file__).resolve().parent.parent


def main():
    parser = argparse.ArgumentParser(
        description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter
    )
    parser.add_argument("directory", type=Path, nargs="?", default=REPO_ROOT, help="Directory to clean (default: repo root)")
    parser.add_argument("--dry-run", action="store_true", help="List PDFs without deleting them")
    args = parser.parse_args()

    if not args.directory.is_dir():
        print(f"error: {args.directory} is not a directory", file=sys.stderr)
        sys.exit(1)

    pdfs = sorted(p for p in args.directory.rglob("*.pdf") if ".git" not in p.parts)
    for pdf in pdfs:
        if not args.dry_run:
            pdf.unlink()
        print(f"{'WOULD DELETE' if args.dry_run else 'DELETED'} {pdf}")

    print(f"\n{len(pdfs)} PDF file(s) {'found' if args.dry_run else 'deleted'}")


if __name__ == "__main__":
    main()
