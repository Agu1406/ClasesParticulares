/*
E01 — Spawn y saludo (PENDIENTE).

Enunciado:
  mpirun -np 1. El padre spawnea 3 hijos del mismo ejecutable.
  Envía a cada hijo el entero 5. Cada hijo imprime su rank local
  y devuelve rank*5 al padre. El padre imprime los tres valores.

Usa: MPI_Comm_spawn, MPI_Comm_get_parent, Send/Recv en el intercomm.

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

#define Tag1 1
#define M 3

int main(int argc, char *argv[]) {
    int idProc;
    MPI_Comm parent;
    MPI_Comm intercomm;
    int errcodes[M];
    int dato;
    MPI_Status status;
    int i;

    MPI_Init(&argc, &argv);
    MPI_Comm_get_parent(&parent);

    if (parent == MPI_COMM_NULL) {
        /* TODO: spawn M, enviar 5, recibir respuestas */
        (void)intercomm;
        (void)errcodes;
        (void)dato;
        (void)status;
        (void)i;
        (void)argv;
    } else {
        /* TODO: recibir, imprimir rank, devolver rank*dato */
        (void)idProc;
    }

    MPI_Finalize();
    return 0;
}
