/*
E18 - Separar una fecha dd/mm/aaaa (PENDIENTE)

ENUNCIADO:
  Implementa bool separar_fecha(const char *texto, int *dia, int *mes, int *anio): devuelve true si el texto tiene el formato dd/mm/aaaa con dia 1-31 y mes 1-12, y rellena los tres valores. Si no, false sin tocarlos.

PISTA:
  sscanf(texto, "%d/%d/%d", &d, &m, &a) devuelve 3 si lee los tres

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


bool separar_fecha(const char *texto, int *dia, int *mes, int *anio) {
    // TODO: lee con sscanf y valida rangos
    (void)texto;
    (void)dia;
    (void)mes;
    (void)anio;
    return false;
}

int main(void) {
    int d = 0, m = 0, a = 0;
    PRUEBA(separar_fecha("13/10/2026", &d, &m, &a) && d == 13 && m == 10 && a == 2026);
    PRUEBA(separar_fecha("1/2/1999", &d, &m, &a) && d == 1 && m == 2 && a == 1999);
    d = 0; m = 0; a = 0;
    PRUEBA(!separar_fecha("13-10-2026", &d, &m, &a) && d == 0);
    PRUEBA(!separar_fecha("32/01/2026", &d, &m, &a));
    PRUEBA(!separar_fecha("10/13/2026", &d, &m, &a));
    PRUEBA(!separar_fecha("hola", &d, &m, &a));

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
