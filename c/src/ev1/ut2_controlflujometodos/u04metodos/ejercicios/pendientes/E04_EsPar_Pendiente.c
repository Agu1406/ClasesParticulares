/*
E04 - Funcion booleana es_par (PENDIENTE)

ENUNCIADO:
  Implementa bool es_par(int n) que devuelva true si n es par (tambien para negativos).

PISTA:
  n % 2 == 0 sirve tambien con negativos

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>

static int pruebas = 0;
static int aciertos = 0;
#define PRUEBA(cond) do { pruebas++; if (cond) { aciertos++; printf("  [ OK  ] %s\n", #cond); } \
                          else { printf("  [FALLO] %s\n", #cond); } } while (0)


bool es_par(int n) {
    // TODO: devuelve true si n es par
    return false;
}

int main(void) {
    PRUEBA(es_par(4));
    PRUEBA(!es_par(7));
    PRUEBA(es_par(0));
    PRUEBA(es_par(-6));
    PRUEBA(!es_par(-3));

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
