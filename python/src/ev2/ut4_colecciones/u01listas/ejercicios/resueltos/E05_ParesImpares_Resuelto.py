"""
OBJETIVO: De [1,2,3,4,5,6], crea dos listas: pares e impares; imprimelas.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

numeros = [1, 2, 3, 4, 5, 6]
pares = []
impares = []
for n in numeros:
    if n % 2 == 0:
        pares.append(n)
    else:
        impares.append(n)
print("Pares:", pares)
print("Impares:", impares)
