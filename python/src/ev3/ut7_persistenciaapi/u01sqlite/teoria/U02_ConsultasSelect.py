"""
U02 — Consultas SELECT: fetchall, fetchone y WHERE.

OBJETIVO:
  - Ejecutar SELECT y recuperar filas con fetchall / fetchone.
  - Filtrar con WHERE.
  - Relacionar con JDBC ResultSet (next + getXxx).

En Java JDBC: Statement.executeQuery + ResultSet.next().
En Python: cursor.execute("SELECT...") + fetchall() / fetchone().

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

import sqlite3

print("\n¡INICIO DEL PROGRAMA!\n")

conexion = sqlite3.connect(":memory:")
cursor = conexion.cursor()
cursor.execute(
    """
    CREATE TABLE alumnos (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        nombre TEXT NOT NULL,
        nota REAL
    )
    """
)
cursor.executemany(
    "INSERT INTO alumnos (nombre, nota) VALUES (?, ?)",
    [("Ana", 8.5), ("Luis", 6.0), ("Maria", 9.0), ("Pedro", 4.5)],
)
conexion.commit()

"""
PRIMERA PARTE — SELECT * + fetchall (todas las filas).
Cada fila es una tupla (id, nombre, nota).
"""
print("¡DEMO 1: SELECT + fetchall!\n")
cursor.execute("SELECT id, nombre, nota FROM alumnos")
filas = cursor.fetchall()
print(f"fetchall -> {len(filas)} filas:")
for fila in filas:
    print(f"  id={fila[0]} nombre={fila[1]} nota={fila[2]}")
print()

"""
SEGUNDA PARTE — fetchone (una fila o None).
Util para PRIMARY KEY o LIMIT 1.
"""
print("¡DEMO 2: fetchone!\n")
cursor.execute("SELECT id, nombre, nota FROM alumnos WHERE nombre = 'Ana'")
una = cursor.fetchone()
print(f"fetchone Ana: {una}")
cursor.execute("SELECT id, nombre, nota FROM alumnos WHERE nombre = 'Nadie'")
print(f"fetchone Nadie: {cursor.fetchone()}\n")

"""
TERCERA PARTE — WHERE con condicion numerica.
"""
print("¡DEMO 3: WHERE nota >= 7!\n")
cursor.execute("SELECT nombre, nota FROM alumnos WHERE nota >= 7 ORDER BY nota DESC")
for nombre, nota in cursor.fetchall():
    print(f"  {nombre}: {nota}")

conexion.close()
print("\n¡FIN DEL PROGRAMA!")
