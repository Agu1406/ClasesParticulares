/*
E02 - Contar vocales (PENDIENTE)

ENUNCIADO:
  Implementa int contar_vocales(const char *s) que cuente las vocales (a, e, i, o, u) sin distinguir mayusculas.

PISTA:
  tolower convierte a minuscula; un switch con los cinco casos queda limpio

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


int contar_vocales(const char *s) {
    // TODO: cuenta las vocales
    (void)s;
    return -1;
}

int main(void) {
    PRUEBA(contar_vocales("") == 0);
    PRUEBA(contar_vocales("Hola mundo") == 4);
    PRUEBA(contar_vocales("AEIOU") == 5);
    PRUEBA(contar_vocales("rhythm") == 0);
    PRUEBA(contar_vocales("Programacion") == 5);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
