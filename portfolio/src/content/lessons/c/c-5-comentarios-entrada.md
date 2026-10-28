---
id: c-5
languageId: c
title: Comentarios y entrada por teclado
description: // y /* */, scanf con & para números, y fgets cuando la frase lleva espacios.
part: 5
totalParts: 7
roadmapPhase: fundamentos
level: Principiante
examNote: scanf de un int lleva & y %d. %s se para en el primer espacio. Los comentarios no se ejecutan.
sourcePath: c/src/ev1/ut1_fundamentosc/u03comentariosentrada/teoria
sectionIcons:
  - comment
  - keyboard
exercises:
  - id: e01
    title: E01. Lee dos enteros y muestra su suma.
    fileUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut1_fundamentosc/u03comentariosentrada/ejercicios/pendientes/E01_SumaDosNumeros_Pendiente.c"
    solutionUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut1_fundamentosc/u03comentariosentrada/ejercicios/resueltos/E01_SumaDosNumeros_Resuelto.c"
  - id: e09
    title: E09. Lee una frase con fgets.
    fileUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut1_fundamentosc/u03comentariosentrada/ejercicios/pendientes/E09_LeerFraseConFgets_Pendiente.c"
    solutionUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut1_fundamentosc/u03comentariosentrada/ejercicios/resueltos/E09_LeerFraseConFgets_Resuelto.c"
---

## Comentarios

El compilador los ignora. Sirven para explicar, no para «apagar» un error y olvidarlo.

```c
// Esta línea no se compila.
printf("esta si\n"); /* y este comentario tampoco */
```

`#` no comenta: abre una directiva (`#include`, `#define`).

## scanf

`scanf` escribe dentro de la variable, así que hay que pasarle su dirección con `&`. El especificador tiene que coincidir con el tipo.

```c
int edad;
double altura;
scanf("%d", &edad);
scanf("%lf", &altura);
```

Para un `double`, en `scanf` se usa `%lf`. En `printf`, un `double` se imprime con `%f`.

`scanf("%s", palabra)` lee una sola palabra: se detiene en el espacio. No lleva `&` si `palabra` ya es un array, porque el array se convierte en la dirección de su primer elemento.

## fgets para una frase

```c
char frase[80];
fgets(frase, 80, stdin);
```

Lee como mucho 79 caracteres más el cierre, y se guarda el `\n` del Enter. Es la forma de clase cuando el texto puede llevar espacios.

> Para el examen: un `scanf("%d", edad)` sin `&` está mal. Si el enunciado dice «nombre y apellidos», toca `fgets`, no `%s`.
