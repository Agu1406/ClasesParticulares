# E06 — Examen RA1 / RA3 / RA5 (consola)

Original (estilo 1.ª evaluación típica). Consola. Sin POO, sin arrays, sin ficheros. Un `Main` por carpeta.

---

## E01_NominaSimple (3 puntos)

1. Pide nombre (`String`), horas trabajadas (`int`) y precio hora (`double`).
2. Constantes: `IRPF = 0.15`. Las horas > 40 se pagan al **1.5** del precio hora (extras).
3. Calcula: pago bruto (normal + extras), retención IRPF, neto = bruto − retención.
4. Muestra nombre, bruto, retención y neto.
5. Muestra el neto casteado a `int` con comentario.

---

## E02_SumaHastaLimite (3,5 puntos)

1. Pide un límite positivo (`int`). Si ≤ 0: error y fin.
2. Lee enteros uno a uno y ve sumándolos.
3. Para cuando la suma **alcance o supere** el límite (el número que lo supera sí cuenta).
4. Muestra: suma final, cuántos números se leyeron y si se superó el límite o se igualó exactamente.

---

## E03_MenuEstadisticas (3,5 puntos)

Menú `do-while`:

```text
[1] Máximo de N enteros
[2] Contar vocales de una palabra
[3] Tabla del n (1 al 12)
[0] Salir
```

- **1:** pide N > 0; lee N enteros; muestra el máximo.
- **2:** pide una palabra (`String`); cuenta cuántas vocales aeiou/AEIOU tiene (recorre con `charAt` y `for`).
- **3:** pide n y muestra `n x i = resultado` del 1 al 12.
- **0:** salir. Otra: error.
