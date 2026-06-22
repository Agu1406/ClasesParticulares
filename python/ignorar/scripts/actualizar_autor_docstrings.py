#!/usr/bin/env python3
"""Actualiza el bloque de autor en los docstrings de los archivos Python."""
from pathlib import Path

FULL = """Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev"""

OLD_WITH_CONTACT = """Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es"""

OLD_AUTHOR_ONLY = "Autor: Agustin. A. Marquez. Pina"

SKIP_MARKERS = ("Repositorio GitHub:", "agustinmarquez.dev")

ROOT = Path(__file__).resolve().parents[2]
roots = [ROOT / "src", ROOT / "ignorar" / "scripts"]


def insert_in_module_docstring(text: str) -> str | None:
    for quote in ('"""', "'''"):
        if not text.startswith(quote):
            continue
        end = text.find(quote, 3)
        if end == -1:
            continue
        before = text[:end].rstrip("\n") + "\n"
        after = text[end:]
        return before + "\n" + FULL + after
    return None


def main() -> None:
    updated: list[Path] = []
    added: list[Path] = []
    skipped: list[Path] = []

    for root in roots:
        if not root.exists():
            continue
        for path in root.rglob("*.py"):
            if path.name == Path(__file__).name:
                continue

            text = path.read_text(encoding="utf-8")
            if any(marker in text for marker in SKIP_MARKERS):
                skipped.append(path)
                continue

            new_text = text
            if OLD_WITH_CONTACT in new_text:
                new_text = new_text.replace(OLD_WITH_CONTACT, FULL, 1)
            elif OLD_AUTHOR_ONLY in new_text:
                new_text = new_text.replace(OLD_AUTHOR_ONLY, FULL, 1)
            elif "Autor: Agustin. A. Marquez. Pina" not in new_text:
                inserted = insert_in_module_docstring(new_text)
                if inserted is not None:
                    new_text = inserted
                    added.append(path)

            if new_text != text:
                path.write_text(new_text, encoding="utf-8", newline="\n")
                if path not in added:
                    updated.append(path)

    print(f"Actualizados (reemplazo): {len(updated)}")
    print(f"Anadidos (sin autor previo): {len(added)}")
    print(f"Omitidos (ya tenian enlaces): {len(skipped)}")
    if added:
        print("Archivos con bloque anadido:")
        for item in added:
            print(f" - {item.relative_to(ROOT)}")


if __name__ == "__main__":
    main()
