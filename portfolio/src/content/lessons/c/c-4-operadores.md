---
id: c-4
languageId: c
title: Operadores aritméticos, lógicos y precedencia
description: + − * / %, incremento, lógicos && || !, comparación, math.h y errores típicos. EV1 UT2 u01.
part: 4
totalParts: 6
roadmapPhase: control
sectionIcons:
  - calculate
exercises:
  - id: ex1
    title: u01operadores — al menos tres ejercicios pendientes de mapa y precedencia.
    completed: false
    fileFolder: ut2_controlflujometodos/u01operadores/ejercicios/pendientes
---

## Aritméticos

- `/` entre enteros **trunca**; `%` es resto entero.
- `+=`, `-=`, `*=` acortan asignaciones.

## Incremento

`i++` usa el valor y luego suma; `++i` suma antes. En exámenes cae en expresiones dentro de `printf` limitadas: mejor no encadenar locuras.

## Lógicos

- `&&` y `||` evalúan en **cortocircuito**.
- `!` convierte «falso» (0) en verdadero y viceversa.

## Comparación y doubles

Evita `==` entre `double`; usa tolerancia (`fabs(a-b) < 1e-9`) como en U06 del temario de bugs.

## math.h

Funciones como `sqrt`, `fabs` pueden requerir **`-lm`** al enlazar en Linux.
