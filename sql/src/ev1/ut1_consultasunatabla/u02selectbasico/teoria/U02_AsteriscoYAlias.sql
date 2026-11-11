/*
OBJETIVO: Usar * para explorar y AS para renombrar columnas en el resultado.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- =============================================================================
-- Asterisco: todas las columnas
-- =============================================================================
-- Util para EXPLORAR. En entregas y examenes, lista columnas explicitas.

SELECT * FROM productos;
SELECT * FROM clientes;

-- =============================================================================
-- Alias con AS (nombre en el resultado)
-- =============================================================================
SELECT nombre AS producto,
       precio AS precio_euros
FROM productos;

SELECT CONCAT(nombre, ' ', apellidos) AS nombre_completo
FROM clientes;

-- En MySQL AS es opcional: SELECT nombre producto FROM productos;
-- En clase lo escribimos SIEMPRE con AS para claridad.

-- =============================================================================
-- Errores tipicos
-- =============================================================================
-- - Confundir alias con renombrar la columna real en la tabla (AS no altera la BD)
-- - Olvidar comillas en alias con espacios: AS `precio euros` o AS 'precio euros'

-- Prueba tu: SELECT nombre AS articulo, stock AS unidades FROM productos;
