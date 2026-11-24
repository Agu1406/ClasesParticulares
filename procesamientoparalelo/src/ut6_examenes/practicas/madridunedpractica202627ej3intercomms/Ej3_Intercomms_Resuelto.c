/*
Práctica 2026-27 — EJERCICIO 3 (RESUELTO) — comentarios junior.

=============================================================================
¿QUÉ PEDÍA EL ENUNCIADO?
  - 10 procesos ESTÁTICOS = conjunto A  (mpirun -np 10)
  - Esos crean 10 DINÁMICOS = conjunto B  (spawn)
  - Cada proceso de B genera un valorAleat
  - inter1: 5 A de menor rank ↔ 5 B de mayor rank → SUMA de valorAleat de esos B
  - inter2: 5 A de mayor rank ↔ 5 B de menor rank → PRODUCTO de valorAleat de esos B
  - El A de menor rank (A0) hace total = suma + producto y lo reparte a TODOS
    con UNA colectiva (aquí: Bcast tras juntar a los 20 en un solo comunicador)

Nombres UNED: TagN, commPadres, valorAleat.

=============================================================================
TRUCO DIDÁCTICO (para no volvernos locos):
  En vez de colectivas raras sobre intercommunicators "puros", hacemos:

  1) Spawn → commPadres (chat A ↔ B)
  2) MPI_Intercomm_merge → intracomm con 20 procesos:
        ranks 0..9   = A (padres)     A0, A1, ... A9
        ranks 10..19 = B (hijos)      hijo local r → rank 10+r
  3) Creamos subgrupos (Comm_create) que imitan inter1 e inter2
  4) Reduce SUM / PROD dentro de esos subgrupos
  5) A0 Bcast el total a los 20

DIBUJO DE RANGOS EN intracomm:
  A:  0  1  2  3  4  5  6  7  8  9
  B: 10 11 12 13 14 15 16 17 18 19
       ^-----------^  ^-----------^
       B bajos 0..4   B altos 5..9

  inter1 ≈ A0..A4 + B5..B9  → ranks 0,1,2,3,4, 15,16,17,18,19
  inter2 ≈ A5..A9 + B0..B4  → ranks 5,6,7,8,9, 10,11,12,13,14

=============================================================================
  mpicc -Wall -o ej3 Ej3_Intercomms_Resuelto.c && mpirun -np 10 ./ej3

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define Tag1 1
#define N 10

int main(int argc, char *argv[]) {
    int idProc;       /* rank en WORLD local (A entre sí, o B entre sí) */
    int size;
    int idIntra;      /* rank en el intracomm de 20 */
    int sizeIntra;
    MPI_Comm parent;
    MPI_Comm commPadres;  /* intercomm A↔B tras el spawn (nombre UNED) */
    MPI_Comm intracomm;   /* los 20 juntos tras merge */
    MPI_Comm commInter1;  /* subcomunicador "inter1" */
    MPI_Comm commInter2;  /* subcomunicador "inter2" */
    MPI_Group gWorld;
    MPI_Group g1;
    MPI_Group g2;
    int errcodes[N];
    int ranks1[N];    /* lista de ranks del intracomm que forman inter1 */
    int ranks2[N];
    int valorAleat = 1;
    int aporte = 0;   /* lo que yo aporto al Reduce */
    int suma = 0;
    int producto = 1;
    int total = 0;
    int i;
    int n1 = 0;
    int n2 = 0;

    MPI_Init(&argc, &argv);
    MPI_Comm_get_parent(&parent);

    if (parent == MPI_COMM_NULL) {
        /* ---------- Soy de A (estático) ---------- */
        MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
        MPI_Comm_size(MPI_COMM_WORLD, &size);
        if (size != N) {
            if (idProc == 0) {
                fprintf(stderr, "Usa mpirun -np 10\n");
            }
            MPI_Finalize();
            return 1;
        }

        /*
        Spawn colectivo: los 10 de A llaman juntos y crean 10 hijos B.
        commPadres = intercommunicador entre el grupo A y el grupo B.
        */
        MPI_Comm_spawn(argv[0], MPI_ARGV_NULL, N, MPI_INFO_NULL,
                       0, MPI_COMM_WORLD, &commPadres, errcodes);

        /*
        Merge: convierte el intercomm en un intracomm "normal".
        high=0 en padres → los A se quedan con los ranks bajos (0..9).
        */
        MPI_Intercomm_merge(commPadres, 0, &intracomm);

    } else {
        /* ---------- Soy de B (hijo dinámico) ---------- */
        MPI_Comm_rank(MPI_COMM_WORLD, &idProc);
        srand((unsigned)time(NULL) + (unsigned)idProc * 97u);
        valorAleat = 1 + rand() % 9; /* 1..9: evitamos 0 que anula el producto */
        printf("[B hijo %d] valorAleat=%d\n", idProc, valorAleat);

        /* high=1 en hijos → los B quedan en ranks altos (10..19) */
        MPI_Intercomm_merge(parent, 1, &intracomm);
    }

    /* A partir de aquí TODOS (A y B) están en intracomm */
    MPI_Comm_rank(intracomm, &idIntra);
    MPI_Comm_size(intracomm, &sizeIntra);

    /*
    Construyo las listas de ranks para inter1 e inter2
    (ver dibujo del encabezado).
    */
    for (i = 0; i < 5; i++) {
        ranks1[n1++] = i;        /* A bajos 0..4 */
        ranks1[n1++] = 15 + i;   /* B altos: hijo 5..9 → 15..19 */
        ranks2[n2++] = 5 + i;    /* A altos 5..9 */
        ranks2[n2++] = 10 + i;   /* B bajos: hijo 0..4 → 10..14 */
    }

    /*
    Group_incl: "quéate solo con estos ranks".
    Comm_create: crea un comunicador solo para ese grupo.
    Quien NO está en el grupo recibe MPI_COMM_NULL (no participa).
    */
    MPI_Comm_group(intracomm, &gWorld);
    MPI_Group_incl(gWorld, n1, ranks1, &g1);
    MPI_Group_incl(gWorld, n2, ranks2, &g2);
    MPI_Comm_create(intracomm, g1, &commInter1);
    MPI_Comm_create(intracomm, g2, &commInter2);

    /*
    ----- inter1: SUMA de valorAleat de los B altos -----
    Root del Reduce = rank 0 DENTRO de commInter1.
    Como metimos A0 primero en ranks1, A0 (idIntra==0) es ese root.
    Los A aportan 0 (no queremos sumar su basura); los B altos aportan valorAleat.
    */
    if (commInter1 != MPI_COMM_NULL) {
        if (idIntra >= 15) {
            aporte = valorAleat;
        } else {
            aporte = 0;
        }
        MPI_Reduce(&aporte, &suma, 1, MPI_INT, MPI_SUM, 0, commInter1);
        if (idIntra == 0) {
            printf("[A0] suma inter1 (B altos)=%d\n", suma);
        }
        MPI_Comm_free(&commInter1);
    }

    /*
    ----- inter2: PRODUCTO de valorAleat de los B bajos -----
    Root dentro de commInter2 = el primero de ranks2 = A5 (idIntra==5).
    Identidad del producto = 1 (los A aportan 1 para no fastidiar).
    */
    if (commInter2 != MPI_COMM_NULL) {
        if (idIntra >= 10 && idIntra <= 14) {
            aporte = valorAleat;
        } else {
            aporte = 1;
        }
        MPI_Reduce(&aporte, &producto, 1, MPI_INT, MPI_PROD, 0, commInter2);
        if (idIntra == 5) {
            printf("[A5] producto inter2 (B bajos)=%d\n", producto);
            /* A5 se lo manda a A0 para que A0 haga el total */
            MPI_Send(&producto, 1, MPI_INT, 0, Tag1, intracomm);
        }
        MPI_Comm_free(&commInter2);
    }

    if (idIntra == 0) {
        MPI_Status st;
        MPI_Recv(&producto, 1, MPI_INT, 5, Tag1, intracomm, &st);
        total = suma + producto;
        printf("[A0] total = suma + producto = %d\n", total);
    }

    /*
    UNA colectiva a todos los procesos existentes (los 20):
    Bcast del total desde A0.
    */
    MPI_Bcast(&total, 1, MPI_INT, 0, intracomm);
    printf("[rank intra %d] total conocido=%d\n", idIntra, total);

    /* Limpieza */
    MPI_Group_free(&g1);
    MPI_Group_free(&g2);
    MPI_Group_free(&gWorld);
    MPI_Comm_free(&intracomm);
    if (parent == MPI_COMM_NULL) {
        MPI_Comm_free(&commPadres);
    }

    MPI_Finalize();
    return 0;
}
