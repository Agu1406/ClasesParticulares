/*
Práctica 2026-27 — EJERCICIO 1 (PENDIENTE).

N procesos estáticos. El proceso 0 realiza 10 comunicaciones en anillo de un
token. Cada vuelta: sentido ascendente o descendente aleatorio (sentidoGiro).
Token = número de comunicación (1..10).

Convenio: #define Tag1, Tag2, ... ; variables idProc, sentidoGiro.

mpirun -np 4 ./Ej1_...

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
    /* TODO */
    (void)idProc;
    (void)size;
    (void)sentidoGiro;
    (void)token;
    (void)vuelta;
    (void)argc;
    (void)argv;
    return 0;
}
