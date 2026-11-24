/*
U01 — Anillo ascendente (token).

OBJETIVO:
  - Pasar un token: 0 -> 1 -> 2 -> ... -> size-1 -> 0
  - Vecino derecho = (idProc + 1) % size
  - Vecino izquierdo = (idProc - 1 + size) % size
  - Patrón clave en exámenes UNED y práctica ej1.

Compilar:  mpicc -Wall -o U01_AnilloAscendente U01_AnilloAscendente.c
Ejecutar:  mpirun -np 4 ./U01_AnilloAscendente

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
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

    if (idProc == 0) {
        token = 7;
        printf("0 inicia token=%d -> %d\n", token, der);
        MPI_Send(&token, 1, MPI_INT, der, Tag1, MPI_COMM_WORLD);
        MPI_Recv(&token, 1, MPI_INT, izq, Tag1, MPI_COMM_WORLD, &status);
        printf("0 cierra el anillo, token=%d\n", token);
    } else {
        MPI_Recv(&token, 1, MPI_INT, izq, Tag1, MPI_COMM_WORLD, &status);
        token++;
        printf("%d recibe, incrementa a %d, envia a %d\n", idProc, token, der);
        MPI_Send(&token, 1, MPI_INT, der, Tag1, MPI_COMM_WORLD);
    }

    MPI_Finalize();
    return 0;
}
