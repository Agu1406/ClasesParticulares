---
id: java-11
languageId: java
title: Conceptos básicos de la POO
description: Clases como plantillas, objetos como instancias. Atributos y métodos. Constructores y encapsulación (guía java/src/README.md).
part: 11
totalParts: 11
roadmapPhase: poo
pdfFile: L02-Clases y Objetos.pdf
sectionIcons:
  - data_object
exercises:
  - id: ex1
    title: Define una clase Coche con marca y año; crea dos coches e imprime sus datos.
    completed: false
  - id: ex2
    title: Ejercicios de POO básico (clases, objetos, constructores).
    completed: false
    fileFolder: poo_basico
  - id: ex3
    title: Soluciones resueltas de POO básico.
    completed: false
    solutionFolder: poo_basico/resueltos
---

## Clase y objeto

Una clase agrupa atributos (datos) y métodos (comportamiento). Con new creas instancias (objetos).

```java
public class Persona {
    String nombre;
    int edad;

    public void presentarse() {
        System.out.println("Soy " + nombre + ", tengo " + edad + " años.");
    }
}

Persona p = new Persona();
p.nombre = "Ana";
p.edad = 25;
p.presentarse();
```

## Constructor y encapsulación

El constructor tiene el mismo nombre que la clase. Los atributos private se acceden mediante getters y setters.

```java
public class Cuenta {
    private double saldo;

    public Cuenta(double saldoInicial) {
        saldo = saldoInicial;
    }

    public double getSaldo() { return saldo; }
    public void depositar(double cantidad) {
        if (cantidad > 0) saldo += cantidad;
    }
}
```
