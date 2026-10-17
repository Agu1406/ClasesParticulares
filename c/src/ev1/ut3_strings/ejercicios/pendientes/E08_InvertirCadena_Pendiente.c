/*
E08 - Invertir una cadena (PENDIENTE)

ENUNCIADO:
  Implementa void invertir(char *s) que de la vuelta a la cadena en el sitio (sin usar otro array).

PISTA:
  Intercambia s[i] y s[n - 1 - i] hasta llegar a la mitad

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


void invertir(char *s) {
    // TODO: invierte la cadena intercambiando extremos
    (void)s;
}

int main(void) {
    char a[] = "abc";
    invertir(a);
    PRUEBA(strcmp(a, "cba") == 0);
    char b[] = "programa";
    invertir(b);
    PRUEBA(strcmp(b, "amargorp") == 0);
    char c[] = "x";
    invertir(c);
    PRUEBA(strcmp(c, "x") == 0);
    char d[] = "";
    invertir(d);
    PRUEBA(strcmp(d, "") == 0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
