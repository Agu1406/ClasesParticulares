/*
E01 — Bcast (RESUELTO).

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

    MPI_Bcast(&dato, 1, MPI_INT, 0, MPI_COMM_WORLD);
    printf("%d dato=%d\n", idProc, dato);

    MPI_Finalize();
    return 0;
}
