# Repositorio de Clases Particulares — JavaScript (DWEC)

Material de **Desarrollo web en entorno cliente** (módulo **0612**, 2.º de DAW), organizado como en `java/`: por **evaluación (EV)** y **unidad teórica (UT)**, alineado con el BOE.

- [BOE-2023-06-03-RD-405-modulo-0612-DWEC.md](./BOE-2023-06-03-RD-405-modulo-0612-DWEC.md)

## Estructura de `js/`

```text
js/
├── BOE-2023-06-03-RD-405-modulo-0612-DWEC.md
├── README.md                 ← única guía (esta)
├── ignorar/                  ← gitignored: material bruto, scripts generadores
├── ev1/
├── ev2/
└── ev3/
```

Cada UT usa subtemas numerados (`01-…`, `02-…`, …, `NN-repaso`). En cada subtema: `teoria/`, `ejercicios/pendientes|resueltos/` (01–10) y, si aplica, `practicas/` (enunciado + `_SIN_RESOLVER` + `_RESUELTO` en la misma carpeta, como en Java).

**Orden de estudio:** teoría → ejercicios genéricos → prácticas de instituto → bloque `NN-repaso` de la UT.

### Scripts (solo local)

Los generadores viven en `ignorar/scripts/` y **no** se publican en GitHub. Ejemplo:

```bash
node js/ignorar/scripts/gen-regexp-ut6-aguadulce.mjs
```

---

## Mapa RA → evaluación → unidad

| Evaluación | RA del BOE | Unidades (UT) |
| --- | --- | --- |
| **EV1** | RA 1, RA 2, inicio RA 3 | `ut1-cliente-web`, `ut2-sintaxis-js`, `ut3-objetos-intro` |
| **EV2** | RA 3 (cierre), RA 4, RA 5 | `ut4-objetos-navegador`, `ut5-poo-colecciones`, `ut6-eventos-formularios` |
| **EV3** | RA 6, RA 7 | `ut7-dom`, `ut8-async-frameworks` |

| RA | Título breve | EV principal |
| --- | --- | --- |
| RA 1 | Arquitecturas cliente | EV1 |
| RA 2 | Sintaxis | EV1 |
| RA 3 | Objetos predefinidos | EV1 + EV2 (`ut4`) |
| RA 4 | Funciones, arrays, POO | EV2 |
| RA 5 | Eventos y formularios | EV2 |
| RA 6 | DOM | EV3 |
| RA 7 | Async y frameworks | EV3 |

Pesos orientativos: EV1 **30–35 %**, EV2 **35–40 %**, EV3 **25–35 %** (cada centro define los suyos en la programación didáctica).

---

## EV1 — Cliente web y JavaScript básico

| UT | Subtemas | Repaso | Prácticas de instituto |
| --- | --- | --- | --- |
| `ut1-cliente-web` | `01` cliente · `02` scripts · `03` devtools · `04` dom | `05-repaso` | Ventura en `02`, `04` |
| `ut2-sintaxis-js` | `01` variables · `02` operadores · `03` condicionales · `04` bucles · `05` estilo | `06-repaso` | Ventura en `01`–`04` |
| `ut3-objetos-intro` | `01` consola · `02` window/document · `03` errores | `04-repaso` | — |

Contenidos: cliente/servidor, DevTools, sintaxis (`let`, bucles, condicionales), `console`, primer contacto con `window`/`document`.

---

## EV2 — Objetos del navegador, POO e interactividad

| UT | Subtemas | Repaso | Prácticas de instituto |
| --- | --- | --- | --- |
| `ut4-objetos-navegador` | `01` window · `02` document · `03` diálogos · `04` storage | `05-repaso` | — |
| `ut5-poo-colecciones` | `01` funciones · `02` arrays · `03` objetos/clases · `04` herencia | `05-repaso` | Ventura `01`–`04`; Almería en `03` |
| `ut6-eventos-formularios` | `01` eventos · `02` listeners · `03` formularios · `04` regexp | `05-repaso` | Ventura `01`–`02`; Aguadulce (Morones) `03`–`04` |

**Proyectos Almería (ut5):**

- Tocadiscos: `ev2/ut5-poo-colecciones/03-objetos-y-clases/practicas/almeria-tocadiscos/`
- Ejército romano: `ev2/ut5-poo-colecciones/03-objetos-y-clases/practicas/almeria-ejercito-romano/`

**Aguadulce — Morones (ut6):**

- Tarea 06 AJAX: `ev2/ut6-eventos-formularios/03-formularios/practicas/almeria-morones-tarea06-tiempo-ajax/`
- Tarjeta crédito (regexp / lookahead): `ev2/ut6-eventos-formularios/04-regexp-validacion/practicas/almeria-morones-tarjeta-credito/`
- Ejercicios regexp (`04-regexp-validacion/ejercicios/`): solo `pendientes/` y `resueltos/`; cada carpeta `01-…` … `10-…` pide **regex normal** y **lookahead** (sin `(?:)`).

---

## EV3 — DOM y comunicación asíncrona

| UT | Subtemas | Repaso | Prácticas de instituto |
| --- | --- | --- | --- |
| `ut7-dom` | `01` selectores · `02` nodos · `03` atributos · `04` classList | `05-repaso` | Ventura `01`–`04`; examen en `05-repaso` |
| `ut8-async-frameworks` | `01` async · `02` promesas · `03` fetch · `04` DOM+APIs | `05-repaso` | — |

En centros con solo 2 evaluaciones, `ut8` puede no impartirse; el DOM (`ut7`) cierra el módulo.

---

## Convención de carpetas

| Capa | Ruta | Qué guarda |
| --- | --- | --- |
| Subtema | `evN/utX-…/01-tema/` … | Bloque numerado del temario |
| Teoría | `…/teoria/*.js` | Ejemplos ejecutables (JSDoc) |
| Ejercicios | `…/ejercicios/pendientes\|resueltos/01-…` | 10 + 10 por subtema; orden `01`→`10` en el nombre de carpeta |
| Prácticas | `…/practicas/{origen}-…/` | Enunciado + `*_SIN_RESOLVER` + `*_RESUELTO` |
| Repaso UT | `…/NN-repaso/` | Mezcla de toda la UT |

**PHP** usa geografía en la raíz (`php/andalucia/…`). **JS** prioriza subtema numerado; el material de centro va en `practicas/`, no en carpetas `enunciados/` sueltas.

---

## Dos o tres evaluaciones según el centro

| Modelo | En este repo |
| --- | --- |
| **3 evaluaciones** | `ev1` + `ev2` + `ev3` |
| **2 evaluaciones** | Mismo árbol: 1.º trimestre → `ev1`, 2.º → `ev2`+`ev3` |

Referencia **IES Ventura Rodríguez** (Madrid): topics 1–4 en 1.º trimestre; topics 5–6 + examen en 2.º (`practicas/ventura-*` repartidas en `ev1`–`ev3`).

---

## Relación con Java (1.º DAW)

| Programación (Java) | DWEC (JavaScript) |
| --- | --- |
| `ev1` fundamentos | `ev1` cliente + sintaxis |
| `ev2` colecciones, POO | `ev2` POO, eventos, formularios |
| `ev3` JDBC, Spring | `ev3` DOM, fetch, frameworks |

Convenciones detalladas de Java: `java/src/ignorar/AGENT.md` (no commiteado; misma idea que `js/ignorar/`).
