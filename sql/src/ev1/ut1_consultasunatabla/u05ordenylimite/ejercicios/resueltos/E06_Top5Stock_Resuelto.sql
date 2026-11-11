/*
OBJETIVO: Los 5 productos con mas stock.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Los 5 productos con mas stock.
SELECT nombre, stock
FROM productos
ORDER BY stock DESC
LIMIT 5;
