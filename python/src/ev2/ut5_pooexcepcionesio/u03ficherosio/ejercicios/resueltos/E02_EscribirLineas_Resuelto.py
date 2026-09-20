"""
OBJETIVO: Escribe tres lineas (uno, dos, tres) en lineas.txt con open(..., "w").
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from pathlib import Path

CARPETA = Path(__file__).resolve().parent / "salida_demo"
CARPETA.mkdir(exist_ok=True)
fichero = CARPETA / "lineas.txt"
with open(fichero, "w", encoding="utf-8") as f:
    f.write("uno\n")
    f.write("dos\n")
    f.write("tres\n")
print(fichero.read_text(encoding="utf-8"))
