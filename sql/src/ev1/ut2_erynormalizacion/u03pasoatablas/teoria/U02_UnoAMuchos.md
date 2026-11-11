<!--
OBJETIVO: Traducir relaciones 1:N colocando la FK en el lado N.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# Relacion 1:N → FK en el lado N

```text
[Cliente] 1 ---- N [Pedido]
```

Tablas:

```text
Cliente(id_cliente PK, ...)
Pedido(id_pedido PK, ..., id_cliente FK → Cliente)
```

La FK vive donde esta el **muchos**.

## Prueba tu

Profesor 1 — N Curso: en que tabla va id_profesor?
