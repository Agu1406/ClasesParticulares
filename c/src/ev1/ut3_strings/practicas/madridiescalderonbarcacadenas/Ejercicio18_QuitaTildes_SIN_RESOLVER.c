/*
Ejercicio 18 - quita_tildes (SIN RESOLVER)

ENUNCIADO:
  Escribe la funcion quita_tildes que copia el texto cambiando las vocales con tilde
  (a e i o u, mayusculas y minusculas) y la u con dieresis por la vocal sin tilde.
  La n con tilde (enie) NO se modifica.
  El texto esta en UTF-8: una vocal con tilde ocupa 2 bytes (0xC3 y otro).

PISTA:
  Si encuentras el byte 0xC3, mira el siguiente byte en una tabla.

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


/* Segundo byte UTF-8 (tras 0xC3) y la letra por la que se sustituye. */
static const unsigned char SEGUNDO[] = {0xA1, 0xA9, 0xAD, 0xB3, 0xBA, 0xBC, 0x81, 0x89, 0x8D, 0x93, 0x9A, 0x9C};
static const char SUSTITUTO[] = "aeiouuAEIOUU";

void quita_tildes(const char *texto, char *salida, size_t capacidad) {
    // TODO: copia el texto sustituyendo las vocales con tilde (UTF-8)
    (void)texto;
    (void)capacidad;
    salida[0] = '\0';
}

int main(void) {
    char r[64];
    quita_tildes("Jos\xC3\xA9 Mar\xC3\xAD" "a", r, sizeof(r));
    PRUEBA(strcmp(r, "Jose Maria") == 0);
    quita_tildes("Programaci\xC3\xB3n", r, sizeof(r));
    PRUEBA(strcmp(r, "Programacion") == 0);
    quita_tildes("aeiou AEIOU", r, sizeof(r));
    PRUEBA(strcmp(r, "aeiou AEIOU") == 0);
    quita_tildes("\xC3\x81\xC3\x89\xC3\x8D\xC3\x93\xC3\x9A", r, sizeof(r));
    PRUEBA(strcmp(r, "AEIOU") == 0);
    quita_tildes("ping\xC3\xBC" "ino", r, sizeof(r));
    PRUEBA(strcmp(r, "pinguino") == 0);
    quita_tildes("ni\xC3\xB1" "o", r, sizeof(r));
    PRUEBA(strcmp(r, "ni\xC3\xB1" "o") == 0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
