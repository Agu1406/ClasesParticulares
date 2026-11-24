/*
E06 — Suma de ranks en el cero (PENDIENTE) — sin Reduce.

Enunciado:
  La suma 0+1+...+(size-1) vale size*(size-1)/2.
  Solo el proceso idProc==0 imprime:
    "Suma de ranks = S (size=N)"
  Los demás no imprimen.
  No uses MPI_Reduce (eso es UT3). Solo la fórmula.

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int idProc;
    int size;
    int suma;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    /* TODO: si idProc==0, calcular suma e imprimir */

    (void)suma;

    MPI_Finalize();
    return 0;
}
