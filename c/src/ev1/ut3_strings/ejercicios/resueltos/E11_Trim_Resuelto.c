/*
E11 - Quitar espacios de los extremos (RESUELTO)

ENUNCIADO:
  Implementa void trim(char *s) que elimine los espacios (y tabuladores) del principio y del final, modificando la cadena.

PISTA:
  Primero localiza el inicio, luego usa memmove para desplazar al principio

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


void trim(char *s) {
    size_t inicio = 0;
    while (s[inicio] != '\0' && isspace((unsigned char)s[inicio])) {
        inicio++;
    }
    size_t fin = strlen(s);
    while (fin > inicio && isspace((unsigned char)s[fin - 1])) {
        fin--;
    }
    size_t largo = fin - inicio;
    memmove(s, s + inicio, largo);
    s[largo] = '\0';
}

int main(void) {
    char a[] = "   hola mundo   ";
    trim(a);
    PRUEBA(strcmp(a, "hola mundo") == 0);
    char b[] = "sin espacios";
    trim(b);
    PRUEBA(strcmp(b, "sin espacios") == 0);
    char c[] = "     ";
    trim(c);
    PRUEBA(strcmp(c, "") == 0);
    char d[] = "\t x \t";
    trim(d);
    PRUEBA(strcmp(d, "x") == 0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
