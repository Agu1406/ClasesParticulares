/*
E03 — Vecino izquierdo (PENDIENTE).

Enunciado:
  izquierdo = (idProc - 1 + size) % size
  Imprime: "idProc=X -> izquierdo=Y"
  Sin Send/Recv: solo aritmética (preparación del anillo).

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int idProc;
    int size;
    int izquierdo;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    /* TODO: izquierdo = ... */

    printf("idProc=%d -> izquierdo=%d\n", idProc, izquierdo);

    MPI_Finalize();
    return 0;
}
