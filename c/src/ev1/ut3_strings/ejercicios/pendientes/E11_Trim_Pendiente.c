/*
E11 - Quitar espacios de los extremos (PENDIENTE)

ENUNCIADO:
  Implementa void trim(char *s) que elimine los espacios (y tabuladores) del principio y del final, modificando la cadena.

PISTA:
  Primero localiza el inicio, luego usa memmove para desplazar al principio

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
    // TODO: elimina espacios iniciales y finales
    (void)s;
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
