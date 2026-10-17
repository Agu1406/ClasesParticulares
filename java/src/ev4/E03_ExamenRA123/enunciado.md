# E03 — Examen RA1 / RA3 / RA5

Consola. Sin POO, sin ficheros ni GUI. Un `Main` por carpeta de ejercicio.

---

## E01_ConversorMonedas (2 puntos)

Convierte euros ↔ dólares:

1. Pide la cantidad (`double`).
2. Pide el valor de cambio (p. ej. cuántos dólares vale 1 euro, o cuántos euros vale 1 dólar).
3. Elige el sentido de la conversión.
4. Muestra el resultado.

---

## E02_TerminadosEn3 (3 puntos)

Lee enteros positivos hasta que llegue uno **negativo**.

Cuenta cuántos terminan en 3 (`n % 10 == 3`).

El negativo no se cuenta; solo corta la secuencia. Muestra el contador al final.

---

## E03_AprenderASumar (5 puntos)

1. Pide N (entre 2 y 50). Si no, error y fin.
2. Genera N sumas de 3 números aleatorios entre 10 y 100.
3. Muestra cada suma (`a + b + c = ?`) y lee la respuesta.
4. Indica si es correcta o incorrecta.
5. Pierde al llegar a **N/2** errores (división entera) y para.
6. Si termina las N sumas sin llegar a ese tope, gana.

Ejemplo: N = 4 → máx. 2 errores. N = 5 → máx. 2 errores.
