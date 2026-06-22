"""
OBJETIVO: Bucle: pide entero hasta que sea valido.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
"""

while True:
    try:
        n = int(input("Entero: "))
        print("OK", n)
        break
    except ValueError:
        print("Repite")
