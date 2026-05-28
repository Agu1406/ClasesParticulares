# EV3 — DOM, capas y comunicación asíncrona

**Evaluación 3.ª** · Trimestre 3 · Peso orientativo: **25–35 %** del módulo

## Resultados de aprendizaje

| RA | Cobertura en EV3 |
| --- | --- |
| **RA 6** | Completo |
| **RA 7** | Completo |

## Unidades

### ut7-dom (RA 6)

- Árbol DOM: nodos, elementos, texto
- Selectores: `getElementById`, `querySelector`, `querySelectorAll`
- Crear, modificar y eliminar nodos
- Atributos, enlaces y `href`
- Clases CSS desde JS (`classList`)
- Separación: HTML (contenido), CSS (aspecto), JS (comportamiento)

**Al terminar la UT:** página que construya o modifique listas/tablas dinámicamente sin frameworks.

En centros con solo 2 evaluaciones, este bloque cierra el módulo; **ut8** (fetch, APIs) puede no impartirse.

### ut8-async-frameworks (RA 7)

- Sincronía vs asincronía; callback hell (contexto)
- Promesas, `async` / `await`
- `fetch`: GET/POST, cabeceras, JSON
- Actualizar DOM con datos del servidor
- Librerías ligeras o framework (React/Vue según centro)

**Al terminar la UT:** app que cargue datos de una API pública y los muestre en pantalla.

## Orden de estudio en cada UT (convención C)

1. Subtemas numerados `01-…` → `04-…`: `teoria/` + `ejercicios/pendientes|resueltos/` (01–10).
2. En el mismo subtema, `practicas/`: entregas reales de institutos.
3. Último bloque: `05-repaso` — repaso de toda la UT (en ut7 incluye examen final Ventura).

## Estructura por UT (convención C)

| UT | Subtemas | Repaso | Prácticas de instituto |
| --- | --- | --- | --- |
| [ut7-dom](./ut7-dom/) | `01` selectores · `02` modificar nodos · `03` atributos/enlaces · `04` classList | `05-repaso` | Ventura en `01`–`04`; examen en `05-repaso` |
| [ut8-async-frameworks](./ut8-async-frameworks/) | `01` async · `02` promesas · `03` fetch · `04` DOM+APIs | `05-repaso` | — (solo material genérico) |

Regenerar ejercicios genéricos: `node js/scripts/gen-ev3.mjs`.

## Entregables típicos (referencia)

- Práctica DOM (ut7): galería, lista de tareas, CRUD en memoria + DOM
- Proyecto final (ut8): cliente + API (JSONPlaceholder, OpenWeather, etc.) o SPA mínima con framework
- Examen EV3: DOM + lectura de código async

## Enlace al BOE

Criterios completos: [BOE DWEC — RA 6, RA 7](../BOE-2023-06-03-RD-405-modulo-0612-DWEC.md#resultados-de-aprendizaje-y-criterios-de-evaluación)

[← Volver a la guía general](../README.md)
