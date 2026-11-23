# U00 — Mapeo CES Kotlin → Java (UT6)

Tabla rápida para portar las unidades del CES Juan Pablo Segundo (Kotlin) a la estructura de este repo en Java.

| CES Kotlin (aula) | En este repo (Java) | Idea |
|-------------------|---------------------|------|
| U1 Variables / visibilidad | `ev1` fundamentos (si aplica) / base Java | `var`→tipo mutable, `val`→`final`, nullability→Optional/`null` |
| U2 Control de flujo | condicionales / bucles Java | `when`→`switch`, rangos→`for` |
| U3 Funciones | métodos estáticos / de instancia | lambdas→`Consumer`/`Function` o for-each |
| U4 Colecciones | `u05coleccionesestructuras` | `arrayListOf`→`new ArrayList<>()` |
| U5 Clases / herencia | **UT6 u01–u04** (herencia → polimorfismo → abstracción → interfaces) | `open` implícito, `abstract`, `override` |

Prácticas CES (bajo `u02polimorfismo/practicas/`):

| Práctica | Carpeta |
|----------|---------|
| P1 Centralita | `madridcesjuanpablosegundocentralita/` |
| P2 Figuras | `madridcesjuanpablosegundofiguras/` |
| P3 Trabajadores | `madridcesjuanpablosegundotrabajadores/` |
| P4 Alumnos | `madridcesjuanpablosegundoalumnos/` |

Orden de estudio POO avanzada: `u01herencia` → `u02polimorfismo` → `u03abstraccion` → `u04interfaces`.

Convención: estructura plana, pares `_RESUELTO` / `_SIN_RESOLVER`, enunciado `madrid-cesjuanpablosegundo-*-enunciado.md`.
