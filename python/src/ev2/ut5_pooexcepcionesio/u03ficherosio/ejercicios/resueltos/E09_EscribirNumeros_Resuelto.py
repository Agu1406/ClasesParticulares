"""
OBJETIVO: Guarda los numeros del 1 al 10, uno por linea, en numeros.txt.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from pathlib import Path

CARPETA = Path(__file__).resolve().parent / "salida_demo"
CARPETA.mkdir(exist_ok=True)
fichero = CARPETA / "numeros.txt"
with open(fichero, "w", encoding="utf-8") as f:
    for n in range(1, 11):
        f.write(f"{n}\n")
print(fichero.read_text(encoding="utf-8"))
