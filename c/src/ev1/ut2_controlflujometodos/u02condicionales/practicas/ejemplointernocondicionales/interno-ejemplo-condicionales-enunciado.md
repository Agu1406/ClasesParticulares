# Practica ejemplo: billete de tren

**Objetivo:** Combinar if / else if / switch y operadores logicos.

## Enunciado

Lee la **edad** (int), la **clase** (`T` turista, `P` preferente; admite minusculas) y si es **ida y vuelta** (`s` o `n`).

Reglas:

- Precio base: turista 40.00, preferente 65.00. Otra clase: `Clase no valida` y termina.
- Edad negativa: `Edad no valida` y termina.
- Descuento por edad: menores de 4 viajan gratis; de 4 a 12 anos, 50 %; 65 o mas, 30 %; resto, sin descuento.
- Si es ida y vuelta, el precio (ya con descuento) se multiplica por 1.8.

Muestra `Precio final: X.XX`.

## Ejemplo de ejecucion

```
Edad: 70
Clase (T/P): P
Ida y vuelta (s/n): s
Precio final: 81.90
```

## Entrega

Entrega `EjemploCondicionales_SIN_RESOLVER.c` completado.

Compila con `gcc -std=c11 -Wall -Wextra -pedantic fichero.c -o prog -lm` y ejecuta `./prog` (en Windows `prog.exe`).
