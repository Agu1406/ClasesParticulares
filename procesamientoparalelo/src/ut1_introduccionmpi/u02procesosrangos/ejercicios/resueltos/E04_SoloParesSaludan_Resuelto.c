/*
E04 — Solo los pares saludan (RESUELTO).

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int idProc;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);

    if (idProc % 2 == 0) {
        printf("Hola, soy el par idProc=%d\n", idProc);
    }

    MPI_Finalize();
    return 0;
}
