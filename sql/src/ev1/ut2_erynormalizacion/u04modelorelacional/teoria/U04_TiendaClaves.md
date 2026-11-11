<!--
OBJETIVO: Leer PK/FK sobre el esquema tienda de UT1.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# Caso: tienda (UT1)

```text
clientes(id_cliente PK, nombre, apellidos, email UNIQUE?, ...)
productos(id_producto PK, nombre, categoria, precio, stock, ...)
pedidos(id_pedido PK, id_cliente FK, id_producto FK, cantidad, fecha_pedido, estado)
```

Integridad referencial: no puedes insertar un pedido con `id_cliente = 999` si no existe.

## Prueba tu

Propón una clave alternativa en productos (si tuvieras codigo_barras UNIQUE).
