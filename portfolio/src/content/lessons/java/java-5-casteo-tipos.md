---
id: java-5
languageId: java
title: Casteo de tipos
description: Convertir una variable de un tipo a otro. Por ejemplo double a int (perdiendo decimales) o int a double. La sintaxis es (tipo) variable.
part: 5
totalParts: 11
roadmapPhase: fundamentos
sectionIcons:
  - swap_horiz
exercises:
  - id: ex1
    title: Convierte un double a int y un int a double; imprime ambos valores.
    completed: false
---

## Conversión de tipos primitivos

Necesitamos una variable recipiente del tipo destino. Entre paréntesis indicamos el tipo al que queremos convertir. El valor original no se pierde; se crea una copia en el nuevo formato. Ejemplos en CasteoTiposPrimitivos.java (src/ev1/ut0/casteotipos).

```java
int valorOriginal = 14;
double valorConvertido = (double) valorOriginal;

double valorPIOriginal = 3.1416;
int valorPIConvertido = (int) valorPIOriginal;
System.out.println(valorPIConvertido); // 3
```
