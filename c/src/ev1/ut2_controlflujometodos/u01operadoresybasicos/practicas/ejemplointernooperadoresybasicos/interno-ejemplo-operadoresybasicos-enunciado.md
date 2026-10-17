# Practica ejemplo: conversor de segundos

**Objetivo:** Dominar / y % con enteros, y usar & para comprobar bits.

## Enunciado

Lee un entero no negativo `total` (segundos) y muestra:

1. `total segundos = H h M min S s` (horas totales, no solo las del dia).
2. `= D dia(s) y R h` (dias completos y las horas que sobran).
3. `Es par` o `Es impar` usando `total & 1` (sin `%`).
4. `Multiplo de 8: si` o `Multiplo de 8: no` usando `(total & 7) == 0`.

## Ejemplo de ejecucion

```
Segundos: 98765
98765 segundos = 27 h 26 min 5 s
= 1 dia(s) y 3 h
Es impar
Multiplo de 8: no
```

## Entrega

Entrega `EjemploOperadoresBasicos_SIN_RESOLVER.c` completado.

Compila con `gcc -std=c11 -Wall -Wextra -pedantic fichero.c -o prog -lm` y ejecuta `./prog` (en Windows `prog.exe`).
