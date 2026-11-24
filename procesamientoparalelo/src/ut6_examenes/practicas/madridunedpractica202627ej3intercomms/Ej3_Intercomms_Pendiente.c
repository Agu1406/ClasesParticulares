/*
Práctica 2026-27 — EJERCICIO 3 (PENDIENTE) — guía junior.

LEE el Resuelto comentado (Ej3_Intercomms_Resuelto.c): tiene el dibujo de ranks.

ENUNCIADO:
  np=10 (A) spawnean 10 (B). valorAleat en cada B.
  inter1: A bajos + B altos → suma
  inter2: A altos + B bajos → producto
  A0: total = suma+producto; una colectiva al resto.
  Nombres: TagN, commPadres, valorAleat.

CHECKLIST:
  [ ] get_parent → rama A / rama B
  [ ] spawn → commPadres; merge → intracomm 20
  [ ] Group_incl + Comm_create para inter1 e inter2
  [ ] Reduce SUM / PROD
  [ ] A0 junta y Bcast
  [ ] Finalize

mpirun -np 10 ./ej3

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define Tag1 1
#define Tag2 2
#define N 10

int main(int argc, char *argv[]) {
    MPI_Comm parent;
    int valorAleat;
    MPI_Comm commPadres;

    MPI_Init(&argc, &argv);
    MPI_Comm_get_parent(&parent);

    if (parent == MPI_COMM_NULL) {
        /*
        TODO A (padres): size==10, spawn, merge, grupos, Reduce, Bcast
        Ver comentarios largos en el Resuelto.
        */
        (void)commPadres;
        (void)argv;
        printf("TODO ej3 padres — abre Ej3_Intercomms_Resuelto.c\n");
    } else {
        /*
        TODO B (hijos): valorAleat, merge, participar en Reduce/Bcast
        */
        (void)valorAleat;
        printf("TODO ej3 hijos\n");
    }

    MPI_Finalize();
    return 0;
}
