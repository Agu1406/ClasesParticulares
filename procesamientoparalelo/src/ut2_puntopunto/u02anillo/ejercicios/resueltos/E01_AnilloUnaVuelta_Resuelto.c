/*
E01 — Anillo una vuelta (RESUELTO).

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

#define Tag1 1

int main(int argc, char *argv[]) {
    int idProc;
    int size;
    int token;
    int der;
    int izq;
    MPI_Status status;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    der = (idProc + 1) % size;
    izq = (idProc - 1 + size) % size;

    if (idProc == 0) {
        token = 0;
        MPI_Send(&token, 1, MPI_INT, der, Tag1, MPI_COMM_WORLD);
        MPI_Recv(&token, 1, MPI_INT, izq, Tag1, MPI_COMM_WORLD, &status);
        printf("0 token final=%d (esperado %d)\n", token, size);
    } else {
        MPI_Recv(&token, 1, MPI_INT, izq, Tag1, MPI_COMM_WORLD, &status);
        token++;
        printf("%d token=%d\n", idProc, token);
        MPI_Send(&token, 1, MPI_INT, der, Tag1, MPI_COMM_WORLD);
    }

    MPI_Finalize();
    return 0;
}
