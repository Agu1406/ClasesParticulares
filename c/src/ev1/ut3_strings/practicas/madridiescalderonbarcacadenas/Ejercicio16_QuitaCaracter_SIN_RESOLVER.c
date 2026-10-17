/*
Ejercicio 16 - quita_caracter (SIN RESOLVER)

ENUNCIADO:
  Escribe la funcion quita_caracter que recibe una cadena, un caracter y un buffer de salida.
  Debe copiar la cadena en la salida eliminando todas las apariciones del caracter.
  Escribe tambien quita_caracter_en_sitio, que hace lo mismo modificando la propia cadena.

PISTA:
  Con dos indices: uno para leer (i) y otro para escribir (j).

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


size_t quita_caracter(const char *texto, char c, char *salida, size_t capacidad) {
    // TODO: copia en salida todo menos c y devuelve la longitud
    (void)texto;
    (void)c;
    (void)capacidad;
    salida[0] = '\0';
    return 0;
}

void quita_caracter_en_sitio(char *s, char c) {
    // TODO: elimina c de la propia cadena
    (void)s;
    (void)c;
}

int main(void) {
    char r[64];
    quita_caracter("Hola mundo", 'o', r, sizeof(r));
    PRUEBA(strcmp(r, "Hla mund") == 0);
    quita_caracter("programacion", 'a', r, sizeof(r));
    PRUEBA(strcmp(r, "progrmcion") == 0);
    quita_caracter("Java", 'x', r, sizeof(r));
    PRUEBA(strcmp(r, "Java") == 0);
    PRUEBA(quita_caracter("aaaa", 'a', r, sizeof(r)) == 0 && strcmp(r, "") == 0);
    char pequeno[4];
    quita_caracter("abcdef", 'z', pequeno, sizeof(pequeno));
    PRUEBA(strcmp(pequeno, "abc") == 0);
    char s[] = "Hola mundo";
    quita_caracter_en_sitio(s, 'o');
    PRUEBA(strcmp(s, "Hla mund") == 0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
