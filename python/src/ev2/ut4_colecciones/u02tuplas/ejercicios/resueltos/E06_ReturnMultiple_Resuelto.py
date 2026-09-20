"""
OBJETIVO: Funcion min_max([4,1,9,2]) que devuelve (minimo, maximo); imprimelos.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

def min_max(nums):
    return min(nums), max(nums)

mini, maxi = min_max([4, 1, 9, 2])
print(mini)
print(maxi)
