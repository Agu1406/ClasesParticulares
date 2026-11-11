# Practicas Galicia (centro) — UT1

Consultas de **una sola tabla** adaptadas del banco `galicia/` (sin JOIN, sin DML, sin GROUP BY/subconsultas).

## Bases de datos

Copia los scripts originales (no se borran de la raiz):

- Circo: `galicia/circo/BDCirco.sql` (o el `.sql` de creacion del banco)
- Viviendas: `galicia/viviendas/viviendas.sql`

```powershell
mysql -u root -p < ..\..\..\..\..\galicia\circo\BDCirco.sql
mysql -u root -p < ..\..\..\..\..\galicia\viviendas\viviendas.sql
```

Cada fichero lleva `USE circo;` o `USE viviendas;` segun el original.

El banco completo en `galicia/` se reubicara en UTs posteriores (JOIN/DML).
