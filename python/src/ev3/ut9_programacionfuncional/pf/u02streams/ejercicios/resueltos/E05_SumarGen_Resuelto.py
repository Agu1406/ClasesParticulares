"""
OBJETIVO: Suma los valores de un generator expression (sin list intermedia).
SOLUCION: sum(n * n for n in numeros).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

numeros = [1, 2, 3, 4, 5]
print(sum(n * n for n in numeros))
