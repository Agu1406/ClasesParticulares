/*
U04 — Estructura del programa: main, return y argumentos de linea de comandos.

OBJETIVO:
  - Conocer las dos firmas habituales de main: main(void) y main(argc, argv).
  - Entender que el valor devuelto por main es el codigo de salida (0 = exito).
  - Leer el primer argumento de la linea de comandos (argv[1]) si existe.
  - Escribir avisos en stderr y conocer exit(EXIT_FAILURE).
  - Ordenar un programa: includes, defines, prototipos, main, funciones.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>   // printf, fprintf
#include <stdlib.h>  // EXIT_SUCCESS, EXIT_FAILURE, exit

/*
ORDEN HABITUAL DE UN FICHERO .c
  1. Comentario de cabecera (objetivo, autor)
  2. #include
  3. #define y constantes
  4. Prototipos de funciones (se veran en la unidad de funciones)
  5. int main(...)
  6. Definicion del resto de funciones
*/

/*
main puede escribirse de dos formas validas:
  int main(void)                    -> el programa NO recibe argumentos
  int main(int argc, char *argv[])  -> recibe los argumentos de la terminal
    argc = argument count  (cuantos hay, contando el nombre del programa)
    argv = argument vector (la lista de textos; argv[0] es el nombre del .exe)
*/
int main(int argc, char *argv[]) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - argc y argv[0].
      Siempre hay al menos 1 argumento: el nombre del programa.
      Prueba a ejecutarlo asi (cuando sepas el nombre del .exe):
        U04_MainYCodigoDeSalida Lucia
      Lucia seria argv[1].
    */
    printf("--- PRIMERA PARTE: argc y argv[0] ---\n\n");

    printf("argc = %d  (cuantos textos recibio el programa)\n", argc);
    printf("argv[0] = \"%s\"  (nombre del programa)\n", argv[0]);

    /*
    SEGUNDA PARTE - Un argumento opcional.
      Este if es un ADELANTO: lo estudiaremos en UT2. Aqui solo pregunta
      "hay un texto detras del nombre del programa?".
      NUNCA leas argv[1] sin comprobar argc: si no existe, el programa falla.
    */
    printf("\n--- SEGUNDA PARTE: Argumento opcional ---\n\n");

    if (argc > 1) {
        printf("Hola, %s\n", argv[1]);
    } else {
        printf("No has pasado ningun nombre. Ejecuta: programa Lucia\n");
    }

    if (argc > 2) {
        printf("Tambien recibiste un segundo dato: %s\n", argv[2]);
    }

    /*
    TERCERA PARTE - El codigo de salida.
      return 0 al final de main indica al sistema operativo que todo fue bien.
      Cualquier otro valor indica un error. En <stdlib.h> existen dos constantes:
        EXIT_SUCCESS (0)    EXIT_FAILURE (1)
      Se puede consultar despues de ejecutar:
        PowerShell:  echo $LASTEXITCODE        Linux/macOS: echo $?
    */
    printf("\n--- TERCERA PARTE: Codigo de salida ---\n\n");

    printf("EXIT_SUCCESS vale %d y EXIT_FAILURE vale %d\n", EXIT_SUCCESS, EXIT_FAILURE);

    /*
    CUARTA PARTE - stdout y stderr.
      printf escribe en la salida estandar (stdout).
      Los mensajes de ERROR deben ir a la salida de error (stderr) con fprintf,
      asi se pueden separar de la salida normal al redirigir:
        programa > salida.txt     (stderr sigue viendose en pantalla)
    */
    printf("\n--- CUARTA PARTE: stdout y stderr ---\n\n");

    printf("Este mensaje va a stdout\n");
    fprintf(stderr, "Este mensaje va a stderr (aviso de ejemplo)\n");

    /*
    QUINTA PARTE - exit() termina el programa desde cualquier funcion.
      return en main y exit(0) son equivalentes cuando se esta en main.
      Aqui solo mostramos la condicion; no la ejecutamos para poder seguir.
    */
    printf("\n--- QUINTA PARTE: exit ---\n\n");

    int configuracion_valida = 1;
    if (!configuracion_valida) {
        fprintf(stderr, "Error: configuracion no valida\n");
        exit(EXIT_FAILURE);  // termina aqui con codigo 1
    }
    printf("La configuracion es valida: el programa continua.\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return EXIT_SUCCESS;
}
