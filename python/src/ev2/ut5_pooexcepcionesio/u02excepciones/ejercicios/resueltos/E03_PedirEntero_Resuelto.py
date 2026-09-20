"""
OBJETIVO: Bucle: pide entero hasta que sea valido.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

while True:
    try:
        n = int(input("Entero: "))
        print("OK", n)
        break
    except ValueError:
        print("Repite")
