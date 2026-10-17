/*
Ejercicio 17 - oculta_vocales (SIN RESOLVER)

ENUNCIADO:
  Escribe la funcion oculta_vocales que copia el texto en la salida cambiando todas las
  vocales sin tilde (mayusculas y minusculas) por el caracter 'X'.

PISTA:
  strchr("aeiouAEIOU", c) != NULL comprueba si es vocal (cuidado con c == '\0').

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


static bool es_vocal(char c) {
    return c != '\0' && strchr("aeiouAEIOU", c) != NULL;
}

void oculta_vocales(const char *texto, char *salida, size_t capacidad) {
    // TODO: copia el texto cambiando las vocales por 'X'
    (void)texto;
    (void)capacidad;
    salida[0] = '\0';
}

int main(void) {
    char r[64];
    oculta_vocales("Hola mundo", r, sizeof(r));
    PRUEBA(strcmp(r, "HXlX mXndX") == 0);
    oculta_vocales("PROGRAMACION", r, sizeof(r));
    PRUEBA(strcmp(r, "PRXGRXMXCXXN") == 0);
    oculta_vocales("xyz", r, sizeof(r));
    PRUEBA(strcmp(r, "xyz") == 0);
    oculta_vocales("", r, sizeof(r));
    PRUEBA(strcmp(r, "") == 0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
