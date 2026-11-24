/*
Examen PP sep 2025 — PROBLEMA 2 (RESUELTO).

Cada estático (COMM_SELF) spawnea M hijos, reparte un array de M enteros
por hijo mediante Send (equivalente a scatter), cada hijo calcula
suma(a[i]*rank), el padre Reduce (suma) de esos resultados.

mpicc -Wall -o p2 Problema2_Resuelto.c && mpirun -np 3 ./p2

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define Tag1 1
#define MAX_M 9

int main(int argc, char *argv[]) {
    int idProc;
    int size;
    MPI_Comm parent;
    MPI_Comm intercomm;
    MPI_Comm intracomm;
    int errcodes[MAX_M];
    int M;
    int i;
    int j;
    int *matriz = NULL; /* M hijos * M valores */
    int local[MAX_M];
    int parcial;
    int totalHijos;
    int cero = 0;
    MPI_Status status;

    MPI_Init(&argc, &argv);
    MPI_Comm_get_parent(&parent);

    if (parent == MPI_COMM_NULL) {
        MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
        MPI_Comm_size(MPI_COMM_WORLD, &size);

        srand((unsigned)time(NULL) + (unsigned)idProc * 17u);
        M = 1 + rand() % 9; /* [1,10) */

        MPI_Comm_spawn(argv[0], MPI_ARGV_NULL, M, MPI_INFO_NULL,
                       0, MPI_COMM_SELF, &intercomm, errcodes);

        matriz = (int *)malloc((size_t)(M * M) * sizeof(int));
        for (i = 0; i < M; i++) {
            for (j = 0; j < M; j++) {
                matriz[i * M + j] = 1 + rand() % 9;
            }
            MPI_Send(&M, 1, MPI_INT, i, Tag1, intercomm);
            MPI_Send(&matriz[i * M], M, MPI_INT, i, Tag1, intercomm);
        }

        /* Recoger suma de cada hijo y sumar (colectiva manual = Reduce) */
        totalHijos = 0;
        for (i = 0; i < M; i++) {
            MPI_Recv(&parcial, 1, MPI_INT, i, Tag1, intercomm, &status);
            totalHijos += parcial;
        }
        printf("Estatico %d: M=%d suma_hijos=%d\n", idProc, M, totalHijos);

        free(matriz);
        MPI_Comm_free(&intercomm);
    } else {
        MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
        MPI_Recv(&M, 1, MPI_INT, 0, Tag1, parent, &status);
        MPI_Recv(local, M, MPI_INT, 0, Tag1, parent, &status);

        parcial = 0;
        for (j = 0; j < M; j++) {
            parcial += local[j] * idProc;
        }
        MPI_Send(&parcial, 1, MPI_INT, 0, Tag1, parent);
        (void)cero;
        (void)intracomm;
    }

    MPI_Finalize();
    return 0;
}
