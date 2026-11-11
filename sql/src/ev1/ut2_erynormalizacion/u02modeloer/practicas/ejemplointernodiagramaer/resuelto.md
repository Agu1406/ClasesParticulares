<!--
OBJETIVO: Solucion E/R academia.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# Resuelto — Academia

## Entidades

- Alumno (dni PK, nombre, email)
- Curso (codigo PK, titulo, horas)
- Profesor (id PK, nombre)
- Matricula puede ser relacion N:M con atributos o entidad asociativa

## Diagrama

```text
[Profesor] 1 ----imparte---- N [Curso]
[Alumno] N ----matricula(fecha,nota)---- M [Curso]
```

Identificadores: dni, codigo, id_profesor.
