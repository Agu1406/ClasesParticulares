<!--
OBJETIVO: Montar un E/R minimo de la tienda vista en UT1.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# Ejemplo: E/R de tienda (minimo)

```text
[Cliente] 1 ----realiza---- N [Pedido] N ----incluye---- 1 [Producto]
```

Mas fiel a un ticket con varias lineas (futuro):

```text
[Cliente] 1 -- N [Pedido] 1 -- N [LineaPedido] N -- 1 [Producto]
```

En nuestra BD UT1, `pedidos` mezcla cabecera y linea (un producto por fila): util para practicar SQL, no es el diseno "perfecto" de factura.

## Prueba tu

Anade entidad `Categoria` 1 — N Producto al diagrama.
