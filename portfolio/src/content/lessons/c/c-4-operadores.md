---
id: c-4
languageId: c
title: Operadores
description: Aritmética, resto, comparación, lógica, precedencia y la diferencia entre = y ==. También ++ y el orden en que se lee una expresión.
part: 4
totalParts: 7
roadmapPhase: control
level: Principiante
examNote: = asigna y == compara. * y / van antes que + y -. % es el resto, no un porcentaje.
sourcePath: c/src/ev1/ut2_controlflujometodos/u01operadoresybasicos/teoria
sectionIcons:
  - calculate
  - rule
exercises:
  - id: e01
    title: E01. Operaciones básicas con enteros.
    fileUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut2_controlflujometodos/u01operadoresybasicos/ejercicios/pendientes/E01_OperacionesBasicas_Pendiente.c"
    solutionUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut2_controlflujometodos/u01operadoresybasicos/ejercicios/resueltos/E01_OperacionesBasicas_Resuelto.c"
  - id: e03
    title: E03. Prefijo y postfijo de ++.
    fileUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut2_controlflujometodos/u01operadoresybasicos/ejercicios/pendientes/E03_PrefijoYPostfijo_Pendiente.c"
    solutionUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut2_controlflujometodos/u01operadoresybasicos/ejercicios/resueltos/E03_PrefijoYPostfijo_Resuelto.c"
  - id: e04
    title: E04. Precedencia, sin calcular de izquierda a derecha a ciegas.
    fileUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut2_controlflujometodos/u01operadoresybasicos/ejercicios/pendientes/E04_PrecedenciaDeOperadores_Pendiente.c"
    solutionUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut2_controlflujometodos/u01operadoresybasicos/ejercicios/resueltos/E04_PrecedenciaDeOperadores_Resuelto.c"
---

## Aritmética y resto

`+ - * /` y `%`. El resto solo tiene sentido con enteros: `10 % 3` vale `1` porque 10 = 3·3 + 1. `n % 2` dice si es par (resto 0) y `n % 10` saca la última cifra.

`a += b` es `a = a + b`. Igual con `-=`, `*=`, `/=` y `%=`.

## Comparar y combinar

`== != < > <= >=` devuelven 1 o 0. `&&` es «y», `||` es «o», `!` es «no».

```c
int edad = 20;
if (edad >= 18 && edad < 65) {
    printf("en rango\n");
}
```

Un solo `=` guarda un valor. `if (x = 5)` no pregunta si x es 5: mete 5 en x y, como 5 no es 0, entra en el if. gcc avisa con `-Wall`.

## Qué se calcula antes

`*` y `/` (y `%`) van antes que `+` y `-`. `2 + 3 * 4` vale 14, no 20. Los paréntesis mandan sobre todos.

`x++` usa el valor y luego suma 1. `++x` suma 1 y luego usa el valor. Dentro de un `for`, `i++` e `++i` se ven igual porque el incremento va en su propio sitio.

> Para el examen: lee el operador letra a letra. Si ves `=` donde esperabas una pregunta, es una asignación.
