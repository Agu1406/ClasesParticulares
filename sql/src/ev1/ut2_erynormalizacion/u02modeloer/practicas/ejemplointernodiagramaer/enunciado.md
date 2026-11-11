<!--
OBJETIVO: Practica: diagrama E/R de una academia.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# Practica interna u02 — Academia

## Enunciado

Una academia quiere gestionar:

- Alumnos (dni, nombre, email).
- Cursos (codigo, titulo, horas).
- Un alumno se matricula en varios cursos y un curso tiene varios alumnos.
- De cada matricula interesa la fecha y la nota final (puede ser NULL si aun no evaluado).
- Cada curso lo imparte **un** profesor (id, nombre). Un profesor puede impartir varios cursos.

## Tareas

1. Lista entidades y atributos.
2. Dibuja el E/R (ASCII o papel) con cardinalidades.
3. Marca identificadores.

## Checklist

- [ ] N:M Alumno-Curso visible
- [ ] 1:N Profesor-Curso
- [ ] Atributos de matricula (fecha, nota)
