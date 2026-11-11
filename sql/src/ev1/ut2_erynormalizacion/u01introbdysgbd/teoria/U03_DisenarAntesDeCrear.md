<!--
OBJETIVO: Justificar el orden diseno conceptual -> logico -> fisico (SQL).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# Disenar antes de crear

Orden profesional (y de examen DAM/DAW):

1. **Conceptual (E/R):** entidades, atributos, relaciones, cardinalidades.
2. **Logico (relacional):** tablas, claves, normalizacion.
3. **Fisico (SQL/DDL):** `CREATE TABLE`, tipos, indices.

```text
Enunciado del negocio
        |
        v
   Diagrama E/R     <- u02 / u03
        |
        v
  Tablas + claves   <- u03 / u04
        |
        v
  Normalizar 3FN    <- u05
        |
        v
  CREATE TABLE...   <- UT3
```

En UT1 saltamos al SQL de consulta porque practicar SELECT es urgente.
En UT2 aprendes a **no improvisar el esquema**.

## Prueba tu

Sin mirar el script: dibuja mentalmente 3 entidades de una "academia" (alumno, curso, matricula).
