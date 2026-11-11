/*
OBJETIVO: Declarar claves ajenas y entender integridad referencial.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
*/

USE tienda;

-- En tienda, pedidos referencia clientes y productos:

SHOW CREATE TABLE pedidos;

-- Idea:
-- CONSTRAINT fk_pedidos_cliente
--   FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)

-- Al insertar un pedido, id_cliente debe existir (o la sentencia falla).

SELECT CONSTRAINT_NAME, COLUMN_NAME, REFERENCED_TABLE_NAME, REFERENCED_COLUMN_NAME
FROM information_schema.KEY_COLUMN_USAGE
WHERE TABLE_SCHEMA = 'tienda' AND TABLE_NAME = 'pedidos'
  AND REFERENCED_TABLE_NAME IS NOT NULL;
