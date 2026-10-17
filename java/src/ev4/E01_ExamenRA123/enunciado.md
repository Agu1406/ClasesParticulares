# E01 — Examen RA1 / RA3 / RA5

Consola. Sin POO, sin ficheros ni GUI. Un `Main` por carpeta de ejercicio.

---

## E01_TicketIVA (3 puntos)

Simula el cobro de un producto:

1. Pide: nombre (`String`), unidades (`int`) y precio unitario (`double`).
2. Constante `IVA = 0.21`.
3. Calcula base, IVA y total (base + IVA).
4. Muestra un ticket con esos datos.
5. Muestra también el total casteado a `int` y comenta por qué puede diferir.

---

## E02_Centinela (3,5 puntos)

Lee notas hasta que el usuario escriba **-1**:

1. Si la nota no está en [0, 10] (y no es -1), error y vuelve a pedir.
2. Clasifica: Suspenso `[0,5)`, Aprobado `[5,7)`, Notable `[7,9)`, Sobresaliente `[9,10]`.
3. Al final: cantidad, media y cuántas de cada categoría.
4. Si no hay notas válidas, indícalo (no dividas entre 0).

---

## E03_MenuApp (3,5 puntos)

Menú `do-while` hasta salir:

```text
[1] Sumar N enteros
[2] Tabla de multiplicar
[3] Par o impar (varios)
[0] Salir
```

- **1:** pide N > 0, lee N enteros, muestra la suma (`for`).
- **2:** pide un entero y muestra su tabla del 1 al 10.
- **3:** pide cuántos números; para cada uno indica par o impar.
- **0:** salir. Otra opción: mensaje de error.
