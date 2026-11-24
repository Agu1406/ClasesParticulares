/*
E01 — Anillo una vuelta (PENDIENTE).

Enunciado:
  Token empieza en 0 con valor 0. Cada proceso lo recibe, suma 1 e imprime,
  y lo pasa al vecino derecho (idProc+1)%size. El 0 debe recibir el token
  final (debería valer size).

Ejecutar: mpirun -np 4 ./...

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

#define Tag1 1

int main(int argc, char *argv[]) {
    int idProc;
    int size;
    int token;
    int der;
    int izq;
    MPI_Status status;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    der = (idProc + 1) % size;
    izq = (idProc - 1 + size) % size;

    /* TODO: anillo ascendente como en U01_AnilloAscendente */
    (void)token;
    (void)der;
    (void)izq;
    (void)status;

    MPI_Finalize();
    return 0;
}
