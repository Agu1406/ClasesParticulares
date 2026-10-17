/*
E16 - Cifrado Cesar (RESUELTO)

ENUNCIADO:
  Implementa void cesar(char *s, int desplazamiento): desplaza cada letra (mayuscula o minuscula) en el alfabeto de 26 letras. Lo que no es letra no cambia. El desplazamiento puede ser negativo.

PISTA:
  ((c - 'a' + d) % 26 + 26) % 26 + 'a'

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


void cesar(char *s, int desplazamiento) {
    int d = ((desplazamiento % 26) + 26) % 26;
    for (int i = 0; s[i] != '\0'; i++) {
        if (islower((unsigned char)s[i])) {
            s[i] = (char)('a' + (s[i] - 'a' + d) % 26);
        } else if (isupper((unsigned char)s[i])) {
            s[i] = (char)('A' + (s[i] - 'A' + d) % 26);
        }
    }
}

int main(void) {
    char a[] = "abc xyz";
    cesar(a, 3);
    PRUEBA(strcmp(a, "def abc") == 0);
    char b[] = "Hola, Mundo!";
    cesar(b, 1);
    PRUEBA(strcmp(b, "Ipmb, Nvoep!") == 0);
    cesar(b, -1);
    PRUEBA(strcmp(b, "Hola, Mundo!") == 0);
    char c[] = "abc";
    cesar(c, 52);
    PRUEBA(strcmp(c, "abc") == 0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
