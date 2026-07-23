#!/usr/bin/env python3
"""
Recursively convert Graphviz (.dot) files to SVG or PNG using the local
`dot` binary.

Output is written next to each .dot source file, matching the convention
used for .puml (convert_puml.py) and .mmd files in this repo.

Usage:
    scripts/convert_dot.py <directory>
    scripts/convert_dot.py <directory> --image-format png

Requires Graphviz's `dot` on PATH (brew install graphviz).
"""
import argparse
import subprocess
import sys
from pathlib import Path


def find_dot_files(root: Path):
    return sorted(p for p in root.rglob("*.dot"))


def convert(dot_path: Path, img_fmt: str) -> bool:
    out_path = dot_path.with_suffix(f".{img_fmt}")
    cmd = ["dot", f"-T{img_fmt}", str(dot_path), "-o", str(out_path)]
    result = subprocess.run(cmd, capture_output=True, text=True)
    if result.returncode != 0:
        print(f"FAIL {dot_path}\n{result.stderr.strip()}", file=sys.stderr)
        return False
    print(f"OK   {dot_path} -> {out_path.name}")
    return True


def main():
    parser = argparse.ArgumentParser(
        description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter
    )
    parser.add_argument("directory", type=Path, help="Directory to search recursively for .dot files")
    parser.add_argument("--image-format", choices=["svg", "png"], default="svg",
                        help="Output image format (default: svg)")
    args = parser.parse_args()

    if not args.directory.is_dir():
        print(f"error: {args.directory} is not a directory", file=sys.stderr)
        sys.exit(1)

    dot_files = find_dot_files(args.directory)
    if not dot_files:
        print(f"No .dot files found under {args.directory}")
        return

    print(f"Found {len(dot_files)} .dot file(s) under {args.directory}\n")
    failures = sum(1 for f in dot_files if not convert(f, args.image_format))

    print(f"\n{len(dot_files) - failures}/{len(dot_files)} converted successfully")
    if failures:
        sys.exit(1)


if __name__ == "__main__":
    main()
