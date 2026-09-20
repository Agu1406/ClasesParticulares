"""
OBJETIVO: En [12, 7, 30, 4, 18], encuentra e imprime el mayor (recorriendo a mano).
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

lista = [12, 7, 30, 4, 18]
mayor = lista[0]
for n in lista:
    if n > mayor:
        mayor = n
print("El mayor valor es:", mayor)
