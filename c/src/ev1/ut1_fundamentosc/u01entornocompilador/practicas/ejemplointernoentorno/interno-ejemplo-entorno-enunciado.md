# Practica ejemplo: ficha del programador

**Objetivo:** Practicar printf, secuencias de escape y el ciclo editar-compilar-ejecutar.

## Enunciado

Escribe un programa en C que muestre exactamente esta ficha por consola (cada linea con su salto de linea):

- Una linea de 30 signos `=`.
- El titulo `FICHA DEL PROGRAMADOR` centrado a mano.
- Otra linea de `=`.
- Las lineas `Nombre:`, `Lenguaje:` y `Carpeta:` alineadas con un tabulador.
- La carpeta debe mostrarse como `C:\clases\c` (barras invertidas reales).
- Una cita entre comillas dobles: `"Un programa, un paso"`.
- El texto `Progreso: 100%`.
- Una linea final de `=`.

## Ejemplo de ejecucion

```
==============================
    FICHA DEL PROGRAMADOR
==============================
Nombre:	Agustin
Lenguaje:	C11
Carpeta:	C:\clases\c
"Un programa, un paso"
Progreso: 100%
==============================
```

## Entrega

Entrega `EjemploEntorno_SIN_RESOLVER.c` completado.

Compila con `gcc -std=c11 -Wall -Wextra -pedantic fichero.c -o prog -lm` y ejecuta `./prog` (en Windows `prog.exe`).
