/*
E02 — Reparto padre→hijos y recogida (RESUELTO).

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

#define Tag1 1
#define M 4

int main(int argc, char *argv[]) {
    int idProc;
    MPI_Comm parent;
    MPI_Comm intercomm;
    int errcodes[M];
    int sendbuf[M] = {1, 2, 3, 4};
    int dato;
    int suma = 0;
    MPI_Status status;
    int i;

    MPI_Init(&argc, &argv);
    MPI_Comm_get_parent(&parent);

    if (parent == MPI_COMM_NULL) {
        MPI_Comm_spawn(argv[0], MPI_ARGV_NULL, M, MPI_INFO_NULL,
                       0, MPI_COMM_WORLD, &intercomm, errcodes);
        for (i = 0; i < M; i++) {
            MPI_Send(&sendbuf[i], 1, MPI_INT, i, Tag1, intercomm);
        }
        for (i = 0; i < M; i++) {
            MPI_Recv(&dato, 1, MPI_INT, i, Tag1, intercomm, &status);
            suma += dato;
            printf("Padre: hijo %d aporto %d\n", i, dato);
        }
        printf("Suma total=%d\n", suma);
        MPI_Comm_free(&intercomm);
    } else {
        MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
        MPI_Recv(&dato, 1, MPI_INT, 0, Tag1, parent, &status);
        dato = dato * idProc; /* rank 0 da 0: en examen a menudo [1,10) */
        MPI_Send(&dato, 1, MPI_INT, 0, Tag1, parent);
    }

    MPI_Finalize();
    return 0;
}
