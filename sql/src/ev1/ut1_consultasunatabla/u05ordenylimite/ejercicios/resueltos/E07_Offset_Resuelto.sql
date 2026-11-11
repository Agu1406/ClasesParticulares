/*
OBJETIVO: Productos por precio DESC: saltar 3 y mostrar 3.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Productos por precio DESC: saltar 3 y mostrar 3.
SELECT nombre, precio
FROM productos
ORDER BY precio DESC
LIMIT 3 OFFSET 3;
