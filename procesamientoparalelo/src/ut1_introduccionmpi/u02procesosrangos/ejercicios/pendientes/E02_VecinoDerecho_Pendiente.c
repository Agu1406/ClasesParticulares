/*
E02 — Calcular vecino derecho (PENDIENTE) — sin mensajes aún.

Enunciado:
  Para cada idProc, calcula el "vecino derecho" en un anillo:
    derecho = (idProc + 1) % size
  Imprime: "idProc=X -> derecho=Y"
  No uses Send/Recv todavía; solo aritmética de rangos.

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int idProc;
    int size;
    int derecho;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    /* TODO: derecho = ... */

    printf("idProc=%d -> derecho=%d\n", idProc, derecho);

    MPI_Finalize();
    return 0;
}
