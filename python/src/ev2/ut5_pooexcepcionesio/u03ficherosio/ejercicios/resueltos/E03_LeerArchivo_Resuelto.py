"""
OBJETIVO: Crea leer_demo.txt con dos lineas, leelo con read_text e imprime el contenido.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from pathlib import Path

CARPETA = Path(__file__).resolve().parent / "salida_demo"
CARPETA.mkdir(exist_ok=True)
fichero = CARPETA / "leer_demo.txt"
fichero.write_text("linea A\nlinea B\n", encoding="utf-8")
print(fichero.read_text(encoding="utf-8"))
