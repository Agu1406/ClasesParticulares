#!/usr/bin/env python3
"""Renumera archivos de teoria para que cada subtema empiece en U01."""
from __future__ import annotations

from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]

# Renombrar de mayor a menor dentro de cada carpeta para evitar colisiones.
RENAMES: list[tuple[Path, str]] = [
    (
        ROOT / "src/ev1/ut1_fundamentospython/u03inputcomentarios/teoria/U04_ComentariosIntro.py",
        "U02_ComentariosIntro.py",
    ),
    (
        ROOT / "src/ev1/ut1_fundamentospython/u03inputcomentarios/teoria/U03_InputIntro.py",
        "U01_InputIntro.py",
    ),
    (
        ROOT
        / "src/ev1/ut2_controlflujometodos/u01condicionales/teoria/U07_CondicionalesAnidadasIntro.py",
        "U04_CondicionalesAnidadasIntro.py",
    ),
    (
        ROOT / "src/ev1/ut2_controlflujometodos/u01condicionales/teoria/U06_MatchCaseIntro.py",
        "U03_MatchCaseIntro.py",
    ),
    (
        ROOT / "src/ev1/ut2_controlflujometodos/u01condicionales/teoria/U05_IfElseIntro.py",
        "U02_IfElseIntro.py",
    ),
    (
        ROOT / "src/ev1/ut2_controlflujometodos/u01condicionales/teoria/U04_IfIntro.py",
        "U01_IfIntro.py",
    ),
    (
        ROOT / "src/ev1/ut2_controlflujometodos/u02bucles/teoria/U09_TablasIntro.py",
        "U03_TablasIntro.py",
    ),
    (
        ROOT / "src/ev1/ut2_controlflujometodos/u02bucles/teoria/U08_WhileIntro.py",
        "U02_WhileIntro.py",
    ),
    (
        ROOT / "src/ev1/ut2_controlflujometodos/u02bucles/teoria/U07_ForIntro.py",
        "U01_ForIntro.py",
    ),
    (
        ROOT / "src/ev1/ut2_controlflujometodos/u03funciones/teoria/U07_CalculadoraIntro.py",
        "U02_CalculadoraIntro.py",
    ),
    (
        ROOT / "src/ev1/ut2_controlflujometodos/u03funciones/teoria/U06_FuncionesIntro.py",
        "U01_FuncionesIntro.py",
    ),
    (
        ROOT / "src/ev1/ut2_controlflujometodos/u04excepciones/teoria/U08_ExcepcionesIntro.py",
        "U01_ExcepcionesIntro.py",
    ),
    (
        ROOT / "src/ev1/ut2_controlflujometodos/u05repaso/teoria/U05_RepasoEv1Intro.py",
        "U01_RepasoEv1Intro.py",
    ),
    (
        ROOT / "src/ev2/ut4_colecciones/u03diccionarios/teoria/U13_DiccionariosAvanzadosIntro.py",
        "U02_DiccionariosAvanzadosIntro.py",
    ),
    (
        ROOT / "src/ev2/ut4_colecciones/u03diccionarios/teoria/U12_DiccionariosIntro.py",
        "U01_DiccionariosIntro.py",
    ),
    (
        ROOT / "src/ev2/ut4_colecciones/u02tuplas/teoria/U11_TuplasIntro.py",
        "U01_TuplasIntro.py",
    ),
    (
        ROOT / "src/ev2/ut4_colecciones/u01listas/teoria/U10_ListasIntro.py",
        "U01_ListasIntro.py",
    ),
]

DOCSTRING_REPLACEMENTS: dict[Path, list[tuple[str, str]]] = {
    ROOT
    / "src/ev1/ut1_fundamentospython/u03inputcomentarios/teoria/U01_InputIntro.py": [
        ("U03 — Entrada de datos con input().", "U01 — Entrada de datos con input()."),
    ],
    ROOT
    / "src/ev1/ut1_fundamentospython/u03inputcomentarios/teoria/U02_ComentariosIntro.py": [
        ("U04 — Comentarios y estilo basico.", "U02 — Comentarios y estilo basico."),
    ],
    ROOT / "src/ev1/ut2_controlflujometodos/u01condicionales/teoria/U01_IfIntro.py": [
        ("U04 — Condicional if.", "U01 — Condicional if."),
        (
            "SIGUIENTE BLOQUE: U05 (elif/else), U06 (match/case), U07 (anidados).",
            "SIGUIENTE BLOQUE: U02 (elif/else), U03 (match/case), U04 (anidados).",
        ),
    ],
    ROOT / "src/ev1/ut2_controlflujometodos/u01condicionales/teoria/U02_IfElseIntro.py": [
        ("U05 — if / elif / else y operador ternario.", "U02 — if / elif / else y operador ternario."),
    ],
    ROOT / "src/ev1/ut2_controlflujometodos/u01condicionales/teoria/U03_MatchCaseIntro.py": [
        (
            "U06 — match / case (equivalente moderno al switch de Java).",
            "U03 — match / case (equivalente moderno al switch de Java).",
        ),
    ],
    ROOT
    / "src/ev1/ut2_controlflujometodos/u01condicionales/teoria/U04_CondicionalesAnidadasIntro.py": [
        (
            "U07 — Condicionales anidados y operadores logicos.",
            "U04 — Condicionales anidados y operadores logicos.",
        ),
    ],
    ROOT / "src/ev1/ut2_controlflujometodos/u02bucles/teoria/U01_ForIntro.py": [
        ("U07 — Bucle for y range().", "U01 — Bucle for y range()."),
    ],
    ROOT / "src/ev1/ut2_controlflujometodos/u02bucles/teoria/U02_WhileIntro.py": [
        ("U08 — Bucle while.", "U02 — Bucle while."),
    ],
    ROOT / "src/ev1/ut2_controlflujometodos/u02bucles/teoria/U03_TablasIntro.py": [
        ("U09 — Patrones con bucles anidados.", "U03 — Patrones con bucles anidados."),
    ],
    ROOT / "src/ev1/ut2_controlflujometodos/u03funciones/teoria/U01_FuncionesIntro.py": [
        ("U06 — Funciones con def.", "U01 — Funciones con def."),
    ],
    ROOT / "src/ev1/ut2_controlflujometodos/u03funciones/teoria/U02_CalculadoraIntro.py": [
        (
            "U07 — Proyecto integrador: calculadora con funciones y menu.",
            "U02 — Proyecto integrador: calculadora con funciones y menu.",
        ),
    ],
    ROOT / "src/ev1/ut2_controlflujometodos/u04excepciones/teoria/U01_ExcepcionesIntro.py": [
        ("U08 — Excepciones: try / except.", "U01 — Excepciones: try / except."),
    ],
    ROOT / "src/ev1/ut2_controlflujometodos/u05repaso/teoria/U01_RepasoEv1Intro.py": [
        ("U05 — Repaso EV1: conceptos clave.", "U01 — Repaso EV1: conceptos clave."),
    ],
    ROOT / "src/ev2/ut4_colecciones/u01listas/teoria/U01_ListasIntro.py": [
        (
            "EJERCICIO 10: Listas\nEn este ejercicio aprenderás a trabajar con listas en Python.",
            "U01 — Listas en Python.\n\nOBJETIVO:\n  - Crear listas y acceder a elementos por indice.\n  - Modificar, agregar y eliminar elementos.\n  - Recorrer listas con bucles.",
        ),
    ],
    ROOT / "src/ev2/ut4_colecciones/u02tuplas/teoria/U01_TuplasIntro.py": [
        (
            "EJERCICIO 11: Tuplas\nEn este ejercicio aprenderás a trabajar con tuplas en Python.",
            "U01 — Tuplas en Python.\n\nOBJETIVO:\n  - Crear tuplas y acceder a elementos.\n  - Entender inmutabilidad y desempaquetado.\n  - Usar tuplas como claves o registros simples.",
        ),
    ],
    ROOT / "src/ev2/ut4_colecciones/u03diccionarios/teoria/U01_DiccionariosIntro.py": [
        (
            "EJERCICIO 12: Diccionarios Básicos\nEn este ejercicio aprenderás a trabajar con diccionarios en Python.",
            "U01 — Diccionarios basicos.\n\nOBJETIVO:\n  - Crear diccionarios y acceder a claves.\n  - Agregar, modificar y eliminar pares clave-valor.\n  - Recorrer diccionarios.",
        ),
    ],
    ROOT / "src/ev2/ut4_colecciones/u03diccionarios/teoria/U02_DiccionariosAvanzadosIntro.py": [
        (
            "EJERCICIO 13: Diccionarios Avanzados\nEn este ejercicio practicarás operaciones avanzadas con diccionarios.",
            "U02 — Diccionarios avanzados.\n\nOBJETIVO:\n  - Combinar diccionarios y usar metodos utiles.\n  - Trabajar con diccionarios anidados.\n  - Aplicar comprensiones y valores por defecto.",
        ),
    ],
}


def main() -> None:
    for old_path, new_name in RENAMES:
        if not old_path.exists():
            raise FileNotFoundError(old_path)
        new_path = old_path.with_name(new_name)
        if new_path.exists():
            raise FileExistsError(f"Destino ya existe: {new_path}")
        old_path.rename(new_path)
        print(f"Renombrado: {old_path.relative_to(ROOT)} -> {new_path.name}")

    for path, replacements in DOCSTRING_REPLACEMENTS.items():
        if not path.exists():
            raise FileNotFoundError(path)
        text = path.read_text(encoding="utf-8")
        for old, new in replacements:
            if old not in text:
                raise ValueError(f"No se encontro texto en {path}:\n{old!r}")
            text = text.replace(old, new, 1)
        path.write_text(text, encoding="utf-8", newline="\n")
        print(f"Docstring actualizado: {path.relative_to(ROOT)}")


if __name__ == "__main__":
    main()
