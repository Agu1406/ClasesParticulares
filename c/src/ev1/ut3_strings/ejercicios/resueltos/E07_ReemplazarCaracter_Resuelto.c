/*
E07 - Reemplazar un caracter (RESUELTO)

ENUNCIADO:
  Implementa int reemplazar(char *s, char viejo, char nuevo) que cambie todas las apariciones y devuelva cuantas hizo.

PISTA:
  Recorre y compara cada posicion

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


int reemplazar(char *s, char viejo, char nuevo) {
    int cambios = 0;
    for (int i = 0; s[i] != '\0'; i++) {
        if (s[i] == viejo) {
            s[i] = nuevo;
            cambios++;
        }
    }
    return cambios;
}

int main(void) {
    char a[] = "uno dos tres";
    PRUEBA(reemplazar(a, ' ', '_') == 2);
    PRUEBA(strcmp(a, "uno_dos_tres") == 0);
    char b[] = "hola";
    PRUEBA(reemplazar(b, 'z', 'x') == 0);
    PRUEBA(strcmp(b, "hola") == 0);
    char c[] = "aaa";
    PRUEBA(reemplazar(c, 'a', 'b') == 3 && strcmp(c, "bbb") == 0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
