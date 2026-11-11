<!--
OBJETIVO: Traducir entidades debiles con PK compuesta dependiente del padre.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# Entidad debil

Depende de otra para existir/identificarse. Ejemplo: `LineaPedido` depende de `Pedido`.

```text
Pedido(id_pedido PK, ...)
LineaPedido(id_pedido FK, num_linea, id_producto FK, cantidad)
  PK: (id_pedido, num_linea)
```

La PK de la debil **incluye** la PK del padre.

## Prueba tu

Habitacion debil respecto a Hotel: propone PK.
