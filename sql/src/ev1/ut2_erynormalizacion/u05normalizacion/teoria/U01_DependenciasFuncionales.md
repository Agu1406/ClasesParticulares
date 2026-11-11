<!--
OBJETIVO: Introducir dependencias funcionales como base de la normalizacion.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# Dependencias funcionales (DF)

`A → B` significa: conocido A, queda determinado B.

Ejemplos:

- `id_producto → nombre, precio` (en Producto bien disenado)
- `dni → nombre` del alumno

Si `curso_id, dni → nota` en matricula, la nota depende de la pareja alumno-curso.

Normalizar = eliminar redundancias molestas siguiendo formas normales apoyadas en DFs.
