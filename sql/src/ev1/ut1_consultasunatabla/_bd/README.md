# BD práctica — `tienda`

Script MySQL/MariaDB para **EV1 UT1**. En esta unidad se consulta **una sola tabla por consulta** (sin `JOIN`).

## Cargar

```powershell
mysql -u root -p < tienda.sql
```

O desde el cliente: abrir `tienda.sql` y ejecutarlo entero.

## Tablas

| Tabla | Para qué sirve en UT1 |
|-------|------------------------|
| `clientes` | Filtros, `NULL`, ciudades, activo |
| `productos` | Precios, stock, categorías, `LIKE` |
| `pedidos` | Estados, fechas, cantidades (sin JOIN aún) |

```sql
USE tienda;
SHOW TABLES;
DESCRIBE productos;
```

## XAMPP

```text
C:\xampp\mysql\bin\mysql.exe -u root < tienda.sql
```

O importar desde phpMyAdmin.
