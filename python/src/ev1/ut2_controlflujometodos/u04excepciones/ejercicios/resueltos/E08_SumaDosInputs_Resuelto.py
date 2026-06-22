"""
OBJETIVO: Pide dos numeros; si falla int, mensaje amable.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

try:
    a = int(input("a: "))
    b = int(input("b: "))
    print(a + b)
except ValueError:
    print("escribe numeros")
