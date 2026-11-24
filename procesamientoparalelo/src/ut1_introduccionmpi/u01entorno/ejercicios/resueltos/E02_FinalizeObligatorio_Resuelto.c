/*
E02 — Finalize obligatorio (RESUELTO).

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    MPI_Init(&argc, &argv);
    printf("MPI encendido\n");
    MPI_Finalize();
    printf("MPI apagado\n");
    return 0;
}
