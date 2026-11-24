/*
U02 — MPI_Scatter y MPI_Gather.

OBJETIVO:
  - Scatter: root reparte trozos de un array (1 entero por proceso aquí).
  - Gather: root recoge un valor de cada proceso.

Compilar:  mpicc -Wall -o U02_ScatterGather U02_ScatterGather.c
Ejecutar:  mpirun -np 4 ./U02_ScatterGather

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int idProc;
    int size;
    int sendbuf[8];
    int local;
    int recvbuf[8];
    int i;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    if (idProc == 0) {
        for (i = 0; i < size; i++) {
            sendbuf[i] = (i + 1) * 10;
        }
    }

    MPI_Scatter(sendbuf, 1, MPI_INT, &local, 1, MPI_INT, 0, MPI_COMM_WORLD);
    printf("%d recibio local=%d\n", idProc, local);

    local = local + idProc;
    MPI_Gather(&local, 1, MPI_INT, recvbuf, 1, MPI_INT, 0, MPI_COMM_WORLD);

    if (idProc == 0) {
        printf("Gather en 0: ");
        for (i = 0; i < size; i++) {
            printf("%d ", recvbuf[i]);
        }
        printf("\n");
    }

    MPI_Finalize();
    return 0;
}
