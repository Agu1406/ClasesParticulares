---
id: c-2
languageId: c
title: printf, compilación y el primer error de gcc
description: Especificadores %d %f %c %s, secuencias de escape y el comando gcc con el que se corrige en clase.
part: 2
totalParts: 7
roadmapPhase: fundamentos
level: Principiante
examNote: El fallo típico es mezclar el especificador y el tipo, u olvidar el salto de línea. El comando de compilación se pide tal cual.
sourcePath: c/src/ev1/ut1_fundamentosc/u01entornocompilador/teoria/U02_PrintfBasico.c
sectionIcons:
  - terminal
  - bug_report
exercises:
  - id: e06
    title: E06. Imprime un entero con el especificador correcto.
    fileUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut1_fundamentosc/u01entornocompilador/ejercicios/pendientes/E06_FormatoEntero_Pendiente.c"
    solutionUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut1_fundamentosc/u01entornocompilador/ejercicios/resueltos/E06_FormatoEntero_Resuelto.c"
  - id: e08
    title: E08. Monta una tabla alineada con printf.
    fileUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut1_fundamentosc/u01entornocompilador/ejercicios/pendientes/E08_TablaAlineada_Pendiente.c"
    solutionUrl: "https://github.com/Agu1406/ClasesParticulares/blob/main/c/src/ev1/ut1_fundamentosc/u01entornocompilador/ejercicios/resueltos/E08_TablaAlineada_Resuelto.c"
---

## printf y los especificadores

`printf` recibe un texto con huecos y, detrás, los valores que los rellenan.

| Hueco | Sirve para |
| --- | --- |
| `%d` | `int` |
| `%f` | `double` o `float` (en printf) |
| `%c` | un `char` |
| `%s` | una cadena |
| `%%` | un signo `%` literal |

```c
int edad = 26;
double altura = 1.76;
char letra = 'A';
printf("Edad: %d\n", edad);
printf("Altura: %.2f\n", altura);
printf("Letra: %c\n", letra);
```

`%.2f` deja dos decimales. `\n` baja de línea y `\t` salta un tabulador. Para pintar comillas se escribe `\"` y para una barra invertida, `\\`.

## Compilar y leer el primer error

```text
gcc -std=c11 -Wall -Wextra -pedantic fichero.c -o prog -lm
./prog
```

`-std=c11` fija el estándar de clase. `-Wall -Wextra -pedantic` encienden avisos: un `=` dentro de un `if` sale ahí. `-o prog` nombra el ejecutable y `-lm` enlaza matemáticas.

gcc señala el primer error con archivo y línea. Se corrige ese, se vuelve a compilar y se mira el siguiente. No se arreglan todos a ciegas.

> Para el examen: `%d` con un entero, `%f` con un real, y el `\n` escrito a mano. El comando de gcc entra tal como está arriba.
