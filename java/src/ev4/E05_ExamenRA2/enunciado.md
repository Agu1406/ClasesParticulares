# E05 — Examen RA1 / RA3 / RA5 (consola)

Original (estilo 1.ª evaluación típica). Consola. Sin POO, sin arrays, sin ficheros. Un `Main` por carpeta.

---

## E01_CalculadoraIMC (3 puntos)

1. Pide peso en kg (`double`) y altura en metros (`double`).
2. IMC = peso / (altura × altura). Usa `double`.
3. Clasifica con `if` / `else if`:
   - IMC < 18.5 → Bajo peso  
   - IMC < 25 → Normal  
   - IMC < 30 → Sobrepeso  
   - resto → Obesidad  
4. Muestra IMC y categoría.
5. Muestra también el IMC casteado a `int` y comenta el efecto.

---

## E02_MultiplosEnRango (3,5 puntos)

1. Pide `inicio`, `fin` y `divisor` (enteros). Si `inicio > fin`, intercámbialos.
2. Si `divisor` es 0: error y fin.
3. Cuenta cuántos números del intervalo (incluido) son múltiplos de `divisor` (`%`).
4. Muestra el contador.
5. Además muestra la suma de esos múltiplos.

---

## E03_AdivinaNumero (3,5 puntos)

1. Genera un número secreto aleatorio entre 1 y 50 (ambos inclusive).
2. El usuario tiene **7** intentos máximo.
3. En cada intento: pide un entero; si es menor o mayor, indícalo; si acierta, gana y para.
4. Si agota los intentos sin acertar, pierde y muestra el secreto.
