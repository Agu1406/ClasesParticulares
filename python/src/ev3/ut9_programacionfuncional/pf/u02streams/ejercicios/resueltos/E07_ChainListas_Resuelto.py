"""
OBJETIVO: Concatena varias listas con itertools.chain.
SOLUCION: list(chain(a, b, c)).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from itertools import chain

a = [1, 2]
b = [3, 4]
c = [5]
print(list(chain(a, b, c)))
