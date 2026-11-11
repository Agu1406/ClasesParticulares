# UT1 — Consultas sobre una tabla (completa)

Objetivo: que el alumno escriba `SELECT` con filtros, ordenación y resúmenes globales sobre **una** tabla. Estilo ApuntesDam (tramos 7–8 inicio).

## Antes de clase

```powershell
mysql -u root -p < _bd\tienda.sql
```

## Orden

1. **u01entornosql** — entorno y primera consulta  
2. **u02selectbasico** — proyección de columnas (+ `practicas/galiciacirco` C01/C05)  
3. **u03where** — filtros (+ Galicia where)  
4. **u04predicados** — BETWEEN/IN/LIKE/NULL (+ Galicia LIKE)  
5. **u05ordenylimite** — ORDER BY / LIMIT (+ viviendas V04)  
6. **u06calculos** — agregadas sin GROUP BY (+ circo C28–C30)

En cada U0X: proyectar `teoria/U0N_…` → 2–3 `ejercicios/pendientes` → práctica interna → Galicia si sobra tiempo.

## Cabecera

```sql
/*
OBJETIVO: …
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/
```

## Refs

- `_refs/BD04_Contenido.pdf` — temario oficial de consultas (profesor).
- Banco original Galicia/Madrid/BBDD sigue en la raiz hasta migrar el resto (ver `src/MAPA_MIGRACION.md`).
