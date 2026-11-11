/*
OBJETIVO: Categorias con al menos 2 productos.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Categorias con al menos 2 productos.
SELECT categoria, COUNT(*) AS n
FROM productos
GROUP BY categoria
HAVING COUNT(*) >= 2;
