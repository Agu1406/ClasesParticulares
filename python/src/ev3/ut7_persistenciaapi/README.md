# UT7 — Persistencia (sqlite / SQL)

Espejo Java `ut7_persistenciajdbcapi` y C# `ut7_persistenciaado`.

Equivalencia pedagogica basica: JDBC `Connection` / `Statement` / `ResultSet` → Python `sqlite3.connect` / `cursor` / `execute` / `fetch*`.

| Subtema | Tema Python | Equivalente | Estado |
|---------|-------------|-------------|--------|
| `u01sqlite` | `sqlite3` stdlib (CRUD basico) | JDBC / ADO basico | **Con contenido** (teoria U01–U03 + ejercicios E01–E08) |
| `u02basesdatos` | SQL / esquema | SQL / esquema | Esqueleto |
| `u03pooavanzado` | DAO / capas | DAO / capas | Esqueleto |
| `u04orm` | SQLAlchemy (mas adelante) | Hibernate / BDOO | Esqueleto |
| `u05repaso` | Repaso / examenes | Repaso | Esqueleto |

## `u01sqlite`

Solo biblioteca estandar `sqlite3` (sin SQLAlchemy).

- **Teoria:** `teoria/U01_SqliteIntro.py`, `U02_ConsultasSelect.py`, `U03_ParametrosYContext.py`
- **Ejercicios:** `ejercicios/pendientes/` y `ejercicios/resueltos/` (E01–E08)
  - E01 Crear tabla · E02 Insertar · E03 Select todos · E04 Select WHERE
  - E05 Update · E06 Delete · E07 Contar · E08 Mini-CRUD (`alumnos.db`)

Demos de teoria: `:memory:`. Ejercicios: `:memory:` o fichero fijo `alumnos.db` creado/borrado en el script.

Ejecutar demos: `python ruta/al/archivo.py`
