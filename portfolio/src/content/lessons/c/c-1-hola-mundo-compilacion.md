---
id: c-1
languageId: c
title: Hola Mundo, compilación y estructura mínima
description: Primer programa en C11, #include, main, printf, punto y coma, return y gcc con avisos. Base de EV1 UT1 u01.
part: 1
totalParts: 6
roadmapPhase: fundamentos
sectionIcons:
  - terminal
  - build
exercises:
  - id: ex1
    title: Ejecuta U01_HolaMundo.c y localiza include, main, printf y return 0.
    completed: false
    fileFolder: ut1_fundamentosc/u01entornocompilador/teoria
  - id: ex2
    title: E01 y E02 en ejercicios/pendientes (entorno).
    completed: false
    fileFolder: ut1_fundamentosc/u01entornocompilador/ejercicios/pendientes
    solutionFolder: ut1_fundamentosc/u01entornocompilador/ejercicios/resueltos
---

## Objetivo de la lección

Al terminar sabrás escribir de memoria la **estructura mínima** de un programa C, compilarlo con **gcc C11** y leer el primer error del compilador sin bloquearte.

## Estructura mínima

Todo programa empieza en `int main(void)`. Antes necesitas `#include <stdio.h>` para que exista `printf`. Cada instrucción termina en **`;`**. Al acabar, `return 0;` indica al sistema que todo fue bien.

```c
#include <stdio.h>

int main(void) {
    printf("Hola Mundo\n");
    return 0;
}
```

## Compilar como en clase

En el temario usamos siempre avisos activos:

```bash
gcc -std=c11 -Wall -Wextra -pedantic U01_HolaMundo.c -o U01_HolaMundo -lm
```

En Windows el ejecutable se lanza con `.\U01_HolaMundo`; en Linux/macOS con `./U01_HolaMundo`.

## Detalles que caen en examen

- C distingue **mayúsculas**: solo `printf`, no `Printf`.
- `printf` **no** añade salto de línea solo: escribe `\n`.
- Los **comentarios** (`//` o `/* */`) los ignora el compilador; no sustituyen código que falte.

## En el repositorio

Teoría viva: `c/src/ev1/ut1_fundamentosc/u01entornocompilador/teoria/` (U01–U05). Mapa completo: `c/src/ev1/README.md`.
