/*
Examen PP sep 2026 — PROBLEMA 2 (RESUELTO) — versión reducida N_HIJOS=12
(en examen real: 100). Misma lógica.

mpicc -Wall -o p2 Problema2_Resuelto.c && mpirun -np 1 ./p2

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define N_HIJOS 12
#define Tag1 1

int main(int argc, char *argv[]) {
    int idProc;
    MPI_Comm parent;
    MPI_Comm intercomm;
    MPI_Comm inter2;
    MPI_Comm inter3;
    int errcodes[N_HIJOS];
    int ranks2[N_HIJOS];
    int ranks3[N_HIJOS];
    int n2 = 0;
    int n3 = 0;
    int i;
    int dato;
    int suma2 = 0;
    int suma3 = 0;
    MPI_Status status;

    MPI_Init(&argc, &argv);
    MPI_Comm_get_parent(&parent);

    if (parent == MPI_COMM_NULL) {
        srand((unsigned)time(NULL));
        MPI_Comm_spawn(argv[0], MPI_ARGV_NULL, N_HIJOS, MPI_INFO_NULL,
                       0, MPI_COMM_WORLD, &intercomm, errcodes);

        for (i = 0; i < N_HIJOS; i++) {
            if (i % 2 == 0) {
                ranks2[n2++] = i;
            }
            if (i % 3 == 0) {
                ranks3[n3++] = i;
            }
        }

        MPI_Intercomm_create(MPI_COMM_WORLD, 0, intercomm, ranks2[0], Tag1, &inter2);
        MPI_Intercomm_create(MPI_COMM_WORLD, 0, intercomm, ranks3[0], Tag1 + 1, &inter3);

        for (i = 0; i < n2; i++) {
            dato = 1 + rand() % 50;
            MPI_Send(&dato, 1, MPI_INT, i, Tag1, inter2);
        }
        for (i = 0; i < n2; i++) {
            MPI_Recv(&dato, 1, MPI_INT, i, Tag1, inter2, &status);
            suma2 += dato;
        }

        for (i = 0; i < n3; i++) {
            dato = 1 + rand() % 50;
            MPI_Send(&dato, 1, MPI_INT, i, Tag1, inter3);
        }
        for (i = 0; i < n3; i++) {
            MPI_Recv(&dato, 1, MPI_INT, i, Tag1, inter3, &status);
            suma3 += dato;
        }

        printf("Suma grupo x2=%d | Suma grupo x3=%d\n", suma2, suma3);

        MPI_Comm_free(&inter2);
        MPI_Comm_free(&inter3);
        MPI_Comm_free(&intercomm);
    } else {
        MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
        srand((unsigned)time(NULL) + (unsigned)idProc * 31u);

        if (idProc % 2 == 0) {
            MPI_Intercomm_create(MPI_COMM_WORLD, 0, parent, 0, Tag1, &inter2);
            MPI_Recv(&dato, 1, MPI_INT, 0, Tag1, inter2, &status);
            dato *= (1 + rand() % 5);
            MPI_Send(&dato, 1, MPI_INT, 0, Tag1, inter2);
            MPI_Comm_free(&inter2);
        }
        if (idProc % 3 == 0) {
            MPI_Intercomm_create(MPI_COMM_WORLD, 0, parent, 0, Tag1 + 1, &inter3);
            MPI_Recv(&dato, 1, MPI_INT, 0, Tag1, inter3, &status);
            dato *= (1 + rand() % 5);
            MPI_Send(&dato, 1, MPI_INT, 0, Tag1, inter3);
            MPI_Comm_free(&inter3);
        }
    }

    MPI_Finalize();
    return 0;
}
