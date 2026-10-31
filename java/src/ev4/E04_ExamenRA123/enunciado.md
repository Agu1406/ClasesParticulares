# E04 — Examen RA1 / RA3 / RA5 (consola)

Original (estilo 1.ª evaluación típica). Consola. Sin POO, sin arrays, sin ficheros. Un `Main` por carpeta.

---

## E01_FacturaDescuento (3 puntos)

Factura de un servicio:

1. Pide: concepto (`String`), horas (`int`) y precio por hora (`double`).
2. Constante `DESCUENTO = 0.15` (15 % si horas ≥ 10; si no, descuento 0).
3. Calcula subtotal = horas × precio; aplica descuento si corresponde; total = subtotal − descuento.
4. Muestra concepto, horas, subtotal, descuento y total.
5. Muestra el total casteado a `int` y comenta por qué puede diferir.

---

## E02_RegistroEdades (3,5 puntos)

Lee edades (`int`) hasta **-1**:

1. Si la edad es negativa (y no es -1) o mayor que 120: error y vuelve a pedir.
2. Clasifica: Niño `[0,12]`, Adolescente `[13,17]`, Adulto `[18,64]`, Mayor `[65,120]`.
3. Al final: cantidad válida, media (double) y cuántos de cada grupo.
4. Si no hay edades válidas, indícalo (no dividas entre 0).

---

## E03_MenuCajero (3,5 puntos)

Menú `do-while` (saldo inicial 1000.0):

```text
[1] Consultar saldo
[2] Ingresar
[3] Retirar
[0] Salir
```

- **1:** muestra el saldo.
- **2:** pide cantidad > 0 y la suma al saldo.
- **3:** pide cantidad > 0; si hay saldo suficiente, resta; si no, mensaje de error.
- **0:** salir. Otra opción: mensaje de error.
