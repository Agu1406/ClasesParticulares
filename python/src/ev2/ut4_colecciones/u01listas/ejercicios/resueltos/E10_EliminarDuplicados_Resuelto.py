"""
OBJETIVO: De [1, 2, 2, 3, 1, 4], crea otra lista sin duplicados (orden de primera aparicion).
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

original = [1, 2, 2, 3, 1, 4]
sin_duplicados = []
for n in original:
    if n not in sin_duplicados:
        sin_duplicados.append(n)
print("Original:", original)
print("Sin duplicados:", sin_duplicados)
