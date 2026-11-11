# E08 — Examen práctico (2.ª evaluación)

**Módulo:** 0485 Programación · Consola Java  
**Duración:** 2 horas · **Total:** 10 puntos  
**RA (alumno):** RA2 · RA4.3 (propiedades y métodos; el ej.4 amplía con herencia) · RA6.1 (arrays/matrices)  
**RA4.8** (métodos estáticos): apenas entra.

Estilo inspirado en exámenes públicos de 2.ª eval (ver `FUENTES.md`). Enunciado adaptado para este repo.

## Instrucciones

1. Duración: 2 horas. Hay **4 ejercicios**; la puntuación va junto a cada título.
2. Cada ejercicio es un programa completo con clase `Main`. Usa `Scanner teclado = new Scanner(System.in)`.
3. **Pide cada dato con un mensaje** que termine en ` => ` (con espacio), p. ej. `Introduce una fila => `. La corrección compara **toda** la salida, incluidos esos mensajes.
4. Entra lo de la 1.ª evaluación más arrays/matrices, `String`, clases y objetos, y herencia. En los ejercicios de clases, escribe las clases **en el mismo archivo**, **sin `public`**, antes o después de `Main`.
5. Un programa que no compila no puntúa. Entrega aunque no hayas terminado.
6. En el simulacro: sin apuntes ni Internet hasta entregar.

| Ejercicio | Puntos |
|-----------|--------|
| 1. Las butacas del cine | 2 |
| 2. El cifrado César | 2,5 |
| 3. El inventario de la tienda | 2,5 |
| 4. Los socios del gimnasio | 3 |
| **Total** | **10** |

---

## E01_ButacasCine (2 puntos)

Un cine de barrio tiene una sala de **4 filas** con **6 butacas** cada una. La taquilla anota las reservas una a una.

### Qué debe hacer el programa

1. Guarda la sala en `boolean[4][6]` (`false` = libre).
2. Pide `Introduce una fila => ` y `Introduce una butaca => ` (empezando en **1**) en bucle hasta `0 0`.
3. Si la butaca no existe: `Butaca F-B no existe`.
4. Si ya está ocupada: `Butaca F-B ya ocupada`.
5. Si es válida y libre, se reserva **sin mostrar nada** más.
6. Al terminar, muestra cada fila (`X` ocupada, `.` libre), p. ej. `1 ..X...`, y luego `Libres: N`.

### Ejemplo

**Entrada** (valores tecleados):

```text
1
3
2
3
1
3
5
1
0
0
```

**Salida:**

```text
Introduce una fila => Introduce una butaca => Introduce una fila => Introduce una butaca => Introduce una fila => Introduce una butaca => Butaca 1-3 ya ocupada
Introduce una fila => Introduce una butaca => Butaca 5-1 no existe
Introduce una fila => Introduce una butaca => 1 ..X...
2 ..X...
3 ......
4 ......
Libres: 22
```

*(En consola, cada `print` de prompt queda en la misma línea que el número tecleado; arriba se muestra el texto que escribe el programa.)*

---

## E02_CifradoCesar (2,5 puntos)

Desplaza cada letra del alfabeto inglés un número fijo de posiciones (puede ser negativo o mayor que 26). Solo cambian `a`–`z` / `A`–`Z`; el resto se mantiene.

### Qué debe hacer el programa

1. Pide `Introduce el desplazamiento => ` y `Introduce el mensaje => `.
2. Muestra `Cifrado: ` + mensaje cifrado.
3. Muestra `Letras cambiadas: ` + cuántas letras se han desplazado.
4. Mayúscula sigue mayúscula; minúscula, minúscula.

### Ejemplo

**Entrada:**

```text
3
Hola, mundo
```

**Salida:**

```text
Introduce el desplazamiento => Introduce el mensaje => Cifrado: Krod, pxqgr
Letras cambiadas: 9
```

**Otro ejemplo (desplazamiento -1, mensaje `ABC xyz`):**

```text
Introduce el desplazamiento => Introduce el mensaje => Cifrado: ZAB wxy
Letras cambiadas: 6
```

---

## E03_InventarioTienda (2,5 puntos)

Clase `Producto` con código, precio y stock; métodos `boolean vender(int)`, `void reponer(int)` y `double valor()` (stock × precio).

### Qué debe hacer el programa

1. Pide el número de productos y, por cada uno, código, precio (`Locale.US`) y stock.
2. Pide operaciones hasta `FIN`: `V` vender o `R` reponer (más código y unidades).
3. Código inexistente: `No existe el producto C3`.
4. Stock insuficiente: `Stock insuficiente de B2 (quedan 5)`.
5. Al final, cada producto como `A1: 7 unidades · 17.50 €` y `Valor total: 35.50 €`.

### Ejemplo

**Entrada:**

```text
2
A1
2.50
10
B2
1.20
5
V
A1
3
V
B2
6
R
B2
10
V
C3
1
FIN
```

**Salida (resumen de mensajes del programa):**

```text
Introduce el numero de productos => Introduce el codigo => Introduce el precio => Introduce el stock => Introduce el codigo => Introduce el precio => Introduce el stock => Introduce una operacion (V/R/FIN) => Introduce el codigo => Introduce las unidades => Introduce una operacion (V/R/FIN) => Introduce el codigo => Introduce las unidades => Stock insuficiente de B2 (quedan 5)
Introduce una operacion (V/R/FIN) => Introduce el codigo => Introduce las unidades => Introduce una operacion (V/R/FIN) => Introduce el codigo => Introduce las unidades => No existe el producto C3
Introduce una operacion (V/R/FIN) => A1: 7 unidades · 17.50 €
B2: 15 unidades · 18.00 €
Valor total: 35.50 €
```

---

## E04_SociosGimnasio (3 puntos)

Clase abstracta `Socio` (nombre, meses, `double importe()`, `String modalidad()`) y una subclase por modalidad:

- **Básico:** 25 €/mes.
- **Premium:** 40 €/mes; si meses ≥ 12, 10 % de descuento sobre el total.
- **Estudiante:** 18 €/mes hasta 10 meses; los meses de más, a precio de básico (25 €).

### Qué debe hacer el programa

1. Pide el número de socios y, por cada uno, modalidad (`B`/`P`/`E`), nombre y meses.
2. Una línea por socio: `Ana (básico, 3 meses): 75.00 €` (usa `1 mes` en singular).
3. Termina con `Total: ` y `Socio que más paga: ` (el primero si hay empate).

### Ejemplo

**Entrada:**

```text
3
B
Ana
3
P
Luis
12
E
Eva
12
```

**Salida:**

```text
Introduce el numero de socios => Introduce la modalidad (B/P/E) => Introduce el nombre => Introduce los meses => Introduce la modalidad (B/P/E) => Introduce el nombre => Introduce los meses => Introduce la modalidad (B/P/E) => Introduce el nombre => Introduce los meses => Ana (básico, 3 meses): 75.00 €
Luis (premium, 12 meses): 432.00 €
Eva (estudiante, 12 meses): 230.00 €
Total: 737.00 €
Socio que más paga: Luis
```
