---
id: java-8
languageId: java
title: Strings y funciones
description: Trabajar con cadenas de texto (String) y definir métodos; parámetros, retorno y reutilización de código (guía java/src/README.md).
part: 8
totalParts: 11
roadmapPhase: estructuras
pdfFile: String referencia breve.pdf
sectionIcons:
  - text_fields
exercises:
  - id: ex1
    title: Crea un método que reciba un String y devuelva su longitud; prueba con varios textos.
    completed: false
  - id: ex2
    title: Ejercicios de strings (código para practicar).
    completed: false
    fileFolder: strings
  - id: ex3
    title: Soluciones resueltas de ejercicios de strings.
    completed: false
    solutionFolder: strings/resueltos
---

## String: longitud, concatenación, comparación

String tiene length(), concat() o el operador +. Para comparar contenido usa equals(); == compara referencias.

```java
String a = "Hola";
String b = " mundo";
System.out.println(a + b);
System.out.println(a.length());
System.out.println(a.equals("Hola"));
```

## Métodos: declaración y uso

Un método tiene nombre, parámetros (opcionales) y tipo de retorno. void indica que no devuelve nada.

```java
public static void saludar() {
    System.out.println("Hola");
}
public static int sumar(int a, int b) {
    return a + b;
}
```
