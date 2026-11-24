/*
Práctica 2026-27 — EJERCICIO 1 (RESUELTO) — comentarios junior.

=============================================================================
¿QUÉ PEDÍA EL ENUNCIADO?
  - N procesos ESTÁTICOS (los de mpirun -np N). Aquí no hay spawn.
  - El proceso 0 hace 10 "vueltas" de un TOKEN por un ANILLO.
  - Cada vuelta el 0 elige sentidoGiro al azar:
      0 = ascendente (0→1→2→…→N-1→0)
      1 = descendente (0→N-1→…→1→0)
  - El valor del token es el número de vuelta (1..10).
  - Nombres UNED: idProc, sentidoGiro, Tag1, Tag2, ...

=============================================================================
¿QUÉ ES UN ANILLO?
  Imagina los procesos en círculo. Cada uno tiene:
    - "siguiente": a quién le paso el token
    - "anterior": de quién lo recibo
  Con % size el círculo se cierra (el último vuelve al 0).

=============================================================================
Compilar / ejecutar (VM UNED):
  mpicc -Wall -o ej1 Ej1_Anillo_Resuelto.c
  mpirun -np 4 ./ej1

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/* Etiquetas de mensaje: sirven para no mezclar "sentido" con "token". */
#define Tag1 1   /* mensaje: sentidoGiro (solo lo manda el 0 al resto) */
#define Tag2 2   /* mensaje: token del anillo */

int main(int argc, char *argv[]) {
    int idProc;       /* mi rango 0..size-1 (nombre UNED) */
    int size;         /* cuántos procesos estáticos hay */
    int sentidoGiro;  /* 0 ascendente, 1 descendente */
    int token;        /* valor que circula (1..10) */
    int vuelta;       /* número de comunicación 1..10 */
    int siguiente;    /* a quién envío el token */
    int anterior;     /* de quién recibo el token */
    int i;
    MPI_Status status; /* relleno por Recv: de quién vino el mensaje */

    /* 1) Encender MPI — obligatorio al principio */
    MPI_Init(&argc, &argv);

    /* 2) ¿Quién soy y cuántos somos? */
    MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    /*
    Solo el 0 inicializa la semilla aleatoria.
    (Si todos hicieran srand(time), podrían sacar el mismo segundo.)
    */
    if (idProc == 0) {
        srand((unsigned)time(NULL));
    }

    /* ========== 10 VUELTAS DEL ANILLO ========== */
    for (vuelta = 1; vuelta <= 10; vuelta++) {

        /*
        PASO A — Todo el mundo debe conocer sentidoGiro de ESTA vuelta.
        El 0 lo decide y se lo cuenta a los demás con Send.
        (También se podría usar MPI_Bcast; Send en bucle es más "manual".)
        */
        if (idProc == 0) {
            sentidoGiro = rand() % 2; /* 0 o 1 */
            token = vuelta;           /* el token VALE el nº de vuelta */
            for (i = 1; i < size; i++) {
                MPI_Send(&sentidoGiro, 1, MPI_INT, i, Tag1, MPI_COMM_WORLD);
            }
        } else {
            /* Los que no son 0: esperan el sentido desde el 0 */
            MPI_Recv(&sentidoGiro, 1, MPI_INT, 0, Tag1, MPI_COMM_WORLD, &status);
        }

        /*
        PASO B — Calcular vecinos según el sentido.
        Ascendente: siguiente = id+1, anterior = id-1  (con wrap % size)
        Descendente: al revés
        El +size antes del % evita números negativos en C.
        */
        if (sentidoGiro == 0) {
            siguiente = (idProc + 1) % size;
            anterior = (idProc - 1 + size) % size;
        } else {
            siguiente = (idProc - 1 + size) % size;
            anterior = (idProc + 1) % size;
        }

        /*
        PASO C — Hacer circular el token UNA vez.
        El 0 LO ARRANCA (Send primero) y LO CIERRA (Recv del anterior).
        Los demás: primero Recv (del anterior), luego Send (al siguiente).

        ORDEN IMPORTANTE:
          Si todos hicieran Recv primero, incluido el 0, se COLGARÍAN
          (nadie habría enviado aún) → deadlock.
        */
        if (idProc == 0) {
            printf("Vuelta %d sentidoGiro=%d token=%d\n", vuelta, sentidoGiro, token);
            MPI_Send(&token, 1, MPI_INT, siguiente, Tag2, MPI_COMM_WORLD);
            MPI_Recv(&token, 1, MPI_INT, anterior, Tag2, MPI_COMM_WORLD, &status);
            printf("0 cierra vuelta %d token=%d\n", vuelta, token);
        } else {
            MPI_Recv(&token, 1, MPI_INT, anterior, Tag2, MPI_COMM_WORLD, &status);
            printf("%d ve token=%d (vuelta %d)\n", idProc, token, vuelta);
            MPI_Send(&token, 1, MPI_INT, siguiente, Tag2, MPI_COMM_WORLD);
        }
    }

    /* 3) Apagar MPI */
    MPI_Finalize();
    return 0;
}
