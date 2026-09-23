"""
OBJETIVO: Escribe un generador (yield) que produzca los cuadrados de 1..n.
SOLUCION: yield n*n en un for range(1, n+1).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def cuadrados(n):
    for i in range(1, n + 1):
        yield i * i


print(list(cuadrados(5)))
