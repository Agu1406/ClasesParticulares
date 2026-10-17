# EV1 — Mapa para dar clase (C)

Orden oficial: **UT1 → UT2 → UT3 → UT4**. En cada subtema: teoría (`U01_…`) → ejercicios pendientes → práctica interna. Los resueltos se abren **después** de que el alumno lo intente.

Compilar cualquier fichero:

```powershell
gcc -std=c11 -Wall -Wextra -pedantic fichero.c -o prog -lm
.\prog
```

## UT1 — Fundamentos (`ut1_fundamentosc`)

### u01 entorno y compilador

| Teoría | Para qué sirve en clase |
|--------|-------------------------|
| `U01_HolaMundo.c` | Primera proyección. Las cuatro líneas mágicas. |
| `U02_PrintfBasico.c` | `\n` `\t` `%d` `%f` `%s` `%%`. Tabla de precios. |
| `U03_ProcesoDeCompilacion.c` | gcc, `-Wall`, `#define`, tipos de error. |
| `U04_MainYCodigoDeSalida.c` | `return 0`, `argc`/`argv`, stdout vs stderr. |
| `U05_ErroresDeCompilacion.c` | Ritual cuando “no me compila”. |

Práctica: `practicas/ejemplointernoentorno/` (ficha del programador).

### u02 tipos y variables

`U01_VariablesIntro` → `U02_VariablesTipos` (enteros/reales/char/bool/`#define`/casteo) → `U03_OperadoresAritmeticos` → `U04_OperadoresComparativos` → `U05_OperadoresLogicos` → `U06_RepasoCompleto` (igual que C++/C#).

Práctica: `practicas/ejemplointernotiposvariables/`.

### u03 comentarios y entrada

`U01_Comentarios` → `scanf` básico → formatos → validación/buffer → `fgets` + conversión → estilo → `U07_RepasoCompleto` (ticket).

Práctica: `practicas/ejemplointernocomentariosentrada/`.

## UT2 — Control de flujo y funciones (`ut2_controlflujometodos`)

| Subtema | Teoría clave | Práctica |
|---------|--------------|----------|
| u01 operadores | mapa, `++`, precedencia, bits, `math.h` | `ejemplointernooperadoresybasicos` |
| u02 condicionales | `U01_If` → `U02_IfElse` → `U03_Switch` → `U04_Anidados` → `U05_Repaso` (como C++/C#) | `ejemplointernocondicionales` |
| u03 bucles | `U01_For` → `U02_While` → `U03_DoWhile` → `U04_Anidados` (break/centinela en u05repaso) | `ejemplointernobucles` |
| u04 métodos | **funciones** (el nombre de carpeta es por paridad). Prototipos, valor, `static`, recursión, `*` intro, menús | `ejemplointernometodos` |
| u05 repaso | Solo **UT1+UT2**. No es el cierre de EV1. | `ejemplointernorepasoev1` |
| u06 depuración | `assert`, printf-debug, catálogo de bugs, GDB, stderr | `ejemplointernodepuracionaserciones` |

## UT3 — Cadenas (`ut3_strings`, plana)

`U01_CadenasEnC` (`'\0'`) → `string.h` → `ctype.h` → leer → números ↔ texto → buscar/tokenizar → funciones propias → UTF-8 (política ASCII).

- Práctica interna: `practicas/ejemplointernocadenas/`
- Centro: `practicas/madridiescalderonbarcacadenas/` (5 ejercicios)

## UT4 — Tipos compuestos (`ut4_tiposcompuestos`)

`U01_Enum` → `struct` → `typedef`/anidados → struct y funciones → `union` → `sizeof`/alineación → **`U07_CierreEv1`** (ficha de alumno: cierra la evaluación).

Práctica: `practicas/ejemplointernoenumstructtypedef/`.

## Ritmo sugerido (si das 1–2 sesiones por subtema)

1. Primera semana: u01 entorno (U01, U02, U05) + E01–E05 + ficha.
2. Segunda: tipos (U01–U07) + práctica factura.
3. Tercera: `scanf`/`fgets` + ticket.
4. Siguientes: un subtema de UT2 por sesión (teoría 20 min, 2–3 ejercicios, práctica si sobra).
5. Cierre: UT3 informe de frase → UT4 ficha → `U07_CierreEv1`.

## Qué no entra en EV1

Arrays como unidad, punteros avanzados, `malloc`/`free`, ficheros, listas. Eso es EV2.
