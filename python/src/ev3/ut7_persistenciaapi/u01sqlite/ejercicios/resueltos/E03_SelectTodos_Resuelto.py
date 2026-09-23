"""
OBJETIVO: Lista todos los alumnos (nombre, nota) tras insertar Ana, Luis y Maria.
SOLUCION: SELECT + fetchall.

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
    cursor.execute("SELECT nombre, nota FROM alumnos")
    for nombre, nota in cursor.fetchall():
        print(f"{nombre}: {nota}")
