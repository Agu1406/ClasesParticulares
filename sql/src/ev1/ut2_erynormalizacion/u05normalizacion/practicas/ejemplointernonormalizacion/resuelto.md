<!--
OBJETIVO: Solucion normalizacion factura 3FN.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# Resuelto — Factura 3FN

```text
Cliente(cliente_id PK, cliente_nombre, cliente_ciudad)
Producto(producto_id PK, producto_nombre, producto_precio)
TipoIVA(iva_tipo PK, iva_nombre)
Factura(num_factura PK, fecha, cliente_id FK)
LineaFactura(num_factura FK, producto_id FK, cantidad, iva_tipo FK)
  PK (num_factura, producto_id)  -- o num_linea
```

cantidad es atributo de la **linea**, no del producto.

Nota: precios historicos en facturas reales se congelan en la linea; aqui simplificamos.
