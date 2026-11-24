/*
Examen PP sep 2026 — PROBLEMA 1 (PENDIENTE).

1 proceso estático crea N hijos. El padre lee un entero, lo envía al hijo
de mayor rango. Anillo descendente entre hijos: cada uno +1, imprime,
hasta el de menor rango que lo devuelve al padre. Luego el padre recoge
con colectiva los datos guardados por cada hijo y suma.

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

#define N_HIJOS 4
#define Tag1 1

int main(int argc, char *argv[]) {
    /* TODO */
    (void)argc;
    (void)argv;
    return 0;
}
