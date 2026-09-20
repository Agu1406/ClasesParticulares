"""
OBJETIVO: Con [["Ana",8,9,7],["Luis",7,8,8]], imprime nombre y media de notas de cada uno.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

calificaciones = [
    ["Ana", 8, 9, 7],
    ["Luis", 7, 8, 8],
]
for estudiante in calificaciones:
    nombre = estudiante[0]
    notas = estudiante[1:]
    media = sum(notas) / len(notas)
    print(f"{nombre}: {media:.2f}")
