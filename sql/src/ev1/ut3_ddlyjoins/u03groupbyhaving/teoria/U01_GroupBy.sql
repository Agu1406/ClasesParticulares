/*
OBJETIVO: Agrupar filas con GROUP BY y una agregada.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- Sin GROUP BY (UT1): un solo resumen de toda la tabla.
-- Con GROUP BY: un resumen POR cada valor de grupo.

SELECT categoria, COUNT(*) AS cuantos
FROM productos
GROUP BY categoria;

SELECT ciudad, COUNT(*) AS clientes
FROM clientes
GROUP BY ciudad;

SELECT estado, COUNT(*) AS pedidos
FROM pedidos
GROUP BY estado;

-- Regla: en el SELECT, cada columna debe ser agregada O aparecer en GROUP BY.
