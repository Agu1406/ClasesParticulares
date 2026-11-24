/*
Práctica 2026-27 — EJERCICIO 1 (PENDIENTE) — guía junior.

=============================================================================
LEÉ PRIMERO el Resuelto comentado (Ej1_Anillo_Resuelto.c) si te pierdes.

ENUNCIADO EN CRUDO:
  N procesos estáticos. El 0 hace 10 vueltas de un token en anillo.
  Cada vuelta: sentidoGiro aleatorio (0 ascendente / 1 descendente).
  token = número de vuelta (1..10).
  Variables: idProc, sentidoGiro. Tags: Tag1, Tag2, ...

PASOS QUE DEBES PROGRAMAR:
  1) MPI_Init, rank → idProc, size
  2) for vuelta = 1..10:
       a) el 0 elige sentidoGiro y se lo manda a todos (Tag1)
       b) calculas siguiente/anterior según sentido
       c) el 0 envía el token y al final lo recibe; los demás Recv luego Send (Tag2)
  3) MPI_Finalize

PISTA deadlock: el 0 debe Send el token ANTES de su Recv final.

mpirun -np 4 ./ej1

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

    /* TODO 1: MPI_Init */
    /* TODO 2: Comm_rank / Comm_size → idProc, size */
    /* TODO 3: si idProc==0 → srand */
    /* TODO 4: bucle 10 vueltas (sentido + anillo) */
    /* TODO 5: MPI_Finalize */

    (void)idProc;
    (void)size;
    (void)sentidoGiro;
    (void)token;
    (void)vuelta;
    (void)siguiente;
    (void)anterior;
    (void)i;
    (void)status;
    (void)argc;
    (void)argv;
    return 0;
}
