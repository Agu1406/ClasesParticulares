# UT7 — Persistencia con ADO.NET + SQLite

Equivalente a Java `ut7_persistenciajdbcapi` / Python `ut7_persistenciaapi` / C++ `ut7_persistenciastl`.

## Equivalencia pedagógica

| Concepto | JDBC (Java) | Python `sqlite3` | ADO.NET (C#) |
|----------|-------------|------------------|--------------|
| Conexión | `DriverManager.getConnection` | `sqlite3.connect` | `SqliteConnection` |
| Comando | `Statement` / `PreparedStatement` | `cursor.execute` | `SqliteCommand` (`CreateCommand`) |
| Escritura | `executeUpdate` | `execute` + `commit` | `ExecuteNonQuery` |
| Lectura | `ResultSet` | `fetchall` / `fetchone` | `ExecuteReader` / `SqliteDataReader` |
| Parámetros | `?` + `setXxx` | `?` + tupla | `@nombre` + `Parameters.AddWithValue` |
| Recursos | try-with-resources | `with` / `close` | `using` / `using var` |

Paquete NuGet: **Microsoft.Data.Sqlite** (no viene en la BCL).

## Cómo ejecutar (file-based apps .NET)

Cada `.cs` de esta UT empieza con la directiva de paquete:

```csharp
#:package Microsoft.Data.Sqlite@9.0.0
```

Desde la carpeta del archivo (o con ruta relativa):

```powershell
dotnet run --file .\U01_SqliteIntro.cs
```

`dotnet` descarga el paquete automáticamente gracias a `#:package`. No hace falta un `.csproj` aparte para estas demos.

## Mapa de subtemas

| Unidad | Carpeta | Estado |
|--------|---------|--------|
| u01 | `u01sqlite/` | **Completo** (teoría U01–U03 + E01–E08 pendientes/resueltos) |
| u02 | `u02basesdatos/` | Esqueleto |
| u03 | `u03pooavanzado/` | Esqueleto |
| u04 | `u04orm/` | Esqueleto |
| u05 | `u05repaso/` | Esqueleto |

Empieza por `u01sqlite/teoria/U01_SqliteIntro.cs`.

### u01sqlite — contenido

**Teoría**

| Archivo | Tema |
|---------|------|
| `U01_SqliteIntro.cs` | `SqliteConnection`, `CreateCommand`, CREATE/INSERT, `Open` |
| `U02_ConsultasSelect.cs` | SELECT, `ExecuteReader`, WHERE |
| `U03_ParametrosYUsing.cs` | `Parameters.AddWithValue`, `using var connection` |

**Ejercicios E01–E08** (pares `*Pendiente.cs` / `*Resuelto.cs`)

| # | Nombre | Idea |
|---|--------|------|
| E01 | CrearTablaAlumnos | CREATE TABLE en `:memory:` |
| E02 | InsertarAlumnos | INSERT + COUNT |
| E03 | SelectTodos | SELECT + `ExecuteReader` |
| E04 | SelectWhereNota | WHERE `nota >= @umbral` |
| E05 | UpdateNota | UPDATE parametrizado |
| E06 | DeletePorId | DELETE por `id` |
| E07 | ContarFilas | `SELECT COUNT(*)` + `ExecuteScalar` |
| E08 | MiniCRUD | CRUD en fichero `alumnos.db` (borrar al final) |

Demos de teoría y la mayoría de ejercicios usan **`:memory:`**. E08 usa el fichero `alumnos.db` y lo elimina al terminar.
