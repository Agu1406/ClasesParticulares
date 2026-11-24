/*
E01 — Imprimir rango (PENDIENTE).

Enunciado:
  Con mpirun -np 5, cada proceso debe imprimir:
    "idProc=X size=5"
  Usa MPI_Comm_rank y MPI_Comm_size sobre MPI_COMM_WORLD.
  Nombra la variable de rango idProc (convención UNED).

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int idProc;
    int size;

    MPI_Init(&argc, &argv);

    /* TODO: rank y size */

    /* TODO: printf */

    MPI_Finalize();
    return 0;
}
