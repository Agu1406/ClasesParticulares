/*
OBJETIVO: Ejecutar los primeros SELECT y comprobar que la BD tienda responde.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- =============================================================================
-- Primera consulta proyectable
-- =============================================================================
-- Orden logico mental: FROM (de donde) -> SELECT (que columnas).
-- Orden de escritura: SELECT ... FROM ...

SELECT id_producto, nombre, precio
FROM productos;

SELECT id_cliente, nombre, apellidos, ciudad
FROM clientes;

SELECT id_pedido, cantidad, estado, fecha_pedido
FROM pedidos;

-- Si ves filas, el entorno esta listo: pasa a u02 (SELECT con mas control).

-- Prueba tu:
-- 1) Muestra solo nombre y stock de productos.
-- 2) Muestra solo nombre y email de clientes.
