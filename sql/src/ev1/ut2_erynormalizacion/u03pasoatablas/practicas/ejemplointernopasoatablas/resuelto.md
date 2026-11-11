<!--
OBJETIVO: Solucion paso a tablas academia.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# Resuelto

```text
Profesor(id_profesor PK, nombre)
Curso(codigo PK, titulo, horas, id_profesor FK → Profesor)
Alumno(dni PK, nombre, email)
Matricula(dni FK → Alumno, codigo FK → Curso, fecha, nota)
  PK (dni, codigo)
```

id_profesor en **Curso** porque la relacion es 1:N (lado N = Curso).
