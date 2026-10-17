/*
U01 - Enumeraciones (enum): nombres para un conjunto de valores.

OBJETIVO:
  - Declarar un enum y usar sus constantes en lugar de "numeros magicos".
  - Conocer el valor numerico de cada constante (empieza en 0).
  - Combinar enum con switch y con typedef.
  - Convertir un enum a texto con una funcion.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

enum Dia { LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO };

typedef enum { ROJO, AMARILLO, VERDE } Semaforo;

enum Nivel { BAJO = 10, MEDIO = 50, ALTO = 100 };

static const char *nombre_dia(enum Dia d);
static Semaforo siguiente(Semaforo s);
static const char *texto_semaforo(Semaforo s);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Que es un enum.
      Un enum define constantes enteras con nombre. Si no se indica valor,
      la primera vale 0 y cada siguiente suma 1.
      LUNES = 0, MARTES = 1, ... DOMINGO = 6
    */
    printf("--- PRIMERA PARTE: Valores ---\n\n");

    enum Dia hoy = MIERCOLES;
    printf("MIERCOLES vale %d\n", hoy);
    printf("DOMINGO vale %d\n", DOMINGO);

    /*
    SEGUNDA PARTE - Valores propios.
      Se puede dar un valor concreto; las siguientes continuan desde alli.
    */
    printf("\n--- SEGUNDA PARTE: Valores propios ---\n\n");

    printf("BAJO=%d MEDIO=%d ALTO=%d\n", BAJO, MEDIO, ALTO);

    /*
    TERCERA PARTE - enum con switch.
      Es el uso mas natural: un case por cada constante. Con -Wall el
      compilador avisa si falta alguna constante y no hay default.
    */
    printf("\n--- TERCERA PARTE: switch ---\n\n");

    for (enum Dia d = LUNES; d <= DOMINGO; d++) {
        switch (d) {
            case SABADO:
            case DOMINGO:
                printf("%-10s fin de semana\n", nombre_dia(d));
                break;
            default:
                printf("%-10s laborable\n", nombre_dia(d));
                break;
        }
    }

    /*
    CUARTA PARTE - typedef: no repetir la palabra enum.
      typedef enum { ... } Semaforo;  ->  Semaforo s = ROJO;
    */
    printf("\n--- CUARTA PARTE: typedef ---\n\n");

    Semaforo s = ROJO;
    for (int i = 0; i < 4; i++) {
        printf("Semaforo: %s\n", texto_semaforo(s));
        s = siguiente(s);
    }

    /*
    QUINTA PARTE - Limites y buenas practicas.
      - En C un enum es en realidad un int: el compilador NO impide
        asignar cualquier numero (Semaforo x = 42; compila).
      - Nombres de constantes en MAYUSCULAS, sin repetir entre enums.
      - Un enum es mejor que #define para grupos de constantes relacionadas.
      - Habitual: una constante final NUM_ELEMENTOS para contar cuantos hay.
    */
    printf("\n--- QUINTA PARTE: Buenas practicas ---\n\n");

    enum Color { ROJO_C, VERDE_C, AZUL_C, NUM_COLORES };
    printf("Hay %d colores\n", NUM_COLORES);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

static const char *nombre_dia(enum Dia d) {
    switch (d) {
        case LUNES: return "Lunes";
        case MARTES: return "Martes";
        case MIERCOLES: return "Miercoles";
        case JUEVES: return "Jueves";
        case VIERNES: return "Viernes";
        case SABADO: return "Sabado";
        case DOMINGO: return "Domingo";
    }
    return "Desconocido";
}

static const char *texto_semaforo(Semaforo s) {
    switch (s) {
        case ROJO: return "ROJO";
        case AMARILLO: return "AMARILLO";
        case VERDE: return "VERDE";
    }
    return "?";
}

static Semaforo siguiente(Semaforo s) {
    switch (s) {
        case ROJO: return VERDE;
        case VERDE: return AMARILLO;
        case AMARILLO: return ROJO;
    }
    return ROJO;
}
