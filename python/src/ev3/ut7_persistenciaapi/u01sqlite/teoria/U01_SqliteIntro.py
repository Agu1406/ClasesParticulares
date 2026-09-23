"""
U01 — Introduccion a sqlite3: conexion, cursor y escritura.

OBJETIVO:
  - Abrir una conexion con sqlite3.connect (fichero .db o :memory:).
  - Obtener un cursor y ejecutar CREATE TABLE / INSERT.
  - Confirmar con commit y cerrar la conexion.
  - Relacionar con JDBC: Connection / Statement / executeUpdate.

En Java JDBC: DriverManager.getConnection + Statement.executeUpdate + commit.
En Python: sqlite3.connect + cursor.execute + connection.commit (stdlib, sin driver extra).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

import sqlite3

print("\n¡INICIO DEL PROGRAMA!\n")

"""
PRIMERA PARTE — Conexion en memoria (:memory:).
Equivalente pedagogico a abrir Connection en JDBC, pero sin servidor.
"""
print("¡DEMO 1: CONNECT EN :memory:!\n")
conexion = sqlite3.connect(":memory:")
print(f"Tipo de conexion: {type(conexion).__name__}")
print(f"Autocommit desactivado por defecto (isolation_level): {conexion.isolation_level!r}\n")

"""
SEGUNDA PARTE — Cursor + CREATE TABLE + INSERT + commit.
En JDBC: Statement.executeUpdate("CREATE...") / executeUpdate("INSERT...").
En Python: cursor.execute(...); conexion.commit().
"""
print("¡DEMO 2: CREATE E INSERT!\n")
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
cursor.execute("INSERT INTO alumnos (nombre, nota) VALUES ('Ana', 8.5)")
cursor.execute("INSERT INTO alumnos (nombre, nota) VALUES ('Luis', 6.0)")
conexion.commit()
print("Tabla alumnos creada e insertados 2 registros.")
print(f"Ultimo rowid insertado: {cursor.lastrowid}\n")

"""
TERCERA PARTE — Cerrar recursos.
En JDBC: connection.close() (o try-with-resources).
En Python: conexion.close() (en U03 veremos el context manager with).
"""
print("¡DEMO 3: CLOSE!\n")
conexion.close()
print("Conexion cerrada.")

print("\n¡FIN DEL PROGRAMA!")
