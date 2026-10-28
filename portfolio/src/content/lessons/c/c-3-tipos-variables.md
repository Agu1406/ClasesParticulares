---
id: c-3
languageId: c
title: Tipos, variables y constantes
description: int, double, char y bool; por qué 7/2 vale 3; const frente a #define. El tipo se decide al compilar y no cambia.
part: 3
totalParts: 7
roadmapPhase: fundamentos
level: Principiante
examNote: División entera, comillas simples frente a dobles y el 0 como único valor falso. No compares reales con ==.
sourcePath: c/src/ev1/ut1_fundamentosc/u02tiposvariables/teoria/U02_VariablesTipos.c
sectionIcons:
  - data_object
  - calculate
exercises:
  - id: e01
    title: E01. Declara variables con los tipos de clase.
    fileUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut1_fundamentosc/u02tiposvariables/ejercicios/pendientes/E01_VariablesPersonales_Pendiente.c"
    solutionUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut1_fundamentosc/u02tiposvariables/ejercicios/resueltos/E01_VariablesPersonales_Resuelto.c"
  - id: e07
    title: E07. Contrasta la división entera con la real.
    fileUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut1_fundamentosc/u02tiposvariables/ejercicios/pendientes/E07_DivisionEnteraVsReal_Pendiente.c"
    solutionUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut1_fundamentosc/u02tiposvariables/ejercicios/resueltos/E07_DivisionEnteraVsReal_Resuelto.c"
---

## El tipo va delante

```c
int edad = 26;
double altura = 1.76;
char letra = 'A';
```

La forma es `tipo nombre = valor;`. El tipo se fija al compilar: no puedes guardar una letra en un `int` ni un texto en un `char`. Para el día a día de clase, `int` para enteros y `double` para decimales.

Un `char` va entre comillas simples (`'A'`). Las dobles (`"A"`) son una cadena, que en C es un array de `char` terminado en `'\0'` (eso se ve en UT3, no en este examen). `'A'` también es un número: su código ASCII.

## Enteros que se truncan y reales que no se comparan

Si los dos operandos son enteros, `/` se queda la parte baja: `7 / 2` vale `3`. Para el decimal, convierte uno: `(double)7 / 2` vale `3.5`.

`0.1 + 0.2` no sale exactamente `0.3`. En clase no se comparan reales con `==`; se mira si la diferencia es muy pequeña.

`bool` llega con `#include <stdbool.h>`. `true` es 1 y `false` es 0. En un `if`, cualquier valor distinto de 0 es verdadero.

## const y #define

```c
const double PI = 3.1415926535;
#define IVA 0.21
```

`const` es una variable con tipo que no puedes reasignar. `#define` no es una variable: el preprocesador sustituye el texto antes de compilar y no tiene tipo.

> Para el examen: `7/2` es 3, `'A'` no es `"A"`, y el único falso es 0.
