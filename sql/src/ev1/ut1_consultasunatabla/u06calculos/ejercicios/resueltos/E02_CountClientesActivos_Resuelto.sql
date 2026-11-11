/*
OBJETIVO: Cuenta clientes con activo = 1.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Cuenta clientes con activo = 1.
SELECT COUNT(*) AS activos
FROM clientes
WHERE activo = 1;
