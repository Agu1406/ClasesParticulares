"""
OBJETIVO: Copia el contenido de origen.txt a destino.txt.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from pathlib import Path

CARPETA = Path(__file__).resolve().parent / "salida_demo"
CARPETA.mkdir(exist_ok=True)
origen = CARPETA / "origen.txt"
destino = CARPETA / "destino.txt"
origen.write_text("contenido a copiar\n", encoding="utf-8")
destino.write_text(origen.read_text(encoding="utf-8"), encoding="utf-8")
print(destino.read_text(encoding="utf-8"))
