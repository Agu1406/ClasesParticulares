"""
U01 — Repaso UT4: listas, tuplas y diccionarios juntos.

OBJETIVO:
  - Combinar las tres estructuras en un mini flujo de datos.
  - Preparar el salto a NumPy/pandas (u04/u05).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")

# lista de tuplas (nombre, nota)
alumnos = [("Ana", 7), ("Luis", 4), ("Eva", 9)]
print("Lista de tuplas:", alumnos)

# diccionario nombre -> nota
notas = {nombre: nota for nombre, nota in alumnos}
print("Dict:", notas)

aprobados = [n for n, nota in alumnos if nota >= 5]
print("Aprobados:", aprobados)
print("Media:", sum(notas.values()) / len(notas))

print("\n¡FIN DEL PROGRAMA!\n")
