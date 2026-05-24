# Repositorio de Clases Particulares — JavaScript (DWEC)

Material de **Desarrollo web en entorno cliente** (módulo **0612**, 2.º de DAW), organizado como en `java/`: por **evaluación (EV)** y **unidad teórica (UT)**, alineado con el BOE.

## Temario oficial

- [BOE-2023-06-03-RD-405-modulo-0612-DWEC.md](./BOE-2023-06-03-RD-405-modulo-0612-DWEC.md) — extracto RD 405/2023 (7 RA, contenidos, orientaciones).

## Estructura del directorio `js/`

```bash
js/
├── BOE-2023-06-03-RD-405-modulo-0612-DWEC.md
├── README.md                    # Esta guía
├── ev1/                         # 1.ª evaluación
│   ├── ut1-cliente-web/
│   ├── ut2-sintaxis-js/
│   ├── ut3-objetos-intro/
│   └── README.md
├── ev2/                         # 2.ª evaluación
│   ├── ut4-objetos-navegador/
│   ├── ut5-poo-colecciones/
│   ├── ut6-eventos-formularios/
│   ├── por_centro/              # Ejercicios por CCAA / provincia / centro (como java/src/ev3/por_centro)
│   │   └── andalucia/almeria/…
│   └── README.md
└── ev3/                         # 3.ª evaluación
    ├── ut7-dom/
    ├── ut8-async-frameworks/
    └── README.md
```

Cada carpeta `ut*` es un hueco para teoría genérica. Los proyectos **de un instituto concreto** van en `evN/por_centro/{comunidad}/{provincia}/{centro}/`, igual que en Java pero bajo la evaluación que toque (no hace falta esperar a ev3 si el ejercicio es de EV2).

---

## Mapa RA → evaluación → unidad

Referencia normativa: **7 resultados de aprendizaje (RA)** del BOE.  
La repartición en **3 evaluaciones** reproduce el esquema habitual de FP (tres trimestres) y el estilo de Programación en 1.º (`ev1` / `ev2` / `ev3`).

| Evaluación | RA del BOE | Unidades (UT) | Qué debes dominar al final |
| --- | --- | --- | --- |
| **EV1** | **RA 1**, **RA 2**, inicio **RA 3** | ut1, ut2, ut3 | Entender cliente web, escribir JS básico en el navegador, usar consola y objetos globales elementales. |
| **EV2** | **RA 3** (cierre), **RA 4**, **RA 5** | ut4, ut5, ut6 | Objetos del navegador, POO en JS, arrays/funciones, eventos y validación de formularios. |
| **EV3** | **RA 6**, **RA 7** | ut7, ut8 | DOM avanzado, separación de capas, comunicación asíncrona, JSON, fetch y frameworks. |

### Detalle por evaluación

#### EV1 — Fundamentos del cliente y sintaxis JavaScript

| UT | RA | Contenidos (BOE) | Criterios clave (resumen) |
| --- | --- | --- | --- |
| **ut1-cliente-web** | RA 1 | Cliente/servidor, ejecución en navegador, integración HTML+JS, DevTools | Modelos cliente/servidor, lenguajes de script, herramientas de prueba |
| **ut2-sintaxis-js** | RA 2 | Variables, tipos, operadores, if/for/while, comentarios | Sintaxis correcta, ámbitos, conversiones, depuración básica |
| **ut3-objetos-intro** | RA 2 → RA 3 | Primer contacto con `console`, `document`/`window` de forma guiada | Selección del lenguaje, sentencias en navegador, lectura de errores en consola |

#### EV2 — Objetos, POO, colecciones e interactividad

| UT | RA | Contenidos (BOE) | Criterios clave (resumen) |
| --- | --- | --- | --- |
| **ut4-objetos-navegador** | RA 3 | `window`, `document`, diálogos, ventanas, almacenamiento en navegador | Objetos predefinidos, interacción con usuario, storage |
| **ut5-poo-colecciones** | RA 4 | Funciones, arrays, map/filter/reduce, clases, métodos, patrones básicos | POO en JS, colecciones, código reutilizable documentado |
| **ut6-eventos-formularios** | RA 5 | `addEventListener`, tipos de eventos, validación, regex en formularios | Apps interactivas, validación y prueba |

**Ejercicios en el repo (EV2 / ut5):**

- [Tocadiscos (POO, herencia, polimorfismo)](./ev2/por_centro/andalucia/almeria/documentos/Ejercicio%20todadiscos%20musica.md) — código en `ev2/por_centro/andalucia/almeria/iesaguadulce/ejercicio tocadiscos musica/`
- [Ejército romano (POO)](./ev2/por_centro/andalucia/almeria/iesaguadulce/ejercicio%20ejercito%20romano/) — clases `Soldado`, `Centuria`, `Legion`

#### EV3 — DOM dinámico y comunicación asíncrona

| UT | RA | Contenidos (BOE) | Criterios clave (resumen) |
| --- | --- | --- | --- |
| **ut7-dom** | RA 6 | Selección y modificación del DOM, eventos en nodos, compatibilidad entre navegadores, separación contenido / aspecto / comportamiento | Manipular estructura HTML desde JS, capas independientes |
| **ut8-async-frameworks** | RA 7 | Promesas, `fetch`, JSON, actualización dinámica de la página, introducción a librerías o frameworks (React, Vue, etc.) | Comunicación cliente-servidor asíncrona, uso responsable de frameworks |

---

## Tabla rápida: RA → EV

| RA | Título breve | Evaluación principal |
| --- | --- | --- |
| RA 1 | Arquitecturas y tecnologías cliente | EV1 |
| RA 2 | Sintaxis del lenguaje | EV1 |
| RA 3 | Objetos predefinidos del lenguaje | EV1 (inicio) + EV2 (ut4) |
| RA 4 | Estructuras definidas por el usuario (funciones, arrays, POO) | EV2 |
| RA 5 | Eventos y aplicaciones interactivas | EV2 |
| RA 6 | DOM | EV3 |
| RA 7 | Comunicación asíncrona y frameworks | EV3 |

---

## Pesos orientativos para evaluación (centro)

El BOE no fija porcentajes por RA; cada departamento los define en la **programación didáctica**. Propuesta equilibrada (ajustable):

| Evaluación | RA incluidos | Peso orientativo |
| --- | --- | --- |
| EV1 | RA 1, RA 2, RA 3 (parcial) | 30–35 % |
| EV2 | RA 3 (cierre), RA 4, RA 5 | 35–40 % |
| EV3 | RA 6, RA 7 | 25–35 % |

En muchos centros **hay que aprobar todos los RA** evaluados en cada convocatoria (nota mínima 5 por bloque), igual que en Programación.

---

## Cómo usar esta guía (alumno o profesor)

1. Abre el [BOE del módulo](./BOE-2023-06-03-RD-405-modulo-0612-DWEC.md) y localiza el RA de la UT que toque.
2. Entra en `evN/utX-…/` y añade apuntes, ejercicios o enlaces.
3. Antes de un examen, repasa la fila de la tabla **RA → EV** y los criterios de evaluación del BOE de esos RA.
4. Si el centro publica programación didáctica propia, **prioriza sus fechas y pesos**; este mapa sigue siendo válido para saber *qué* entra en cada evaluación.

---

## Relación con Java (1.º DAW)

| Programación (Java) | DWEC (JavaScript) |
| --- | --- |
| `ev1` fundamentos, tipos, bucles | `ev1` cliente web + sintaxis JS |
| `ev2` arrays, ArrayList | `ev2` arrays, funciones, POO (como tocadiscos) |
| `ev3` POO avanzada, JDBC | `ev3` DOM, fetch, APIs, frameworks |

La lógica es la misma: **EV = trimestre académico**, **UT = bloque dentro del trimestre**, **RA = lo que exige el BOE**.

---

## Convención `por_centro` (Andalucía, Madrid, …)

En **Java**, el material de un instituto concreto está en `java/src/ev3/por_centro/{comunidad}/…/ {centro}/`.

En **JS** se repite la idea, pero la carpeta `por_centro` cuelga de la **evaluación donde encaja el RA** (no todo en ev3):

| Capa | Ruta | Qué guarda |
| --- | --- | --- |
| Temario / UT genérica | `evN/utX-…/` | Apuntes reutilizables, ejercicios tipo |
| Proyecto de un centro | `evN/por_centro/{ccaa}/{provincia}/{centro}/` | Código y enunciados de ese instituto |
| Enunciados provinciales | `…/por_centro/…/{provincia}/documentos/` | PDF/MD compartidos en la provincia |

**PHP** en este repo usa solo geografía en la raíz (`php/andalucia/almeria/…`). **Java y JS** combinan **evaluación + geografía** para que sepas a la vez *cuándo* se da en DWEC y *de dónde* viene el ejercicio.

---

## Próximos pasos en el repo

- [ ] Apuntes y ejercicios en `ev1/ut1` … `ev3/ut8`
- [ ] Exámenes tipo por evaluación en `evN/docs/`
- [ ] Ampliar material por centro en `evN/por_centro/andalucia/`, `…/madrid/`, etc.

Guías detalladas por evaluación: [ev1/README.md](./ev1/README.md), [ev2/README.md](./ev2/README.md), [ev3/README.md](./ev3/README.md).
