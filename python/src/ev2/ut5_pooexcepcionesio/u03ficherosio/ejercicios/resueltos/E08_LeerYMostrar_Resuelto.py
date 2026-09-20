"""
OBJETIVO: Muestra las lineas de un fichero numeradas (1:, 2:, ...).
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from pathlib import Path

CARPETA = Path(__file__).resolve().parent / "salida_demo"
CARPETA.mkdir(exist_ok=True)
fichero = CARPETA / "mostrar.txt"
fichero.write_text("rojo\nverde\nazul\n", encoding="utf-8")
for i, linea in enumerate(fichero.read_text(encoding="utf-8").splitlines(), 1):
    print(f"{i}: {linea}")
