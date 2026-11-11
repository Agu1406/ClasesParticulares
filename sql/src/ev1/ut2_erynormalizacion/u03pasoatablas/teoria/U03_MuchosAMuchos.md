<!--
OBJETIVO: Crear tabla puente para relaciones N:M.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# Relacion N:M → tabla puente

```text
[Alumno] N ---- M [Curso]
```

```text
Alumno(dni PK, ...)
Curso(codigo PK, ...)
Matricula(dni FK, codigo FK, fecha, nota)
  PK tipica: (dni, codigo)  o un id_matricula surrogate
```

Sin tabla puente no puedes guardar "Ana en SQL" y "Ana en Java" limpiamente.

## Prueba tu

Autor N:M Libro → nombre de la tabla puente y sus FKs.
