/*
8. Unión de tablas
Pregunta: Tienes dos tablas: "pedidos" y "productos". Realiza una consulta que muestre el nombre del producto y el nombre del cliente para cada pedido.

Tabla "pedidos":

| id_pedido | id_producto   | id_cliente | fecha        |
|-----------|---------------|------------|--------------|
| 1         | 10            | 1          | 2023-11-20   |
| 2         | 12            | 2          | 2023-11-21   |
| 3         | 10            | 3          | 2023-11-22   |

Tabla "productos":

| id_producto | nombre_producto | precio |
|-------------|-----------------|--------|
| 10          | Teléfono móvil  | 300    |
| 11          | Tablet          | 450    |
| 12          | Auriculares     | 50     |

Tabla "clientes":

| id_cliente | nombre_cliente |
|------------|----------------|
| 1          | Juan Pérez     |
| 2          | María López    |
| 3          | Pedro García   |
*/

-- Consulta SQL
SELECT 
    productos.nombre_producto,
    clientes.nombre_cliente
FROM pedidos
INNER JOIN productos ON pedidos.id_producto = productos.id_producto
INNER JOIN clientes ON pedidos.id_cliente = clientes.id_cliente;