/*
E01 — Intercomm múltiplos de 3 (RESUELTO).

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

#define M 6
#define Tag1 1

int main(int argc, char *argv[]) {
    int idProc;
    MPI_Comm parent;
    MPI_Comm intercomm;
    MPI_Comm inter3;
    int errcodes[M];
    int ranks[M];
    int n = 0;
    int i;
    int dato;
    MPI_Status status;

    MPI_Init(&argc, &argv);
    MPI_Comm_get_parent(&parent);

    if (parent == MPI_COMM_NULL) {
        MPI_Comm_spawn(argv[0], MPI_ARGV_NULL, M, MPI_INFO_NULL,
                       0, MPI_COMM_WORLD, &intercomm, errcodes);
        for (i = 0; i < M; i++) {
            if (i % 3 == 0) {
                ranks[n++] = i;
            }
        }
        MPI_Intercomm_create(MPI_COMM_WORLD, 0, intercomm, ranks[0], Tag1, &inter3);
        for (i = 0; i < n; i++) {
            dato = i + 1;
            MPI_Send(&dato, 1, MPI_INT, i, Tag1, inter3);
        }
        for (i = 0; i < n; i++) {
            MPI_Recv(&dato, 1, MPI_INT, i, Tag1, inter3, &status);
            printf("Padre: remoto %d -> %d\n", i, dato);
        }
        MPI_Comm_free(&inter3);
        MPI_Comm_free(&intercomm);
    } else {
        MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
        if (idProc % 3 == 0) {
            MPI_Intercomm_create(MPI_COMM_WORLD, 0, parent, 0, Tag1, &inter3);
            MPI_Recv(&dato, 1, MPI_INT, 0, Tag1, inter3, &status);
            dato *= 2;
            MPI_Send(&dato, 1, MPI_INT, 0, Tag1, inter3);
            MPI_Comm_free(&inter3);
        }
    }

    MPI_Finalize();
    return 0;
}
