"""
OBJETIVO: try acceder indice 10 en lista de 3.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
"""

lista = [1, 2, 3]
try:
    print(lista[10])
except IndexError:
    print("indice malo")
