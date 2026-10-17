/*
E03 - Mayusculas y minusculas en el sitio (RESUELTO)

ENUNCIADO:
  Implementa void a_mayusculas(char *s) y void a_minusculas(char *s). Modifican la propia cadena.

PISTA:
  toupper((unsigned char)s[i])

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


void a_mayusculas(char *s) {
    for (int i = 0; s[i] != '\0'; i++) {
        s[i] = (char)toupper((unsigned char)s[i]);
    }
}

void a_minusculas(char *s) {
    for (int i = 0; s[i] != '\0'; i++) {
        s[i] = (char)tolower((unsigned char)s[i]);
    }
}

int main(void) {
    char a[] = "Hola Mundo 123";
    a_mayusculas(a);
    PRUEBA(strcmp(a, "HOLA MUNDO 123") == 0);
    a_minusculas(a);
    PRUEBA(strcmp(a, "hola mundo 123") == 0);
    char vacia[] = "";
    a_mayusculas(vacia);
    PRUEBA(strcmp(vacia, "") == 0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
