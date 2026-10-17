# Practica ejemplo: estadisticas de temperaturas

**Objetivo:** Bucle con centinela y acumuladores (suma, maximo, minimo, contadores).

## Enunciado

Lee numeros enteros (temperaturas) hasta que el usuario escriba `-999`. El centinela NO es un dato.

Al terminar muestra:

- `Dias`: cuantas temperaturas se leyeron.
- `Media` con 2 decimales.
- `Maxima` y `Minima`.
- `Dias de helada`: cuantas fueron menores que 0.

Si no se leyo ningun dato muestra `Sin datos`.

## Ejemplo de ejecucion

```
Temperatura (-999 para terminar): 12
...
Dias: 6
Media: 5.17
Maxima: 15
Minima: -3
Dias de helada: 2
```

## Entrega

Entrega `EjemploBucles_SIN_RESOLVER.c` completado.

Compila con `gcc -std=c11 -Wall -Wextra -pedantic fichero.c -o prog -lm` y ejecuta `./prog` (en Windows `prog.exe`).
