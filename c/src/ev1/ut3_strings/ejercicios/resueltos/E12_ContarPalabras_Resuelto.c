/*
E12 - Contar palabras (RESUELTO)

ENUNCIADO:
  Implementa int contar_palabras(const char *s): las palabras estan separadas por uno o mas espacios (o tabuladores).

PISTA:
  Una bandera 'dentro de una palabra' evita contar varias veces

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


int contar_palabras(const char *s) {
    int palabras = 0;
    bool dentro = false;
    for (int i = 0; s[i] != '\0'; i++) {
        if (isspace((unsigned char)s[i])) {
            dentro = false;
        } else if (!dentro) {
            dentro = true;
            palabras++;
        }
    }
    return palabras;
}

int main(void) {
    PRUEBA(contar_palabras("") == 0);
    PRUEBA(contar_palabras("   ") == 0);
    PRUEBA(contar_palabras("hola") == 1);
    PRUEBA(contar_palabras("  hola   mundo ") == 2);
    PRUEBA(contar_palabras("una frase de cinco palabras") == 5);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
