/*
U03 — De codigo fuente a programa: preprocesador, compilador y enlazador.

OBJETIVO:
  - Entender las fases que atraviesa un .c hasta convertirse en ejecutable.
  - Compilar desde terminal con gcc y conocer las opciones -Wall -Wextra -std.
  - Usar el preprocesador: #include, #define y compilacion condicional.
  - Distinguir errores de compilacion, de enlazado y de ejecucion.
  - Usar macros predefinidas (__FILE__, __LINE__, __DATE__, __STDC_VERSION__).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

/*
EL PREPROCESADOR actua ANTES de compilar. Sus lineas empiezan por #.
  #include <x.h>   copia el contenido de la cabecera x.h en este punto.
  #define NOMBRE valor   sustituye NOMBRE por valor (sustitucion de texto).
*/
#define SALUDO "Hola desde el preprocesador"
#define MAX_ALUMNOS 30
#define CUADRADO(x) ((x) * (x))   // macro con parametro: parentesis SIEMPRE

/*
Compilacion condicional: el codigo entre #ifdef y #endif solo se compila
si la macro esta definida. Prueba a compilar con: gcc -DMODO_DEBUG ...
*/
#ifdef MODO_DEBUG
#define TRAZA(texto) printf("[DEBUG] %s\n", texto)
#else
#define TRAZA(texto) ((void)0)
#endif

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Las cuatro fases de la compilacion.
      programa.c --(1 preprocesador)--> programa.i   (expande #include y #define)
                 --(2 compilador)-----> programa.s   (codigo ensamblador)
                 --(3 ensamblador)----> programa.o   (codigo maquina, incompleto)
                 --(4 enlazador)------> programa.exe (une .o con la biblioteca C)
      Con gcc las cuatro fases se lanzan con un solo comando, pero se pueden
      parar en cada una:
        gcc -E programa.c -o programa.i     solo preprocesar
        gcc -S programa.c                   hasta ensamblador
        gcc -c programa.c                   hasta objeto (.o)
        gcc programa.c -o programa          todo el proceso
    */
    printf("--- PRIMERA PARTE: Fases de compilacion ---\n\n");
    printf("1. Preprocesador: expande #include y #define\n");
    printf("2. Compilador:    traduce C a ensamblador\n");
    printf("3. Ensamblador:   genera el fichero objeto (.o)\n");
    printf("4. Enlazador:     une los .o y las bibliotecas -> ejecutable\n");

    /*
    SEGUNDA PARTE - El comando gcc recomendado en clase.
      gcc -std=c11 -Wall -Wextra -pedantic programa.c -o programa -lm
        -std=c11     usa el estandar C11
        -Wall -Wextra   activa casi todos los avisos utiles (SIEMPRE ponerlos)
        -pedantic    avisa de usos que no son C estandar
        -o programa  nombre del ejecutable
        -lm          enlaza la biblioteca matematica (math.h) en Linux/macOS
      Ejecutar: ./programa (Linux/macOS)   .\programa (Windows PowerShell)
    */
    printf("\n--- SEGUNDA PARTE: Comando de compilacion ---\n\n");
    printf("gcc -std=c11 -Wall -Wextra -pedantic programa.c -o programa -lm\n");

    /*
    TERCERA PARTE - #define: constantes y macros.
      OJO: #define NO es una variable. El preprocesador sustituye el texto
      antes de compilar. No lleva ; ni =.
    */
    printf("\n--- TERCERA PARTE: #define ---\n\n");
    printf("%s\n", SALUDO);
    printf("Maximo de alumnos: %d\n", MAX_ALUMNOS);
    printf("CUADRADO(7) = %d\n", CUADRADO(7));
    printf("CUADRADO(2 + 3) = %d (por los parentesis es 25 y no 11)\n", CUADRADO(2 + 3));

    /*
    CUARTA PARTE - Macros predefinidas.
      Las rellena el compilador: son muy utiles para mensajes de error.
    */
    printf("\n--- CUARTA PARTE: Macros predefinidas ---\n\n");
    printf("Fichero: %s\n", __FILE__);
    printf("Linea:   %d\n", __LINE__);
    printf("Fecha de compilacion: %s\n", __DATE__);
    printf("Hora de compilacion:  %s\n", __TIME__);
#ifdef __STDC_VERSION__
    printf("Estandar C (__STDC_VERSION__): %ld\n", (long)__STDC_VERSION__);
    printf("(199901 = C99, 201112 = C11, 201710 = C17)\n");
#endif

    /*
    QUINTA PARTE - Compilacion condicional.
      TRAZA no hace nada salvo que compiles con -DMODO_DEBUG.
    */
    printf("\n--- QUINTA PARTE: Compilacion condicional ---\n\n");
    TRAZA("Este mensaje solo aparece con -DMODO_DEBUG");
    printf("Si compilas con -DMODO_DEBUG veras una linea [DEBUG] justo encima.\n");

    /*
    SEXTA PARTE - Tipos de error segun la fase.
      Error de COMPILACION: falta un ; o un tipo mal escrito (lo ves al compilar).
      Error de ENLAZADO:    "undefined reference to ..." (falta una funcion o -lm).
      Error de EJECUCION:   el programa compila pero falla (division por 0...).
      Error LOGICO:         compila y funciona, pero el resultado es incorrecto.
      Los avisos (warnings) NO impiden compilar, pero casi siempre son un fallo real.
    */
    printf("\n--- SEXTA PARTE: Tipos de error ---\n\n");
    printf("Compilacion -> el compilador te dice linea y motivo\n");
    printf("Enlazado    -> undefined reference to `funcion'\n");
    printf("Ejecucion   -> el programa se cierra o se cuelga\n");
    printf("Logico      -> funciona, pero da un resultado incorrecto\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
