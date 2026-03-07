---
id: java-1
languageId: java
title: Conceptos básicos y ciclo de vida del programa
description: Java como lenguaje de alto nivel, orientado a objetos. Quién lee y ejecuta el código: JVM, JDK, JRE. Las etapas: edición, compilación, carga, verificación, ejecución.
part: 1
totalParts: 11
roadmapPhase: fundamentos
sectionIcons:
  - menu_book
exercises:
  - id: ex1
    title: Abre y ejecuta Ejemplo.java en src/ev1/ut0/ciclovida y observa el .class generado.
    completed: false
---

## Conceptos básicos

Los lenguajes de programación se pueden comparar a los lenguajes humanos. Java es un lenguaje de alto nivel, más cercano al humano que al de las máquinas. Es orientado a objetos y ejecutable en casi cualquier sistema con Java instalado. No es el más simple para la primera línea de código, pero sí uno de los más sólidos para construir aplicaciones reales.

## ¿Quién lee y ejecuta el código?

JVM (Java Virtual Machine): traduce el código Java para que el ordenador lo ejecute; la mayoría de usuarios la tienen instalada. JDK (Java Development Kit): lo instalan quienes desarrollan en Java; incluye el compilador, depuradores y librerías. JRE (Java Runtime Environment): JVM más las bibliotecas necesarias para ejecutar un programa concreto.

## Etapas del ciclo de vida

1) Edición: escribimos código en archivos .java. 2) Compilación: el JDK (desde el IDE) convierte el código en algo que la JVM pueda ejecutar. 3) Carga: la JVM carga los archivos compilados. 4) Verificación: la JVM revisa seguridad y coherencia. 5) Ejecución: la JVM traduce a bits y el programa arranca. En el proyecto puedes ver el ciclo en acción en src/ev1/ut0/ciclovida (Ejemplo.java y Ejemplo.class).
