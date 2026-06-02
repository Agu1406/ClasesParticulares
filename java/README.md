# Java - Clases particulares (DAM/DAW)

Material de **Programacion (0485)** organizado por evaluaciones y unidades. Normativa: `BOE-2023-06-03-RD-405-modulo-0485-programacion.md`.

**Documentacion:** las explicaciones van en los propios `.java` (JavaDoc, comentarios multilinea y de linea). Este archivo es solo indice.

## Estructura

```
java/
├── BOE-2023-06-03-RD-405-modulo-0485-programacion.md
├── README.md
├── scripts/
└── src/
    ├── ev1/              RA1-RA3
    ├── ev2/              RA4-RA6
    ├── ev3/              RA7-RA9
    └── pruebaslibres/
```

Convencion por UT: subtemas numerados con `teoria/` (a veces `teoria/01-tema/` … en paralelo a `ejercicios/`), `ejercicios/` (`facil|medio|dificil` + `resueltos/`, o `01-for|02-while|03-dowhile` en `03-bucles`, etc.) y, cuando aplique, `practicas/` **dentro del subtema** (p. ej. `03-practicas-centro/practicas/`, `01-arrays/practicas/`), no solo en la raiz de la UT.

En `teoria/` del subtema solo van clases explicativas (`*Intro.java`, demos). Los ejercicios van en `ejercicios/{tema}/pendientes` y `resueltos` (antes `sin_resolver` bajo `teoria/`). Ejemplos ya aplicados:

| Subtema | Teoria | Ejercicios |
|---------|--------|------------|
| `03-bucles` | `BuclesComparacionIntro` + `teoria/01-for` … `03-dowhile` | `01-for`, `02-while`, `03-dowhile` |
| `02-condicionales` | `CondicionalesComparacionIntro` + `teoria/01-if` … `03-switch` | `01-if`, `02-ifelse`, `03-switch` |
| `04-metodos` | `MetodosIntro` | `pendientes` / `resueltos` (sin subcarpeta tema) |
| `01-strings` (UT3) | `StringIntro` | `pendientes` / `resueltos` |
| `02-excepciones` (UT5) | `ExcepcionesIntro`, `TryCatchFinallyIntro` | `pendientes` / `resueltos` |
| `04-ficheros-io` (UT5) | `FicherosIntro` | `pendientes` / `resueltos` |
| `05-repaso` | `RepasoMixtoIntro` | `pendientes` / `resueltos` (mixtos UT2) |

| `01-arrays` (UT4) | `ArraysIntro` | `facil`, `medio`, `dificil`; prácticas Calderón en `practicas/` |
| `02-arraylist-y-mapas` (UT4) | `teoria/01-arraylist`, `02-mapas` | `01-arraylist`, `02-mapas` (`pendientes` / `resueltos`) |
| `03-repaso` (UT4) | — | Examen/repaso CES en `practicas/` |
| `01-poo-basica` (UT5) | `PooBasicaIntro` + `teoria/01-clases` … `07-estatico` (paralelo a `ejercicios/`) | `01-clases` … `07-estatico` (`pendientes` / `resueltos`) |

Pendiente de mismo criterio: `01-operadores-y-basicos` (ejercicios en `teoria/basicos`).

### practicas/ (centro + enunciado + solucion)

Cada practica de instituto/universidad es **una carpeta** (`comunidad-centro-tema`) con PDF/documento y codigo en la **misma raiz** (pendiente, `_RESUELTO`, varios `.java` si hace falta). **No** subcarpeta `resueltos/`, ni `docs/` ni `enunciados/` sueltos.

```
practicas/
└── madrid-iescalderonbarca-quinielas/
    ├── quinielas--madrid-iescalderonbarca.pdf
    ├── Quinielas.java
    └── Quinielas_RESUELTO.java
```

En JavaDoc/comentarios puede decirse «funcion» (evita el marcador TODO del IDE sobre «metodo»); en rutas y nombres de clase use **metodos**, no `funciones` (PDFs originales del centro exceptuados).

- Nombre carpeta: `comunidad-centro-nombre-proyecto`
- Nombre PDF: `nombre-proyecto--comunidad-centro.pdf`
- Teoria de clase (sin entrega): PDF suelto en `teoria/` del subtema, no en `practicas/`

## JavaDoc (pie de clase)

Al final del bloque JavaDoc de cada clase, convencion habitual:

```
 * @author Agustín. A. Marquez. Piña
 * @since dd/MM/yyyy
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
```

El contenido didactico va antes de estas etiquetas; el resto en comentarios de linea o multilinea.

### JavaDoc en practicas (estilo)

En cada clase principal de una practica, documentar con **objetivo pedagogico**, no con comandos de compilacion:

- Enunciado PDF en la misma carpeta (`nombre--centro.pdf`).
- **Objetivo** de la practica o de la parte.
- Lista de requisitos: «Para ello, el programa debe…».
- **Utiliza** tecnologias (XAMPP, JDBC, hilos, etc.).
- Pie `@author` / `@since` / enlaces al final.

## Indice por evaluacion

### EV1 - Fundamentos (RA1, RA2, RA3)

| UT | Contenido |
|----|-----------|
| `ut1-fundamentos-java` | JVM/JDK, sintaxis, tipos, casteo |
| `ut2-control-flujo-metodos` | Bucles, condicionales, metodos |
| `ut3-cadenas-envolventes-intro-poo` | String, envolventes, intro POO |

### EV2 - POO y colecciones (RA4, RA5, RA6)

| UT | Contenido |
|----|-----------|
| `ut4-colecciones` | Arrays, ArrayList, mapas; repaso/examen en `03-repaso` |
| `ut5-poo-excepciones-io` | POO basica, excepciones, ficheros |

### EV3 - Avanzado y persistencia (RA7, RA8, RA9)

| UT | Contenido |
|----|-----------|
| `ut6-poo-avanzada-estructuras` | Herencia avanzada, multihilo, estructuras |
| `ut7-persistencia-jdbc-api` | JDBC/MySQL (`01-jdbc`), proyectos BD (`02-bases-datos-y-proyectos`) |
| `ut8-frameworks-spring` | Spring y practicas de centro |

### Otros

- `src/pruebaslibres/` - repaso y simulacros de examen

## Requisitos habituales

- **JDK 8+** (mayoria de ejercicios)
- **XAMPP/MySQL + Connector/J** - practicas JDBC (`ut7/01-jdbc`)
- **Maven** - algunos proyectos (p. ej. Bili Store)
- **JavaFX / Tomcat** - proyectos concretos (ver JavaDoc del proyecto)

## Nomenclatura

- Packages segun ruta; clases en PascalCase; metodos/variables en camelCase
- Proyectos de centro: `comunidad-centro-nombre-proyecto`

## Contacto

agu1406@outlook.es - [GitHub](https://github.com/Agu1406/ClasesParticulares) - [agustinmarquez.dev](https://www.agustinmarquez.dev)
