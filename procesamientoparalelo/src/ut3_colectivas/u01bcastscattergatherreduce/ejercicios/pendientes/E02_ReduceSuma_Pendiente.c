/*
E02 — Reduce suma (PENDIENTE).

Cada proceso aporta idProc. Reduce con MPI_SUM en root 0 e imprime el total.
Esperado con -np 4: 0+1+2+3 = 6.

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int idProc;
    int local;
    int total = 0;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    local = idProc;

    /* TODO: MPI_Reduce */
    (void)local;
    (void)total;

    MPI_Finalize();
    return 0;
}
