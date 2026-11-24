/*
U02 — MPI_Group_incl + MPI_Intercomm_create (idea examen 2026 P2).

OBJETIVO:
  - Partir hijos en subconjuntos (p. ej. pares / múltiplos de 3).
  - Crear un intercommunicador entre el padre y ese subconjunto remoto.
  - Aquí: 1 padre spawnea 6 hijos; crea inter solo con hijos de rank par
    en el WORLD de los hijos.

Compilar:  mpicc -Wall -o U02_GrupoYCreate U02_GrupoYCreate.c
Ejecutar:  mpirun -np 1 ./U02_GrupoYCreate

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
*/

#include <mpi.h>
#include <stdio.h>

#define M 6
#define Tag1 1

int main(int argc, char *argv[]) {
    int idProc;
    int size;
    MPI_Comm parent;
    MPI_Comm intercomm;
    MPI_Comm interPares;
    MPI_Group gWorld;
    MPI_Group gPares;
    MPI_Group gPadre;
    int errcodes[M];
    int ranksPares[M];
    int nPares = 0;
    int i;
    int dato;
    MPI_Status status;

    MPI_Init(&argc, &argv);
    MPI_Comm_get_parent(&parent);

    if (parent == MPI_COMM_NULL) {
        MPI_Comm_spawn(argv[0], MPI_ARGV_NULL, M, MPI_INFO_NULL,
                       0, MPI_COMM_WORLD, &intercomm, errcodes);

        for (i = 0; i < M; i++) {
            if (i % 2 == 0) {
                ranksPares[nPares++] = i;
            }
        }

        /*
        En el intercomm padre↔hijos:
        - Grupo local: padres (rank 0)
        - Grupo remoto: hijos 0..M-1
        Creamos un nuevo intercomm cuyo remoto son solo los pares.
        */
        MPI_Comm_remote_group(intercomm, &gWorld);
        MPI_Group_incl(gWorld, nPares, ranksPares, &gPares);
        MPI_Comm_group(MPI_COMM_WORLD, &gPadre);

        MPI_Intercomm_create(MPI_COMM_WORLD, 0, intercomm, ranksPares[0],
                             Tag1, &interPares);
        /*
        Nota: Intercomm_create requiere que el "peer" en el otro lado
        coincida. Los hijos pares deben llamar la simétrica (ver rama else).
        */

        for (i = 0; i < nPares; i++) {
            dato = 10 * i;
            MPI_Send(&dato, 1, MPI_INT, i, Tag1, interPares);
        }
        for (i = 0; i < nPares; i++) {
            MPI_Recv(&dato, 1, MPI_INT, i, Tag1, interPares, &status);
            printf("Padre recibe de par-remoto %d: %d\n", i, dato);
        }

        MPI_Group_free(&gPares);
        MPI_Group_free(&gWorld);
        MPI_Group_free(&gPadre);
        MPI_Comm_free(&interPares);
        MPI_Comm_free(&intercomm);
    } else {
        MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
        MPI_Comm_size(MPI_COMM_WORLD, &size);

        if (idProc % 2 == 0) {
            /* peer_comm = COMM_WORLD de hijos; local_leader = menor par = 0 */
            MPI_Intercomm_create(MPI_COMM_WORLD, 0, parent, 0, Tag1, &interPares);
            MPI_Comm_rank(interPares, &idProc);
            MPI_Recv(&dato, 1, MPI_INT, 0, Tag1, interPares, &status);
            dato = dato + 1;
            MPI_Send(&dato, 1, MPI_INT, 0, Tag1, interPares);
            MPI_Comm_free(&interPares);
        }
        /* Impares no participan en este intercomm */
    }

    MPI_Finalize();
    return 0;
}
