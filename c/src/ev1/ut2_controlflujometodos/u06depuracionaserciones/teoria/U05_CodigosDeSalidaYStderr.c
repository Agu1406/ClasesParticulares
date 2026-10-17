/*
U05 - Codigos de salida, exit() y manejo de errores.

OBJETIVO:
  - Entender el valor que devuelve main (codigo de salida del proceso).
  - Usar EXIT_SUCCESS / EXIT_FAILURE y la funcion exit().
  - Informar de errores por stderr y terminar con un codigo distinto de 0.
  - Aplicar el patron "validar, avisar y salir".

COMO VER EL CODIGO DE SALIDA:
  Windows (PowerShell):  .\prog ; echo $LASTEXITCODE
  Linux / macOS:         ./prog ; echo $?

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

enum { OK = 0, ERR_ENTRADA = 2, ERR_RANGO = 3 };

static int leer_porcentaje(const char *texto, int *valor);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Que significa el codigo de salida.
      0 (EXIT_SUCCESS)  todo fue bien.
      distinto de 0 (EXIT_FAILURE = 1, u otros): hubo un error.
      Scripts, makefiles y pruebas automaticas usan este numero.
    */
    printf("--- PRIMERA PARTE: EXIT_SUCCESS / EXIT_FAILURE ---\n\n");

    printf("EXIT_SUCCESS = %d\n", EXIT_SUCCESS);
    printf("EXIT_FAILURE = %d\n", EXIT_FAILURE);

    /*
    SEGUNDA PARTE - return en main frente a exit().
      return n; en main equivale a exit(n);
      exit(n) puede llamarse desde CUALQUIER funcion y termina el programa
      al instante (vaciando buffers).
    */
    printf("\n--- SEGUNDA PARTE: return o exit ---\n\n");

    printf("return en main == exit en cualquier funcion\n");

    /*
    TERCERA PARTE - Codigos propios.
      Un enum da nombre a cada tipo de error: mas legible que numeros sueltos.
    */
    printf("\n--- TERCERA PARTE: Codigos propios ---\n\n");

    int valor = 0;
    const char *entradas[] = {"85", "abc", "150"};
    for (int i = 0; i < 3; i++) {
        int codigo = leer_porcentaje(entradas[i], &valor);
        if (codigo == OK) {
            printf("\"%s\" -> valido: %d%%\n", entradas[i], valor);
        } else {
            printf("\"%s\" -> codigo de error %d\n", entradas[i], codigo);
        }
    }

    /*
    CUARTA PARTE - Mensajes de error en stderr.
      Los errores NO van con printf (stdout) sino con fprintf(stderr, ...).
      Asi se pueden redirigir por separado.
    */
    printf("\n--- CUARTA PARTE: stderr ---\n\n");

    fprintf(stderr, "Error: ejemplo de mensaje de error\n");
    printf("La salida normal sigue por stdout\n");

    /*
    QUINTA PARTE - Patron "validar, avisar y salir".
      Si algo imprescindible falla, no sigas: avisa y devuelve un codigo != 0.
    */
    printf("\n--- QUINTA PARTE: Validar y salir ---\n\n");

    bool entrada_correcta = true;
    if (!entrada_correcta) {
        fprintf(stderr, "Error: entrada no valida\n");
        return EXIT_FAILURE;
    }
    printf("Entrada correcta: el programa continua\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return EXIT_SUCCESS;
}

static int leer_porcentaje(const char *texto, int *valor) {
    char *fin = NULL;
    long v = strtol(texto, &fin, 10);
    if (fin == texto || *fin != '\0') {
        return ERR_ENTRADA;           // no es un numero
    }
    if (v < 0 || v > 100) {
        return ERR_RANGO;             // fuera de 0..100
    }
    *valor = (int)v;
    return OK;
}
