"""
OBJETIVO: De [14, 7, 23, 5, 11], crea una lista solo con los mayores que 10 e imprime.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

numeros = [14, 7, 23, 5, 11]
mayores = []
for n in numeros:
    if n > 10:
        mayores.append(n)
print(mayores)
