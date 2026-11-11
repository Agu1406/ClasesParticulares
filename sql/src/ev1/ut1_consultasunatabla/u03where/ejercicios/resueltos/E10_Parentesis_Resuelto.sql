/*
OBJETIVO: Activos de Barcelona o cualquier cliente de Bilbao.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- ENUNCIADO: Activos de Barcelona o cualquier cliente de Bilbao.
SELECT nombre, ciudad, activo
FROM clientes
WHERE (ciudad = 'Barcelona' AND activo = 1)
   OR ciudad = 'Bilbao';
