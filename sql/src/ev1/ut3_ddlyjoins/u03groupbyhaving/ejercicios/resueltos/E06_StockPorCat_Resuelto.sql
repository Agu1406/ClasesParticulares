/*
OBJETIVO: Suma de stock por categoria ordenada DESC.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Suma de stock por categoria ordenada DESC.
SELECT categoria, SUM(stock) AS stock_total
FROM productos
GROUP BY categoria
ORDER BY stock_total DESC;
