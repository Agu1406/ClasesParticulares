# C — Clases particulares

Material de **C11** organizado como `java/`, `csharp/` y `cpp/`: evaluaciones, unidades `ut{N}_…`, subtemas `u{NN}…`, `teoria/`, `ejercicios/` y `practicas/`.

**Objetivo:** que puedas dar clase mañana. Cada `.c` de teoría es un programa que se proyecta, se ejecuta y se comenta en voz alta. Los ejercicios van pareados (`_Pendiente` / `_Resuelto`). Cada subtema de EV1 tiene una práctica interna.

C **no copia el UT1–UT9 de Java** (no hay POO ni Spring). EV1 sí sigue el mismo mapa pedagógico que C++: fundamentos → control y funciones → cadenas → tipos compuestos. A partir de EV2 el temario es propio de C (arrays, punteros, memoria, ficheros).

**Canon de carpetas y nombres:** [`../java/README.md`](../java/README.md). Este README es la guía del módulo C.

- **EV1 (lista para clase):** `src/ev1/` — UT1 a UT4.
- **Legacy (no usar en clase):** `01-introduccion/`, `02-sintaxis-basica/`, `03-control-flujo/`. Quedan como archivo; el material vivo está en `src/ev1`.

## Requisitos

- Compilador **gcc** con **C11** (MinGW/MSYS2, TDM-GCC, o el gcc de tu distro)
- IDE: VS Code, Cursor, CLion o Code::Blocks

## Cómo dar la primera clase

Abre la carpeta **`c/`** como workspace (File → Open Folder).

| Minuto | Qué hacer | Archivo |
|--------|-----------|---------|
| 0–10 | Proyectar y ejecutar el Hola Mundo. Señala `#include`, `main`, `printf`, `;`, `return`. | `src/ev1/ut1_fundamentosc/u01entornocompilador/teoria/U01_HolaMundo.c` |
| 10–20 | Compilar a mano una vez para que vean gcc. | Comando de abajo |
| 20–35 | El alumno hace E01 y E02 (pendientes). Si se atasca, abre el resuelto **después**. | `…/ejercicios/pendientes/` |
| 35–50 | U02 (`printf`, `\n`, `\t`, `%d`) y práctica de la ficha. | `U02_PrintfBasico.c` + `practicas/ejemplointernoentorno/` |
| Si piden “no me compila” | U05: cómo leer el primer error de gcc. | `U05_ErroresDeCompilacion.c` |

Mapa completo de lecciones: [`src/ev1/README.md`](src/ev1/README.md).

## Cómo ejecutar un fichero

Cada `.c` se compila solo.

```powershell
gcc -std=c11 -Wall -Wextra -pedantic U01_HolaMundo.c -o U01_HolaMundo -lm
.\U01_HolaMundo
```

En Linux/macOS el ejecutable se lanza con `./U01_HolaMundo`.

**Botón Play (VS Code / Cursor):** instala **C/C++** (`ms-vscode.cpptools`) y **Code Runner** (`formulahendry.code-runner`). Abre un `.c` y pulsa ▶ o **Ctrl+Alt+N**. También: *Terminal → Run Task → Ejecutar .c actual* (o **Ctrl+Shift+B**).

## Estructura

```
c/
├── README.md
├── .vscode/                 ← tareas gcc + Code Runner
├── 01-introduccion/         ← LEGACY, no usar
├── 02-sintaxis-basica/      ← LEGACY, no usar
├── 03-control-flujo/        ← LEGACY, no usar
└── src/
    └── ev1/                 UT1–UT4 (fundamentos, control, strings, struct)
```

### Mapa EV1

| UT | Carpeta | Qué se enseña | Práctica |
|----|---------|---------------|----------|
| **UT1** | `ut1_fundamentosc` | gcc, `printf`, tipos, `scanf`/`fgets` | 3 internas |
| **UT2** | `ut2_controlflujometodos` | operadores, if/switch, bucles, funciones, depuración | 6 internas |
| **UT3** | `ut3_strings` | cadenas, `string.h`, `ctype.h` | interna + Calderón |
| **UT4** | `ut4_tiposcompuestos` | `enum`, `struct`, `typedef`, `union` | 1 interna |

`u05repaso` (dentro de UT2) repasa **hasta funciones**. El cierre de toda la EV1 es `ut4/…/teoria/U07_CierreEv1.c`.

### Convención (igual que Java / C++ / C#)

- **UT:** `ut{N}_{nombre}`
- **Subtema:** `u{NN}{nombre}`
- **Teoría:** `U{NN}_{Nombre}.c` ejecutables, explicación en comentario de bloque
- **Ejercicios:** `E{NN}_*_Pendiente.c` / `_Resuelto.c`
- **Prácticas:** carpeta `{comunidad}{centro}{nombre}` sin guiones; enunciado `interno-ejemplo-….md`

### Formato C (EV1)

```c
#include <stdio.h>

int main(void) {
    printf("Hola Mundo\n");
    return 0;
}
```

- Estándar **C11**. Avisos **siempre** on: `-Wall -Wextra -pedantic`.
- Hasta `u03bucles`: programa lineal dentro de `main`.
- Desde **`u04metodos`**: se habla de **funciones** (en C no hay métodos). La carpeta se llama `u04metodos` por paridad con Java/C#/C++.
- **EV1:** no se enseña `malloc`, ficheros ni punteros avanzados. Sí hay un primer contacto con `&` / `*` al pasar structs y en `scanf`.
- Política de texto: ejemplos en **ASCII**. UTF-8 se explica en `U08_CadenasYUtf8.c`, no se exige en ejercicios.

## Test de repaso (examen EV1 hasta bucles)

Autoevaluación tipo examen (62 preguntas, 6 temas, opciones barajadas):

- Abrir localmente: [`tests/test_ev1_hasta_bucles.html`](tests/test_ev1_hasta_bucles.html) (ver [`tests/README.md`](tests/README.md)).
- En el portal: sección «Prepara el examen» en `/c` tras desplegar `portfolio/`.

Plantilla del test: `linux/ra3/tests/` (misma mecánica que RA3 SMR).

## Contacto

agu1406@outlook.es
