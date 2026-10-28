---
id: c-6
languageId: c
title: Condicionales
description: if, else if, else y switch. Una sola rama de la cadena, y el break que el switch no pone solo.
part: 6
totalParts: 7
roadmapPhase: control
level: Principiante
examNote: Traza de if/else y de switch sin break. Un ; pegado al if deja el cuerpo fuera. El 0 es la única condición falsa.
sourcePath: c/src/ev1/ut2_controlflujometodos/u02condicionales/teoria/U01_If.c
sectionIcons:
  - account_tree
  - alt_route
exercises:
  - id: e01
    title: E01. Di si un número es par o impar.
    fileUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut2_controlflujometodos/u02condicionales/ejercicios/pendientes/E01_ParOImpar_Pendiente.c"
    solutionUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut2_controlflujometodos/u02condicionales/ejercicios/resueltos/E01_ParOImpar_Resuelto.c"
  - id: e05
    title: E05. Pasa una nota numérica a letra.
    fileUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut2_controlflujometodos/u02condicionales/ejercicios/pendientes/E05_NotaALetra_Pendiente.c"
    solutionUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut2_controlflujometodos/u02condicionales/ejercicios/resueltos/E05_NotaALetra_Resuelto.c"
---

## if, else if, else

La condición va entre paréntesis. Solo corre una rama.

```c
int n = -2;
if (n > 0) {
    printf("P\n");
} else if (n == 0) {
    printf("Z\n");
} else {
    printf("N\n");
}
```

Con `n` igual a -2 se escribe `N`.

Dos trampas de clase:

- `if (x = 5)` asigna. La comparación es `==`.
- `if (n > 0);` con punto y coma no hace nada: el bloque de después se ejecuta siempre, porque ya no pertenece al `if`.

Si el cuerpo es una sola instrucción puedes omitir las llaves, pero en clase se ponen siempre: así no se queda una línea fuera.

## switch

Sirve cuando comparas un entero o un `char` con varios valores concretos.

```c
switch (d) {
    case 1:
        printf("a");
        break;
    case 2:
        printf("b");
        break;
    default:
        printf("otro");
}
```

Sin `break`, la ejecución sigue en el `case` de abajo (fall-through) hasta encontrar un `break` o el final. `default` es el cajón de «ningún case coincidió».

> Para el examen: sigue la rama con el valor real, no con el que «debería» ser. En un switch, cuenta cada printf hasta el primer break.
