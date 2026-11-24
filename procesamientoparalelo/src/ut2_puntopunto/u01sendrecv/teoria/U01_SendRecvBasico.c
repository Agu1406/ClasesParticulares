/*
U01 — Primer mensaje: Send / Recv (punto a punto).

=============================================================================
MODELO MENTAL (WhatsApp entre procesos):
  - El proceso 0 ENVÍA el número 42 al proceso 1.
  - El proceso 1 lo RECIBE y lo imprime.
  - Los demás ranks (si hubiera) no participan en este ejemplo.

  IMPORTANTE: la variable "dato" del proceso 0 y la del 1 son DISTINTAS.
  Send COPIA el valor hacia el otro proceso. No es memoria compartida.
=============================================================================

Parámetros que hay que memorizar (salen en todos los exámenes):

  MPI_Send(buf, count, datatype, dest, tag, comm);
    buf      = dirección del dato (&dato)
    count    = cuántos elementos (1 entero → 1)
    datatype = MPI_INT, MPI_DOUBLE, ...
    dest     = rank destino (aquí 1)
    tag      = etiqueta int (aquí Tag1); el Recv debe usar el mismo tag
    comm     = comunicador (MPI_COMM_WORLD)

  MPI_Recv(buf, count, datatype, source, tag, comm, &status);
    source   = rank origen (aquí 0), o MPI_ANY_SOURCE
    status   = info de de dónde vino el mensaje

Compilar:  mpicc -Wall -o U01_SendRecvBasico U01_SendRecvBasico.c
Ejecutar:  mpirun -np 2 ./U01_SendRecvBasico
           (NECESITAS al menos 2 procesos)

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
*/

#include <mpi.h>
#include <stdio.h>

/* Tag = "asunto" del mensaje. Convención UNED: Tag1, Tag2, ... */
#define Tag1 1

int main(int argc, char *argv[]) {
    int idProc;
    int size;
    int dato;
    MPI_Status status; /* relleno por Recv: de quién vino, qué tag, etc. */

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    if (size < 2) {
        if (idProc == 0) {
            fprintf(stderr, "Necesitas mpirun -np 2 (o mas)\n");
        }
        MPI_Finalize();
        return 1;
    }

    if (idProc == 0) {
        dato = 42;
        printf("Proceso 0: voy a enviar dato=%d al proceso 1\n", dato);

        /*
        Bloqueante: Send no sigue hasta que el sistema puede reutilizar buf
        con seguridad (detalle fino; en clase: "envía y espera a que salga").
        */
        MPI_Send(&dato, 1, MPI_INT, 1, Tag1, MPI_COMM_WORLD);
        printf("Proceso 0: envio hecho\n");
    } else if (idProc == 1) {
        printf("Proceso 1: esperando recibir...\n");

        /*
        Si nadie envía, este Recv se queda COLGADO para siempre (deadlock).
        Por eso el 0 debe hacer Send y el 1 Recv (o al revés con cuidado).
        */
        MPI_Recv(&dato, 1, MPI_INT, 0, Tag1, MPI_COMM_WORLD, &status);

        printf("Proceso 1: he recibido dato=%d (vino de rank %d, tag %d)\n",
               dato, status.MPI_SOURCE, status.MPI_TAG);
    }
    /* Si hubiera idProc 2, 3... aquí no hacen nada en este ejemplo */

    MPI_Finalize();
    return 0;
}
