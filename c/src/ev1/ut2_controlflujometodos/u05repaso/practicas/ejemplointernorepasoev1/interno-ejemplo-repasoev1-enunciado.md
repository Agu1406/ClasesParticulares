# Practica ejemplo: caja registradora

**Objetivo:** Repaso integrador: menu con do-while y switch, funciones, validacion y acumuladores.

## Enunciado

Menu:

```
1. Anadir producto
2. Ver total
3. Aplicar descuento del 10%
4. Vaciar caja
0. Salir
```

- **1**: pide un precio; si no es un numero positivo, muestra `Precio no valido`. Si es valido, lo suma al total y cuenta un articulo.
- **2**: muestra `Articulos: N` y `Total: X.XX`.
- **3**: reduce el total un 10 % y muestra `Descuento aplicado`.
- **4**: pone total y articulos a 0 y muestra `Caja vaciada`.
- **0**: muestra `Hasta luego.`
- Otra opcion: `Opcion no valida`.

Organiza el programa en funciones: `leer_numero`, `mostrar_menu` y una por opcion.

## Ejemplo de ejecucion

```
Opcion: 1
Precio: 12.50
Opcion: 1
Precio: 7.50
Opcion: 2
Articulos: 2
Total: 20.00
```

## Entrega

Entrega `EjemploRepasoEv1_SIN_RESOLVER.c` completado.

Compila con `gcc -std=c11 -Wall -Wextra -pedantic fichero.c -o prog -lm` y ejecuta `./prog` (en Windows `prog.exe`).
