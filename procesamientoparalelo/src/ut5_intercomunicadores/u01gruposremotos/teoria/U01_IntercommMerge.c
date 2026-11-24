/*
U01 — MPI_Intercomm_merge (padre + hijos en un solo intracomm).

OBJETIVO:
  - Tras spawn tienes un intercommunicador (dos grupos).
  - Merge crea un intracomm donde puedes usar Scatter/Gather/Reduce "normales".
  - Muy útil en examen para no pelearte con colectivas en intercomm.

Compilar:  mpicc -Wall -o U01_IntercommMerge U01_IntercommMerge.c
Ejecutar:  mpirun -np 1 ./U01_IntercommMerge

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
*/

#include <mpi.h>
#include <stdio.h>

#define M 3

int main(int argc, char *argv[]) {
    int idProc;
    int sizeIntra;
    MPI_Comm parent;
    MPI_Comm intercomm;
    MPI_Comm intracomm;
    int errcodes[M];
    int valor;
    int suma = 0;

    MPI_Init(&argc, &argv);
    MPI_Comm_get_parent(&parent);

    if (parent == MPI_COMM_NULL) {
        MPI_Comm_spawn(argv[0], MPI_ARGV_NULL, M, MPI_INFO_NULL,
                       0, MPI_COMM_WORLD, &intercomm, errcodes);
        /* high=0: el grupo local (padres) queda con rangos bajos */
        MPI_Intercomm_merge(intercomm, 0, &intracomm);
        MPI_Comm_rank(intracomm, &idProc);
        MPI_Comm_size(intracomm, &sizeIntra);
        printf("Padre: en intracomm soy %d de %d\n", idProc, sizeIntra);

        valor = 0;
        MPI_Reduce(&valor, &suma, 1, MPI_INT, MPI_SUM, 0, intracomm);
        printf("Suma de ranks de hijos (aprox): mira que hijos aportan su rank\n");
        printf("Reduce total=%d\n", suma);

        MPI_Comm_free(&intracomm);
        MPI_Comm_free(&intercomm);
    } else {
        MPI_Intercomm_merge(parent, 1, &intracomm);
        MPI_Comm_rank(intracomm, &idProc);
        valor = idProc;
        MPI_Reduce(&valor, &suma, 1, MPI_INT, MPI_SUM, 0, intracomm);
        MPI_Comm_free(&intracomm);
    }

    MPI_Finalize();
    return 0;
}
