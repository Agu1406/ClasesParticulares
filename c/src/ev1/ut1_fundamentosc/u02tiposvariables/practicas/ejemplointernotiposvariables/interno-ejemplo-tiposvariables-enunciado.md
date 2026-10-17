# Practica ejemplo: factura de la cafeteria

**Objetivo:** Elegir tipos (int, double), usar constantes, casteo y formatos de printf.

## Enunciado

Datos fijos del pedido:

- 3 cafes a 1.35 euros cada uno.
- 2 tostadas a 2.10 euros cada una.
- IVA: 21 % (definelo como constante).

Muestra:

1. `Subtotal` (suma de ambos productos).
2. `IVA (21%)`.
3. `Total`.
4. `Unidades` (total de unidades, entero).
5. `Precio medio por unidad` = subtotal / unidades (cuidado con la division entera: usa casteo).
6. El total en centimos, redondeado, como entero (`(int)(total * 100 + 0.5)`).

## Ejemplo de ejecucion

```
Subtotal: 8.25
IVA (21%): 1.73
Total: 9.98
Unidades: 5
Precio medio por unidad: 1.65
Total en centimos: 998
```

## Entrega

Entrega `EjemploTiposVariables_SIN_RESOLVER.c` completado.

Compila con `gcc -std=c11 -Wall -Wextra -pedantic fichero.c -o prog -lm` y ejecuta `./prog` (en Windows `prog.exe`).
