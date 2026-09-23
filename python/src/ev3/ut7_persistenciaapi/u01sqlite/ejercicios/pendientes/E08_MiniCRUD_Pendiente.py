"""
OBJETIVO: Mini-CRUD en alumnos.db: crear tabla, insertar 2, actualizar 1, borrar 1, listar.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

import os
import sqlite3

DB = "alumnos.db"
# TODO: si existe alumnos.db, borrarlo; CREATE; INSERT Ana y Luis;
#       UPDATE nota de Ana a 9.0; DELETE Luis; SELECT restantes;
#       cerrar conexion y borrar alumnos.db al final (en Windows hace falta close)
