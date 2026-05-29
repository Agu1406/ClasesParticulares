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

Convencion por UT: subtemas numerados con `teoria/`, `ejercicios/` (`facil|medio|dificil` + `resueltos/`) y `practicas/` (material de centros; PDF en `enunciados/`).

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
| `ut4-colecciones` | ArrayList, mapas, practicas integradas |
| `ut5-poo-excepciones-io` | POO basica, excepciones, ficheros |

### EV3 - Avanzado y persistencia (RA7, RA8, RA9)

| UT | Contenido |
|----|-----------|
| `ut6-poo-avanzada-estructuras` | Herencia avanzada, multihilo, estructuras |
| `ut7-persistencia-jdbc-api` | JDBC/MySQL (`01-jdbc`), proyectos BD (`02-bases-datos-y-proyectos`) |
| `ut8-frameworks-spring` | Spring y practicas de centro |

### Otros

- `src/pruebaslibres/` - repaso y simulacros de examen
- `src/ev*/docs/` - PDFs y enunciados de apoyo

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
