# Examen 3.ª EV — Bibliotecas comunidad (JDBC)

Enunciado: `biblioteca-comunidad-jdbc-examen3ev.pdf`  
Esquema MySQL: `biblioteca_ces.sql` (BD `biblioteca_ces`)

Solución Hibernate equivalente: carpeta hermana `examen3evbibliotecacomunidadjdbchibernate/`.

## Antes de ejecutar Java

1. XAMPP → MySQL activo.
2. phpMyAdmin → **Importar** → `biblioteca_ces.sql` → **Continuar** (tablas vacías).
3. Repite el paso 2 antes de cada prueba desde cero.

## Esta carpeta (estructura plana)

| Fichero | Rol |
|---------|-----|
| `Examen3EvBibliotecaMain_SIN_RESOLVER` / `_RESUELTO` | Main |
| `Autor`, `Biblioteca`, `Libro` | Modelo |
| `*DAO_*` | Acceso con `PreparedStatement` |
| `ConexionBD`, `CSVUtil` | Utilidades |

Librería: **MySQL** solamente. Ajustes en `ConexionBD.java`.
