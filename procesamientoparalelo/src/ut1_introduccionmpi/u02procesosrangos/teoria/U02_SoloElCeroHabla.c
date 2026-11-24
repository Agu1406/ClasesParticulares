/*
U02 — Condicionar por rango.

OBJETIVO:
  - Usar if (idProc == 0) para trabajo del maestro.
  - Evitar que todos los procesos lean de teclado a la vez.

Compilar:  mpicc -Wall -o U02_SoloElCeroHabla U02_SoloElCeroHabla.c
Ejecutar:  mpirun -np 3 ./U02_SoloElCeroHabla

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    int idProc;
    int size;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    if (idProc == 0) {
        printf("Maestro: hay %d procesos estaticos\n", size);
    } else {
        printf("Esclavo %d: esperando ordenes...\n", idProc);
    }

    MPI_Finalize();
    return 0;
}
