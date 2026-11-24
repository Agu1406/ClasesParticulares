/*
U02 — Ping-pong entre 0 y 1.

OBJETIVO:
  - Ver ida y vuelta con el mismo tag o tags distintos.
  - Cuidado con deadlocks: no hagas que ambos Recv primero
    sin nadie que Send (aquí 0 envía primero).

Compilar:  mpicc -Wall -o U02_PingPong U02_PingPong.c
Ejecutar:  mpirun -np 2 ./U02_PingPong

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
*/

#include <mpi.h>
#include <stdio.h>

#define Tag1 10
#define Tag2 11

int main(int argc, char *argv[]) {
    int idProc;
    int size;
    int token;
    MPI_Status status;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    if (size < 2) {
        MPI_Finalize();
        return 1;
    }

    if (idProc == 0) {
        token = 1;
        MPI_Send(&token, 1, MPI_INT, 1, Tag1, MPI_COMM_WORLD);
        MPI_Recv(&token, 1, MPI_INT, 1, Tag2, MPI_COMM_WORLD, &status);
        printf("0 recibe de vuelta token=%d\n", token);
    } else if (idProc == 1) {
        MPI_Recv(&token, 1, MPI_INT, 0, Tag1, MPI_COMM_WORLD, &status);
        token++;
        MPI_Send(&token, 1, MPI_INT, 0, Tag2, MPI_COMM_WORLD);
        printf("1 reenvia token=%d\n", token);
    }

    MPI_Finalize();
    return 0;
}
