/*
E19 - Anagramas (RESUELTO)

ENUNCIADO:
  Implementa bool son_anagramas(const char *a, const char *b): mismas letras con las mismas repeticiones, ignorando mayusculas y lo que no sea letra.

PISTA:
  Dos tablas int cuenta[26] y comparar

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


bool son_anagramas(const char *a, const char *b) {
    int ca[26] = {0};
    int cb[26] = {0};
    for (int i = 0; a[i] != '\0'; i++) {
        if (isalpha((unsigned char)a[i])) {
            ca[tolower((unsigned char)a[i]) - 'a']++;
        }
    }
    for (int i = 0; b[i] != '\0'; i++) {
        if (isalpha((unsigned char)b[i])) {
            cb[tolower((unsigned char)b[i]) - 'a']++;
        }
    }
    for (int k = 0; k < 26; k++) {
        if (ca[k] != cb[k]) {
            return false;
        }
    }
    return true;
}

int main(void) {
    PRUEBA(son_anagramas("roma", "amor"));
    PRUEBA(son_anagramas("Listen", "Silent"));
    PRUEBA(son_anagramas("dormitory", "dirty room"));
    PRUEBA(!son_anagramas("hola", "halo!!x"));
    PRUEBA(!son_anagramas("aab", "abb"));
    PRUEBA(son_anagramas("", ""));

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
