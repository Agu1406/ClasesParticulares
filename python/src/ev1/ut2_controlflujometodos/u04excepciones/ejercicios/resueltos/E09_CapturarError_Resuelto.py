"""
OBJETIVO: except ValueError as e: muestra e.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
"""

try:
    int("x")
except ValueError as e:
    print(e)
