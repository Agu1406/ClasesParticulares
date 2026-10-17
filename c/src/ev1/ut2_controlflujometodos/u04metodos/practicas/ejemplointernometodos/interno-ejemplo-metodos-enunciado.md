# Practica ejemplo: mini biblioteca matematica

**Objetivo:** Escribir funciones con parametros y retorno, reutilizar y probar con casos limite.

## Enunciado

Implementa estas funciones (el `main` ya contiene las pruebas):

| Funcion | Descripcion |
|---|---|
| `bool es_primo(int n)` | `true` si `n` es primo (los menores que 2 no lo son). |
| `int mcd(int a, int b)` | Maximo comun divisor (Euclides). |
| `long long factorial(int n)` | `n!`, de forma recursiva. |
| `long long fibonacci(int n)` | Termino `n` con un bucle (`fib(0)=0`, `fib(1)=1`). |
| `int suma_digitos(int n)` | Suma de las cifras de `n >= 0`. |
| `long long potencia(int base, int exp)` | `base^exp` sin usar `pow`. |
| `bool es_perfecto(int n)` | `true` si `n` es igual a la suma de sus divisores propios. |
| `int cifras_pares(int n)` | Cuantas cifras pares tiene `n >= 0`. |

## Ejemplo de ejecucion

```
  [ OK  ] ...
Resultado: 8/8 pruebas correctas
```

## Entrega

Entrega `EjemploMetodos_SIN_RESOLVER.c` completado.

Compila con `gcc -std=c11 -Wall -Wextra -pedantic fichero.c -o prog -lm` y ejecuta `./prog` (en Windows `prog.exe`).
