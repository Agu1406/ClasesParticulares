"""
OBJETIVO: try 10/2 else imprime sin error.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
"""

try:
    r = 10 / 2
except ZeroDivisionError:
    print("error")
else:
    print("sin error", r)
