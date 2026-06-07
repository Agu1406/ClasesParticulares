# Examen 3.ª EV — Bibliotecas comunidad

Enunciado: `examen3ev--biblioteca-comunidad-jdbc.pdf`  
Esquema MySQL compartido: `sql/biblioteca_ces.sql` (BD `biblioteca_ces`)

## Antes de ejecutar Java

1. XAMPP → MySQL activo.
2. phpMyAdmin → **Importar** → `sql/biblioteca_ces.sql` → **Continuar** (tablas vacías).
3. Repite el paso 2 antes de cada prueba desde cero.

## Dos soluciones (mismo enunciado)

| Carpeta | Tecnologia | Main resuelto |
|---------|------------|---------------|
| `hibernate/` | JPA + Hibernate + `hibernate.cfg.xml` | `hibernate.Examen3EvBibliotecaMain_RESUELTO` |
| `jdbc/` | JDBC + `PreparedStatement` | `jdbc.Examen3EvBibliotecaMain_RESUELTO` |

Ambas usan `model/` + `util/` + `dao/`.

- **Hibernate:** librerias **MySQL** + **Hibernate** (+ JAXB en el modulo). Ajustes en `hibernate/hibernate.cfg.xml`.
- **JDBC:** libreria **MySQL** solamente. Ajustes en `jdbc/util/ConexionBD.java`.

## Estructura

```
examen3evbibliotecacomunidadjdbc/
├── sql/biblioteca_ces.sql
├── hibernate/
│   ├── hibernate.cfg.xml
│   ├── model/  dao/  util/
│   └── Examen3EvBibliotecaMain_SIN_RESOLVER / _RESUELTO
└── jdbc/
    ├── model/  dao/  util/
    └── Examen3EvBibliotecaMain_SIN_RESOLVER / _RESUELTO
```
