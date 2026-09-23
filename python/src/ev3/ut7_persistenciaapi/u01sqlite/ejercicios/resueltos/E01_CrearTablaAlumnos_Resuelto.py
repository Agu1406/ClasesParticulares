"""
OBJETIVO: Crea en :memory: la tabla alumnos (id INTEGER PK AUTOINCREMENT, nombre TEXT, nota REAL).
SOLUCION: sqlite3.connect + CREATE TABLE + commit.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

import sqlite3

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
conexion.commit()
print("Tabla creada")
conexion.close()
