# E02 — Examen RA1 / RA3 / RA5

Consola. Sin POO, sin ficheros ni GUI. Un `Main` por carpeta de ejercicio.

---

## E01_ConversorTemperatura (3 puntos)

1. Fórmulas:  
   F = C × 9 / 5 + 32  
   C = (F − 32) × 5 / 9
2. Pide un valor `double` y la escala de origen (`C` o `F`).
3. Si la escala no es válida, error y fin.
4. Muestra el resultado en la otra escala.
5. Muestra también el resultado casteado a `int` y comenta el efecto del casteo.

Usa `9.0` / `5.0` para no truncar en la división.

---

## E02_CajeroAparcamiento (3,5 puntos)

Tarifa: **0,05 €/minuto**, mínimo **1,00 €**.

1. Pide minutos (`int` ≥ 0). Si es negativo, error y fin.
2. Calcula el cobro (mínimo 1 € si el bruto es menor).
3. Pregunta si tiene bono (`S`/`N`). Si sí, 10 % de descuento.
4. Muestra: minutos, cobro sin descuento, descuento y total.

---

## E03_EntrenamientoNumerico (3,5 puntos)

Menú `do-while` hasta salir:

```text
[1] Contar pares en un rango
[2] Factorial
[3] Media de positivos (centinela 0)
[0] Salir
```

- **1:** pide inicio y fin; si inicio > fin, intercámbialos. Cuenta pares en el intervalo (incluido).
- **2:** pide n ≥ 0; calcula factorial en `long` (`0! = 1`).
- **3:** lee positivos hasta 0; ignora negativos. Muestra la media (o aviso si no hubo).
- **0:** salir. Otra opción: mensaje de error.
