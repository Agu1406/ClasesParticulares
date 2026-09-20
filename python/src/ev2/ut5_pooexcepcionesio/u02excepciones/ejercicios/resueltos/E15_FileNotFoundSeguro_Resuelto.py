"""
OBJETIVO: Intenta leer un fichero inexistente; captura FileNotFoundError e imprime aviso.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from pathlib import Path

fichero = Path(__file__).resolve().parent / "no_existe_e15.txt"
try:
    print(fichero.read_text(encoding="utf-8"))
except FileNotFoundError:
    print("El fichero no existe")
