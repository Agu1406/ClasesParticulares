/*
Examen PP sep 2025 — PROBLEMA 2 (PENDIENTE) — 5 puntos

Enunciado (resumen):
  N procesos estáticos. Cada uno crea M hijos dinámicos, M aleatorio en [1,10).
  Con comunicación colectiva, cada estático envía a cada hijo un array de M
  valores aleatorios en [1,10). Cada hijo multiplica cada elemento por su rango,
  suma el array. El padre obtiene la suma de todos los valores de los hijos
  con colectiva. Todo en un único fichero.

Pistas:
  - Cada estático: spawn con COMM_SELF y su propio M.
  - MPI_Intercomm_merge + Scatter / Reduce, o bucles Send + Reduce.

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(int argc, char *argv[]) {
    /* TODO */
    (void)argc;
    (void)argv;
    return 0;
}
