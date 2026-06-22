"""
OBJETIVO: def dividir(a,b) captura ZeroDivisionError.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
"""

def dividir(a, b):
    try:
        return a / b
    except ZeroDivisionError:
        return "error"

print(dividir(10, 2), dividir(10, 0))
