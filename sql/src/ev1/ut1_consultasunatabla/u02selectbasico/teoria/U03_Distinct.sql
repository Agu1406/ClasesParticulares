/*
OBJETIVO: Eliminar duplicados del resultado con DISTINCT.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- =============================================================================
-- DISTINCT: valores unicos
-- =============================================================================
-- Sin DISTINCT, si 3 clientes viven en Madrid, Madrid sale 3 veces.

SELECT ciudad FROM clientes;           -- puede repetir
SELECT DISTINCT ciudad FROM clientes;  -- cada ciudad una vez

SELECT DISTINCT categoria FROM productos;

-- DISTINCT aplica a la COMBINACION de columnas listadas:
SELECT DISTINCT ciudad, activo FROM clientes;

-- No confundir con "unique en la tabla": DISTINCT solo afecta al RESULTADO.

-- Prueba tu: DISTINCT estado FROM pedidos;
