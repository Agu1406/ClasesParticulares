/*
Práctica 2026-27 — EJERCICIO 2 (PENDIENTE)
Misma carcasa que tu borrador. buscar_hijo_libre ya está; el resto son TODO.

Compilar / ejecutar:
  mpicc -Wall -o ej2 Ej2_Factoriales_Pendiente.c
  mpirun -np 1 ./ej2

Autor: Agustin. A. Marquez. Pina
*/

// Librerias de C/C++.
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Libreria de MPI.
#include <mpi.h>

// Libreria de "sleep" (descomenta cuando uses sleep(1)).
/* #include <unistd.h> */

#define OBJETIVO 1000
#define MAX_HIJOS 100
#define MAX_COLA 2048

/*
Estructura que el maestro usa para guardar cada factorial,
se guarda el número original, su factorial y el proceso (rank)
que hizo el calculo.
*/
typedef struct {
    int numero;
    long long factorial;
    int proceso;
} Resultado;

static long long factorial(int numero) {
    printf("TODO");
    (void)numero;
    return -1;
}

static int buscar_hijo_libre(const int *libre, int numeroHijos) {
    /**
    POSICIONES  => [0][1][2][3][4][5]
    VALORES     => [0][0][0][0][0][0]
    */
    for (int posicion = 0; posicion < numeroHijos; posicion++) {
        if (libre[posicion] == 1) {
            return posicion;
        }
    }

    // Devuelve "-1" que significa "nadie está libre."
    return -1;
}

static void enviar_resultado(const Resultado *reg, MPI_Comm comm, int dest) {
    printf("TODO: MPI_Send");
    (void)reg;
    (void)comm;
    (void)dest;
}

static void recibir_resultado(Resultado *reg, MPI_Comm comm, int source,
                              MPI_Status *status) {
    printf("TODO: MPI_recv");
    (void)reg;
    (void)comm;
    (void)source;
    (void)status;
}

int main(int argc, char *argv[]) {
    int rank, numeroHijos;
    int libre[MAX_HIJOS];
    int resultados = 0;
    int numero, hijo;

    /*
    También necesitarás:
      int cola[MAX_COLA], colaIni, colaFin;
      Resultado historial[OBJETIVO], reg;
      int generados, enVuelo, fin, flag, fuente;
      MPI_Status status;
    */

    MPI_Init(&argc, &argv);

    // Radio para "hablar con mi padre".
    MPI_Comm parentcomm;

    // Radio para "hablar con mis hijos".
    MPI_Comm childcomm;

    MPI_Comm_get_parent(&parentcomm);

    if (parentcomm == MPI_COMM_NULL) {
        /*
        srand => "semilla" que genera números pseudo-aleatorios.

        time(NULL) => segundos desde 1970. Cambia cada segundo,
        así cada ejecución tiene una semilla distinta.

        (unsigned) => cast: srand pide unsigned int.
         */
        srand((unsigned)time(NULL));

        /*
        Rand genera un número aleatorio usando la semilla que hemos definido
        previamente y divide ese número entre 100 guardando solo el resto, el
        resto será un número cualquiera entre "0" y "99", pero necesitamos que
        sea entre "1" y "100", para eso es el "+ 1", para desplazar el rango de
        numeros hacía arriba.
         */
        numeroHijos = (rand() % 100) + 1;

        /*
        MPI_Comm_spawn suele tener los siguientes argumentos:

        argv[0]        => ruta de ESTE ejecutable
        MPI_ARGV_NULL  => Argumentos extra a los hijos.
        numeroHijos    => cuántos hijos.
        MPI_INFO_NULL  => Opciones especiales.
        0              => Raiz del spawn.
        MPI_COMM_WORLD => Grupo desde el que generamos.
        &childcomm     => SALE: radio hacia los hijos.
        */
        MPI_Comm_spawn(argv[0], MPI_ARGV_NULL, numeroHijos, MPI_INFO_NULL,
                       0, MPI_COMM_WORLD, &childcomm, MPI_ERRCODES_IGNORE);

        /*
        Recorro una por una todas las posiciones del array y voy marcando en ella
        que todas están libres (etiqueta/código 1).

        Acabamos de empezar, acabamos de hacer el spawn, nadie esta trabajando, todo
        están libres.

        POSICIONES  => [00][01][02][03][04]... etc
        VALORES     => [ 1][ 1][ 1][ 1][ 1]... etc
        TAMAÑO      => Tiene numeroHijos elementos.
        */
        for (int posicion = 0; posicion < numeroHijos; posicion++) {
            libre[posicion] = 1;
        }

        while (resultados < OBJETIVO) {
            // Elijo un número aleatorio entre cero y veinte.
            numero = rand() % 21;

            /*
            Le damos como contexto la cantidad de hijos que tiene el programa
            para saber el tamaño del array y le damos el propio el array para
            que tenga como y donde buscar.
            */
            hijo = buscar_hijo_libre(libre, numeroHijos);

            /*
            TODO — sigue estos pasos (mira el Resuelto):
              A) Primero Iprobe: ¿alguien terminó? → recibir, marcar libre, vaciar cola
              B) Si hijo >= 0 → Send y marcar ocupado; si no → meter en cola
              C) sleep(1)
              D) Cuando resultados == 1000 → salir y mandar -1 a cada hijo
            */
            (void)numero;
            (void)hijo;
            printf("TODO MAESTRO: completar pasos A–D del while\n");
            break;
        }

        printf("TODO MAESTRO: Send -1 a cada hijo y MPI_Comm_free\n");

    } else {
        printf("TODO: Implementar el/los hijos.\n");
        (void)rank;
    }

    // PARTE 5 - Finalizar el MPI.
    MPI_Finalize();
    return 0;
}
