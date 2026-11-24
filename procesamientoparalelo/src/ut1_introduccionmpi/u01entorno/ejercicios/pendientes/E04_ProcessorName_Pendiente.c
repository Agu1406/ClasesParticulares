/*
E04 — Nombre del procesador (PENDIENTE).

Enunciado:
  Usa MPI_Comm_rank para obtener idProc.
  Usa MPI_Get_processor_name(name, &len) e imprime:
    "idProc=X host=NOMBRE"
  Así ves si varios procesos corren en la misma máquina.

Pista:
  char name[MPI_MAX_PROCESSOR_NAME];
  int len;
  MPI_Get_processor_name(name, &len);

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int idProc;
    char name[MPI_MAX_PROCESSOR_NAME];
    int len;

    MPI_Init(&argc, &argv);

    /* TODO: rank + Get_processor_name + printf */

    (void)idProc;
    (void)name;
    (void)len;

    MPI_Finalize();
    return 0;
}
