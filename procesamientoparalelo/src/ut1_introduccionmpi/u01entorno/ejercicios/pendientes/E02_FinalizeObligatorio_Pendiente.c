/*
E02 — Finalize obligatorio (PENDIENTE).

Enunciado:
  El programa ya llama a MPI_Init. Tú debes:
  1) Imprimir "MPI encendido"
  2) Llamar a MPI_Finalize
  3) Imprimir "MPI apagado" DESPUÉS del Finalize

Recuerda: tras Finalize no uses más funciones MPI.

mpicc -Wall -o e02 E02_FinalizeObligatorio_Pendiente.c
mpirun -np 2 ./e02

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    MPI_Init(&argc, &argv);

    /* TODO: printf encendido */
    /* TODO: MPI_Finalize */
    /* TODO: printf apagado */

    return 0;
}
