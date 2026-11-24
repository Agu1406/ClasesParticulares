/*
Práctica 2026-27 — EJERCICIO 3 (ESQUELETO GUIADO).

10 estáticos (A) spawnean 10 dinámicos (B).
inter1: 5 menores de A ↔ 5 mayores de B (suma colectiva de valorAleat de B).
inter2: 5 mayores de A ↔ 5 menores de B (producto colectiva).
El menor de A suma ambos resultados y hace Bcast a todos los demás.

Variables: TagN, commPadres, valorAleat.

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define Tag1 1

int main(int argc, char *argv[]) {
    MPI_Init(&argc, &argv);
    printf("Ej3 esqueleto: ver PDF practica — implementar inter1/inter2\n");
    /* TODO: size==10, spawn 10, MPI_Intercomm_create, Reduce, Bcast */
    MPI_Finalize();
    (void)argv;
    return 0;
}
