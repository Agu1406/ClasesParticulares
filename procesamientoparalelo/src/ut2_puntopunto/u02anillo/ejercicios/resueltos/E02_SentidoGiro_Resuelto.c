/*
E02 — Una vuelta con sentidoGiro (RESUELTO).

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define Tag1 1

int main(int argc, char *argv[]) {
    int idProc;
    int size;
    int token;
    int sentidoGiro;
    int siguiente;
    int anterior;
    int i;
    MPI_Status status;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    if (idProc == 0) {
        srand((unsigned)time(NULL));
        sentidoGiro = rand() % 2;
        for (i = 1; i < size; i++) {
            MPI_Send(&sentidoGiro, 1, MPI_INT, i, Tag1, MPI_COMM_WORLD);
        }
    } else {
        MPI_Recv(&sentidoGiro, 1, MPI_INT, 0, Tag1, MPI_COMM_WORLD, &status);
    }

    if (sentidoGiro == 0) {
        siguiente = (idProc + 1) % size;
        anterior = (idProc - 1 + size) % size;
    } else {
        siguiente = (idProc - 1 + size) % size;
        anterior = (idProc + 1) % size;
    }

    if (idProc == 0) {
        token = 1;
        printf("sentidoGiro=%d token=%d\n", sentidoGiro, token);
        MPI_Send(&token, 1, MPI_INT, siguiente, Tag1, MPI_COMM_WORLD);
        MPI_Recv(&token, 1, MPI_INT, anterior, Tag1, MPI_COMM_WORLD, &status);
        printf("0 cierra anillo token=%d\n", token);
    } else {
        MPI_Recv(&token, 1, MPI_INT, anterior, Tag1, MPI_COMM_WORLD, &status);
        printf("%d ve token=%d\n", idProc, token);
        MPI_Send(&token, 1, MPI_INT, siguiente, Tag1, MPI_COMM_WORLD);
    }

    MPI_Finalize();
    return 0;
}
