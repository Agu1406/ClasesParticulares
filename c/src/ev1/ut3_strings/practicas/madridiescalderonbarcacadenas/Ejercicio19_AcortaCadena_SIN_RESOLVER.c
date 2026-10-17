/*
Ejercicio 19 - acorta_cadena (SIN RESOLVER)

ENUNCIADO:
  Escribe la funcion acorta_cadena que copia en la salida un caracter por cada tres, o fraccion,
  del texto original: los de las posiciones 0, 3, 6, 9, ...

PISTA:
  El bucle avanza de 3 en 3: i += 3

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>
#include <ctype.h>

static int pruebas = 0;
static int aciertos = 0;
#define PRUEBA(cond) do { pruebas++; if (cond) { aciertos++; printf("  [ OK  ] %s\n", #cond); } \
                          else { printf("  [FALLO] %s\n", #cond); } } while (0)


void acorta_cadena(const char *texto, char *salida, size_t capacidad) {
    // TODO: copia los caracteres de las posiciones 0, 3, 6...
    (void)texto;
    (void)capacidad;
    salida[0] = '\0';
}

int main(void) {
    char r[64];
    acorta_cadena("Hola mundo", r, sizeof(r));
    PRUEBA(strcmp(r, "Hauo") == 0);
    acorta_cadena("Programacion", r, sizeof(r));
    PRUEBA(strcmp(r, "Pgmi") == 0);
    acorta_cadena("Java", r, sizeof(r));
    PRUEBA(strcmp(r, "Ja") == 0);
    acorta_cadena("AB", r, sizeof(r));
    PRUEBA(strcmp(r, "A") == 0);
    acorta_cadena("", r, sizeof(r));
    PRUEBA(strcmp(r, "") == 0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
