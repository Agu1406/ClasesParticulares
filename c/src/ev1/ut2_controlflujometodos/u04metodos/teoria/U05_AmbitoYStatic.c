/*
U05 - Ambito de las variables: locales, globales y static.

OBJETIVO:
  - Distinguir variables locales, parametros y variables globales.
  - Entender el tiempo de vida (cuando existe) y el ambito (donde se ve) de una variable.
  - Usar static dentro de una funcion para que recuerde su valor entre llamadas.
  - Usar static en una funcion o global para limitar su visibilidad al fichero.
  - Saber por que se debe evitar abusar de las variables globales.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

/*
VARIABLE GLOBAL: se declara fuera de cualquier funcion.
  - Se ve desde todas las funciones del fichero (de abajo de su declaracion).
  - Existe durante toda la ejecucion.
  - Se inicializa a 0 si no se pone valor (las locales NO).
  - Abusar de ellas hace el programa dificil de entender: preferir parametros y return.
*/
int llamadas_totales = 0;

/* static en un global: solo visible en ESTE fichero (aislamiento). */
static const int MAX_VIDAS = 3;

void funcion_local(void);
int contador_normal(void);
int contador_con_memoria(void);
void usar_global(void);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Variables locales.
      Nacen al entrar en la funcion y MUEREN al salir. Cada llamada crea
      variables nuevas. Dos funciones pueden tener variables con el mismo
      nombre sin que se mezclen.
    */
    printf("--- PRIMERA PARTE: Locales ---\n\n");

    int x = 10;
    printf("En main: x = %d\n", x);
    funcion_local();
    printf("En main otra vez: x = %d (la x de la funcion era otra)\n", x);

    /*
    SEGUNDA PARTE - Una local normal no recuerda nada.
      contador_normal() crea la variable a 0 en cada llamada.
    */
    printf("\n--- SEGUNDA PARTE: Local sin memoria ---\n\n");

    printf("contador_normal() -> %d\n", contador_normal());
    printf("contador_normal() -> %d\n", contador_normal());
    printf("contador_normal() -> %d\n", contador_normal());

    /*
    TERCERA PARTE - static local: la variable recuerda su valor.
      Se inicializa UNA sola vez (al arrancar el programa) y conserva el
      valor entre llamadas, pero solo se ve dentro de su funcion.
    */
    printf("\n--- TERCERA PARTE: static local ---\n\n");

    printf("contador_con_memoria() -> %d\n", contador_con_memoria());
    printf("contador_con_memoria() -> %d\n", contador_con_memoria());
    printf("contador_con_memoria() -> %d\n", contador_con_memoria());

    /*
    CUARTA PARTE - Variable global.
    */
    printf("\n--- CUARTA PARTE: Global ---\n\n");

    usar_global();
    usar_global();
    printf("llamadas_totales vale %d (modificada por las funciones)\n", llamadas_totales);
    printf("MAX_VIDAS (static global, constante) vale %d\n", MAX_VIDAS);

    /*
    QUINTA PARTE - Sombra (shadowing).
      Una local con el mismo nombre que una global la "tapa" dentro de su bloque.
    */
    printf("\n--- QUINTA PARTE: Sombra de una global ---\n\n");

    int llamadas_totales_local = 999;     // nombre distinto para no confundir
    {
        int llamadas_totales = 5;         // tapa a la global dentro de este bloque
        printf("Dentro del bloque: llamadas_totales = %d\n", llamadas_totales);
    }
    printf("Fuera del bloque, la global sigue valiendo %d (y la local %d)\n",
           llamadas_totales, llamadas_totales_local);

    /*
    SEXTA PARTE - Resumen.
        local        -> vive en la funcion/bloque, sin memoria
        static local -> vive en la funcion, CON memoria entre llamadas
        global       -> la ven todas las funciones; usar con moderacion
        static global/funcion -> solo visible en el fichero
    */
    printf("\n--- SEXTA PARTE: Resumen ---\n\n");
    printf("Local | static local | global | static global\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

void funcion_local(void) {
    int x = 99;       // otra variable distinta de la x de main
    printf("En funcion_local: x = %d\n", x);
}

int contador_normal(void) {
    int contador = 0;       // se crea a 0 en cada llamada
    contador++;
    return contador;
}

int contador_con_memoria(void) {
    static int contador = 0;   // se inicializa una sola vez
    contador++;
    return contador;
}

void usar_global(void) {
    llamadas_totales++;
}
