/*
OBJETIVO: Tratar valores desconocidos con IS NULL / IS NOT NULL (nunca = NULL).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- =============================================================================
-- NULL: valor desconocido / ausente
-- =============================================================================
-- NULL no es 0, ni '', ni 'null'. Es "no hay dato".

-- MAL (no hace lo que crees):
-- WHERE email = NULL

-- BIEN:
SELECT nombre, email FROM clientes WHERE email IS NULL;
SELECT nombre, telefono FROM clientes WHERE telefono IS NOT NULL;
SELECT nombre, descripcion FROM productos WHERE descripcion IS NULL;

-- En condiciones, NULL "contagia": comparaciones con NULL no son TRUE.
-- Por eso necesitamos IS NULL.

-- Prueba tu: clientes con email informado Y telefono informado.
