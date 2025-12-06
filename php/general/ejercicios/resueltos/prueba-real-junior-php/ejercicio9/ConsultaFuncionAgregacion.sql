/*
9. Agrupación y funciones de agregación
Pregunta: Calcula el número total de pedidos por cliente y muestra el cliente con más pedidos.

Tabla "pedidos":

| id_pedido | id_producto   | id_cliente | fecha        |
|-----------|---------------|------------|--------------|
| 1         | 10            | 1          | 2023-11-20   |
| 2         | 12            | 2          | 2023-11-21   |
| 3         | 10            | 3          | 2023-11-22   |
*/

-- Consulta SQL
SELECT 
    id_cliente,
    COUNT(*) AS total_pedidos
FROM pedidos
GROUP BY id_cliente
ORDER BY total_pedidos DESC
LIMIT 1;