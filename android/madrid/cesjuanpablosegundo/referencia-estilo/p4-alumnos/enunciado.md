# PRÁCTICA: Alumnos

Crea una aplicación que permita gestionar el funcionamiento de un centro escolar.

## Alumno

Atributos:

- id: único
- nombre
- apellido
- telefono: opcional (null si no se indica)
- correo: opcional (null si no se indica)
- calificacion: inicial 0
- matriculado: true por defecto

Métodos:

- mostrarDatos: si falta un dato, mostrar “dato no disponible”
- desmatricular: matriculado = false
- calificar: asigna la calificación pasada por parámetro

## Colegio

Gestiona la lista de alumnos. Debe permitir matricular, listar, mostrar por id/dni-equivalente, desmatricular y calificar. Entrada con menú por consola.
