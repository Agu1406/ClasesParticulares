/*
E01 — El 0 envía a todos (RESUELTO).

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

#define Tag1 1

int main(int argc, char *argv[]) {
    int idProc;
    int size;
    int dato;
    MPI_Status status;
    int i;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    if (idProc == 0) {
        dato = 100;
        for (i = 1; i < size; i++) {
            MPI_Send(&dato, 1, MPI_INT, i, Tag1, MPI_COMM_WORLD);
        }
        printf("0 envio 100 a %d procesos\n", size - 1);
    } else {
        MPI_Recv(&dato, 1, MPI_INT, 0, Tag1, MPI_COMM_WORLD, &status);
        printf("%d recibio %d\n", idProc, dato);
    }

    MPI_Finalize();
    return 0;
}
