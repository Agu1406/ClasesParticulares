/*
E06 - Contiene, empieza y termina (RESUELTO)

ENUNCIADO:
  Implementa bool contiene(const char *texto, const char *buscada) con strstr,
  bool empieza_por(const char *texto, const char *prefijo) con strncmp y
  bool termina_en(const char *texto, const char *sufijo).

PISTA:
  Para termina_en compara la cola del texto: texto + (largo_texto - largo_sufijo)

SOLUCION:
  Todas las pruebas deben mostrar OK.

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


bool contiene(const char *texto, const char *buscada) {
    return strstr(texto, buscada) != NULL;
}

bool empieza_por(const char *texto, const char *prefijo) {
    return strncmp(texto, prefijo, strlen(prefijo)) == 0;
}

bool termina_en(const char *texto, const char *sufijo) {
    size_t lt = strlen(texto);
    size_t ls = strlen(sufijo);
    if (ls > lt) {
        return false;
    }
    return strcmp(texto + (lt - ls), sufijo) == 0;
}

int main(void) {
    PRUEBA(contiene("programacion", "gram"));
    PRUEBA(!contiene("programacion", "java"));
    PRUEBA(empieza_por("programacion", "pro"));
    PRUEBA(!empieza_por("programacion", "ion"));
    PRUEBA(termina_en("programacion", "cion"));
    PRUEBA(!termina_en("programacion", "pro"));
    PRUEBA(!termina_en("ab", "abc"));
    PRUEBA(empieza_por("abc", ""));

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
