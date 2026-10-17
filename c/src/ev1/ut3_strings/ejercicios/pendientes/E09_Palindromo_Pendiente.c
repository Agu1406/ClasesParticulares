/*
E09 - Palindromo (PENDIENTE)

ENUNCIADO:
  Implementa bool es_palindromo(const char *s): ignora mayusculas y todo lo que no sea una letra.

PISTA:
  Dos indices, uno por cada extremo, saltando lo que no sea letra

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>

static int pruebas = 0;
static int aciertos = 0;
#define PRUEBA(cond) do { pruebas++; if (cond) { aciertos++; printf("  [ OK  ] %s\n", #cond); } \
                          else { printf("  [FALLO] %s\n", #cond); } } while (0)


bool es_palindromo(const char *s) {
    // TODO: true si se lee igual al derecho y al reves
    (void)s;
    return false;
}

int main(void) {
    PRUEBA(es_palindromo("reconocer"));
    PRUEBA(es_palindromo("Anita lava la tina"));
    PRUEBA(es_palindromo("Dabale arroz a la zorra el abad"));
    PRUEBA(!es_palindromo("programar"));
    PRUEBA(es_palindromo(""));
    PRUEBA(es_palindromo("a"));

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
