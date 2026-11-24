/*
E05 — Primero y último (PENDIENTE).

Enunciado:
  - Si idProc == 0: imprime "Soy el PRIMERO"
  - Si idProc == size-1: imprime "Soy el ULTIMO"
  - Si eres ambos (np 1): imprime las dos líneas
  - Resto: imprime "Soy intermedio idProc=X"

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int idProc;
    int size;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    /* TODO: condicionales primero / ultimo / intermedio */

    (void)idProc;
    (void)size;

    MPI_Finalize();
    return 0;
}
