# EV1 — Mapa para dar clase (SQL / Bases de Datos DAM·DAW)

Orden: **UT1 → UT2 → UT3**. Entorno recomendado: **XAMPP** (MySQL + phpMyAdmin).

```text
C:\xampp\mysql\bin\mysql.exe -u root < ruta\al\script.sql
```

Migracion: [`../MAPA_MIGRACION.md`](../MAPA_MIGRACION.md).

## Mapa del curso

| Evaluación | Unidades |
|---|---|
| EV1 | UT1 Consultas 1 tabla · UT2 E/R + normalización · UT3 DDL + GROUP BY + JOIN |
| EV2 | UT4 Subconsultas · UT5 DML + transacciones |
| EV3 | UT6 Procedimientos/triggers · UT7 NoSQL |

## UT1 — `ut1_consultasunatabla`

SELECT / WHERE / predicados / ORDER / agregadas sin GROUP BY. BD `_bd/tienda.sql`.

## UT2 — `ut2_erynormalizacion`

E/R, paso a tablas, claves, 1FN–3FN (Markdown). Refs BD01–03 + Cataluña UOC.

## UT3 — `ut3_ddlyjoins`

| U0X | Contenido |
|-----|-----------|
| u01ddlbasico | CREATE DATABASE/TABLE (XAMPP) |
| u02restriccionesyclaves | Restricciones, FK, ALTER |
| u03groupbyhaving | GROUP BY / HAVING |
| u04innerjoin | INNER JOIN + Galicia |
| u05outerjoin | LEFT JOIN + JOIN/GROUP BY + Galicia |

Madrid Access en `ut3_ddlyjoins/practicas/madridaccess/`.

## Checklist EV1

- [x] UT1 SQL proyectable
- [x] UT2 diseno proyectable
- [x] UT3 DDL/JOIN + XAMPP documentado
