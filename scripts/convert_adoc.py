#!/usr/bin/env python3
"""
Recursively convert AsciiDoc (.adoc) files to HTML or PDF, using the shared
Spengergasse theme resources (doc stylesheet for HTML, PDF theme for PDF)
from resources/ - matching the convention used for the Marp theme in
convert_marp.py.

Diagrams embedded via asciidoctor-diagram blocks (e.g. [plantuml, name, svg],
[graphviz, name, svg], [mermaid, name, svg]) are resolved automatically and
written next to the source file, alongside the .html/.pdf output.

Usage:
    scripts/convert_adoc.py <directory>
    scripts/convert_adoc.py <directory> --format pdf
    scripts/convert_adoc.py <directory> --stylesheet other-theme.css
    scripts/convert_adoc.py <directory> --format pdf --pdf-theme other-theme.yml

Requires `asciidoctor` and `asciidoctor-diagram` on PATH
(gem install asciidoctor asciidoctor-diagram), plus `asciidoctor-pdf` for
--format pdf (gem install asciidoctor-pdf). Diagram backends used by
asciidoctor-diagram (e.g. plantuml, dot, mmdc) must be installed separately.
"""
import argparse
import subprocess
import sys
from pathlib import Path

RESOURCES_DIR = Path(__file__).resolve().parent.parent / "resources"
DEFAULT_STYLESHEET = "spengergasse-doc-theme.css"
DEFAULT_PDF_THEME = "spengergasse-pdf-theme.yml"


def find_adoc_files(root: Path):
    return sorted(p for p in root.rglob("*.adoc"))


def convert(adoc_path: Path, fmt: str, stylesdir: Path, stylesheet: str, pdf_theme: Path) -> bool:
    if fmt == "pdf":
        out_path = adoc_path.with_suffix(".pdf")
        cmd = [
            "asciidoctor-pdf", "-r", "asciidoctor-diagram",
            "-a", f"pdf-theme={pdf_theme}",
            "-o", str(out_path),
            str(adoc_path),
        ]
    else:
        out_path = adoc_path.with_suffix(".html")
        cmd = [
            "asciidoctor", "-r", "asciidoctor-diagram",
            "-a", f"stylesdir={stylesdir}",
            "-a", f"stylesheet={stylesheet}",
            "-a", "linkcss",
            "-o", str(out_path),
            str(adoc_path),
        ]

    result = subprocess.run(cmd, capture_output=True, text=True)
    if result.returncode != 0:
        print(f"FAIL {adoc_path}\n{result.stderr.strip()}", file=sys.stderr)
        return False
    print(f"OK   {adoc_path} -> {out_path.name}")
    return True


def main():
    parser = argparse.ArgumentParser(
        description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter
    )
    parser.add_argument("directory", type=Path, help="Directory to search recursively for .adoc files")
    parser.add_argument("--format", choices=["html", "pdf"], default="html", help="Output format (default: html)")
    parser.add_argument("--stylesheet", default=DEFAULT_STYLESHEET,
                        help=f"Stylesheet filename inside --stylesdir (default: {DEFAULT_STYLESHEET}); ignored for --format pdf")
    parser.add_argument("--stylesdir", type=Path, default=RESOURCES_DIR,
                        help=f"Directory containing the stylesheet (default: {RESOURCES_DIR}); ignored for --format pdf")
    parser.add_argument("--pdf-theme", type=Path, default=RESOURCES_DIR / DEFAULT_PDF_THEME,
                        help=f"Path to the asciidoctor-pdf theme YAML (default: {RESOURCES_DIR / DEFAULT_PDF_THEME}); ignored for --format html")
    args = parser.parse_args()

    if not args.directory.is_dir():
        print(f"error: {args.directory} is not a directory", file=sys.stderr)
        sys.exit(1)

    if args.format == "html" and not (args.stylesdir / args.stylesheet).is_file():
        print(
            f"warning: stylesheet not found: {args.stylesdir / args.stylesheet} "
            f"(output will link a missing stylesheet)",
            file=sys.stderr,
        )
    if args.format == "pdf" and not args.pdf_theme.is_file():
        print(f"error: PDF theme not found: {args.pdf_theme}", file=sys.stderr)
        sys.exit(1)

    adoc_files = find_adoc_files(args.directory)
    if not adoc_files:
        print(f"No .adoc files found under {args.directory}")
        return

    print(f"Found {len(adoc_files)} .adoc file(s) under {args.directory}\n")
    failures = sum(
        1 for f in adoc_files
        if not convert(f, args.format, args.stylesdir, args.stylesheet, args.pdf_theme)
    )

    print(f"\n{len(adoc_files) - failures}/{len(adoc_files)} converted successfully")
    if failures:
        sys.exit(1)


if __name__ == "__main__":
    main()
