/*
E21 - Generar un acronimo (PENDIENTE)

ENUNCIADO:
  Implementa void acronimo(const char *texto, char *salida, size_t capacidad): escribe en salida la inicial en mayuscula de cada palabra.
  Respeta la capacidad (siempre termina en '\0').

PISTA:
  Marca el inicio de palabra y guarda solo ese caracter

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


void acronimo(const char *texto, char *salida, size_t capacidad) {
    // TODO: construye el acronimo respetando la capacidad
    (void)texto;
    (void)capacidad;
    salida[0] = '\0';
}

int main(void) {
    char s[16];
    acronimo("Organizacion Mundial de la Salud", s, sizeof(s));
    PRUEBA(strcmp(s, "OMDLS") == 0);
    acronimo("  hola   mundo ", s, sizeof(s));
    PRUEBA(strcmp(s, "HM") == 0);
    acronimo("", s, sizeof(s));
    PRUEBA(strcmp(s, "") == 0);
    char pequeno[4];
    acronimo("uno dos tres cuatro", pequeno, sizeof(pequeno));
    PRUEBA(strcmp(pequeno, "UDT") == 0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
