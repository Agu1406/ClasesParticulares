/*
Práctica 2026-27 — EJERCICIO 2 (ESQUELETO GUIADO).

Maestro spawnea M hijos (1..100). Genera enteros 0..20 cada 1s hasta 1000
factoriales hechos. Reparto dinámico a hijos libres; colaEspera si no hay libres.
Hijo: factorial y devuelve. RegistroFact {numero, factorial, proceso}.

Tags desde 37: Tag1=37, Tag2=38, ...

Este fichero marca las piezas; completar en clase / siguientes olas.

Autor: Agustin. A. Marquez. Pina
*/

#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
/* sleep(1) entre generacion de numeros: en la VM Linux #include <unistd.h> */

#define Tag1 37
#define Tag2 38
#define Tag3 39
#define MAX_M 100
#define OBJETIVO 1000

typedef struct {
    int numero;
    long long factorial;
    int proceso;
} RegistroFact;

static long long factorial(int n) {
    long long r = 1;
    int i;
    for (i = 2; i <= n; i++) {
        r *= i;
    }
    return r;
}

int main(int argc, char *argv[]) {
    MPI_Comm parent;
    /* TODO:
       - padre: spawn M, arrays libres[], colaEspera[], resultados[OBJETIVO]
       - bucle: generar numero, asignar hijo libre o encolar
       - Iprobe/Recv resultados Tag2
       - hijo: Recv numero, factorial, Send RegistroFact
    */
    MPI_Init(&argc, &argv);
    MPI_Comm_get_parent(&parent);
    if (parent == MPI_COMM_NULL) {
        printf("Ej2 esqueleto: implementar reparto dinamico (ver enunciado PDF)\n");
    }
    (void)factorial;
    MPI_Finalize();
    return 0;
}
