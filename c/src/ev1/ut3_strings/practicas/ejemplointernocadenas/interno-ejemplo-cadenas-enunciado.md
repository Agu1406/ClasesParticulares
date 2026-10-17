# Practica ejemplo: informe de una frase

**Objetivo:** Combinar lectura de cadenas, `string.h` y `ctype.h` en un programa pequeno.

## Enunciado

Escribe un programa en C que lea **una linea** de texto (puede tener espacios) y muestre un informe con:

- La frase original.
- Su longitud (`strlen`).
- Cuantas vocales tiene (`a e i o u`, mayusculas o minusculas).
- Cuantas letras, digitos y espacios tiene.
- La misma frase en MAYUSCULAS.

No hace falta tratar UTF-8: trabaja con ASCII (como el resto de la UT3).

## Ejemplo de ejecucion

```
Frase: Hola DAM 2026
Longitud: 13
Vocales: 3
Letras: 7
Digitos: 4
Espacios: 2
Mayusculas: HOLA DAM 2026
```

## Entrega

Entrega `EjemploCadenas_SIN_RESOLVER.c` completado.

Compila con `gcc -std=c11 -Wall -Wextra -pedantic fichero.c -o prog -lm` y ejecuta `./prog` (en Windows `prog.exe`).
