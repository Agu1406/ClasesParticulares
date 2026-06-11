# Examen TPP — Sales Analytics (programacion funcional)

Practica de repaso recuperada a partir del examen parcial de la alumna. El dataset se genera de forma determinista con `DatasetGenerator` (semilla fija `84`).

Entregar `pendiente/ExamSalesAnalytics_Pendiente` completado.

## Estructura

```
internotpppsalesanalytics/
├── interno-tpp-exam-sales-analytics.md   ← este documento
├── pendiente/                            ← plantilla en blanco
└── resuelto/                             ← solucion y intento parcial recuperado
```

## Modelo de datos

- **Customer:** `id`, `name`, `country`, `tier` (`STANDARD`, `PREMIUM`, `VIP`)
- **Product:** `id`, `name`, `category`, `price`
- **OrderItem:** `product`, `quantity`
- **Order:** `id`, `customer`, `items`, `orderDate`

Funciones auxiliares ya definidas en la clase principal:

- `itemRevenue`: ingresos de una linea de pedido (`precio × cantidad`)
- `orderRevenue`: ingresos totales de un pedido

## Ejercicios

Completar los metodos marcados con `// TODO` en `pendiente/ExamSalesAnalytics_Pendiente.java`.

1. **totalRevenueVIPCustomers** — Ingresos totales de pedidos cuyo cliente es `VIP`.
2. **anyOrderWhereCategoryIs** — `true` si existe al menos un pedido con algun producto de la categoria indicada.
3. **uniqueCategoriesByPremiumCustomers** — Categorias distintas compradas por clientes `PREMIUM`, ordenadas alfabeticamente.
4. **topExpensiveProducts** — Precios (`List<Double>`) de los 5 productos mas caros (sin repetir importes).
5. **totalProductsSoldInCategory** — Unidades vendidas de una categoria concreta (suma de cantidades).
6. **productsBoughtByCustomersFrom** — Nombres unicos de productos comprados por clientes de un pais.
7. **revenueWithDiscount** — Ingresos totales aplicando la funcion de descuento recibida a cada pedido.
8. **getPredicate** — `Predicate<Order>` que filtra por `tier`, `country` e ingreso del pedido mayor que un umbral.

## Salida de referencia (dataset por defecto)

Ejecutar `resuelto/ExamSalesAnalytics_Resuelto` para comprobar el resultado esperado con 50 clientes, 100 productos y 1000 pedidos.

El intento parcial de la alumna recuperado del examen esta en `resuelto/ExamSalesAnalytics_AlumnaParcial.java`.
