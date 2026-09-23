"""
OBJETIVO: Borra el alumno con id=2 y muestra los ids restantes (esperado: 1 y 3).
SOLUCION: DELETE WHERE id = ? + SELECT id.

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
    cursor.execute("DELETE FROM alumnos WHERE id = ?", (2,))
    cursor.execute("SELECT id FROM alumnos ORDER BY id")
    for (alumno_id,) in cursor.fetchall():
        print(alumno_id)
