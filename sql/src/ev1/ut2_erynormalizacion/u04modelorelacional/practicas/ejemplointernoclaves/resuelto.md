<!--
OBJETIVO: Solucion claves tienda + categoria.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# Resuelto

```text
Categoria(id_categoria PK, nombre)
Producto(..., id_categoria FK)
Pedido(id_pedido PK, id_cliente FK, id_producto FK, ...)
Cliente(id_cliente PK, ...)
```

INSERT INTO pedidos (..., id_cliente) VALUES (..., 999);
— falla si 999 no esta en clientes (integridad referencial).
