---
id: c-5
languageId: c
title: if, else y switch
description: Condiciones, llaves, errores clásicos (= vs ==), switch/case/break/default. EV1 UT2 u02.
part: 5
totalParts: 6
roadmapPhase: control
sectionIcons:
  - call_split
exercises:
  - id: ex1
    title: Practica ejemplointernocondicionales y E01–E05 pendientes de u02condicionales.
    completed: false
    fileFolder: ut2_controlflujometodos/u02condicionales/ejercicios/pendientes
---

## if / else

La condición va **entre paréntesis**. El cuerpo suele ir entre llaves aunque sea una línea (evita bugs al ampliar código).

Errores de examen:

- `if (x = 5)` asigna; comparar es `==`.
- `if (cond);` con `;` suelto deja el `if` vacío.

## Verdad en C

Cualquier valor **distinto de 0** es verdadero en un `if`.

## switch

Compara enteros o `char` con **constantes**. Cada `case` termina casi siempre en **`break`**. `default` recoge el resto.

## Menús

Patrón típico EV1: `scanf` de opción + `switch` o cadena `if / else if` + mensaje de error en el `else` final.
