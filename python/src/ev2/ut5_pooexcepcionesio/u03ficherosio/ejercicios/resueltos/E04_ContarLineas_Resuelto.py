"""
OBJETIVO: En un fichero con 4 lineas, imprime cuantas lineas tiene (splitlines).
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from pathlib import Path

CARPETA = Path(__file__).resolve().parent / "salida_demo"
CARPETA.mkdir(exist_ok=True)
fichero = CARPETA / "contar.txt"
fichero.write_text("a\nb\nc\nd\n", encoding="utf-8")
print(len(fichero.read_text(encoding="utf-8").splitlines()))
