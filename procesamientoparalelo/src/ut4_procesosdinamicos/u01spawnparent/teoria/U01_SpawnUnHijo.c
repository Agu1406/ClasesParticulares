/*
U01 — Crear hijos con MPI_Comm_spawn (nivel junior).

=============================================================================
ESTO ES LO QUE MÁS CUESTA AL PRINCIPIO. Léelo despacio.

1) Arrancas: mpirun -np 1 ./prog
   → Hay 1 proceso ESTÁTICO (el "padre").

2) El padre llama a MPI_Comm_spawn(...):
   → MPI arranca M copias NUEVAS del mismo ejecutable = HIJOS (dinámicos).

3) ¿Cómo sabe cada copia si es padre o hijo?
   MPI_Comm_get_parent(&parent);
   - Si parent == MPI_COMM_NULL  → soy ESTÁTICO / padre (nadie me spawneó)
   - Si parent != MPI_COMM_NULL  → soy HIJO; "parent" es el chat con mi padre

4) Por eso UN SOLO .c tiene un gran if/else:
     if (padre) { ... } else { ... }
   No son dos programas: son dos papeles del mismo binario.

5) intercomm = "teléfono" entre el grupo de padres y el grupo de hijos.
   Para hablar con el hijo 0: Send(..., dest=0, ..., intercomm)
   El hijo recibe con Recv(..., source=0, ..., parent)
=============================================================================

Compilar:  mpicc -Wall -o U01_SpawnUnHijo U01_SpawnUnHijo.c
Ejecutar:  mpirun -np 1 ./U01_SpawnUnHijo

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
*/

#include <mpi.h>
#include <stdio.h>

#define Tag1 1
#define NUM_HIJOS 2

int main(int argc, char *argv[]) {
    int idProc;
    int size;
    MPI_Comm parent;     /* ¿tengo padre? */
    MPI_Comm intercomm;  /* chat padres ↔ hijos (solo lo usa el padre) */
    int errcodes[NUM_HIJOS];
    int token;
    MPI_Status status;
    int i;

    MPI_Init(&argc, &argv);

    /* Pregunta clave de casi todos los exámenes UNED con spawn: */
    MPI_Comm_get_parent(&parent);

    if (parent == MPI_COMM_NULL) {
        /* ================================================================
           PAPEL: PROCESO ESTÁTICO (PADRE)
           ================================================================ */
        MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
        MPI_Comm_size(MPI_COMM_WORLD, &size);
        printf("[PADRE] rank=%d size=%d — voy a crear %d hijos\n",
               idProc, size, NUM_HIJOS);

        /*
        MPI_Comm_spawn(
          command,   // qué programa lanzar: argv[0] = este mismo ejecutable
          argv,      // argumentos para los hijos (MPI_ARGV_NULL = ninguno)
          maxprocs,  // cuántos hijos
          info,      // opciones (MPI_INFO_NULL = por defecto)
          root,      // quién "lidera" el spawn en el grupo local (0)
          comm,      // comunicador de los padres (WORLD si solo hay 1)
          &intercomm,// SALE: comunicador hacia los hijos
          errcodes   // errores por hijo
        );
        */
        MPI_Comm_spawn(argv[0], MPI_ARGV_NULL, NUM_HIJOS, MPI_INFO_NULL,
                       0, MPI_COMM_WORLD, &intercomm, errcodes);

        /*
        En intercomm, los hijos se ven como ranks remotos 0 .. NUM_HIJOS-1.
        Les mando un token distinto a cada uno.
        */
        for (i = 0; i < NUM_HIJOS; i++) {
            token = 100 + i;
            printf("[PADRE] envio %d al hijo remoto %d\n", token, i);
            MPI_Send(&token, 1, MPI_INT, i, Tag1, intercomm);
        }

        for (i = 0; i < NUM_HIJOS; i++) {
            MPI_Recv(&token, 1, MPI_INT, i, Tag1, intercomm, &status);
            printf("[PADRE] hijo %d me devolvio %d\n", i, token);
        }

        MPI_Comm_free(&intercomm);
    } else {
        /* ================================================================
           PAPEL: PROCESO DINÁMICO (HIJO)
           parent = comunicador hacia el padre (rank 0 en el lado del padre)
           MPI_COMM_WORLD aquí = solo entre hermanos hijos
           ================================================================ */
        MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
        MPI_Recv(&token, 1, MPI_INT, 0, Tag1, parent, &status);
        printf("[HIJO localRank=%d] recibi %d del padre\n", idProc, token);
        token *= 2;
        MPI_Send(&token, 1, MPI_INT, 0, Tag1, parent);
        printf("[HIJO localRank=%d] devolvi %d\n", idProc, token);
    }

    MPI_Finalize();
    return 0;
}
