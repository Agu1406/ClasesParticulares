/*
Ejercicio 20 - escalera_cadena (SIN RESOLVER)

ENUNCIADO:
  Escribe la funcion escalera_cadena que copia el texto alternando mayusculas y minusculas:
  la primera letra en mayuscula, la segunda en minuscula, la tercera en mayuscula...
  Los espacios y los signos se copian igual y NO cuentan para la alternancia.

PISTA:
  Una variable booleana 'toca_mayuscula' que se invierte solo cuando procesas una letra.

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


void escalera_cadena(const char *texto, char *salida, size_t capacidad) {
    // TODO: alterna mayusculas y minusculas entre letras
    (void)texto;
    (void)capacidad;
    salida[0] = '\0';
}

int main(void) {
    char r[64];
    escalera_cadena("Hola mundo", r, sizeof(r));
    PRUEBA(strcmp(r, "HoLa MuNdO") == 0);
    escalera_cadena("PROGRAMACION", r, sizeof(r));
    PRUEBA(strcmp(r, "PrOgRaMaCiOn") == 0);
    escalera_cadena("java", r, sizeof(r));
    PRUEBA(strcmp(r, "JaVa") == 0);
    escalera_cadena("A", r, sizeof(r));
    PRUEBA(strcmp(r, "A") == 0);
    escalera_cadena("", r, sizeof(r));
    PRUEBA(strcmp(r, "") == 0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
