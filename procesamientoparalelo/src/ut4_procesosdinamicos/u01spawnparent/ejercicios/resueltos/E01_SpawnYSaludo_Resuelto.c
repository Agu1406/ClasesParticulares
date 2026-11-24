/*
E01 — Spawn y saludo (RESUELTO).

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

#define Tag1 1
#define M 3

int main(int argc, char *argv[]) {
    int idProc;
    MPI_Comm parent;
    MPI_Comm intercomm;
    int errcodes[M];
    int dato;
    MPI_Status status;
    int i;

    MPI_Init(&argc, &argv);
    MPI_Comm_get_parent(&parent);

    if (parent == MPI_COMM_NULL) {
        MPI_Comm_spawn(argv[0], MPI_ARGV_NULL, M, MPI_INFO_NULL,
                       0, MPI_COMM_WORLD, &intercomm, errcodes);
        for (i = 0; i < M; i++) {
            dato = 5;
            MPI_Send(&dato, 1, MPI_INT, i, Tag1, intercomm);
        }
        for (i = 0; i < M; i++) {
            MPI_Recv(&dato, 1, MPI_INT, i, Tag1, intercomm, &status);
            printf("Padre: hijo %d -> %d\n", i, dato);
        }
        MPI_Comm_free(&intercomm);
    } else {
        MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
        MPI_Recv(&dato, 1, MPI_INT, 0, Tag1, parent, &status);
        printf("Hijo %d recibio %d\n", idProc, dato);
        dato = idProc * dato;
        MPI_Send(&dato, 1, MPI_INT, 0, Tag1, parent);
    }

    MPI_Finalize();
    return 0;
}
