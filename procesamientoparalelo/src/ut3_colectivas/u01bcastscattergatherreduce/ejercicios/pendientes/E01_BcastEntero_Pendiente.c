/*
E01 — Bcast de un entero (PENDIENTE).

El proceso 0 lee (o fija) un entero y lo reparte con MPI_Bcast.
Todos imprimen el valor.

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int idProc;
    int dato = 0;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);

    if (idProc == 0) {
        dato = 123;
    }

    /* TODO: MPI_Bcast */
    (void)dato;

    MPI_Finalize();
    return 0;
}
