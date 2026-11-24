/*
E03 — Versión de MPI (PENDIENTE).

Enunciado:
  Tras MPI_Init, llama a MPI_Get_version(&major, &minor) e imprime:
    "MPI version=X.Y"
  Todos los procesos pueden imprimirlo (verás N líneas con -np N).
  No hace falta rank todavía.

Pista: int major, minor; MPI_Get_version(&major, &minor);

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int major;
    int minor;

    MPI_Init(&argc, &argv);

    /* TODO: MPI_Get_version y printf */

    (void)major;
    (void)minor;

    MPI_Finalize();
    return 0;
}
