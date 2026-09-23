"""
U03 — Parametros ? y conexion como contexto (with).

OBJETIVO:
  - Usar placeholders ? para pasar valores (evitar SQL injection).
  - Usar with conexion: para commit/rollback automatico (no cierra; conviene close al final).
  - Relacionar con JDBC PreparedStatement.setXxx(...).

En Java JDBC: PreparedStatement con ? y setString/setDouble.
En Python: cursor.execute(sql, (valor1, valor2)) — NUNCA f-strings con input.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

import sqlite3

print("\n¡INICIO DEL PROGRAMA!\n")

"""
PRIMERA PARTE — with + CREATE / INSERT con ?.
Al salir del with sin excepcion, sqlite3 hace commit automatico.
"""
print("¡DEMO 1: with connection + placeholders ?!\n")
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
    nombre = "Ana"
    nota = 8.5
    # Seguro: el valor no se concatena en el SQL
    cursor.execute("INSERT INTO alumnos (nombre, nota) VALUES (?, ?)", (nombre, nota))
    cursor.execute(
        "INSERT INTO alumnos (nombre, nota) VALUES (?, ?)",
        ("Luis", 6.0),
    )
    print("Insertados 2 alumnos con parametros ?.\n")

    """
    SEGUNDA PARTE — SELECT parametrizado (WHERE).
    """
    print("¡DEMO 2: SELECT con ?!\n")
    umbral = 7.0
    cursor.execute(
        "SELECT nombre, nota FROM alumnos WHERE nota >= ? ORDER BY nota DESC",
        (umbral,),
    )
    for fila in cursor.fetchall():
        print(f"  {fila[0]}: {fila[1]}")
    print()

    """
    TERCERA PARTE — Por que NO concatenar (idea de SQL injection).
    Demostracion didactica: el input malicioso cambia el significado del SQL.
    """
    print("¡DEMO 3: peligro de concatenar (NO HACER)!\n")
    # Simulamos un "nombre" malicioso que cierra la comilla y anade OR 1=1
    entrada_maliciosa = "x' OR '1'='1"
    sql_inseguro = f"SELECT * FROM alumnos WHERE nombre = '{entrada_maliciosa}'"
    print(f"SQL inseguro generado:\n  {sql_inseguro}")
    try:
        cursor.execute(sql_inseguro)
        print(f"Filas devueltas (ataque OR 1=1): {cursor.fetchall()}")
    except sqlite3.Error as exc:
        print(f"Error SQL: {exc}")

    print("\nForma segura con ?:")
    cursor.execute("SELECT * FROM alumnos WHERE nombre = ?", (entrada_maliciosa,))
    print(f"Filas (ninguna, busca el literal): {cursor.fetchall()}")

print("\n(with hizo commit al salir sin error; la conexion puede seguir abierta hasta close/GC)")
print("\n¡FIN DEL PROGRAMA!")
