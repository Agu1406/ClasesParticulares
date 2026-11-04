---
id: c-3
languageId: c
title: Entrada por teclado, buffer y comentarios
description: scanf con &, formatos, problemas de buffer, fgets y validación básica. EV1 UT1 u03.
part: 3
totalParts: 6
roadmapPhase: fundamentos
sectionIcons:
  - keyboard
exercises:
  - id: ex1
    title: Completa ejercicios de scanf y fgets en u03comentariosentrada/ejercicios/pendientes.
    completed: false
    fileFolder: ut1_fundamentosc/u03comentariosentrada/ejercicios/pendientes
    solutionFolder: ut1_fundamentosc/u03comentariosentrada/ejercicios/resueltos
---

## scanf

- Formato + **dirección** de la variable: `scanf("%d", &edad);`
- Sin `&` en un escalar, el comportamiento es indefinido (error grave).

## Buffer de entrada

Mezclar `scanf("%d")` con lectura de línea deja `\n` sin leer. Soluciones del temario:

- Consumir basura con un `scanf(" %c", &c)` de limpieza controlada.
- Preferir **`fgets`** + conversión cuando haya espacios en el texto.

## fgets

Lee hasta salto de línea o límite del array. Ideal para nombres completos y menús con opciones textuales.

## Comentarios útiles

Documenta **por qué**, no cada línea obvia. En EV1 los bloques `/* PRIMERA PARTE */` del profesor son plantilla: imita ese estilo en tus entregas.

## Validación

Tras leer, comprueba rangos (`if (edad < 0)`) antes de calcular o entrar en bucles; evita menús que nunca terminan.
