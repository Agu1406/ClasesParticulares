# Examen 3.ª EV — Bibliotecas comunidad (Hibernate)

Enunciado: `biblioteca-comunidad-jdbc-examen3ev.pdf`  
Esquema MySQL: `biblioteca_ces.sql` (BD `biblioteca_ces`)

Solución JDBC equivalente: carpeta hermana `examen3evbibliotecacomunidadjdbcjdbc/`.

## Antes de ejecutar Java

1. XAMPP → MySQL activo.
2. phpMyAdmin → **Importar** → `biblioteca_ces.sql` → **Continuar** (tablas vacías).
3. Repite el paso 2 antes de cada prueba desde cero.

## Esta carpeta (estructura plana)

| Fichero | Rol |
|---------|-----|
| `hibernate.cfg.xml` | Configuración Hibernate |
| `Examen3EvBibliotecaMain_SIN_RESOLVER` / `_RESUELTO` | Main |
| `Autor`, `Biblioteca`, `Libro` | Entidades JPA |
| `*DAO_*` | Acceso a datos |
| `CSVUtil*`, `HibernateUtil` | Utilidades |

Librerías: **MySQL** + **Hibernate** (+ JAXB en el módulo).
