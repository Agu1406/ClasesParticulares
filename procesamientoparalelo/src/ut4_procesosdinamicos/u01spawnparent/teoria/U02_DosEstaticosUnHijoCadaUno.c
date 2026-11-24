/*
U02 — Dos estáticos; cada uno spawnea 1 hijo (estilo examen 2025 P1).

OBJETIVO:
  - Varios padres en MPI_COMM_WORLD.
  - Cada padre hace spawn de 1 hijo.
  - Comunicación P2P entre hijos: hace falta que los padres
    conecten o que un hijo conozca cómo llegar al otro.
  - Versión didáctica: hijo del mayor rango envía token al padre,
    y el diseño completo del examen se ve en UT6.

Aquí: cada padre spawnea 1 hijo y le envía su propio rank estático.

Compilar:  mpicc -Wall -o U02_DosEstaticosUnHijoCadaUno U02_DosEstaticosUnHijoCadaUno.c
Ejecutar:  mpirun -np 2 ./U02_DosEstaticosUnHijoCadaUno

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
*/

#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define Tag1 1

int main(int argc, char *argv[]) {
    int idProc;
    int size;
    MPI_Comm parent;
    MPI_Comm intercomm;
    int errcodes[1];
    int dato;
    MPI_Status status;

    MPI_Init(&argc, &argv);
    MPI_Comm_get_parent(&parent);

    if (parent == MPI_COMM_NULL) {
        MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
        MPI_Comm_size(MPI_COMM_WORLD, &size);

        MPI_Comm_spawn(argv[0], MPI_ARGV_NULL, 1, MPI_INFO_NULL,
                       0, MPI_COMM_SELF, &intercomm, errcodes);
        /*
        Nota: root en COMM_SELF con size 1: cada estático spawnea por su cuenta.
        */

        dato = idProc;
        MPI_Send(&dato, 1, MPI_INT, 0, Tag1, intercomm);
        MPI_Recv(&dato, 1, MPI_INT, 0, Tag1, intercomm, &status);
        printf("Estatico %d: hijo devolvio %d\n", idProc, dato);
        MPI_Comm_free(&intercomm);
    } else {
        MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
        MPI_Recv(&dato, 1, MPI_INT, 0, Tag1, parent, &status);
        printf("Hijo: mi padre estatico tenia rank %d\n", dato);
        dato = dato * 10;
        MPI_Send(&dato, 1, MPI_INT, 0, Tag1, parent);
    }

    MPI_Finalize();
    return 0;
}
