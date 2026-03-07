---
id: java-3
languageId: java
title: Comentarios en Java
description: Comentarios de una línea (//), multilínea (/* */) y JavaDoc (/** */). Sirven para explicar el código a nosotros y a quien lo lea.
part: 3
totalParts: 11
roadmapPhase: fundamentos
sectionIcons:
  - comment
exercises:
  - id: ex1
    title: Abre y modifica Comentarios.java en src/ev1/ut0/comentarios y practica los tres tipos.
    completed: false
---

## Comentarios de una línea

Se escriben con doble barra seguida del comentario. Sirven para explicar algo puntual en una sola línea. Pueden ir en su propia línea o detrás de una instrucción.

```java
// Este es un comentario de Java.
public class Ejemplo {
    public static void main (String [] args) {
        System.out.println("¡Hola!"); // También detrás de la instrucción.
    }
}
```

## Comentarios multilínea

Empiezan con /* y terminan con */. Permiten escribir varias líneas de explicación. Útiles para notas largas o recordatorios.

```java
/* AQUÍ EMPIEZA EL COMENTARIO.
   Puedo escribir todo lo que quiera hasta
   indicar el fin con --> */
System.out.println("¡Hola por tercera vez!");
```

## Comentarios JavaDoc

Empiezan con /** y terminan con */. Cada línea lleva un asterisco al inicio. Son los más profesionales: permiten generar documentación (PDF) del proyecto. Suelen incluir @Since, @Author, @Version. Lo veremos con más detalle más adelante.

```java
/**
 * Clase Ejemplo para explicar los tipos de comentarios.
 * @Since 14/06/2025
 * @Author Agustín Antonio Márquez Piña
 * @Version 1.0
 */
public class Ejemplo { }
```
