/*
E01 — El 0 envía su idProc a todos los demás (PENDIENTE).

Enunciado:
  Proceso 0 envía el entero 100 a cada proceso i = 1 .. size-1
  con tag Tag1. Cada receptor imprime lo recibido.
  Usa un bucle for en el 0.

Ejecutar: mpirun -np 4 ./E01_...

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

#define Tag1 1

int main(int argc, char *argv[]) {
    int idProc;
    int size;
    int dato;
    MPI_Status status;
    int i;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    if (idProc == 0) {
        dato = 100;
        /* TODO: for i=1..size-1 Send */
        (void)i;
        (void)dato;
    } else {
        /* TODO: Recv desde 0 */
        (void)status;
        (void)dato;
    }

    MPI_Finalize();
    return 0;
}
