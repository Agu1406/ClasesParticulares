/*
Examen PP sep 2025 — PROBLEMA 1 (PENDIENTE) — 5 puntos

Enunciado (resumen):
  2 procesos estáticos. Cada uno crea dinámicamente un proceso hijo.
  El hijo del estático de mayor rango envía un token aleatorio al otro
  hijo con comunicación punto a punto directa entre ambos.

Diseño sugerido:
  - mpirun -np 2; ambos llaman MPI_Comm_spawn colectivo con maxprocs=2
    (un hijo "por" cada estático) O cada uno spawnea con COMM_SELF.
  - En la solución resuelta: spawn colectivo maxprocs=2 → hijos en WORLD size 2.
  - Hijo rank 1 (asociado al estático mayor) genera token y Send al hijo 0.

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define Tag1 1

int main(int argc, char *argv[]) {
    /* TODO: implementar */
    (void)argc;
    (void)argv;
    return 0;
}
