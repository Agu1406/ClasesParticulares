/*
OBJETIVO: Solucion practica arranque + checklist.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

USE tienda;
SHOW TABLES;
DESCRIBE clientes;
DESCRIBE productos;
DESCRIBE pedidos;
SELECT COUNT(*) AS n_clientes FROM clientes;
SELECT COUNT(*) AS n_productos FROM productos;
SELECT COUNT(*) AS n_pedidos FROM pedidos;
SELECT id_producto, nombre, precio FROM productos;

-- Checklist profesor: 3 tablas, counts > 0, SELECT devuelve filas.
