"""
OBJETIVO: try/except: convierte 25 y hola a int.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
"""

for t in ("25", "hola"):
    try:
        print(int(t))
    except ValueError:
        print("no es entero")
