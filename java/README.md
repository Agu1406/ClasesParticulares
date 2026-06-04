# Java - Clases particulares (DAM/DAW)

Material de **Programacion (0485)** organizado por evaluaciones y unidades. Normativa: `BOE-2023-06-03-RD-405-modulo-0485-programacion.md`.

**Documentacion:** las explicaciones van en los propios `.java` (JavaDoc, comentarios multilinea y de linea). Este archivo es solo indice.

## Estructura

```
java/
├── BOE-2023-06-03-RD-405-modulo-0485-programacion.md
├── README.md
└── src/                    # Sources Root en IntelliJ
    ├── ev1/                RA1-RA3  (ut1, ut2, ut3)
    ├── ev2/                RA4-RA6  (ut4, ut5, ut6)
    └── ev3/                RA7-RA9  (ut7, ut8, ut9/pf/…)
```

### Convencion por subtema (EV1, EV2, EV3)

Cada subtema (p. ej. `src/ev2/ut4/u01arrays/`, `src/ev3/ut9/pf/u01lambda/`) tiene **exactamente tres** carpetas. El subtema lleva prefijo de orden: `u01`, `u02`, … + nombre del tema.

| Carpeta | Contenido |
|---------|-----------|
| `teoria/` | Bloques en orden `u01/`, `u02/`, `u03/`… (orden didactico 01→02→03; prefijo `u` para paquetes Java validos) |
| `ejercicios/` | Solo `pendientes/` y `resueltos/` con los mismos ejercicios pareados (`EjercicioNN_…_SIN_RESOLVER` / `_RESUELTO`) |
| `practicas/` | Una carpeta por proyecto; PDF + version alumno + version resuelta en la misma raiz |

El `package` de cada `.java` coincide con la ruta bajo `src/` (sin guiones en carpetas con codigo). Ejemplo:

```java
// src/ev2/ut4/u01arrays/ejercicios/pendientes/Ejercicio01_Arrays_SIN_RESOLVER.java
package ev2.ut4.u01arrays.ejercicios.pendientes;
```

### practicas/ (centro + enunciado + solucion)

```
practicas/
└── madridiescalderonbarcaquinielas/
    ├── quinielas--madrid-iescalderonbarca.pdf
    ├── Quinielas_SIN_RESOLVER.java
    └── Quinielas_RESUELTO.java
```

- Carpeta de proyecto: identificador Java valido (sin guiones): `madridiescalderonbarcaquinielas`
- PDF: puede llevar guiones (`proyecto--centro.pdf`)
- Sin subcarpetas `sin_resolver/` ni `resueltos/` dentro del proyecto

En JavaDoc puede decirse «funcion»; en rutas y nombres de clase use **metodos**, no `funciones`.

### UT9 (programacion funcional)

Ruta: `src/ev3/ut9/pf/` con subtemas `lambda`, `streams`, `optional`, `principios`, `repaso`. Misma convencion de tres carpetas. Practicas TPP: `practicas/valencianaepigtppsesion1` … `valencianaepigtppsesion5`. PDFs globales: `repaso/teoria/` (p. ej. `universidad/`).

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
| `ev1/ut1` | JVM/JDK, sintaxis, tipos, casteo |
| `ev1/ut2` | Bucles, condicionales, metodos |
| `ev1/ut3` | String, envolventes, intro POO |

### EV2 - POO y colecciones (RA4, RA5, RA6)

| UT | Contenido |
|----|-----------|
| `ev2/ut4` | Arrays, ArrayList, mapas, repaso |
| `ev2/ut5` | POO basica, excepciones, ficheros, GUI |
| `ev2/ut6` | Herencia, colecciones, concurrencia |

### EV3 - Avanzado y persistencia (RA7, RA8, RA9)

| UT | Contenido |
|----|-----------|
| `ev3/ut7` | JDBC, BDD, repaso (codigo didactico plano) |
| `ev3/ut8` | Spring |
| `ev3/ut9/pf` | Lambda, Stream API, Optional, principios PF |

## Requisitos habituales

- **JDK 8+** (mayoria de ejercicios)
- **XAMPP/MySQL + Connector/J** - practicas JDBC (`ev3/ut7/jdbc`)
- **Maven** - algunos proyectos (p. ej. Bili Store)
- **JavaFX / Tomcat** - proyectos concretos (ver JavaDoc del proyecto)

## Nomenclatura

- Packages segun ruta; clases en PascalCase; metodos/variables en camelCase
- Proyectos de centro: carpeta `comunidadcentronombreproyecto` (sin guiones); PDF con guiones permitidos

## Contacto

agu1406@outlook.es - [GitHub](https://github.com/Agu1406/ClasesParticulares) - [agustinmarquez.dev](https://www.agustinmarquez.dev)
