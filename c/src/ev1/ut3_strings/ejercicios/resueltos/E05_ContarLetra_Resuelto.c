/*
E05 - Contar apariciones de una letra (RESUELTO)

ENUNCIADO:
  Implementa int contar_letra(const char *s, char c) que cuente cuantas veces aparece c (distingue mayusculas).

PISTA:
  Un contador y un bucle

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


int contar_letra(const char *s, char c) {
    int n = 0;
    for (int i = 0; s[i] != '\0'; i++) {
        if (s[i] == c) {
            n++;
        }
    }
    return n;
}

int main(void) {
    PRUEBA(contar_letra("banana", 'a') == 3);
    PRUEBA(contar_letra("banana", 'n') == 2);
    PRUEBA(contar_letra("banana", 'z') == 0);
    PRUEBA(contar_letra("Banana", 'b') == 0);
    PRUEBA(contar_letra("", 'a') == 0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
