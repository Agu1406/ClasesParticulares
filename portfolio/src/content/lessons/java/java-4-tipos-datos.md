---
id: java-4
languageId: java
title: Tipos de datos
description: Java es un lenguaje tipado; cada dato tiene su contenedor. Datos primitivos (int, double, char, boolean...) y datos avanzados (Integer, String...).
part: 4
totalParts: 11
roadmapPhase: fundamentos
pdfFile: 2ClasesTiposDatos.pdf
pdfSource: usc
sectionIcons:
  - data_object
exercises:
  - id: ex1
    title: Declara variables de tipos primitivos y asígnales valor; prueba en DatosPrimitivos.java.
    completed: false
---

## Sintaxis: tipo nombre = valor

Cada tipo de dato se guarda en una variable de ese tipo. No se puede guardar un entero en un char ni una letra en un int. Cada cosa tiene su lugar.

```java
int miNumeroFavorito = 14;
char miLetraFavorita = 'A';
```

## Datos primitivos

Las formas más básicas: enteros (byte, short, int, long), decimales (float, double), carácter (char), lógico (boolean). Para aprender rápido se recomienda usar int para enteros y double para decimales. Puedes probar en DatosPrimitivos.java (src/ev1/ut0/tipodatos).

```java
byte unByte = 42;
int unInt = 123456;
long unLong = 123456789L;
float unFloat = 3.14f;
double unDouble = 3.1415926535;
char unChar = 'A';
boolean unBoolean = true;
```

## Datos avanzados

Tienen la primera letra en mayúscula (Integer, Double, String...). Ocupan más memoria y ofrecen características avanzadas. String es el tipo para cadenas de texto. Los veremos en ejercicios más adelante.

```java
Integer myInt = 123_456;
String myString = "Hola, soy un texto";
```
