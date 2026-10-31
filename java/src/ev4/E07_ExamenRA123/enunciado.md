# E07 — Examen práctico (1.ª evaluación)

**Módulo:** 0485 Programación · Consola Java  
**Duración:** 2 horas · **Total:** 10 puntos

## Instrucciones

1. Duración: 2 horas. Hay **4 ejercicios**; la puntuación va junto a cada título.
2. Cada ejercicio es un programa completo con clase `Main`. Lee con `Scanner` **en el orden indicado** y muestra la salida **exactamente** como en los ejemplos (se corrige línea a línea).
3. Solo lo visto en la evaluación: variables, operadores, entrada/salida, condicionales, bucles y **métodos**. No hace falta arrays ni métodos de `String`.
4. Un programa que no compila no puntúa. Entrega aunque no hayas terminado.
5. En el simulacro: sin apuntes ni Internet hasta entregar.

| Ejercicio | Puntos |
|-----------|--------|
| 1. La factura de la luz | 2 |
| 2. El contador de pasos | 2,5 |
| 3. Simplificar fracciones | 2,5 |
| 4. El día del año | 3 |
| **Total** | **10** |

---

## E01_FacturaLuz (2 puntos)

La compañía cobra:

- **Término fijo:** `3.50` € (constante).
- **Energía:** `0.18` € por cada kWh consumido (constante).
- Si el consumo es **mayor o igual a 300** kWh, aplica un **10 %** de descuento **solo sobre la parte de energía** (no sobre el fijo).

### Qué debe hacer el programa

1. Lee un `double`: kWh consumidos.
2. Si el consumo es negativo, muestra exactamente: `Datos no validos`
3. Si no, calcula y muestra (una línea cada una):
   - `Fijo: X.XX`
   - `Energia: X.XX`
   - `Descuento: X.XX`
   - `Total: X.XX`  
   Usa dos decimales con `printf` y punto decimal (`Locale.US` o equivalente).

### Ejemplos

```text
250
```

```text
Fijo: 3.50
Energia: 45.00
Descuento: 0.00
Total: 48.50
```

```text
300
```

```text
Fijo: 3.50
Energia: 54.00
Descuento: 5.40
Total: 52.10
```

```text
-1
```

```text
Datos no validos
```

---

## E02_ContadorPasos (2,5 puntos)

Registro diario de pasos hasta que el usuario escriba **0** (centinela; el 0 no cuenta).

1. Lee enteros (pasos del día). Si un valor es **negativo**, muestra `Ignorado` y **no** lo cuentas; sigue pidiendo.
2. Al terminar (al leer 0):
   - Si no hubo ningún día válido: `Sin datos`
   - Si no: muestra  
     `Dias: N`  
     `Total: T`  
     `Media: M.M` (un decimal)  
     `Maximo: X`

### Ejemplos

```text
4000
7500
-3
9000
0
```

```text
Ignorado
Dias: 3
Total: 20500
Media: 6833.3
Maximo: 9000
```

```text
0
```

```text
Sin datos
```

---

## E03_SimplificarFracciones (2,5 puntos)

Lee dos enteros: numerador y denominador.

1. Si el denominador es **0**: `Fraccion no valida`
2. Si no, simplifica la fracción (divide numerador y denominador por su **MCD**).
3. El signo negativo, si lo hay, debe quedar **solo en el numerador** (denominador siempre positivo).
4. Muestra: `a/b` (simplificada).  
   Recomendación: un método `mcd(int a, int b)`.

### Ejemplos

```text
12
18
```

```text
2/3
```

```text
-15
25
```

```text
-3/5
```

```text
8
0
```

```text
Fraccion no valida
```

---

## E04_DiaDelAno (3 puntos)

Lee tres enteros: `dia`, `mes`, `anio`.

1. Si la fecha no es válida (mes fuera de 1–12, día imposible para ese mes, año ≤ 0): `Fecha no valida`
2. Si es válida, calcula qué **día del año** es (1 = 1 de enero, …). Ten en cuenta **años bisiestos** (divisible por 4, salvo múltiplos de 100 que no lo sean de 400).
3. Muestra: `Dia del anio: N`

Puedes usar métodos (`esBisiesto`, `diasDelMes`, …).

### Ejemplos

```text
1
1
2024
```

```text
Dia del anio: 1
```

```text
1
3
2024
```

```text
Dia del anio: 61
```

```text
29
2
2023
```

```text
Fecha no valida
```

```text
31
4
2024
```

```text
Fecha no valida
```
