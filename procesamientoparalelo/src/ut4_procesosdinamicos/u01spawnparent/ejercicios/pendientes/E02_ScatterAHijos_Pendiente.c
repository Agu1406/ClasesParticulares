/*
E02 — Scatter del padre a hijos (PENDIENTE).

Enunciado:
  Padre (np 1) spawnea M=4 hijos. Tiene un array de 4 enteros {1,2,3,4}.
  Usa MPI_Scatter sobre el intercomunicador... OJO: Scatter en intercomm
  es delicado (grupos local/remoto).

  Versión pedida en clase: el padre hace 4 Send (uno por hijo) con sendbuf[i],
  cada hijo multiplica por su rank y el padre hace Reduce... 
  Alternativa simple aceptada: Gather de los productos con Recv en bucle.

Implementa la versión con bucles Send/Recv (más clara en examen).

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>

#define Tag1 1
#define M 4

int main(int argc, char *argv[]) {
    /* TODO: ver E02 resuelto */
    (void)argc;
    (void)argv;
    return 0;
}
