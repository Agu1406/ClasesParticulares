/*
E03 — Vecino izquierdo (RESUELTO).

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int idProc;
    int size;
    int izquierdo;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    izquierdo = (idProc - 1 + size) % size;
    printf("idProc=%d -> izquierdo=%d\n", idProc, izquierdo);

    MPI_Finalize();
    return 0;
}
