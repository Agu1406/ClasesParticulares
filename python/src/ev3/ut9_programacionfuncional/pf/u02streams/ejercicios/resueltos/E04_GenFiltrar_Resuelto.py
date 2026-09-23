"""
OBJETIVO: Generador que filtre (yield) solo los valores > umbral.
SOLUCION: if x > umbral: yield x.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

numeros = [1, 5, 3, 8, 2, 10]


def filtrar_mayor(xs, umbral):
    for x in xs:
        if x > umbral:
            yield x


print(list(filtrar_mayor(numeros, 4)))
