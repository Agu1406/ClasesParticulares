/*
Examen PP sep 2026 — PROBLEMA 1 (RESUELTO).

Flujo:
  1) Padre spawnea N_HIJOS.
  2) Padre lee dato (aquí fijado a 10 si no hay stdin interactivo fiable).
  3) Padre Send al hijo rank N-1.
  4) Anillo descendente: N-1 -> N-2 -> ... -> 0; cada uno guarda valor, +1, print.
  5) Hijo 0 Send del valor al padre.
  6) Padre Gather (bucles Recv) de los valores guardados y suma.

mpicc -Wall -o p1 Problema1_Resuelto.c && mpirun -np 1 ./p1

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

#define N_HIJOS 4
#define Tag1 1

int main(int argc, char *argv[]) {
    int idProc;
    int size;
    MPI_Comm parent;
    MPI_Comm intercomm;
    int errcodes[N_HIJOS];
    int dato;
    int guardado;
    int siguiente;
    int i;
    int suma = 0;
    int recibidos[N_HIJOS];
    MPI_Status status;

    MPI_Init(&argc, &argv);
    MPI_Comm_get_parent(&parent);

    if (parent == MPI_COMM_NULL) {
        MPI_Comm_spawn(argv[0], MPI_ARGV_NULL, N_HIJOS, MPI_INFO_NULL,
                       0, MPI_COMM_WORLD, &intercomm, errcodes);

        dato = 10;
        printf("Padre: dato inicial=%d -> hijo %d\n", dato, N_HIJOS - 1);
        MPI_Send(&dato, 1, MPI_INT, N_HIJOS - 1, Tag1, intercomm);

        /* El menor rango (0) devolverá el dato al padre al cerrar el anillo */
        MPI_Recv(&dato, 1, MPI_INT, 0, Tag1, intercomm, &status);
        printf("Padre: recibe del hijo 0 el dato=%d\n", dato);

        for (i = 0; i < N_HIJOS; i++) {
            MPI_Recv(&recibidos[i], 1, MPI_INT, i, Tag1, intercomm, &status);
            suma += recibidos[i];
        }
        printf("Padre: suma colectiva de guardados=%d\n", suma);

        MPI_Comm_free(&intercomm);
    } else {
        MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
        MPI_Comm_size(MPI_COMM_WORLD, &size);

        if (idProc == size - 1) {
            MPI_Recv(&dato, 1, MPI_INT, 0, Tag1, parent, &status);
        } else {
            MPI_Recv(&dato, 1, MPI_INT, idProc + 1, Tag1, MPI_COMM_WORLD, &status);
        }

        guardado = dato;
        printf("Hijo %d recibe %d, guarda, incrementa\n", idProc, dato);
        dato++;

        if (idProc > 0) {
            siguiente = idProc - 1;
            MPI_Send(&dato, 1, MPI_INT, siguiente, Tag1, MPI_COMM_WORLD);
        } else {
            MPI_Send(&dato, 1, MPI_INT, 0, Tag1, parent);
        }

        /* Envío del valor guardado al padre (gather) */
        MPI_Send(&guardado, 1, MPI_INT, 0, Tag1, parent);
    }

    MPI_Finalize();
    return 0;
}
