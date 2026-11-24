/*
U02 — Compilar y lanzar (recordatorio en código).

OBJETIVO:
  - Recordar mpicc vs gcc (gcc solo NO enlaza MPI).
  - Ver -np: número de procesos estáticos al arrancar.
  - Diferenciar "proceso MPI" de "hilo" o "proceso del SO" en clase.

Compilar:  mpicc -Wall -o U02_CompilarYLanzar U02_CompilarYLanzar.c
Ejecutar:  mpirun -np 2 ./U02_CompilarYLanzar
           mpirun -np 8 ./U02_CompilarYLanzar

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int size;

    MPI_Init(&argc, &argv);

    /*
    MPI_Comm_size pregunta cuántos procesos hay en el comunicador.
    MPI_COMM_WORLD = todos los procesos arrancados con mpirun -np N.
    Esos N son los "procesos estáticos" del enunciado UNED.
    */
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    printf("Procesos estaticos en MPI_COMM_WORLD: %d\n", size);
    printf("(Prueba otra vez con distinto -np)\n");

    MPI_Finalize();
    return 0;
}
