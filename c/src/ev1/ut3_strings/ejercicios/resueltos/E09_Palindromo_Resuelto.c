/*
E09 - Palindromo (RESUELTO)

ENUNCIADO:
  Implementa bool es_palindromo(const char *s): ignora mayusculas y todo lo que no sea una letra.

PISTA:
  Dos indices, uno por cada extremo, saltando lo que no sea letra

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


bool es_palindromo(const char *s) {
    int i = 0;
    int j = (int)strlen(s) - 1;
    while (i < j) {
        if (!isalpha((unsigned char)s[i])) {
            i++;
        } else if (!isalpha((unsigned char)s[j])) {
            j--;
        } else if (tolower((unsigned char)s[i]) != tolower((unsigned char)s[j])) {
            return false;
        } else {
            i++;
            j--;
        }
    }
    return true;
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
