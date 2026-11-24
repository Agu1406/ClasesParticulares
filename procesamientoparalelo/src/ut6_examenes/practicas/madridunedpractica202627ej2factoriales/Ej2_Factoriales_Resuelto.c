/*
Práctica 2026-27 — EJERCICIO 2 (RESUELTO)
Tu estilo + comentarios más junior / lineales.

Compilar / ejecutar (VM Linux/UNED):
  mpicc -Wall -o ej2 Ej2_Factoriales_Resuelto.c
  mpirun -np 1 ./ej2

Autor: Agustin. A. Marquez. Pina
*/

// Librerias de C/C++.
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Libreria de MPI.
#include <mpi.h>

// Libreria de "sleep".
#include <unistd.h>

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

/* Calcula n!  (0! = 1). long long porque 20! es muy grande. */
static long long factorial(int numero) {
    long long r = 1;
    int i;

    if (numero < 0) {
        return 0;
    }
    for (i = 2; i <= numero; i++) {
        r = r * (long long)i;
    }
    return r;
}

static int buscar_hijo_libre(const int *libre, int numeroHijos) {
    /**
    POSICIONES  => [0][1][2][3][4][5]
    VALORES     => [0][0][0][0][0][0]   (ejemplo: todos ocupados)
    Si encuentro un 1 → ese hijo está libre → devuelvo su posición.
    */
    for (int posicion = 0; posicion < numeroHijos; posicion++) {
        if (libre[posicion] == 1) {
            return posicion;
        }
    }

    // Devuelve "-1" que significa "nadie está libre."
    return -1;
}

/* El hijo manda los 3 campos con 3 Send (tag siempre 0). */
static void enviar_resultado(const Resultado *reg, MPI_Comm comm, int dest) {
    MPI_Send(&reg->numero, 1, MPI_INT, dest, 0, comm);
    MPI_Send(&reg->factorial, 1, MPI_LONG_LONG, dest, 0, comm);
    MPI_Send(&reg->proceso, 1, MPI_INT, dest, 0, comm);
}

/*
El maestro recibe esos 3 mensajes.
Si source es ANY_SOURCE, tras el 1.er Recv usamos el hijo concreto.
*/
static void recibir_resultado(Resultado *reg, MPI_Comm comm, int source,
                              MPI_Status *status) {
    MPI_Recv(&reg->numero, 1, MPI_INT, source, 0, comm, status);
    source = status->MPI_SOURCE;
    MPI_Recv(&reg->factorial, 1, MPI_LONG_LONG, source, 0, comm, status);
    MPI_Recv(&reg->proceso, 1, MPI_INT, source, 0, comm, status);
}

int main(int argc, char *argv[]) {
    int rank;                      /* quién soy (hijo) entre hermanos */
    int numeroHijos;               /* cuántos hijos crea el maestro */
    int libre[MAX_HIJOS];          /* 1 = libre, 0 = ocupado */
    int cola[MAX_COLA];            /* números que esperan turno */
    int colaIni = 0;               /* de dónde saco de la cola */
    int colaFin = 0;               /* dónde escribo en la cola */
    Resultado historial[OBJETIVO]; /* los 1000 resultados guardados */
    Resultado reg;                 /* un resultado de paso */
    int resultados = 0;            /* cuántos ya tengo guardados */
    int generados = 0;             /* cuántos números ya saqué del generador */
    int enVuelo = 0;               /* trabajos mandados sin respuesta */
    int numero;                    /* el n de ahora (0..20 o -1 = fin) */
    int hijo;                      /* posición del hijo libre */
    int fin = -1;                  /* señal de “adiós” para los hijos */
    int posicion;
    int flag;                      /* 1 = hay mensaje en el buzón */
    int fuente;                    /* de qué hijo vino el resultado */
    MPI_Status status;

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
        así cada ejecución tiene una semilla distinta y rand()
        no repite siempre la misma secuencia.

        (unsigned) => conversión de tipo (cast): time da time_t
        y srand pide unsigned int. Solo adapta el tipo del argumento.
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

        argv[0]        => ruta de ESTE ejecutable (mismo programa para los hijos)
        MPI_ARGV_NULL  => Argumentos extra a los hijos.
        numeroHijos    => cuántos hijos creo.
        MPI_INFO_NULL  => Opciones especiales.
        0              => Raiz del spawn.
        MPI_COMM_WORLD => Grupo desde el que generamos.
        &childcomm     => SALE: radio hacia los hijos.
        MPI_ERRCODES_IGNORE => no guardo códigos de error por hijo.
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
        for (posicion = 0; posicion < numeroHijos; posicion++) {
            libre[posicion] = 1;
        }

        printf("[MAESTRO] numeroHijos=%d OBJETIVO=%d\n", numeroHijos, OBJETIVO);

        while (resultados < OBJETIVO) {

            /* --- Paso A: ¿alguien terminó? --- */

            /*
            MPI_Iprobe = “¿hay algún mensaje esperando?” SIN quedarme colgado.
              MPI_ANY_SOURCE → da igual de qué hijo
              0              → tag (siempre 0)
              childcomm      → radio con los hijos
              &flag          → SALE 1 si hay mensaje, 0 si no
              &status        → info del mensaje (de quién, etc.) si hay
            */
            MPI_Iprobe(MPI_ANY_SOURCE, 0, childcomm, &flag, &status);

            /* Mientras flag sea 1, hay al menos un resultado pendiente de recoger. */
            while (flag) {

                /* status.MPI_SOURCE = rank del hijo que escribió el mensaje. */
                fuente = status.MPI_SOURCE;

                /* Recojo los 3 campos (numero, factorial, proceso) de ese hijo. */
                recibir_resultado(&reg, childcomm, fuente, &status);

                /* Solo guardo si aún no llegué a 1000 resultados. */
                if (resultados < OBJETIVO) {

                    /* Copio la struct entera al hueco resultados del historial. */
                    historial[resultados] = reg;

                    /* Ahora tengo un resultado más. */
                    resultados++;

                    /* Lo muestro por pantalla (para ver el progreso). */
                    printf("[MAESTRO] #%d: n=%d fact=%lld proc=%d\n",
                           resultados, reg.numero, reg.factorial, reg.proceso);
                }

                /* Ese hijo vuelve a estar libre */
                libre[fuente] = 1;
                enVuelo--;

                /* Si hay números en cola, se lo doy YA a este hijo */
                if (colaIni < colaFin && resultados + enVuelo < OBJETIVO) {
                    numero = cola[colaIni];
                    colaIni++;
                    libre[fuente] = 0;
                    enVuelo++;
                    MPI_Send(&numero, 1, MPI_INT, fuente, 0, childcomm);
                }

                /* ¿Hay más mensajes en el buzón? */
                MPI_Iprobe(MPI_ANY_SOURCE, 0, childcomm, &flag, &status);
            }

            /* --- Paso B: generar un número nuevo (si aún no llegué a 1000 generados) --- */
            if (generados < OBJETIVO) {

                // Elijo un número aleatorio entre cero y veinte.
                numero = rand() % 21;

                /*
                Le damos como contexto la cantidad de hijos que tiene el programa
                para saber el tamaño del array y le damos el propio el array para
                que tenga como y donde buscar.
                */
                hijo = buscar_hijo_libre(libre, numeroHijos);

                if (hijo >= 0) {
                    /* Hay al menos un hijo libre (hijo = su posición en el array). */

                    /* Lo marco ocupado (0) para no mandarle otro número a la vez. */
                    libre[hijo] = 0;

                    /* Sumo 1 a “trabajos enviados que aún no han respondido”. */
                    enVuelo++;

                    /* Cuento este número como ya sacado del generador (va hacia los 1000). */
                    generados++;

                    /*
                    Le mando el número a ese hijo por childcomm.
                      &numero  → qué dato envío
                      1        → un solo int
                      MPI_INT  → tipo
                      hijo     → destino (rank del hijo libre)
                      0        → tag (siempre 0 en este programa)
                      childcomm → radio maestro ↔ hijos
                    */
                    MPI_Send(&numero, 1, MPI_INT, hijo, 0, childcomm);
                } else if ((colaFin - colaIni) < MAX_COLA) {
                    /* Nadie libre → el número espera en la cola */
                    cola[colaFin] = numero;
                    colaFin++;
                    generados++;
                } else {
                    /* Cola llena → espero a que alguien termine (Recv bloqueante) */
                    recibir_resultado(&reg, childcomm, MPI_ANY_SOURCE, &status);
                    fuente = status.MPI_SOURCE;
                    if (resultados < OBJETIVO) {
                        historial[resultados] = reg;
                        resultados++;
                    }
                    libre[fuente] = 1;
                    enVuelo--;
                }

                /* --- Paso C: 1 segundo entre números (lo pide el enunciado) --- */
                sleep(1);

            } else if (enVuelo > 0) {
                /* Ya no genero más; solo recojo lo que falta */
                recibir_resultado(&reg, childcomm, MPI_ANY_SOURCE, &status);
                fuente = status.MPI_SOURCE;
                if (resultados < OBJETIVO) {
                    historial[resultados] = reg;
                    resultados++;
                    printf("[MAESTRO] #%d: n=%d fact=%lld proc=%d\n",
                           resultados, reg.numero, reg.factorial, reg.proceso);
                }
                libre[fuente] = 1;
                enVuelo--;
            }
        }

        /* --- Paso D: ya hay 1000 → mando -1 a cada hijo (señal de fin) --- */
        for (posicion = 0; posicion < numeroHijos; posicion++) {
            MPI_Send(&fin, 1, MPI_INT, posicion, 0, childcomm);
        }

        printf("[MAESTRO] Completados %d factoriales. Listo.\n", resultados);
        MPI_Comm_free(&childcomm);

    } else {
        /* ===================== HIJO ===================== */
        MPI_Comm_rank(MPI_COMM_WORLD, &rank);

        for (;;) {
            /* Espero un número del maestro */
            MPI_Recv(&numero, 1, MPI_INT, 0, 0, parentcomm, &status);

            /* Si es -1 → el maestro dijo fin → salgo */
            if (numero < 0) {
                break;
            }

            /* Calculo y se lo mando de vuelta */
            reg.numero = numero;
            reg.factorial = factorial(numero);
            reg.proceso = rank;
            enviar_resultado(&reg, parentcomm, 0);
        }
    }

    // PARTE 5 - Finalizar el MPI.
    MPI_Finalize();
    return 0;
}
