---
id: java-6
languageId: java
title: Bucles
description: Repetir acciones sin copiar código; for, while y do-while. La base de la iteración en Java (según guía java/src/README.md).
part: 6
totalParts: 11
roadmapPhase: estructuras
pdfFile: Ejercicios con funciones.pdf
sectionIcons:
  - loop
exercises:
  - id: ex1
    title: Imprime los primeros 10 números pares usando un for.
    completed: false
  - id: ex2
    title: Ejercicios de bucles y condicionales en el repositorio (código para practicar).
    completed: false
    fileFolder: buclesycondicionales
---

## Bucle for

El bucle for se usa cuando sabes cuántas veces quieres repetir. Tiene inicialización, condición e incremento.

```java
for (int i = 0; i < 5; i++) {
    System.out.println("Iteración: " + i);
}
```

## while y do-while

while evalúa la condición antes de ejecutar; do-while ejecuta al menos una vez y luego evalúa.

```java
int j = 0;
while (j < 3) {
    System.out.println("j = " + j);
    j++;
}

int k = 0;
do {
    System.out.println("k = " + k);
    k++;
} while (k < 3);
```
