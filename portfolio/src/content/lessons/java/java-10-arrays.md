---
id: java-10
languageId: java
title: Arrays
description: Colecciones de elementos del mismo tipo; declaración, índice desde 0, longitud y recorrido (guía java/src/README.md).
part: 10
totalParts: 11
roadmapPhase: estructuras
pdfFile: Ejercicios Arrays 1.pdf
sectionIcons:
  - list
exercises:
  - id: ex1
    title: Crea un array de 5 números, asígnales valor y calcula su suma.
    completed: false
  - id: ex2
    title: Ejercicios de arrays (código para practicar).
    completed: false
    fileFolder: arrays
  - id: ex3
    title: Soluciones resueltas de ejercicios de arrays.
    completed: false
    solutionFolder: arrays/resueltos
---

## Declaración y uso de arrays

Se declaran con tipo[] nombre; se crean con new tipo[tamaño]. El índice va de 0 a length - 1. Puedes usar for o for-each para recorrerlos.

```java
int[] numeros = new int[] { 10, 20, 30 };
System.out.println(numeros.length);
System.out.println(numeros[1]);

for (int i = 0; i < numeros.length; i++) {
    System.out.println(numeros[i]);
}
for (int n : numeros) {
    System.out.println(n);
}
```
