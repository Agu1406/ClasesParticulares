"""
OBJETIVO: Mini-CRUD en alumnos.db: crear tabla, insertar 2, actualizar 1, borrar 1, listar.
SOLUCION: fichero alumnos.db creado y borrado en el script (CREATE/INSERT/UPDATE/DELETE/SELECT).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

import os
import sqlite3

DB = "alumnos.db"

if os.path.exists(DB):
    os.remove(DB)

conexion = sqlite3.connect(DB)
try:
    with conexion:
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
            [("Ana", 8.5), ("Luis", 6.0)],
        )
        cursor.execute("UPDATE alumnos SET nota = ? WHERE nombre = ?", (9.0, "Ana"))
        cursor.execute("DELETE FROM alumnos WHERE nombre = ?", ("Luis",))
        cursor.execute("SELECT id, nombre, nota FROM alumnos")
        for fila in cursor.fetchall():
            print(fila)
finally:
    conexion.close()

if os.path.exists(DB):
    os.remove(DB)
    print(f"{DB} eliminado")
