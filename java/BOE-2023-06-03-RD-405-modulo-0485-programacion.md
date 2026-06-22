# BOE DWES/PROG - Modulo 0485 Programacion (Java)

Fuente oficial: [Real Decreto 405/2023 (BOE-A-2023-13221)](https://boe.es/diario_boe/txt.php?id=BOE-A-2023-13221)

## Modulo profesional

- **Modulo**: Programacion
- **Codigo**: 0485
- **ECTS**: 14

## Resultados de aprendizaje (RA)

"Texto oficial del BOE y **donde se trabaja en este repositorio** (`src/ev1`, `ev2`, `ev3`).

### RA1 — Reconoce la estructura de un programa informatico

- **EV1** · `ut1_fundamentosjava` — JVM/JDK, sintaxis, tipos primitivos, casteo, comentarios y estilo.
- Subtemas: `u01entornojvmjdk`, `u02tiposvariablesconversion`, `u03comentariosestilo`.

### RA2 — Escribe y prueba programas sencillos aplicando fundamentos de POO

- **EV1** · `ut3_stringsyenvolventes` — `String`, envolventes (`Integer`, `parseInt`, `valueOf`), primera clase simple.
- En este repo el RA2 se introduce aqui antes del RA4 (POO con clases completa en EV2).

### RA3 — Escribe y depura codigo usando estructuras de control

- **EV1** · `ut2_controlflujometodos` — operadores, `if`/`else`, `switch`, bucles (`for`, `while`, `do-while`), metodos y sobrecarga.
- Subtemas: `u01operadoresybasicos`, `u02condicionales`, `u03bucles`, `u04metodos`.

### RA4 — Desarrolla programas organizados en clases (POO)

- **EV2** · `ut5_pooexcepcionesio/u01poobasica` — clases, constructores, encapsulamiento, `static`, instancias, metodos, objetos.
- POO basica antes de E/S y excepciones en la misma UT.

### RA5 — Realiza operaciones de entrada/salida con librerias del lenguaje

- **EV2** · `ut5_pooexcepcionesio` (subtemas distintos de `u01poobasica`):

| Subtema | Contenido |
|---------|-----------|
| `u02excepciones` | `try`/`catch`/`finally`, `throw`, `throws`, excepciones propias |
| `u03ficherosio` | Lectura y escritura de ficheros de texto (`java.io`, NIO) |
| `u04guieventosbasico` | GUI y eventos basicos |

- Diagnostico de nivel: ejercicios 25–28 (`Diagnostico25` … `Diagnostico28`).

### RA6 — Manipula informacion con tipos avanzados de datos

- **EV2** · `ut4_colecciones` — arrays (1D y 2D), `ArrayList`, `HashMap`, `HashSet`, recorridos, genericos y regex (`u03avanzadodatos`).
- Subtemas: `u01arrays`, `u02arraylistymapas`, `u03avanzadodatos`.

### RA7 — Aplica caracteristicas avanzadas de lenguajes OO y entorno

- **EV3** · `ut6_pooavanzadaestructuras` — herencia, `override`, clases abstractas, polimorfismo, interfaces, `Comparable`, colecciones avanzadas, concurrencia, examenes.
- **EV3** · `ut9_programacionfuncional/pf` — lambda, `Stream`, `Optional`, programacion funcional.
- En examenes de centro pueden aparecer excepciones propias (p. ej. `ConciertosException`) dentro de un contexto RA7, pero el bloque de excepciones como tal es **RA5**.

### RA8 — Utiliza bases de datos orientadas a objetos para persistencia

- **EV3** · `ut7_persistenciajdbcapi` — JDBC, modelo de datos, DAO, persistencia en BD.
- **EV3** · `ut8_frameworksspring` — Spring y capas de persistencia (donde aplique).

### RA9 — Gestiona informacion en bases de datos con integridad y consistencia

- **EV3** · `ut7_persistenciajdbcapi` — transacciones, integridad referencial, consistencia en operaciones con BD.

## Reparto por evaluacion en este repositorio (Java)

| Evaluacion | RA | Unidades principales |
|------------|-----|----------------------|
| **EV1** | RA1, RA2, RA3 | `ut1_fundamentosjava`, `ut2_controlflujometodos`, `ut3_stringsyenvolventes` |
| **EV2** | RA4, RA5, RA6 | `ut5_pooexcepcionesio` (RA4 + RA5), `ut4_colecciones` (RA6) |
| **EV3** | RA7, RA8, RA9 | `ut6_pooavanzadaestructuras`, `ut7_persistenciajdbcapi`, `ut8_frameworksspring`, `ut9_programacionfuncional/pf` |

Indice de diagnostico por RA: `src/diagnostico/DiagnosticoNivelIntro.java`.

## Nota didactica

Esta distribucion por EV es una **organizacion pedagogica del repo** para estudio progresivo.
El BOE define los RA y criterios de evaluacion; la secuenciacion temporal puede variar segun centro.
