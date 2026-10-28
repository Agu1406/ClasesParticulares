---
id: c-7
languageId: c
title: Bucles
description: for cuando sabes las vueltas, while cuando miras antes, do-while cuando el cuerpo va al menos una vez. continue salta la vuelta; break corta el bucle.
part: 7
totalParts: 7
roadmapPhase: control
level: Principiante
examNote: El examen pide la traza de un for con acumulador, un do-while que entra aunque la condición sea falsa, y la diferencia entre continue y break.
sourcePath: c/src/ev1/ut2_controlflujometodos/u03bucles/teoria/U01_For.c
sectionIcons:
  - loop
  - repeat
exercises:
  - id: e01
    title: E01. Tabla de multiplicar con for.
    fileUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut2_controlflujometodos/u03bucles/ejercicios/pendientes/E01_TablaDeMultiplicar_Pendiente.c"
    solutionUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut2_controlflujometodos/u03bucles/ejercicios/resueltos/E01_TablaDeMultiplicar_Resuelto.c"
  - id: e03
    title: E03. Suma de 1 hasta n.
    fileUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut2_controlflujometodos/u03bucles/ejercicios/pendientes/E03_SumaHastaN_Pendiente.c"
    solutionUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut2_controlflujometodos/u03bucles/ejercicios/resueltos/E03_SumaHastaN_Resuelto.c"
  - id: e26
    title: E26. Media con centinela (while).
    fileUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut2_controlflujometodos/u03bucles/ejercicios/pendientes/E26_MediaConCentinela_Pendiente.c"
    solutionUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut2_controlflujometodos/u03bucles/ejercicios/resueltos/E26_MediaConCentinela_Resuelto.c"
---

## for

Cuando sabes cuántas vueltas, o puedes contarlas. Tres sitios en la cabecera: inicialización (una vez), condición (antes de cada vuelta) y actualización (al terminar el cuerpo).

```c
int s = 0;
for (int i = 1; i <= 4; i++) {
    s += i;
}
```

`s` acaba en 10. La variable `i` declarada en el `for` no existe fuera (C99).

La actualización puede ser `i--`, `i += 2` o `i *= 2`. Un acumulador (`s += i`) vive fuera del bucle para no ponerse a cero en cada vuelta.

## while y do-while

`while` mira la condición antes. Si nace falsa, el cuerpo no se ejecuta.

`do-while` ejecuta el cuerpo y después mira. Aunque la condición sea falsa, hay una vuelta.

```c
int i = 5;
do {
    printf("%d", i);
    i++;
} while (i < 5);
```

Imprime `5`. Un `while (i < 5)` con el mismo valor inicial no imprimiría nada.

## break, continue y bucles anidados

`break` sale del bucle (del más interno, si hay varios). `continue` salta lo que queda de esa vuelta y pasa a la actualización.

```c
for (int i = 0; i < 4; i++) {
    if (i == 2) continue;
    printf("%d", i);
}
```

Imprime `013`.

Un bucle dentro de otro multiplica las vueltas: 2 por fuera y 3 por dentro son 6 cuerpos. El `break` de dentro no corta el de fuera.

> Para el examen: anota inicialización, condición y actualización en tres líneas y ve tachando vueltas. No cuentes una vuelta cuya condición ya es falsa.
