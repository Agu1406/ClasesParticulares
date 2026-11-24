/*
E02 — Reduce suma (RESUELTO).

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int idProc;
    int local;
    int total = 0;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    local = idProc;

    MPI_Reduce(&local, &total, 1, MPI_INT, MPI_SUM, 0, MPI_COMM_WORLD);
    if (idProc == 0) {
        printf("total=%d\n", total);
    }

    MPI_Finalize();
    return 0;
}
