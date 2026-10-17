/*
U07 - Escribir funciones que reciben y devuelven cadenas.

OBJETIVO:
  - Pasar cadenas a funciones: const char * (solo lectura) y char * (modificable).
  - Entender por que una funcion NO puede devolver un array local.
  - Devolver resultados mediante un buffer que aporta quien llama
    (destino + capacidad).
  - Implementar tus propias mi_strlen, mi_strcpy, quitar_caracter, etc.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>

static size_t mi_strlen(const char *s);
static void mi_strcpy(char *destino, const char *origen);
static bool mi_streq(const char *a, const char *b);
static size_t quitar_caracter(const char *texto, char quitar, char *salida, size_t capacidad);
static bool a_mayuscula_inicial(char *s);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - const char * para leer, char * para modificar.
      Una funcion que SOLO lee la cadena debe declararla const char *: asi
      el compilador impide modificarla por error y se pueden pasar literales.
    */
    printf("--- PRIMERA PARTE: const char * ---\n\n");

    printf("mi_strlen(\"Programacion\") = %zu\n", mi_strlen("Programacion"));
    printf("mi_streq(\"a\", \"a\") = %d | mi_streq(\"a\", \"b\") = %d\n", mi_streq("a", "a"), mi_streq("a", "b"));

    /*
    SEGUNDA PARTE - Un array local NO se puede devolver.
      char* mala(void) { char r[20] = "hola"; return r; }
      r desaparece al terminar la funcion: el puntero queda colgando (dangling).
      Soluciones: (a) buffer de quien llama, (b) modificar en el sitio.
    */
    printf("\n--- SEGUNDA PARTE: Devolver cadenas ---\n\n");

    char copia[20];
    mi_strcpy(copia, "Hola");
    printf("mi_strcpy -> \"%s\"\n", copia);

    /*
    TERCERA PARTE - Patron: destino + capacidad.
      La funcion escribe el resultado en un buffer que le da quien llama,
      respeta la capacidad y siempre termina en '\0'.
      Devuelve la longitud resultante (util para comprobar).
    */
    printf("\n--- TERCERA PARTE: destino y capacidad ---\n\n");

    char sin_o[32];
    size_t largo = quitar_caracter("Hola mundo", 'o', sin_o, sizeof(sin_o));
    printf("quitar 'o' de \"Hola mundo\" -> \"%s\" (len %zu)\n", sin_o, largo);

    char pequeno[5];
    largo = quitar_caracter("programacion", 'a', pequeno, sizeof(pequeno));
    printf("Con capacidad 5 -> \"%s\" (len %zu)\n", pequeno, largo);

    /*
    CUARTA PARTE - Modificar en el sitio.
    */
    printf("\n--- CUARTA PARTE: En el sitio ---\n\n");

    char nombre[] = "ada lovelace";
    if (a_mayuscula_inicial(nombre)) {
        printf("Capitalizado: %s\n", nombre);
    }

    /*
    QUINTA PARTE - Recordatorio de errores tipicos.
      - Olvidar el '\0' final al construir la cadena a mano.
      - Escribir mas alla de la capacidad del destino.
      - Modificar un literal (const char *).
      - Devolver la direccion de un array local.
      - Comparar cadenas con == en vez de strcmp.
    */
    printf("\n--- QUINTA PARTE: Errores tipicos ---\n\n");
    printf("Revisa la lista anterior antes de hacer los ejercicios.\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

static size_t mi_strlen(const char *s) {
    size_t n = 0;
    while (s[n] != '\0') {
        n++;
    }
    return n;
}

static void mi_strcpy(char *destino, const char *origen) {
    size_t i = 0;
    while (origen[i] != '\0') {
        destino[i] = origen[i];
        i++;
    }
    destino[i] = '\0';
}

static bool mi_streq(const char *a, const char *b) {
    size_t i = 0;
    while (a[i] != '\0' && a[i] == b[i]) {
        i++;
    }
    return a[i] == b[i];
}

static size_t quitar_caracter(const char *texto, char quitar, char *salida, size_t capacidad) {
    size_t j = 0;
    for (size_t i = 0; texto[i] != '\0' && j + 1 < capacidad; i++) {
        if (texto[i] != quitar) {
            salida[j++] = texto[i];
        }
    }
    salida[j] = '\0';
    return j;
}

static bool a_mayuscula_inicial(char *s) {
    if (s[0] == '\0') {
        return false;
    }
    bool inicio = true;
    for (size_t i = 0; s[i] != '\0'; i++) {
        if (isspace((unsigned char)s[i])) {
            inicio = true;
        } else if (inicio) {
            s[i] = (char)toupper((unsigned char)s[i]);
            inicio = false;
        }
    }
    return true;
}
