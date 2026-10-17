/*
E04 - Primera y ultima letra (RESUELTO)

ENUNCIADO:
  Implementa char primera_letra(const char *s) y char ultima_letra(const char *s). Si la cadena esta vacia devuelven '\0'.

PISTA:
  La ultima posicion valida es strlen(s) - 1

SOLUCION:
  Todas las pruebas deben mostrar OK.

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


char primera_letra(const char *s) {
    return s[0];
}

char ultima_letra(const char *s) {
    size_t n = strlen(s);
    if (n == 0) {
        return '\0';
    }
    return s[n - 1];
}

int main(void) {
    PRUEBA(primera_letra("Hola") == 'H');
    PRUEBA(ultima_letra("Hola") == 'a');
    PRUEBA(primera_letra("x") == 'x' && ultima_letra("x") == 'x');
    PRUEBA(primera_letra("") == '\0');
    PRUEBA(ultima_letra("") == '\0');

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
