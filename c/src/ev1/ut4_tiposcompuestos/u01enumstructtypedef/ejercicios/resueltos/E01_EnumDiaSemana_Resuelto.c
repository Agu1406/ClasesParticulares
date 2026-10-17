/*
E01 - Enum de dias de la semana (RESUELTO)

ENUNCIADO:
  Dado el enum Dia, implementa const char *nombre_dia(Dia d) y bool es_laborable(Dia d) (lunes a viernes).

PISTA:
  Un switch con un case por constante

SOLUCION:
  Todas las pruebas deben mostrar OK.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>
#include <stdbool.h>

static int pruebas = 0;
static int aciertos = 0;
#define PRUEBA(cond) do { pruebas++; if (cond) { aciertos++; printf("  [ OK  ] %s\n", #cond); } \
                          else { printf("  [FALLO] %s\n", #cond); } } while (0)


typedef enum { LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO } Dia;

const char *nombre_dia(Dia d) {
    switch (d) {
        case LUNES: return "Lunes";
        case MARTES: return "Martes";
        case MIERCOLES: return "Miercoles";
        case JUEVES: return "Jueves";
        case VIERNES: return "Viernes";
        case SABADO: return "Sabado";
        case DOMINGO: return "Domingo";
    }
    return "?";
}

bool es_laborable(Dia d) {
    return d >= LUNES && d <= VIERNES;
}

int main(void) {
    PRUEBA(strcmp(nombre_dia(LUNES), "Lunes") == 0);
    PRUEBA(strcmp(nombre_dia(MIERCOLES), "Miercoles") == 0);
    PRUEBA(strcmp(nombre_dia(DOMINGO), "Domingo") == 0);
    PRUEBA(es_laborable(VIERNES));
    PRUEBA(!es_laborable(SABADO));
    PRUEBA(!es_laborable(DOMINGO));

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
