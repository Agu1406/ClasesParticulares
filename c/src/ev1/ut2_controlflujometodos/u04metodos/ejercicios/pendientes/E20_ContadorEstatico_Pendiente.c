/*
E20 - Funcion con memoria (static) (PENDIENTE)

ENUNCIADO:
  Implementa int siguiente_id(void): devuelve 1 la primera vez, 2 la segunda, etc. usando una variable static. Y void reiniciar_ids(void) que vuelva a empezar (pista: usa un static a nivel de fichero).

PISTA:
  static int contador = 0; a nivel de fichero

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

static int pruebas = 0;
static int aciertos = 0;
#define PRUEBA(cond) do { pruebas++; if (cond) { aciertos++; printf("  [ OK  ] %s\n", #cond); } \
                          else { printf("  [FALLO] %s\n", #cond); } } while (0)


static int contador_ids = 0;

int siguiente_id(void) {
    // TODO: incrementa el contador y devuelvelo
    return 0;
}

void reiniciar_ids(void) {
    // TODO: pone el contador a 0
}

int main(void) {
    PRUEBA(siguiente_id() == 1);
    PRUEBA(siguiente_id() == 2);
    PRUEBA(siguiente_id() == 3);
    reiniciar_ids();
    PRUEBA(siguiente_id() == 1);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
