/*
OBJETIVO: Solucion panel de metricas UT1.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- 1
SELECT COUNT(*) AS total_productos FROM productos;
SELECT COUNT(*) AS total_clientes FROM clientes;

-- 2
SELECT SUM(stock) AS stock_total,
       SUM(precio * stock) AS valor_stock_total
FROM productos;

-- 3
SELECT ROUND(AVG(precio), 2) AS media,
       MIN(precio) AS min_p,
       MAX(precio) AS max_p
FROM productos;

-- 4
SELECT COUNT(*) AS n_pendientes,
       SUM(cantidad) AS uds_pendientes
FROM pedidos
WHERE estado = 'pendiente';

-- 5
SELECT COUNT(DISTINCT ciudad) AS ciudades FROM clientes;

-- Checklist: 5 bloques OK, sin JOIN/GROUP BY.
