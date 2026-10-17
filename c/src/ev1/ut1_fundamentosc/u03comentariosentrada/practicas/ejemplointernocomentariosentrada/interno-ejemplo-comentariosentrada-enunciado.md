# Practica ejemplo: ticket de compra

**Objetivo:** Leer cadenas y numeros de forma segura (fgets, scanf), validar y dar formato.

## Enunciado

1. Pide el **nombre del producto** (puede tener espacios) con `fgets` y quitale el salto de linea.
2. Pide las **unidades** (`int`) y el **precio unitario** (`double`, usa `%lf`) con `scanf`, comprobando el valor devuelto.
3. Si las unidades no son mayores que 0, muestra `Unidades no validas` y termina con codigo 1.
4. Muestra el ticket: producto, unidades, precio, subtotal, IVA (21 %) y total, todo con 2 decimales.
5. Comenta el programa con una cabecera y comentarios utiles (no uno por linea).

## Ejemplo de ejecucion

```
Producto: Cuaderno A4
Unidades: 3
Precio unitario: 2.4
===== TICKET =====
Producto: Cuaderno A4
Unidades: 3
Precio  : 2.40
Subtotal: 7.20
IVA 21% : 1.51
Total   : 8.71
```

## Entrega

Entrega `EjemploComentariosEntrada_SIN_RESOLVER.c` completado.

Compila con `gcc -std=c11 -Wall -Wextra -pedantic fichero.c -o prog -lm` y ejecuta `./prog` (en Windows `prog.exe`).
