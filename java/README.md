# Java - Clases particulares (DAM/DAW)

Material de **Programacion (0485)** organizado por evaluaciones y unidades. Normativa: `BOE-2023-06-03-RD-405-modulo-0485-programacion.md`.

Modulo **`java/`** del repositorio [ClasesParticulares](https://github.com/Agu1406/ClasesParticulares). Modulos relacionados:

- [`javafx/`](../javafx/README.md) — interfaces JavaFX (Gradle, JDK 21)
- [`tests/`](../tests/README.md) — tests interactivos HTML

**Volumen aproximado:** ~1396 clases `.java`, 78 proyectos en `practicas/`, 63 PDF.

**Documentacion:** las explicaciones van en los propios `.java` (JavaDoc, comentarios multilinea y de linea). En la raiz del modulo solo hay **dos** archivos Markdown de documentacion: este `README.md` y `BOE-2023-06-03-RD-405-modulo-0485-programacion.md`. Los `.md` dentro de `practicas/` son **enunciados** de ejercicios, no documentacion general.

**Diagnostico de nivel:** `src/diagnostico/ejercicios/pendientes/` — `Diagnostico01` … `Diagnostico38` (_SIN_RESOLVER / _RESUELTO). Instrucciones para el alumno en el JavaDoc de cada clase. Indice: `diagnostico.DiagnosticoNivelIntro`.

## Estructura

```
java/
├── BOE-2023-06-03-RD-405-modulo-0485-programacion.md
├── README.md
├── .cursor/rules/          # enunciados-practicas, enunciados-examenes, ejercicios-javadoc
└── src/                    # Sources Root en IntelliJ
    ├── diagnostico/        # 38 ejercicios de nivel + DiagnosticoNivelIntro
    ├── recuperacionordinaria/   # examen ordinario (ej. 1, 2, 4, 5); ej. 3 en javafx/
    ├── ev1/                RA1-RA3  (ut1, ut2, ut3)
    ├── ev2/                RA4-RA6  (ut4, ut5)
    └── ev3/                RA7-RA9  (ut6, ut7, ut8, ut9/pf)
```

### Convencion por subtema (EV1, EV2, EV3)

Cada **UT** lleva prefijo de orden y nombre: `ut{N}_{nombre}` (p. ej. `ut1_fundamentosjava`, `ut2_controlflujometodos`). Cada **subtema** bajo la UT: `u{NN}{nombre}` (p. ej. `u01entornojvmjdk`, `u02condicionales`).

**Ultimo subtema de cada UT (objetivo):** `u{NN}examenes` (p. ej. `u05examenes`). Ahi van simulacros y examenes de centro. Hoy solo UT6 lo implementa; el resto usa `u04repaso` / `u05repaso` como **legacy** hasta migrarlo.

**Excepcion UT3:** `ut3_stringsyenvolventes` no tiene subtemas `u01…`; lleva `teoria/`, `ejercicios/` y `practicas/` directamente bajo la UT (bloques `U01_`, `U02_`… en teoria).

Carpetas habituales por subtema tematico:

| Carpeta | Contenido |
|---------|-----------|
| `teoria/` | Bloques en orden `U01_`, `U02_`, `U03_`… (orden didactico; prefijo `U` en clases de teoria) |
| `ejercicios/` | Solo `pendientes/` y `resueltos/` con el mismo ejercicio pareado (ver nomenclatura abajo) |
| `practicas/` | Una carpeta por proyecto. **Estructura plana** (PDF + `_SIN_RESOLVER` / `_RESUELTO` en la raiz). **Excepcion** en `u{NN}examenes`: PDF en la raiz del proyecto + subcarpetas `pendiente/` y `resuelto/` (como `internotpppsalesanalytics`) |

**Nomenclatura de ejercicios** (conviven dos patrones en transicion):

| Patron | Estado | Ejemplo |
|--------|--------|---------|
| `E{NN}_{Nombre}_Pendiente.java` / `_Resuelto.java` | **Objetivo (nuevo)** — adoptado parcialmente en EV1 | `E01_SumarNumeros_Pendiente.java` |
| `Ejercicio{NN}_…_SIN_RESOLVER.java` / `_RESUELTO.java` | **Legacy (mayoria)** | `Ejercicio01_Arrays_SIN_RESOLVER.java` |

Al migrar un subtema, renombrar al patron nuevo. Puede haber mezcla dentro del mismo subtema (p. ej. condicionales).

El `package` de cada `.java` coincide con la ruta bajo `src/` (sin guiones en carpetas con codigo). Ejemplo:

```java
// src/ev2/ut4_colecciones/u01arrays/ejercicios/pendientes/Ejercicio01_Arrays_SIN_RESOLVER.java
package ev2.ut4_colecciones.u01arrays.ejercicios.pendientes;
```

### practicas/ (centro + enunciado + solucion)

```
practicas/
└── madridiescalderonbarcaquinielas/
    ├── madrid-iescalderonbarca-quinielas-i.pdf
    ├── madrid-iescalderonbarca-quinielas-ii.pdf
    ├── Quinielas_SIN_RESOLVER.java
    └── Quinielas_RESUELTO.java
```

- **Carpeta de proyecto:** identificador Java valido (sin guiones): `{comunidad}{centro}{nombrepractica}`  
  Ejemplo: `madridiescalderonbarcaquinielas`, `madridiesrosachacelcondicionales`.
- **Enunciados** (PDF, DOCX, MD…): convencion unificada descrita abajo.
- **Estructura plana obligatoria:** todo en la raiz de la carpeta del proyecto (enunciados, `.java`, `.sql`, `.dat`, `hibernate.cfg.xml`, etc.). **Sin subcarpetas** (`fase1/`, `dao/`, `Objetos/`, `datos/`, …).
- Si un enunciado tiene varias fases o tecnologias distintas → **carpetas hermanas** en `practicas/` (p. ej. `sevillaiesvelazquezalquilerfase1`, `examen3evbibliotecacomunidadjdbchibernate`, `examen3evbibliotecacomunidadjdbcjdbc`).
- Proyectos Eclipse/Maven de referencia del centro: en `javafx/src/ignorar/referencia-centros/` (no dentro de `practicas/` ni en este modulo).
- Sin subcarpetas `sin_resolver/` ni `resueltos/` dentro del proyecto (salvo excepcion de examenes; ver abajo).

En JavaDoc puede decirse «funcion»; en rutas y nombres de clase use **metodos**, no `funciones`.

### Examenes (`u{NN}examenes/practicas/`)

El ultimo subtema de cada UT usa la carpeta **`practicas/`** (igual que el resto de subtemas), no una carpeta `examenes/` aparte.

**Implementado hoy:** solo UT6 tiene `u05examenes`. Proyectos migrados (IES Rosa Chacel; origen `u04repaso/practicas/madridiesrosachacelexamenes/`):

- `…/madridiesrosachacelenunciadov6/` (3 ejercicios)
- `…/madridiesrosachacel14mar2024/` (2 ejercicios)
- `…/madridiesrosachacel15abril2024/` (2 ejercicios)
- `…/madridiesrosachacelmarzo2023/` (1 ejercicio)

Los PDF oficiales pueden estar en legacy (`u04repaso/practicas/`) o pendientes de colocar en la carpeta del proyecto; no asumir que estan commiteados bajo `u05examenes/`.

**Legacy pendiente de migrar** (`ev3/ut6_pooavanzadaestructuras/u04repaso/practicas/`):

- `madridiesrosachacelexamenes`
- `madridiescalderonbarcaexamen1`
- `madridiescanaveralconvocatoria2022`
- `madridcesjuanpablosegundoext5`

```
u05examenes/
└── practicas/
    └── madridiesrosachacelenunciadov6/
        ├── madrid-iesrosachacel-examenes-enunciado-v6.pdf   # cuando este colocado
        ├── pendiente/
        │   ├── ejercicio_1/   → {@code Main.java}
        │   ├── ejercicio_2/   → {@code Main.java}
        │   └── ejercicio_3/   → {@code Main.java}
        └── resuelto/
            ├── ejercicio_1/
            ├── ejercicio_2/
            └── ejercicio_3/
```

Referencia identica en forma: `…/internotpppsalesanalytics/` (`pendiente/` + `resuelto/` + enunciado en la raiz).

- **Carpeta de proyecto:** `{comunidad}{centro}{identificador}` (misma convencion que otras `practicas/`).
- **Package:** `…u05examenes.practicas.madridiesrosachacelenunciadov6.resuelto.ejercicio_1` (cada ejercicio en su subcarpeta; un `main` por ejercicio).
- Regla Cursor: `.cursor/rules/enunciados-examenes.mdc`.

Al migrar desde `u04repaso/practicas/…`, mover cada examen a `u{NN}examenes/practicas/{proyecto}/` con PDF + `pendiente/` + `resuelto/`.

### Recuperacion ordinaria

Examen completo en un solo proyecto (`internorecuperacionordinaria`), con estructura de examen (`pendiente/` + `resuelto/` por `ejercicio_NN`).

| Ruta | Contenido |
|------|-----------|
| `src/recuperacionordinaria/internorecuperacionordinaria/` | Enunciado + ejercicios 1, 2, 4 y 5 |
| [`javafx/src/recuperacionordinaria/`](../javafx/src/recuperacionordinaria/README.md) | Ejercicio 3 (GUI + serializacion) |

| Ejercicio | Tema | Ejecutar (resuelto) |
|-----------|------|---------------------|
| `ejercicio_01_conservatorio` | POO abstracta + interfaces | `Main` |
| `ejercicio_02_hardware` | POO herencia + polimorfismo | `Main` |
| `ejercicio_04_rachas` | Map, List, Set | `Torneo` |
| `ejercicio_05_matriculas` | List, Map, validacion | `Coches` |
| `javafx/…/ejercicio_03_detectives` | FXML + `ObjectOutputStream` | `DetectivesApp` |

Enunciado: [`recuperacion-ordinaria-enunciado.md`](src/recuperacionordinaria/internorecuperacionordinaria/recuperacion-ordinaria-enunciado.md). PDF opcional del centro: `internorecuperacionordinaria/recuperacion-ordinaria.pdf`.

Indice detallado: [`src/recuperacionordinaria/README.md`](src/recuperacionordinaria/README.md).

### Enunciados de practicas y examenes (convencion de nombres)

**Origen de la convencion:** definida en este `README.md` (seccion siguiente) y replicada en `.cursor/rules/enunciados-practicas.mdc`, `.cursor/rules/enunciados-examenes.mdc` y `.cursor/rules/ejercicios-javadoc.mdc`. El README es la **guia canonica**; las reglas Cursor son un extracto operativo.

Todos los documentos de enunciado en `practicas/` (incluido `u{NN}examenes/practicas/`) siguen **un solo patron**:

```
{comunidad}-{centro}-{nombre-practica}.{extension}
```

| Parte | Reglas | Ejemplos |
|-------|--------|----------|
| **comunidad** | CCAA o ambito, minusculas, sin tildes | `madrid`, `valenciana`, `sevilla`, `alicante`, `valladolid`, `salamanca`, `interno` |
| **centro** | Tipo + nombre del centro, pegado, sin guiones internos | `iescalderonbarca`, `iesrosachacel`, `iesarquitectoventurarodriguez`, `cesjuanpablosegundo`, `iesvelazquez`, `ua`, `uax`, `epig` |
| **nombre-practica** | Tema en kebab-case (palabras separadas por `-`) | `quinielas-i`, `ejercicios-funciones`, `practica-libros`, `examen-1-evaluacion` |
| **extension** | Preferir **PDF** para enunciados oficiales del centro; `md` solo para material propio del repo | `.pdf`, `.docx` (pendiente de convertir), `.md` |

**Reglas generales**

- Solo minusculas, ASCII y guiones `-` (nunca espacios, tildes, `(1)`, `Prog04…` ni `--` doble).
- Varios enunciados en la misma carpeta: distintos `{nombre-practica}` (`…-condicionales-extra`, `…-condicionales-ejercicios-if`).
- El prefijo `{comunidad}-{centro}-` debe coincidir con la carpeta del proyecto (sin el sufijo del nombre corto de practica).

**Relacion carpeta ↔ documento**

| Carpeta | Prefijo de enunciado |
|---------|----------------------|
| `madridiescalderonbarcaquinielas` | `madrid-iescalderonbarca-` |
| `madridiesrosachacelobjetos` | `madrid-iesrosachacel-` |
| `madridiesarquitectoventurarodriguezmetodos` | `madrid-iesarquitectoventurarodriguez-` |
| `sevillaiesvelazquezbarberomultihilo` | `sevilla-iesvelazquez-` |
| `alicanteuavisorimagenesl04` | `alicante-ua-` |
| `ejemplointernocondicionales` | `interno-ejemplo-` |

**Ejemplos canonicos**

```
madrid-iescalderonbarca-quinielas-i.pdf
madrid-iescalderonbarca-ejercicios-funciones.pdf
madrid-iesrosachacel-practica-libros.pdf
madrid-iesrosachacel-condicionales-ejercicios.docx
sevilla-iesvelazquez-barbero-dormilon.pdf
interno-ejemplo-enunciado.md
```

**En JavaDoc** citar el nombre canonico:

```java
 * <p>Enunciado: {@code madrid-iesrosachacel-practica-libros.pdf} (carpeta de la practica).</p>
```

**Patron legacy (deprecated):** `{nombre}--{comunidad}-{centro}.pdf` (p. ej. `quiniela-i--madrid-iescalderonbarca.pdf`).  
Aun presente en parte del repo; al tocar una practica, renombrar al patron nuevo y actualizar el JavaDoc.

**Material interno del repo** (plantillas `ejemplointerno…`): `interno-ejemplo-enunciado.md`.

### UT9 (programacion funcional)

Ruta: `src/ev3/ut9_programacionfuncional/pf/` con subtemas `u01lambda`, `u02streams`, `u03optional`, `u04principios`, `u05repaso` (pendiente renombrar a `u05examenes`). La carpeta `pf/teoria/` existe pero esta vacia.

Practicas TPP EPIG: `…/u01lambda/practicas/valencianaepigtppsesion1/` … `…/u05repaso/practicas/valencianaepigtppsesion5/`. PDFs del modulo (colocar en `pf/u05repaso/teoria/universidad/`): `sesion1_lambda_collections.pdf`, `TPPHoja2_alumno_clase.pdf`, `TPPHoja3_alumno_fix.pdf`, `TPPHoja4_alumno_clase_fix.pdf`, `TPPHoja5_alumno.pdf`, `Metodos y Funciones (Parcial 1 PL).docx`; diapos en `pf/u05repaso/teoria/01_functional_prog.pdf`.

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

- Enunciado en la misma carpeta con nombre `{comunidad}-{centro}-{nombre-practica}.pdf` (ver convencion arriba).
- **Objetivo** de la practica o de la parte.
- Lista de requisitos: «Para ello, el programa debe…».
- **Utiliza** tecnologias (XAMPP, JDBC, hilos, etc.).
- Pie `@author` / `@since` / enlaces al final.

## Indice por evaluacion

### EV1 - Fundamentos (RA1, RA2, RA3)

| UT | Subtemas | Contenido |
|----|----------|-----------|
| `ev1/ut1_fundamentosjava` | `u01entornojvmjdk`, `u02tiposvariablesconversion`, `u03comentariosestilo` | JVM/JDK, sintaxis, tipos, casteo, comentarios |
| `ev1/ut2_controlflujometodos` | `u01operadoresybasicos`, `u02condicionales`, `u03bucles`, `u04metodos`, `u05repaso`, `u06depuracionaserciones` | Operadores, condicionales, bucles, metodos, depuracion |
| `ev1/ut3_stringsyenvolventes` | *(estructura plana)* `teoria/`, `ejercicios/`, `practicas/` | String + envolventes (`U01_` inmutabilidad, `U02_` metodos, `U03_` StringBuilder, `U04_` envolventes; ejercicios 1–11 / E14 / 12–13) |

### EV2 - POO y colecciones (RA4, RA5, RA6)

| UT | Subtemas | Contenido |
|----|----------|-----------|
| `ev2/ut4_colecciones` | `u01arrays`, `u02arraylistymapas`, `u03avanzadodatos`, `u04repaso` (legacy) | Arrays (`U06_ArrayBurbuja`), ArrayList/mapas; practicas internas `internocazatesoros`, `internopescalo`, `internotresenraya` |
| `ev2/ut5_pooexcepcionesio` | `u01poobasica`, `u02excepciones`, `u03ficherosio`, `u04guieventosbasico`, `u05repaso` (legacy) | POO basica (`U07` demo juego, `U09` repaso Moto, `internoconcesionario`); excepciones (`U01`–`U05`, ejercicios 1–11 + E12–E14, `ejemplointernoexcepciones`); ficheros; Swing |

### EV3 - Avanzado y persistencia (RA7, RA8, RA9)

| UT | Subtemas | Contenido |
|----|----------|-----------|
| `ev3/ut6_pooavanzadaestructuras` | `u01herenciapolimorfismo`, `u02coleccionesestructuras`, `u03concurrenciamultihilo`, `u04repaso` (legacy), `u05examenes` | Herencia/polimorfismo/abstraccion/interfaces (teoria en subdirs `U01_Abstraccion`…`U04_Interfaces`), colecciones, concurrencia, examenes Rosa Chacel |
| `ev3/ut7_persistenciajdbcapi` | `u01jdbc`, `u02basesdatos`, `u03pooavanzado`, `u04bdoo`, `u05repaso` (legacy) | JDBC, BDD, Hibernate |
| `ev3/ut8_frameworksspring` | `u01spring`, `u02repaso` | **Reservado** — placeholder sin codigo Spring implementado |
| `ev3/ut9_programacionfuncional/pf` | `u01lambda`, `u02streams`, `u03optional`, `u04principios`, `u05repaso` (legacy) | Lambda, Stream API, Optional, principios PF, TPP EPIG |

## Requisitos y ejecucion

- **JDK 8+** — mayoria de ejercicios de consola
- **IntelliJ IDEA** — abrir `java/` con `src/` como Sources Root; compilar/ejecutar cada clase con `main`
- **Sin Maven/Gradle** en este modulo (proyecto Java plano)
- **XAMPP/MySQL + Connector/J** — practicas JDBC (`ev3/ut7_persistenciajdbcapi/u01jdbc`)
- **Hibernate** — practica biblioteca examen 3EV (`examen3evbibliotecacomunidadjdbchibernate`)
- **Swing** — GUI basica en `ev2/ut5_pooexcepcionesio/u04guieventosbasico`
- **JavaFX** — modulo [`javafx/`](../javafx/README.md) (JDK 21, Gradle); no compilar desde `java/`
- **Proyectos Maven de referencia del centro** — en `javafx/src/ignorar/referencia-centros/`

## Nomenclatura

- Packages segun ruta; clases en PascalCase; metodos/variables en camelCase
- **Carpeta de practica:** `{comunidad}{centro}{nombrepractica}` (sin guiones), p. ej. `madridiesrosachacelarrays`
- **Enunciado de practica:** `{comunidad}-{centro}-{nombre-practica}.{ext}` (ver seccion *Enunciados de practicas*)
- **Clases de practica:** `{NombrePractica}_SIN_RESOLVER` / `{NombrePractica}_RESUELTO` en la raiz de la carpeta del proyecto
- **Ejercicios:** preferir `E{NN}_{Nombre}_Pendiente` / `_Resuelto`; legacy `Ejercicio{NN}_…_SIN_RESOLVER` / `_RESUELTO`

## Contacto

agu1406@outlook.es - [GitHub](https://github.com/Agu1406/ClasesParticulares) - [agustinmarquez.dev](https://www.agustinmarquez.dev)
