# PRÁCTICA: Trabajadores

Realizar una aplicación para la gestión de trabajadores. La aplicación podrá registrar trabajadores (asalariados, autónomos y/o jefes). Cada uno de los anteriores tiene las siguientes características:

- Jefes: nombre, apellido, dni, acciones, beneficio, sueldo. Los jefes tendrán la capacidad de despedir un trabajador.
- Asalariados: nombre, apellido, dni, sueldo, número de pagas, contratado (booleano), coutaSS
- Autónomo: nombre, apellido, dni, sueldo, contratado (booleano)

Cada uno de los trabajadores tendrá la capacidad de calcular su salario mensual. Para ello cada uno realizará el calculo de la siguiente forma:

- Asalariados: su salario mensual es su salario (quitándole el 21%) dividido entre el número de pagas
- Autónomos: su salario mensual es su salario total menos la multiplicación de 12 por la couta de la ss, dividido todo entre 12
- Jefe su salario mensual será el salario total entre 12

Adicionalmente existirá una clase Empresa que tendrá una lista de trabajadores, donde se podrán registrar todos los trabajadores de la empresa

- Registrar un trabajador (asalariado, autónomo o jefe)
- Listar trabajadores (asalariados, autónomos o todos)
- Mostrar datos de trabajador por DNI
- Despedir trabajador: pide DNI del jefe y del trabajador a despedir

Formato de salida: cada tipo muestra sus datos específicos y el salario mensual calculado.
