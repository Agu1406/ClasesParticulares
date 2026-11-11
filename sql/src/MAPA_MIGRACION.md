# Mapa de migracion — sql/ → src/evX

Objetivo final: que `sql/` quede centrado en `src/` con material ordenado por EV/UT/U0X.
**Aun no se borran** las carpetas raiz; se migran cuando exista la UT destino.

## Destinos

| Origen | Destino previsto |
|--------|------------------|
| `BBDD/BD01_Contenido.pdf` | EV1 UT2 `_refs/` (almacenamiento / SGBD) |
| `BBDD/BD02_Contenido.pdf` | EV1 UT2 (modelo relacional) |
| `BBDD/BD03_Contenido.pdf` | EV1 UT2 (E/R + normalizacion) |
| `BBDD/BD04_Contenido.pdf` | EV1 UT1 `_refs/` (hecho) + EV2 UT4 parte avanzada |
| `BBDD/BD05_Contenidos.pdf` | EV2 UT5 (DML / tratamiento) |
| `BBDD/BD06_Contenidos.pdf` | EV3 UT6 (programacion BD) |
| `BBDD/BD07_Contenidos.pdf` | EV3 UT7 (objeto-relacional / NoSQL) |
| `galicia/circo` y `viviendas` (1 tabla) | EV1 UT1 `practicas/galicia*` (hecho) |
| `galicia/*` con JOIN / agregaciones | EV1 UT3 |
| `galicia/*` subconsultas / DML | EV2 UT4–UT5 |
| `cataluña/uoc` (arquitectura) | EV1 UT2 practicas centro |
| `madrid/` (Access) | EV1 UT3 o banco Access |

## Estado

- [x] UT1 consultas 1 tabla + Galicia 1-tabla + BD04 en `_refs`
- [x] UT2 E/R + normalizacion (+ BD01–03, cataluña)
- [x] UT3 DDL + agreg/JOIN intro (+ madrid, Galicia JOIN basico)
- [x] EV1 estructura UT1–UT3 lista para clase
- [ ] EV2 / EV3
- [ ] Vaciar raiz dejando solo `src/` (+ README)
