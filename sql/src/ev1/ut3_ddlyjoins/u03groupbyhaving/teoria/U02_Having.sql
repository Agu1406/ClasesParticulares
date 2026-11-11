/*
OBJETIVO: Filtrar grupos con HAVING (despues de agrupar).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- WHERE filtra filas ANTES de agrupar.
-- HAVING filtra GRUPOS DESPUES de agrupar.

SELECT categoria, COUNT(*) AS cuantos
FROM productos
GROUP BY categoria
HAVING COUNT(*) >= 2;

SELECT ciudad, COUNT(*) AS n
FROM clientes
GROUP BY ciudad
HAVING COUNT(*) > 1;

-- Mal tipico: WHERE COUNT(*) >= 2  -> no; eso va en HAVING.
