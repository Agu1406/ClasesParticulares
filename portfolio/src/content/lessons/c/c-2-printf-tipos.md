---
id: c-2
languageId: c
title: printf, tipos básicos y constantes
description: Especificadores %d, %f, %c, tipos int/double/char/bool, const, #define y casteo. EV1 UT1 u02.
part: 2
totalParts: 6
roadmapPhase: fundamentos
sectionIcons:
  - data_object
exercises:
  - id: ex1
    title: Recorre U02_PrintfBasico.c y U02_VariablesTipos.c anotando cada especificador de printf.
    completed: false
    fileFolder: ut1_fundamentosc/u02tiposvariables/teoria
  - id: ex2
    title: Practica la ficha ejemplointernotiposvariables (pendiente antes que resuelto).
    completed: false
    fileFolder: ut1_fundamentosc/u02tiposvariables/practicas/ejemplointernotiposvariables
---

## Tipos que debes dominar en EV1

| Tipo | Uso típico |
|------|------------|
| `int` | Contadores, edades, índices |
| `double` | Medidas, dinero, divisiones reales |
| `char` | Un carácter (`'A'`) |
| `bool` | Verdadero/falso (`#include <stdbool.h>`) |

En C **no hay** tipo `string`: el texto llega en UT3 como array de `char`.

## printf y formatos

- `%d` entero, `%f` real, `%c` carácter, `%s` cadena C (terminada en `\0`).
- `%.2f` fija decimales; `%%` imprime un `%`.

## Constantes

- `const int MAX = 100;` — variable que no debe cambiar.
- `#define IVA 0.21` — macro del preprocesador (sustitución de texto).

## Casteo y división

Si `a` y `b` son `int`, `a / b` es **entera**. Para resultado real: `(double)a / b` o guardar en `double`.

## Repaso activo

Haz el **test interactivo** del módulo (tema «Tipos») tras leer los `.c` de teoría; las preguntas citan las mismas ideas que el examen sorpresa EV1.
