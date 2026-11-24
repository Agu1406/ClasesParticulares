/*
U02 — Anillo descendente (rangos decrecientes).

OBJETIVO:
  - Orden N-1 -> N-2 -> ... -> 0 (como examen sep 2026 P1).
  - "Derecho" en sentido descendente: (idProc - 1 + size) % size
    si el anillo solo vive entre hijos, cuidado con el módulo del grupo.

Compilar:  mpicc -Wall -o U02_AnilloDescendente U02_AnilloDescendente.c
Ejecutar:  mpirun -np 4 ./U02_AnilloDescendente

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
*/

#include <mpi.h>
#include <stdio.h>

#define Tag1 1

int main(int argc, char *argv[]) {
    int idProc;
    int size;
    int token;
    int siguiente; /* rango menor (descendente) */
    int anterior;  /* rango mayor */
    MPI_Status status;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    /* En anillo descendente: el de mayor rango arranca */
    siguiente = (idProc - 1 + size) % size;
    anterior = (idProc + 1) % size;

    if (idProc == size - 1) {
        token = 0;
        printf("%d (mayor) inicia token=%d -> %d\n", idProc, token, siguiente);
        MPI_Send(&token, 1, MPI_INT, siguiente, Tag1, MPI_COMM_WORLD);
        /* No espera vuelta en este ejemplo corto */
    } else {
        MPI_Recv(&token, 1, MPI_INT, anterior, Tag1, MPI_COMM_WORLD, &status);
        token++;
        printf("%d token=%d", idProc, token);
        if (idProc > 0) {
            printf(" -> %d\n", siguiente);
            MPI_Send(&token, 1, MPI_INT, siguiente, Tag1, MPI_COMM_WORLD);
        } else {
            printf(" (menor rango, fin)\n");
        }
    }

    MPI_Finalize();
    return 0;
}
