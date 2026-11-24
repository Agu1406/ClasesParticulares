/*
E06 — Suma de ranks en el cero (RESUELTO).

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int idProc;
    int size;
    int suma;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    if (idProc == 0) {
        suma = size * (size - 1) / 2;
        printf("Suma de ranks = %d (size=%d)\n", suma, size);
    }

    MPI_Finalize();
    return 0;
}
