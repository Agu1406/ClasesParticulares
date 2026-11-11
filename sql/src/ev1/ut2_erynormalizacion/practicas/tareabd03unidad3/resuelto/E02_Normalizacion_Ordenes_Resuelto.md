<!--
OBJETIVO: Solución normalización ordenes hasta 3FN para proyectar en clase.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# E02 — Normalización `ordenes` (RESUELTO)

## Lectura de los datos

Una misma `id_orden` aparece en varias filas (líneas de pedido).  
`estado` toma valores Caracas / Coro / Maracay → en el enunciado actúa como **localidad/estado del cliente**, no como “estado del pedido”.

## Dependencias funcionales

```text
id_orden                 → fecha, id_cliente
id_cliente               → nom_cliente, estado
num_art                  → nom_art, precio
(id_orden, num_art)      → cant
```

(Transitiva de ejemplo: `id_orden → nom_cliente` vía `id_cliente`.)

## 1FN

**Sí está en 1FN:** cada celda es atómica; el grupo repetitivo de artículos ya está “aplanado” en filas.

Clave primaria de la tabla sin normalizar:

```text
PK = (id_orden, num_art)
```

Si alguien hubiera metido varios artículos en una celda, habría que separar filas primero.

## 2FN (eliminar dependencias parciales)

Con PK compuesta `(id_orden, num_art)`:

| DF parcial | Problema |
|------------|----------|
| `id_orden → fecha, id_cliente` | no depende de toda la PK |
| `num_art → nom_art, precio` | no depende de toda la PK |
| `id_cliente → nom_cliente, estado` | (se resuelve al sacar Cliente) |

**Tablas en 2FN:**

```text
CLIENTE  (id_cliente PK, nom_cliente, estado)
ARTICULO (num_art PK, nom_art, precio)
ORDEN    (id_orden PK, fecha, id_cliente FK → CLIENTE)
LINEA    (id_orden FK, num_art FK, cant)
           PK (id_orden, num_art)
```

## 3FN (eliminar transitivas)

En este esquema **ya no quedan** dependencias transitivas entre no-claves:

- `nom_cliente` / `estado` no están en `ORDEN` (solo `id_cliente`).
- En `ARTICULO`, `nom_art` y `precio` dependen solo de `num_art` (clave).

Por tanto **2FN = 3FN** tras esa descomposición.

Si alguien dejara `ORDEN(id_orden, fecha, id_cliente, nom_cliente)` → **viola 3FN** (`id_orden → id_cliente → nom_cliente`).

## Resultado final (3FN) — para la entrega

```text
CLIENTE  (id_cliente PK,
          nom_cliente NN,
          estado NN)

ARTICULO (num_art PK,
          nom_art NN,
          precio NN)

ORDEN    (id_orden PK,
          fecha NN,
          id_cliente NN FK → CLIENTE)

LINEA_ORDEN (id_orden NN FK → ORDEN,
             num_art NN FK → ARTICULO,
             cant NN,
             PRIMARY KEY (id_orden, num_art))
```

### Comprobación con los datos

| id_orden | líneas |
|----------|--------|
| 2301 | Red, Raqueta, Paq-3 |
| 2302 | Paq-6 |
| 2303 | Raqueta, Funda |

Artículo `4011 Raqueta` aparece en 2301 y 2303 con el mismo precio → coherente con `num_art → precio`.
