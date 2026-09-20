"""
U05 — Listas anidadas (lista de listas).

OBJETIVO:
  - Entender una lista cuyos elementos son otras listas.
  - Acceder con dos indices: fila y columna (matriz[fila][columna]).
  - Recorrer con bucles anidados y calcular promedios por fila.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Matriz 2x3 y acceso [fila][columna].
"""
print("¡DEMO 1: MATRIZ SIMPLE!\n")

matriz = [
    [1, 2, 3],
    [4, 5, 6],
]
print(f"matriz: {matriz}")
print(f"Fila 0: {matriz[0]}")
print(f"Elemento [0][1]: {matriz[0][1]}")
print(f"Elemento [1][2]: {matriz[1][2]}")

"""
SEGUNDA PARTE — Recorrido con bucles anidados.
"""
print("\n¡DEMO 2: RECORRIDO ANIDADO!\n")

for i in range(len(matriz)):
    for j in range(len(matriz[i])):
        print(f"  [{i}][{j}] = {matriz[i][j]}")

"""
TERCERA PARTE — Lista de alumnos: [nombre, nota1, nota2, nota3].
"""
print("\n¡DEMO 3: CALIFICACIONES!\n")

calificaciones = [
    ["Ana", 8.5, 9.0, 7.5],
    ["Luis", 7.0, 8.0, 8.5],
    ["Maria", 9.0, 9.5, 9.0],
]

print("Promedio por estudiante:")
for estudiante in calificaciones:
    nombre = estudiante[0]
    notas = estudiante[1:]
    promedio = sum(notas) / len(notas)
    print(f"  {nombre}: {promedio:.2f}")

"""
CUARTA PARTE — Modificar un valor interno.
"""
print("\n¡DEMO 4: MODIFICAR CELDA!\n")

calificaciones[1][2] = 9.0
print(f"Luis tras cambiar nota 2: {calificaciones[1]}")

print("\n¡FIN DEL PROGRAMA!\n")
