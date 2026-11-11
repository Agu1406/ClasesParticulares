/*
OBJETIVO: Los 3 productos mas caros.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Los 3 productos mas caros.
SELECT nombre, precio
FROM productos
ORDER BY precio DESC
LIMIT 3;
