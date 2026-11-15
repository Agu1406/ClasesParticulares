# E11 — Examen práctico (arrays / matriz) — JavaPaint

**Módulo:** 0485 Programación · Consola Java  
**RA (alumno):** RA6.1 (arrays/matrices) · bucles · métodos  
**Total orientativo:** 40 puntos (rúbrica del modelo público)

Adaptado del [Examen 4 arrays (imal3xg)](https://github.com/imal3xg/examenes-programacion-1-dam) — mini editor en consola sobre un tablero. Ver `FUENTES.md`.

## Instrucciones

1. Un único programa con clase `Main` (en este repo: carpeta `E01_JavaPaint`).
2. Matriz `char[11][11]`: bordes `*`, interior espacios. El **cabezal** no se guarda en la matriz: usa dos variables de fila/columna.
3. En cada vuelta: pintar tablero → menú → leer opción (`char` con `teclado.next().charAt(0)`).
4. Salir con **`q`**.

| Bloque | Qué pide | Puntos |
|--------|----------|--------|
| 1. Tablero y menú | Crear, inicializar, pintar, menú, salir con `q` | 20 |
| 2. Movimiento | `a` `d` `s` `w` sin pisar asteriscos; pintar/borrar antes de mover | 10 |
| 3. Modos | `p` pintar, `b` borrar, `m` mover (letra del cabezal P/B/M) | 10 |
| 4. Transformaciones | `r` rotar antihorario, `e` espejo horizontal, `l` limpiar | 10 |

---

## E01_JavaPaint

### Tablero

- Tamaño **11×11**.
- Bordes con `*`, interior con espacio `' '`.
- Cabezal inicial en el **centro** `(5, 5)` (índices 0-based).
- Al imprimir, en la casilla del cabezal se muestra `M`, `P` o `B` según el modo (no se escribe el cabezal dentro de la matriz).

### Menú

```text
a. Izquierda
d. Derecha
s. Abajo
w. Arriba
p. Pintar
b. Borrar
m. Mover
r. Rotar sentido antihorario
e. Espejo horizontal
l. Limpiar tablero
q. Salir
```

### Movimiento (`a` `d` `w` `s`)

- No puede situarse sobre los asteriscos del borde.
- Si modo **pintar**: escribe `'x'` en la posición actual y **después** se mueve.
- Si modo **borrar**: escribe `' '` y después se mueve.
- Si modo **mover**: solo se mueve.

### Modos

- `p` → pintar (cabezal `P`)
- `b` → borrar (cabezal `B`)
- `m` → mover (cabezal `M`)

### Transformaciones

- `r`: rota el contenido **90° antihorario**. La posición del cabezal **no** rota.
- `e`: espejo **horizontal** (izquierda ↔ derecha). El cabezal **no** se mueve.
- `l`: vuelve a inicializar el tablero (bordes `*`, interior vacío).

### Bucle

`do { pintar tablero; menú; leer opción; actuar } while (opción != 'q');`

### Ejemplo de arranque (fragmento)

Tras limpiar, el centro muestra `M` y el resto del interior espacios; el marco es de asteriscos. Tras `q`, el programa termina sin más salida.
