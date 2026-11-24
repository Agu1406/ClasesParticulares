/*
U01 — MPI_Bcast.

OBJETIVO:
  - Un root reparte el mismo dato a TODOS en el comunicador.
  - Todos llaman a Bcast (incluido el root).

Compilar:  mpicc -Wall -o U01_Bcast U01_Bcast.c
Ejecutar:  mpirun -np 4 ./U01_Bcast

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int idProc;
    int dato = -1;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);

    if (idProc == 0) {
        dato = 99;
    }

    /* root=0: el 0 aporta el valor; el resto lo recibe en dato */
    MPI_Bcast(&dato, 1, MPI_INT, 0, MPI_COMM_WORLD);
    printf("%d tiene dato=%d\n", idProc, dato);

    MPI_Finalize();
    return 0;
}
