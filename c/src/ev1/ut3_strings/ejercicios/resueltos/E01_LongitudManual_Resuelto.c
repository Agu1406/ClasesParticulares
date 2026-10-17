/*
E01 - Longitud de una cadena sin strlen (RESUELTO)

ENUNCIADO:
  Implementa size_t mi_longitud(const char *s) recorriendo la cadena hasta el '\0'. No uses strlen.

PISTA:
  Cuenta caracteres mientras s[i] != '\0'

SOLUCION:
  Todas las pruebas deben mostrar OK.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stddef.h>

static int pruebas = 0;
static int aciertos = 0;
#define PRUEBA(cond) do { pruebas++; if (cond) { aciertos++; printf("  [ OK  ] %s\n", #cond); } \
                          else { printf("  [FALLO] %s\n", #cond); } } while (0)


size_t mi_longitud(const char *s) {
    size_t n = 0;
    while (s[n] != '\0') {
        n++;
    }
    return n;
}

int main(void) {
    PRUEBA(mi_longitud("") == 0);
    PRUEBA(mi_longitud("a") == 1);
    PRUEBA(mi_longitud("Hola mundo") == 10);
    PRUEBA(mi_longitud("  dos  ") == 7);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
