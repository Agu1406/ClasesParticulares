/*
E03 — Versión de MPI (RESUELTO).

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int major;
    int minor;

    MPI_Init(&argc, &argv);
    MPI_Get_version(&major, &minor);
    printf("MPI version=%d.%d\n", major, minor);
    MPI_Finalize();
    return 0;
}
