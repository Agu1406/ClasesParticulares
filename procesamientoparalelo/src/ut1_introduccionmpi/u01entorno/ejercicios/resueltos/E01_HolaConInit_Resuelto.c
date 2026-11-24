/*
E01 — Hola con Init (RESUELTO).

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    MPI_Init(&argc, &argv);
    printf("Proceso MPI listo\n");
    MPI_Finalize();
    return 0;
}
