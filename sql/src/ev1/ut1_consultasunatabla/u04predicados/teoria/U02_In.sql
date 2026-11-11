/*
OBJETIVO: Comparar con una lista de valores usando IN (...).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- =============================================================================
-- IN: pertenencia a una lista
-- =============================================================================
-- categoria IN ('Audio','Cables')  <=>  categoria='Audio' OR categoria='Cables'

SELECT nombre, categoria
FROM productos
WHERE categoria IN ('Audio', 'Cables', 'Accesorios');

SELECT nombre, ciudad
FROM clientes
WHERE ciudad IN ('Madrid', 'Barcelona', 'Valencia');

SELECT id_pedido, estado
FROM pedidos
WHERE estado IN ('pendiente', 'enviado');

-- NOT IN para excluir listas (cuidado con NULL en la lista: tema avanzado).

-- Prueba tu: productos en ('Mobiliario','Portatiles').
