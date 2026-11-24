/*
E04 — Nombre del procesador (RESUELTO).

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int idProc;
    char name[MPI_MAX_PROCESSOR_NAME];
    int len;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    MPI_Get_processor_name(name, &len);
    printf("idProc=%d host=%s\n", idProc, name);
    MPI_Finalize();
    return 0;
}
