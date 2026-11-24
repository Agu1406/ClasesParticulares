/*
E02 — Una vuelta con sentidoGiro (PENDIENTE).

Enunciado (mini práctica ej1):
  El proceso 0 elige sentidoGiro = 0 (ascendente) o 1 (descendente) al azar.
  Hace UNA comunicación en anillo del token=1 en ese sentido.
  Variables: idProc, sentidoGiro. Tag: Tag1.

Pistas:
  Ascendente: der=(id+1)%n  izq=(id-1+n)%n
  Descendente: "siguiente" = izq del ascendente.

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define Tag1 1

int main(int argc, char *argv[]) {
    int idProc;
    int size;
    int token;
    int sentidoGiro;
    int siguiente;
    int anterior;
    MPI_Status status;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    /* TODO: 0 elige sentido, anuncia con Send a todos o Bcast (si ya viste UT3) */
    /* TODO: anillo según sentidoGiro */
    (void)token;
    (void)sentidoGiro;
    (void)siguiente;
    (void)anterior;
    (void)status;
    (void)time;
    (void)srand;
    (void)rand;

    MPI_Finalize();
    return 0;
}
