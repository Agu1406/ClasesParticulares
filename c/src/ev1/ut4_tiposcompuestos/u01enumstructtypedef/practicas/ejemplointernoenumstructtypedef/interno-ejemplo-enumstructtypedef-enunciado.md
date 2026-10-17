# Practica ejemplo: inventario

**Objetivo:** Definir y usar structs y enums, pasar por valor y por puntero, devolver structs.

## Enunciado

Tipos ya declarados: `Estado` (enum: `AGOTADO`, `BAJO`, `NORMAL`) y `Producto` (struct con `nombre`, `stock`, `precio`).

| Funcion | Descripcion |
|---|---|
| `Producto crear_producto(const char *nombre, int stock, double precio)` | Devuelve el producto relleno (copia el nombre con `snprintf`). |
| `Estado estado_stock(const Producto *p)` | `AGOTADO` si 0 o menos, `BAJO` si menos de 5, `NORMAL` en otro caso. |
| `bool vender(Producto *p, int unidades)` | Descuenta unidades; `false` sin cambios si `unidades <= 0` o no hay stock. |
| `void reponer(Producto *p, int unidades)` | Suma unidades (ignora valores `<= 0`). |
| `double valor_inventario(const Producto *p)` | `stock * precio`. |
| `void describir(const Producto *p, char *salida, size_t cap)` | Escribe `nombre (stock) - ESTADO`. |

## Ejemplo de ejecucion

```
Resultado: 9/9 pruebas correctas
```

## Entrega

Entrega `EjemploEnumStructTypedef_SIN_RESOLVER.c` completado.

Compila con `gcc -std=c11 -Wall -Wextra -pedantic fichero.c -o prog -lm` y ejecuta `./prog` (en Windows `prog.exe`).
