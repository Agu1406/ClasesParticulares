/*
E05 — Primero y último (RESUELTO).

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int idProc;
    int size;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    if (idProc == 0) {
        printf("Soy el PRIMERO\n");
    }
    if (idProc == size - 1) {
        printf("Soy el ULTIMO\n");
    }
    if (idProc != 0 && idProc != size - 1) {
        printf("Soy intermedio idProc=%d\n", idProc);
    }

    MPI_Finalize();
    return 0;
}
