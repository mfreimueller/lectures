#!/usr/bin/env python3
"""
Recursively convert PlantUML (.puml) files to PNG using the official
plantuml Docker image.

Output is written as .png next to each .puml source file.

Usage:
    scripts/convert_puml.py <directory>
    scripts/convert_puml.py <directory> --image-format svg

Requires Docker on PATH with the plantuml/plantuml image available
(pulled on first run).
"""
import argparse
import subprocess
import sys
from collections import defaultdict
from pathlib import Path

DOCKER_IMAGE = "plantuml/plantuml"


def find_puml_files(root: Path):
    return sorted(p for p in root.rglob("*.puml"))


def convert_batch(puml_files: list[Path], img_fmt: str) -> bool:
    """Convert all .puml files in the same directory in one Docker call."""
    if not puml_files:
        return True

    parent = puml_files[0].resolve().parent
    fmt_flag = f"-t{img_fmt}"

    cmd = [
        "docker", "run", "--rm",
        "-v", f"{parent}:/data",
        DOCKER_IMAGE,
        fmt_flag,
        *[f"/data/{f.name}" for f in puml_files],
    ]
    result = subprocess.run(cmd, capture_output=True, text=True)
    if result.returncode != 0:
        for f in puml_files:
            print(f"FAIL {f}\n{result.stderr.strip()}", file=sys.stderr)
        return False

    ext = f".{img_fmt}"
    for f in puml_files:
        out = f.with_suffix(ext)
        print(f"OK   {f} -> {out.name}")
    return True


def main():
    parser = argparse.ArgumentParser(
        description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter
    )
    parser.add_argument("directory", type=Path, help="Directory to search recursively for .puml files")
    parser.add_argument("--image-format", choices=["png", "svg"], default="png",
                        help="Output image format (default: png)")
    args = parser.parse_args()

    if not args.directory.is_dir():
        print(f"error: {args.directory} is not a directory", file=sys.stderr)
        sys.exit(1)

    puml_files = find_puml_files(args.directory)
    if not puml_files:
        print(f"No .puml files found under {args.directory}")
        return

    # Group by parent directory for batch conversion
    by_dir: dict[Path, list[Path]] = defaultdict(list)
    for f in puml_files:
        by_dir[f.resolve().parent].append(f)

    print(f"Found {len(puml_files)} .puml file(s) in {len(by_dir)} director(ies) under {args.directory}\n")

    failures = 0
    for directory in sorted(by_dir):
        if not convert_batch(by_dir[directory], args.image_format):
            failures += 1

    print(f"\n{len(puml_files) - failures * len(by_dir)}/{len(puml_files)} converted successfully")
    if failures:
        sys.exit(1)


if __name__ == "__main__":
    main()
