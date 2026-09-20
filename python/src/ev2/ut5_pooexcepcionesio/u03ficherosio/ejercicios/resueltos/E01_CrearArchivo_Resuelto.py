"""
OBJETIVO: Crea CARPETA/salida.txt con el texto "Hola ficheros UT5".
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from pathlib import Path

CARPETA = Path(__file__).resolve().parent / "salida_demo"
CARPETA.mkdir(exist_ok=True)
fichero = CARPETA / "salida.txt"
fichero.write_text("Hola ficheros UT5\n", encoding="utf-8")
print("Creado:", fichero)
print(fichero.read_text(encoding="utf-8"))
