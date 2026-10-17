/*
E13 - Primera letra de cada palabra en mayuscula (RESUELTO)

ENUNCIADO:
  Implementa void capitalizar(char *s): cada palabra empieza en mayuscula y el resto en minuscula.

PISTA:
  Recuerda si el caracter anterior era un espacio

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


void capitalizar(char *s) {
    bool inicio = true;
    for (int i = 0; s[i] != '\0'; i++) {
        if (isspace((unsigned char)s[i])) {
            inicio = true;
        } else if (inicio) {
            s[i] = (char)toupper((unsigned char)s[i]);
            inicio = false;
        } else {
            s[i] = (char)tolower((unsigned char)s[i]);
        }
    }
}

int main(void) {
    char a[] = "hOLA mUNDO";
    capitalizar(a);
    PRUEBA(strcmp(a, "Hola Mundo") == 0);
    char b[] = "  ada   LOVELACE ";
    capitalizar(b);
    PRUEBA(strcmp(b, "  Ada   Lovelace ") == 0);
    char c[] = "";
    capitalizar(c);
    PRUEBA(strcmp(c, "") == 0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
