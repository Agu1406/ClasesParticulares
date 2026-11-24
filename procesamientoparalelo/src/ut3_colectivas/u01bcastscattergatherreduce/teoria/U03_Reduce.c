/*
U03 — MPI_Reduce.

OBJETIVO:
  - Combinar un valor de cada proceso en el root (SUM, MAX, …).
  - Tipico: sumar resultados de hijos / anillo.

Compilar:  mpicc -Wall -o U03_Reduce U03_Reduce.c
Ejecutar:  mpirun -np 4 ./U03_Reduce

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int idProc;
    int local;
    int total = 0;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);

    local = idProc + 1; /* 1,2,3,4,... */
    MPI_Reduce(&local, &total, 1, MPI_INT, MPI_SUM, 0, MPI_COMM_WORLD);

    if (idProc == 0) {
        printf("Suma de (idProc+1) = %d\n", total);
    }

    MPI_Finalize();
    return 0;
}
