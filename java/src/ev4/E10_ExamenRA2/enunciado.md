# E10 — Examen práctico (1.ª evaluación)

**Módulo:** 0485 Programación · Consola Java  
**Duración:** 2 horas · **Total:** 10 puntos

Estilo inspirado en el examen resuelto de ejemplo de Apuntes DAM (ver `FUENTES.md`). Enunciado adaptado para este repo.

## Instrucciones

1. Duración: 2 horas. Hay **4 ejercicios**; la puntuación va junto a cada título.
2. Cada ejercicio es un programa completo con clase `Main`. Lee con `Scanner` **en el orden indicado** y muestra la salida **exactamente** como en los ejemplos.
3. Solo lo visto en la evaluación: variables, operadores, entrada/salida, condicionales, bucles y **métodos**. No hacen falta arrays ni métodos de `String`.
4. Un programa que no compila no puntúa. Entrega aunque no hayas terminado.
5. En el simulacro: sin apuntes ni Internet hasta entregar.

| Ejercicio | Puntos |
|-----------|--------|
| 1. La tarifa del aparcamiento | 2 |
| 2. El registro de temperaturas | 2,5 |
| 3. Los primos gemelos | 2,5 |
| 4. El cajero automático | 3 |
| **Total** | **10** |

---

## E01_TarifaAparcamiento (2 puntos)

Los primeros **15 minutos** son gratis. Si ha estado **más de 15 minutos**, paga **0,04 € por cada minuto** de estancia (contando desde el primero). El importe nunca pasa de **18 €**. Con etiqueta **CERO** (`1`) paga la mitad; el descuento se aplica **después** del tope.

### Qué debe hacer el programa

1. Lee dos enteros: minutos y etiqueta (`1` = CERO, `0` = no).
2. Si los minutos son negativos o la etiqueta no es 0 ni 1: `Datos no válidos`.
3. Si no: `Importe: X.XX €` con `Locale.US`.

### Ejemplos

```text
16
0
```

```text
Importe: 0.64 €
```

```text
600
1
```

```text
Importe: 9.00 €
```

```text
-5
0
```

```text
Datos no válidos
```

---

## E02_RegistroTemperaturas (2,5 puntos)

Lecturas enteras hasta el centinela **999** (no cuenta). Alerta si la temperatura es **> 35** o **< 2**.

### Qué debe hacer el programa

1. Lee temperaturas hasta `999`.
2. Si no hay lecturas: `Sin lecturas`.
3. Si las hay, cuatro líneas: `Lecturas: `, `Media: ` (1 decimal, `Locale.US`), `Máxima: `, `Alertas: `.

### Ejemplos

```text
20
25
36
1
30
999
```

```text
Lecturas: 5
Media: 22.4
Máxima: 36
Alertas: 2
```

```text
999
```

```text
Sin lecturas
```

---

## E03_PrimosGemelos (2,5 puntos)

Dos primos son gemelos si se diferencian en 2. Escribe `static boolean esPrimo(int n)` y úsalo desde `main`.

### Qué debe hacer el programa

1. Lee extremos `a` y `b`.
2. Si `a > b`: `Intervalo no válido`.
3. Si no, una línea por cada pareja `(p, p + 2)` con ambos en el intervalo, y al final `Parejas: N`.

### Ejemplos

```text
1
20
```

```text
3 5
5 7
11 13
17 19
Parejas: 4
```

```text
10
1
```

```text
Intervalo no válido
```

---

## E04_CajeroAutomatico (3 puntos)

Billetes de **50**, **20** y **10 €**. De los de 50 solo queda un número limitado. Da primero todos los de 50 posibles, luego 20 y luego 10.

Método `static void mostrar(int cantidad, int valor)`: escribe la línea de ese billete, o nada si la cantidad es 0 (singular/plural).

### Qué debe hacer el programa

1. Lee cantidad a sacar y billetes de 50 disponibles.
2. Validar **en este orden**:
   - cantidad ≤ 0 → `Cantidad no válida`
   - no múltiplo de 10 → `El cajero solo entrega múltiplos de 10 €`
   - > 600 → `Supera el límite diario de 600 €`
3. Si se puede: líneas de billetes (mayor a menor) y `Total de billetes: N`.

### Ejemplos

```text
180
10
```

```text
3 billetes de 50 €
1 billete de 20 €
1 billete de 10 €
Total de billetes: 5
```

```text
180
1
```

```text
1 billete de 50 €
6 billetes de 20 €
1 billete de 10 €
Total de billetes: 8
```

```text
15
5
```

```text
El cajero solo entrega múltiplos de 10 €
```
