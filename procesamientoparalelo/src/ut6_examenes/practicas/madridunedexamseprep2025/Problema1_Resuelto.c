/*
Examen PP sep 2025 — PROBLEMA 1 (RESUELTO).

Diseño:
  - 2 estáticos en WORLD llaman spawn colectivo maxprocs=2 del mismo binario.
  - Los 2 hijos forman su propio COMM_WORLD (ranks 0 y 1).
  - El hijo de mayor rank (1) genera token aleatorio y lo envía al hijo 0.
  - Comunicación P2P directa entre hijos (sin pasar por el padre).

mpicc -Wall -o p1 Problema1_Resuelto.c && mpirun -np 2 ./p1

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
    MPI_Comm parent;
    MPI_Comm intercomm;
    int errcodes[2];
    int token;
    MPI_Status status;

    MPI_Init(&argc, &argv);
    MPI_Comm_get_parent(&parent);

    if (parent == MPI_COMM_NULL) {
        /* Procesos estáticos */
        MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
        MPI_Comm_size(MPI_COMM_WORLD, &size);
        if (size != 2) {
            if (idProc == 0) {
                fprintf(stderr, "Usa mpirun -np 2\n");
            }
            MPI_Finalize();
            return 1;
        }

        MPI_Comm_spawn(argv[0], MPI_ARGV_NULL, 2, MPI_INFO_NULL,
                       0, MPI_COMM_WORLD, &intercomm, errcodes);
        printf("Estatico %d: hijos creados\n", idProc);
        MPI_Comm_free(&intercomm);
    } else {
        /* Procesos dinámicos (hijos) */
        MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
        MPI_Comm_size(MPI_COMM_WORLD, &size);

        if (idProc == size - 1) {
            /* Hijo del estático de mayor rango (mapeo rank hijo == rank padre) */
            srand((unsigned)time(NULL) + (unsigned)idProc);
            token = rand() % 1000;
            printf("Hijo %d envia token=%d al hijo 0\n", idProc, token);
            MPI_Send(&token, 1, MPI_INT, 0, Tag1, MPI_COMM_WORLD);
        } else if (idProc == 0) {
            MPI_Recv(&token, 1, MPI_INT, size - 1, Tag1, MPI_COMM_WORLD, &status);
            printf("Hijo 0 recibe token=%d\n", token);
        }
    }

    MPI_Finalize();
    return 0;
}
