/*
E04 — Solo los pares saludan (PENDIENTE).

Enunciado:
  Si idProc es par (idProc % 2 == 0), imprime:
    "Hola, soy el par idProc=X"
  Si es impar, no imprime nada (o imprime en silencio: mejor nada).

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int idProc;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);

    /* TODO: if (idProc % 2 == 0) ... */

    (void)idProc;

    MPI_Finalize();
    return 0;
}
