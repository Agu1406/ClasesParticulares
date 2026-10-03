#!/usr/bin/env python3
"""Fix broken cin.ignore newlines in ported cpp files."""
from pathlib import Path
import re

root = Path(__file__).resolve().parents[1] / "cpp" / "src" / "ev2"
fixed = 0
for p in root.rglob("*.cpp"):
    t = p.read_text(encoding="utf-8")
    n = re.sub(
        r"cin\.ignore\(numeric_limits<streamsize>::max\(\),[\s\S]*?\);",
        r"cin.ignore(numeric_limits<streamsize>::max(), '\\n');",
        t,
    )
    if n != t:
        p.write_text(n, encoding="utf-8")
        fixed += 1
print("fixed", fixed)

sample = root / "ut4_colecciones/u01arrays/ejercicios/resueltos/E01_CrearYMostrar_Resuelto.cpp"
for line in sample.read_text(encoding="utf-8").splitlines():
    if "cin.ignore" in line:
        print(repr(line))
