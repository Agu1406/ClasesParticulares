/*
Práctica 2026-27 — EJERCICIO 1 (RESUELTO).

mpicc -Wall -o ej1 Ej1_Anillo_Resuelto.c && mpirun -np 4 ./ej1

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define Tag1 1
#define Tag2 2

int main(int argc, char *argv[]) {
    int idProc;
    int size;
    int sentidoGiro;
    int token;
    int vuelta;
    int siguiente;
    int anterior;
    int i;
    MPI_Status status;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    if (idProc == 0) {
        srand((unsigned)time(NULL));
    }

    for (vuelta = 1; vuelta <= 10; vuelta++) {
        if (idProc == 0) {
            sentidoGiro = rand() % 2;
            token = vuelta;
            for (i = 1; i < size; i++) {
                MPI_Send(&sentidoGiro, 1, MPI_INT, i, Tag1, MPI_COMM_WORLD);
            }
        } else {
            MPI_Recv(&sentidoGiro, 1, MPI_INT, 0, Tag1, MPI_COMM_WORLD, &status);
        }

        if (sentidoGiro == 0) {
            siguiente = (idProc + 1) % size;
            anterior = (idProc - 1 + size) % size;
        } else {
            siguiente = (idProc - 1 + size) % size;
            anterior = (idProc + 1) % size;
        }

        if (idProc == 0) {
            printf("Vuelta %d sentidoGiro=%d token=%d\n", vuelta, sentidoGiro, token);
            MPI_Send(&token, 1, MPI_INT, siguiente, Tag2, MPI_COMM_WORLD);
            MPI_Recv(&token, 1, MPI_INT, anterior, Tag2, MPI_COMM_WORLD, &status);
            printf("0 cierra vuelta %d token=%d\n", vuelta, token);
        } else {
            MPI_Recv(&token, 1, MPI_INT, anterior, Tag2, MPI_COMM_WORLD, &status);
            printf("%d ve token=%d (vuelta %d)\n", idProc, token, vuelta);
            MPI_Send(&token, 1, MPI_INT, siguiente, Tag2, MPI_COMM_WORLD);
        }
    }

    MPI_Finalize();
    return 0;
}
