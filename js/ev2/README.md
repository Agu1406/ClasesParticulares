# EV2 — Objetos del navegador, POO e interactividad

**Evaluación 2.ª** · Trimestre 2 · Peso orientativo: **35–40 %** del módulo

## Resultados de aprendizaje

| RA | Cobertura en EV2 |
| --- | --- |
| **RA 3** | Cierre (ventanas, storage, objetos predefinidos) |
| **RA 4** | Completo |
| **RA 5** | Completo |

## Unidades

### ut4-objetos-navegador (RA 3)

- Objeto `window`: tamaño, location, open/close
- Objeto `document`: title, URL, write (uso controlado)
- Diálogos: `alert`, `confirm`, `prompt`
- `localStorage` / `sessionStorage`
- Depuración y documentación del código

**Al terminar la UT:** mini-app que persista preferencias en `localStorage`.

### ut5-poo-colecciones (RA 4)

- Funciones: declaración, parámetros, return, arrow functions
- Arrays: métodos, recorrido, `map`, `filter`, `reduce`
- Clases ES6, herencia, prototipos
- POO aplicada a dominio del enunciado

**Proyectos de instituto (ut5):**

| Proyecto | Enunciado | Código |
| --- | --- | --- |
| Tocadiscos (Almería) | [enunciado](./ut5-poo-colecciones/enunciados/tocadiscos--almeria-iesaguadulce.md) | [práctica](./ut5-poo-colecciones/03-objetos-y-clases/practicas/almeria-tocadiscos/) |
| Ejército romano (Almería) | — | [práctica](./ut5-poo-colecciones/03-objetos-y-clases/practicas/almeria-ejercito-romano/) |

**Al terminar la UT:** proyecto POO con al menos 2 niveles de herencia o composición clara.

### ut6-eventos-formularios (RA 5)

- Modelo de eventos: bubbling, `preventDefault`
- `addEventListener` vs atributos HTML
- Formularios: `submit`, validación en cliente
- Expresiones regulares para email, DNI, etc.

**Al terminar la UT:** formulario validado sin envío real o con envío simulado.

## Entregables típicos (referencia)

- Proyecto POO (ut5) — **40–50 %** de la nota de EV2 en muchos centros
- Práctica eventos + formulario (ut6)
- Examen: teoría RA 4–5 + corrección de código

## Orden de estudio en cada UT (convención C)

1. Subtemas numerados `01-…` → `04-…` (o más): `teoria/` + `ejercicios/pendientes|resueltos/` (01–10).
2. En el mismo subtema, `practicas/`: entregas reales de institutos, tras dominar el bloque.
3. Último bloque: `05-repaso` — repaso de toda la UT.

## Estructura por UT (convención C)

Cada UT sigue el mismo esquema que [EV1 / ut1](../ev1/ut1-cliente-web/): subtemas `01-…` → `05-repaso`, con `teoria/`, `ejercicios/` y `practicas/` solo si hay material de centro.

| UT | Subtemas | Repaso | Prácticas de instituto |
| --- | --- | --- | --- |
| [ut4-objetos-navegador](./ut4-objetos-navegador/) | `01` window · `02` document · `03` diálogos · `04` storage | `05-repaso` | — (solo material genérico) |
| [ut5-poo-colecciones](./ut5-poo-colecciones/) | `01` funciones · `02` arrays · `03` objetos/clases · `04` herencia | `05-repaso` | Ventura en `01`–`04`; Almería en `03` |
| [ut6-eventos-formularios](./ut6-eventos-formularios/) | `01` modelo eventos · `02` listeners · `03` formularios · `04` regexp | `05-repaso` | Ventura en `01`–`02` |

Regenerar ejercicios genéricos: `node js/scripts/gen-ev2.mjs` (usa `gen-dwec-lib.mjs`).

## Enlace al BOE

Criterios completos: [BOE DWEC — RA 3 (cierre), RA 4, RA 5](../BOE-2023-06-03-RD-405-modulo-0612-DWEC.md#resultados-de-aprendizaje-y-criterios-de-evaluación)

[← Volver a la guía general](../README.md)
