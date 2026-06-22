"""
OBJETIVO: Convierte 3.14 y abc a float con try.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
"""

for t in ("3.14", "abc"):
    try:
        print(float(t))
    except ValueError:
        print("fallo")
