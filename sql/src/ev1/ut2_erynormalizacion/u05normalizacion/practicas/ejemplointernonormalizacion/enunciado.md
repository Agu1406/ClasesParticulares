<!--
OBJETIVO: Practica: normalizar una factura desnormalizada hasta 3FN.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# Practica interna u05 — Factura

## Tabla inicial (desnormalizada)

```text
FacturaLinea(
  num_factura, fecha,
  cliente_id, cliente_nombre, cliente_ciudad,
  producto_id, producto_nombre, producto_precio,
  cantidad, iva_tipo, iva_nombre
)
```

Suposiciones: una factura un cliente; muchas lineas; iva_tipo determina iva_nombre; producto_id determina nombre y precio actuales (ojo historico: simplificar).

## Tareas

1. Indica violaciones 1FN/2FN/3FN.
2. Propón el conjunto de tablas en 3FN con PK/FK.
3. Explica donde queda cantidad.

## Checklist

- [ ] Cliente separado
- [ ] Producto separado
- [ ] TipoIVA separado (si aplica)
- [ ] Factura + LineaFactura
