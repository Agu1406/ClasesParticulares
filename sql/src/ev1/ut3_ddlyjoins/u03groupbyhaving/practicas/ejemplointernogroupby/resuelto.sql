/*
OBJETIVO: Solucion group by tienda.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

SELECT categoria,
       COUNT(*) AS productos,
       SUM(stock) AS stock_total,
       ROUND(AVG(precio), 2) AS media_precio
FROM productos
GROUP BY categoria;

SELECT categoria, COUNT(*) AS n
FROM productos
GROUP BY categoria
HAVING COUNT(*) >= 2;

SELECT estado, COUNT(*) AS n, SUM(cantidad) AS uds
FROM pedidos
WHERE estado <> 'cancelado'
GROUP BY estado;

SELECT ciudad, COUNT(*) AS n
FROM clientes
GROUP BY ciudad
HAVING COUNT(*) > 1;
