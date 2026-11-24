/*
U01 — Hola MPI (nivel junior: primera vez con MPI).

=============================================================================
ANTES DE NADA (léelo en voz alta en clase):
  - Esto NO es Java ni un hilo (thread).
  - MPI = varios PROCESOS = varias copias del MISMO programa a la vez.
  - No comparten variables. Cada copia tiene su propia memoria.
  - mpirun -np 4 = "arranca este programa 4 veces en paralelo".
  - Por eso verás "Hola MPI" unas 4 veces (el orden puede salir mezclado).
=============================================================================

OBJETIVO:
  - Ver MPI_Init y MPI_Finalize (el "encendido" y "apagado").
  - Entender que main se ejecuta UNA VEZ POR PROCESO.

Compilar:  mpicc -Wall -o U01_HolaMpi U01_HolaMpi.c
Ejecutar:  mpirun -np 4 ./U01_HolaMpi
           (prueba también -np 2 y -np 1 y compara cuántas líneas salen)

Si no tienes mpicc en Windows: usa la VM UNED del alumno.
Guía humana: procesamientoparalelo/MPI_DESDE_CERO.md

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
*/

#include <mpi.h>   /* Obligatorio: declara MPI_Init, MPI_Finalize, etc. */
#include <stdio.h>

int main(int argc, char *argv[]) {
    /*
    OJO: este printf está ANTES de MPI_Init a propósito, para el experimento.
    En programas "serios" casi todo el trabajo va ENTRE Init y Finalize.
    Con mpirun -np 4, ESTE printf también puede salir 4 veces:
    cada proceso ejecuta main desde el principio.
    */
    printf("\n¡INICIO DEL PROGRAMA! (puede salir varias veces)\n\n");

    /*
    =========================================================================
    PRIMERA PARTE — Encender MPI
    =========================================================================
    Analogía: enchufar la walkie-talkie antes de hablar.

    - MPI_Init DEBE llamarse antes de casi cualquier otra función MPI.
    - Se le pasan &argc y &argv porque algunas implementaciones miran
      argumentos especiales del lanzador. Tú, de momento, solo cópialo.
    - Si olvidas Init, el programa puede petar o comportarse raro.
    */
    printf("--- PRIMERA PARTE: MPI_Init (encender) ---\n");
    MPI_Init(&argc, &argv);

    /*
    =========================================================================
    SEGUNDA PARTE — Código "normal" de C, pero N veces
    =========================================================================
    Aquí aún NO preguntamos "quién soy" (eso es el rank, archivo U02).

    Solo imprimimos. Si lanzaste 4 procesos, esperas ~4 "Hola MPI".
    Si salen desordenados: normal. No hay sincronización todavía.
    */
    printf("--- SEGUNDA PARTE: hola (una linea por proceso) ---\n");
    printf("Hola MPI\n");

    /*
    =========================================================================
    TERCERA PARTE — Apagar MPI
    =========================================================================
    Analogía: apagar la walkie-talkie.

    - MPI_Finalize es lo ÚLTIMO que debes hacer con MPI.
    - Después de Finalize, no llames a Send/Recv/etc.
    - Todos los procesos deben llegar a Finalize (si uno se queda
      en un Recv eterno, el programa no termina: deadlock).
    */
    printf("--- TERCERA PARTE: MPI_Finalize (apagar) ---\n");
    MPI_Finalize();

    printf("\n¡FIN DEL PROGRAMA!\n");
    return 0;
}
