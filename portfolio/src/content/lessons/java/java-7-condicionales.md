---
id: java-7
languageId: java
title: Condicionales
description: Tomar decisiones en el programa con if, else y switch. Esencial para cualquier flujo de control (guía java/src/README.md).
part: 7
totalParts: 11
roadmapPhase: estructuras
pdfFile: Ejercicios con funciones.pdf
sectionIcons:
  - code
exercises:
  - id: ex1
    title: Escribe un programa que indique si un número es par o impar.
    completed: false
  - id: ex2
    title: Más ejercicios de bucles y condicionales en el repositorio.
    completed: false
    fileFolder: buclesycondicionales
---

## if y else

La sentencia if evalúa una condición booleana. Si es true, se ejecuta el bloque; si no, se puede usar else.

```java
int edad = 18;
if (edad >= 18) {
    System.out.println("Mayor de edad");
} else {
    System.out.println("Menor de edad");
}
```

## switch

switch permite elegir entre varias opciones según el valor de una variable (entero, String o enum).

```java
int opcion = 2;
switch (opcion) {
    case 1: System.out.println("Uno"); break;
    case 2: System.out.println("Dos"); break;
    default: System.out.println("Otro");
}
```
