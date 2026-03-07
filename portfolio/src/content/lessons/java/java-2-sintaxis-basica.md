---
id: java-2
languageId: java
title: Sintaxis básica
description: Las 4 líneas mínimas para un programa ejecutable. El primer Hola mundo y System.out.println. El nombre de la clase debe coincidir con el del archivo .java.
part: 2
totalParts: 11
roadmapPhase: fundamentos
sectionIcons:
  - terminal
exercises:
  - id: ex1
    title: Crea una clase con tu nombre e imprime Hola mundo y tu nombre en líneas distintas.
    completed: false
---

## Nuestro primer programa en Java

Por ahora aprendemos de memoria las 4 líneas mínimas necesarias para que nuestros programas sean ejecutables. Donde dice NombreDelPrograma tiene que ir exactamente el mismo nombre (con mayúsculas y minúsculas) del archivo .java. Puedes abrir Programa1.java en src/ev1/ut0/sintaxisbasica.

```java
public class NombreDelPrograma { // Línea 1
    public static void main (String [] args) { // Línea 2
    } // Línea 3
} // Línea 4
```

## Nuestro primer Hola mundo

Con System.out.println() imprimimos mensajes. El texto va entre paréntesis y entre comillas dobles o simples. Las instrucciones en Java siempre terminan con punto y coma (;). Modifica Programa1.java y Programa2.java en src/ev1/ut0/sintaxisbasica para practicar.

```java
public class Programa2 {
    public static void main (String [] args) {
        System.out.println("¡Hola mundo!");
        System.out.println("¡Mi nombre es Agustín!");
    }
}
```
