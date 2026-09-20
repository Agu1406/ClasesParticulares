"""
OBJETIVO: Con [5, 2, 8, 1], imprime sorted() (copia) y luego sort() sobre una copia aparte.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

original = [5, 2, 8, 1]
print("sorted():", sorted(original))
print("Original intacta:", original)

copia = original.copy()
copia.sort()
print("Copia tras sort():", copia)
print("Original intacta:", original)
