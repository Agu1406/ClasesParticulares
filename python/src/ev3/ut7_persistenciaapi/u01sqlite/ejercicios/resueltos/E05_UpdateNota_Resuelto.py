"""
OBJETIVO: Actualiza la nota de Luis a 7.5 y muestra su fila (nombre, nota).
SOLUCION: UPDATE con ? + SELECT fetchone.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

import sqlite3

with sqlite3.connect(":memory:") as conexion:
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
        [("Ana", 8.5), ("Luis", 6.0), ("Maria", 9.0)],
    )
    cursor.execute("UPDATE alumnos SET nota = ? WHERE nombre = ?", (7.5, "Luis"))
    cursor.execute("SELECT nombre, nota FROM alumnos WHERE nombre = ?", ("Luis",))
    nombre, nota = cursor.fetchone()
    print(f"{nombre}: {nota}")
