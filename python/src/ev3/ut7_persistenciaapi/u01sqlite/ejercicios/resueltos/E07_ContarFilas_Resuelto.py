"""
OBJETIVO: Cuenta filas en alumnos tras insertar 4 registros (esperado: 4).
SOLUCION: SELECT COUNT(*) + fetchone()[0].

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
        [("Ana", 8.5), ("Luis", 6.0), ("Maria", 9.0), ("Pedro", 4.5)],
    )
    cursor.execute("SELECT COUNT(*) FROM alumnos")
    print(cursor.fetchone()[0])
