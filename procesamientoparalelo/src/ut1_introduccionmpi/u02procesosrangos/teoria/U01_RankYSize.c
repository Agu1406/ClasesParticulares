/*
U01 — Rank (quién soy) y size (cuántos somos).

=============================================================================
MODELO MENTAL:
  mpirun -np 4 ./prog crea 4 procesos.
  MPI les pone un dorsal (rank): 0, 1, 2, 3.
  size = 4.

  En la UNED a menudo llaman al rank: idProc.
  El 0 NO es mágico: solo es un número. Nosotros decidimos
  "el 0 hace de jefe" con un if (idProc == 0).
=============================================================================

OBJETIVO:
  - MPI_Comm_rank → mi número.
  - MPI_Comm_size → cuántos hay en el comunicador.
  - MPI_COMM_WORLD → el grupo de todos los arrancados con mpirun.

Compilar:  mpicc -Wall -o U01_RankYSize U01_RankYSize.c
Ejecutar:  mpirun -np 4 ./U01_RankYSize

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
*/

#include <mpi.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    /* idProc = "dorsal" de ESTE proceso (0 .. size-1) */
    int idProc;
    /* size = cuántos procesos hay en MPI_COMM_WORLD */
    int size;

    MPI_Init(&argc, &argv);

    /*
    MPI_Comm_rank(comunicador, &variable):
      Escribe en idProc el rango de ESTE proceso dentro de ese comunicador.

    MPI_COMM_WORLD:
      Comunicador por defecto = "todos los que lanzó mpirun".
      Más adelante habrá otros comunicadores (padres, hijos, subgrupos).
    */
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    /*
    Cada proceso imprime SU línea. Verás 4 líneas distintas si -np 4.
    Pregunta al alumno: "¿Aparece la misma idProc cuatro veces?" → No.
    */
    printf("Soy el proceso idProc=%d de un total size=%d\n", idProc, size);

    if (idProc == 0) {
        printf("(Solo el 0 dice esto: a veces al 0 lo usamos de coordinador)\n");
    }

    MPI_Finalize();
    return 0;
}
