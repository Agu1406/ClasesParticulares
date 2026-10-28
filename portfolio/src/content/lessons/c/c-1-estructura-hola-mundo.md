---
id: c-1
languageId: c
title: Estructura de un programa y Hola Mundo
description: Las cuatro piezas que hay que memorizar — include, main, printf y return — y por qué C distingue mayúsculas.
part: 1
totalParts: 7
roadmapPhase: fundamentos
level: Principiante
examNote: En el examen piden la estructura mínima de memoria y detectan Printf o un ; que falta. return 0 no imprime nada.
sourcePath: c/src/ev1/ut1_fundamentosc/u01entornocompilador/teoria/U01_HolaMundo.c
sectionIcons:
  - menu_book
  - terminal
exercises:
  - id: e01
    title: E01. Escribe el Hola Mundo con las cuatro líneas de clase.
    fileUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut1_fundamentosc/u01entornocompilador/ejercicios/pendientes/E01_HolaMundo_Pendiente.c"
    solutionUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut1_fundamentosc/u01entornocompilador/ejercicios/resueltos/E01_HolaMundo_Resuelto.c"
  - id: e02
    title: E02. Dibuja una línea separadora con printf.
    fileUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut1_fundamentosc/u01entornocompilador/ejercicios/pendientes/E02_LineaSeparadora_Pendiente.c"
    solutionUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut1_fundamentosc/u01entornocompilador/ejercicios/resueltos/E02_LineaSeparadora_Resuelto.c"
---

## Qué es un programa en C

Un programa es una lista de órdenes que el ordenador ejecuta de arriba a abajo. C es de alto nivel (se parece más a una frase que a unos y ceros), pero hay que compilarlo: gcc traduce tu `.c` al ejecutable de tu sistema. El mismo fuente se puede recompilar en otro sistema; el ejecutable, no.

En clase se memorizan cuatro piezas aunque todavía no se entiendan del todo: el include, `main`, `printf` y `return`.

## El mínimo que compila

```c
#include <stdio.h>

int main(void) {
    printf("Hola Mundo\n");
    return 0;
}
```

- `#include <stdio.h>` presenta `printf` al compilador. Sin él, en C11, gcc no sabe qué es esa función.
- `int main(void)` es por donde empieza el programa. `void` significa que no recibe argumentos.
- Cada instrucción termina en `;`.
- `return 0;` devuelve al sistema «terminé bien». No escribe un 0 en la pantalla.
- C distingue mayúsculas: solo vale `printf`, no `Printf`.

Si omites `\n`, el siguiente `printf` se pega al anterior. `printf` no añade el salto por su cuenta.

> Para el examen: escribe de memoria el esqueleto. Si el fragmento dice `Printf` o le falta el `;`, no compila.
