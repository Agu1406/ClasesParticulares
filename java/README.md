# Java - Clases particulares (DAM/DAW)

Material de **Programacion (0485)** organizado por evaluaciones y unidades. Normativa: `BOE-2023-06-03-RD-405-modulo-0485-programacion.md`.

**Documentacion:** las explicaciones van en los propios `.java` (JavaDoc, comentarios multilinea y de linea). En la raiz del modulo solo hay **dos** archivos Markdown de documentacion: este `README.md` y `BOE-2023-06-03-RD-405-modulo-0485-programacion.md`. Los `.md` dentro de `practicas/` son **enunciados** de ejercicios, no documentacion general.

**Diagnostico de nivel:** `src/diagnostico/ejercicios/pendientes/` — `Diagnostico01` … `Diagnostico38` (_SIN_RESOLVER / _RESUELTO). Instrucciones para el alumno en el JavaDoc de cada clase. Indice: `diagnostico.DiagnosticoNivelIntro`.

## Estructura

```
java/
├── BOE-2023-06-03-RD-405-modulo-0485-programacion.md
├── README.md
└── src/                    # Sources Root en IntelliJ
    ├── ev1/                RA1-RA3  (ut1_fundamentosjava, ut2_controlflujometodos, ut3_stringsyenvolventes)
    ├── ev2/                RA4-RA6  (ut4_colecciones, ut5_pooexcepcionesio)
    └── ev3/                RA7-RA9  (ut6_pooavanzadaestructuras, ut7_persistenciajdbcapi, ut8_frameworksspring, ut9_programacionfuncional/pf)
```

### Convencion por subtema (EV1, EV2, EV3)

Cada **UT** lleva prefijo de orden y nombre: `ut{N}_{nombre}` (p. ej. `ut1_fundamentosjava`, `ut2_controlflujometodos`). Cada **subtema** bajo la UT: `u{NN}{nombre}` (p. ej. `u01entornojvmjdk`, `u02condicionales`). Tres carpetas fijas por subtema (o directamente bajo la UT si el bloque es unico, como `ut3_stringsyenvolventes/teoria/` con bloques `U01_`, `U02_`…):

| Carpeta | Contenido |
|---------|-----------|
| `teoria/` | Bloques en orden `u01/`, `u02/`, `u03/`… (orden didactico 01→02→03; prefijo `u` para paquetes Java validos) |
| `ejercicios/` | Solo `pendientes/` y `resueltos/` con el mismo ejercicio pareado: `E{NN}_{Nombre}_Pendiente.java` / `E{NN}_{Nombre}_Resuelto.java` (legacy: `EjercicioNN_…_SIN_RESOLVER` / `_RESUELTO`) |
| `practicas/` | Una carpeta por proyecto; PDF + version alumno + version resuelta en la misma raiz |

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
- Proyectos Eclipse/Maven de referencia del centro: en `src/ignorar/referencia-centros/` (no dentro de `practicas/`).
- Sin subcarpetas `sin_resolver/` ni `resueltos/` dentro del proyecto.

En JavaDoc puede decirse «funcion»; en rutas y nombres de clase use **metodos**, no `funciones`.

### Enunciados de practicas (convencion de nombres)

Todos los documentos de enunciado en `practicas/` siguen **un solo patron**:

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

Ruta: `src/ev3/ut9_programacionfuncional/pf/` con subtemas `u01lambda`, `u02streams`, `u03optional`, `u04principios`, `u05repaso`. Practicas TPP EPIG: `…/u01lambda/practicas/valencianaepigtppsesion1/` … `…/u05repaso/practicas/valencianaepigtppsesion5/`. PDFs del modulo (colocar en `pf/u05repaso/teoria/universidad/`): `sesion1_lambda_collections.pdf`, `TPPHoja2_alumno_clase.pdf`, `TPPHoja3_alumno_fix.pdf`, `TPPHoja4_alumno_clase_fix.pdf`, `TPPHoja5_alumno.pdf`, `Metodos y Funciones (Parcial 1 PL).docx`; diapos en `pf/u05repaso/teoria/01_functional_prog.pdf`.

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

| UT | Contenido |
|----|-----------|
| `ev1/ut1_fundamentosjava` | JVM/JDK, sintaxis, tipos, casteo |
| `ev1/ut2_controlflujometodos` | Bucles, condicionales, metodos |
| `ev1/ut3_stringsyenvolventes` | String + envolventes (`U01_`/`U02_` en teoria; ejercicios 1–11 / 12–13) |

### EV2 - POO y colecciones (RA4, RA5, RA6)

| UT | Contenido |
|----|-----------|
| `ev2/ut4_colecciones` | Arrays, ArrayList, mapas, repaso |
| `ev2/ut5_pooexcepcionesio` | POO basica, excepciones, ficheros, GUI |

### EV3 - Avanzado y persistencia (RA7, RA8, RA9)

| UT | Contenido |
|----|-----------|
| `ev3/ut6_pooavanzadaestructuras` | Herencia, colecciones, concurrencia |
| `ev3/ut7_persistenciajdbcapi` | JDBC, BDD, repaso |
| `ev3/ut8_frameworksspring` | Spring |
| `ev3/ut9_programacionfuncional/pf` | Lambda, Stream API, Optional, principios PF |

## Requisitos habituales

- **JDK 8+** (mayoria de ejercicios)
- **XAMPP/MySQL + Connector/J** - practicas JDBC (`ev3/ut7_persistenciajdbcapi/u01jdbc`)
- **Maven** - algunos proyectos (p. ej. Bili Store)
- **JavaFX / Tomcat** - proyectos concretos (ver JavaDoc del proyecto)

## Nomenclatura

- Packages segun ruta; clases en PascalCase; metodos/variables en camelCase
- **Carpeta de practica:** `{comunidad}{centro}{nombrepractica}` (sin guiones), p. ej. `madridiesrosachacelarrays`
- **Enunciado de practica:** `{comunidad}-{centro}-{nombre-practica}.{ext}` (ver seccion *Enunciados de practicas*)
- **Clases de practica:** `{NombrePractica}_SIN_RESOLVER` / `{NombrePractica}_RESUELTO` en la raiz de la carpeta del proyecto

## Contacto

agu1406@outlook.es - [GitHub](https://github.com/Agu1406/ClasesParticulares) - [agustinmarquez.dev](https://www.agustinmarquez.dev)
