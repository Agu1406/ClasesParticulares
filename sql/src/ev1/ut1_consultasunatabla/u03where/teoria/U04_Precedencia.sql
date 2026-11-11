/*
OBJETIVO: Controlar AND/OR con parentesis para que el filtro diga lo que piensas.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- =============================================================================
-- Precedencia: AND se evalua antes que OR
-- =============================================================================
-- Regla de oro en clase: si mezclas AND y OR, PON PARENTESIS.

-- Quiero: (Perifericos baratos) O (cualquier Cable)
SELECT nombre, categoria, precio
FROM productos
WHERE (categoria = 'Perifericos' AND precio < 50)
   OR categoria = 'Cables';

-- Activos de Barcelona O cualquiera de Bilbao:
SELECT nombre, ciudad, activo
FROM clientes
WHERE (ciudad = 'Barcelona' AND activo = 1)
   OR ciudad = 'Bilbao';

-- Prueba tu: reescribe la primera quitando parentesis y compara resultados.
