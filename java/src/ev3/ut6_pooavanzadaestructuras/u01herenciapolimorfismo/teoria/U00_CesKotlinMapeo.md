# U00 — Mapeo CES Kotlin → Java (UT6)

Tabla rápida para portar las unidades del CES Juan Pablo Segundo (Kotlin) a la estructura de este repo en Java.

| CES Kotlin (aula) | En este repo (Java) | Idea |
|-------------------|---------------------|------|
| U1 Variables / visibilidad | `ev1` fundamentos (si aplica) / base Java | `var`→tipo mutable, `val`→`final`, nullability→Optional/`null` |
| U2 Control de flujo | condicionales / bucles Java | `when`→`switch`, rangos→`for` |
| U3 Funciones | métodos estáticos / de instancia | lambdas→`Consumer`/`Function` o for-each |
| U4 Colecciones | `ArrayList`, streams básicos | `arrayListOf`→`new ArrayList<>()` |
| U5 Clases / herencia | **UT6 U01** herencia y polimorfismo | `open` implícito, `abstract`, `override` |

Prácticas CES en esta carpeta:

| Práctica | Carpeta |
|----------|---------|
| P1 Centralita | `practicas/madridcesjuanpablosegundocentralita/` |
| P2 Figuras | `practicas/madridcesjuanpablosegundofiguras/` |
| P3 Trabajadores | `practicas/madridcesjuanpablosegundotrabajadores/` |
| P4 Alumnos | `practicas/madridcesjuanpablosegundoalumnos/` |

Convención: estructura plana, pares `_RESUELTO` / `_SIN_RESOLVER`, enunciado `madrid-cesjuanpablosegundo-*-enunciado.md`.
