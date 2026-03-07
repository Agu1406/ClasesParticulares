---
id: java-9
languageId: java
title: Operaciones matemáticas
description: Operadores aritméticos (+, -, *, /, %) y la clase Math para potencias, raíz, redondeo y números aleatorios (guía java/src/README.md).
part: 9
totalParts: 11
roadmapPhase: estructuras
pdfFile: Ejercicios con funciones.pdf
sectionIcons:
  - calculate
exercises:
  - id: ex1
    title: Escribe un método que reciba dos números y devuelva el mayor; luego prueba con Math.max().
    completed: false
  - id: ex2
    title: Ejercicios de funciones en el repositorio.
    completed: false
    fileFolder: funciones
---

## Operadores y clase Math

Además de +, -, *, / y % (resto), la clase Math ofrece Math.pow(), Math.sqrt(), Math.round(), Math.random(), etc.

```java
int a = 10, b = 3;
System.out.println(a / b);
System.out.println(a % b);
System.out.println(Math.pow(2, 3));
System.out.println(Math.sqrt(9));
System.out.println(Math.round(3.7));
```
