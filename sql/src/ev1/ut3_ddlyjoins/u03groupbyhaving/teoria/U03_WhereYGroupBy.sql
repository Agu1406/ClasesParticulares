/*
OBJETIVO: Combinar WHERE + GROUP BY + HAVING + ORDER BY.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

SELECT categoria, ROUND(AVG(precio), 2) AS media
FROM productos
WHERE stock > 0
GROUP BY categoria
HAVING AVG(precio) > 40
ORDER BY media DESC;

SELECT estado, SUM(cantidad) AS uds
FROM pedidos
WHERE estado <> 'cancelado'
GROUP BY estado
ORDER BY uds DESC;
