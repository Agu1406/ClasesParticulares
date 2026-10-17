/*
E10 - Formatear una nota como texto (RESUELTO)

ENUNCIADO:
  Implementa void formato_nota(double nota, char *salida, size_t capacidad) que escriba con snprintf
  'Nota: N.N (Categoria)', con un decimal y la categoria: Sobresaliente (>=9), Notable (>=7), Aprobado (>=5), Suspenso.

PISTA:
  snprintf(salida, capacidad, "Nota: %.1f (%s)", nota, categoria);

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


void formato_nota(double nota, char *salida, size_t capacidad) {
    const char *categoria = "Suspenso";
    if (nota >= 9) {
        categoria = "Sobresaliente";
    } else if (nota >= 7) {
        categoria = "Notable";
    } else if (nota >= 5) {
        categoria = "Aprobado";
    }
    snprintf(salida, capacidad, "Nota: %.1f (%s)", nota, categoria);
}

int main(void) {
    char t[64];
    formato_nota(9.5, t, sizeof(t));
    PRUEBA(strcmp(t, "Nota: 9.5 (Sobresaliente)") == 0);
    formato_nota(7.0, t, sizeof(t));
    PRUEBA(strcmp(t, "Nota: 7.0 (Notable)") == 0);
    formato_nota(5.0, t, sizeof(t));
    PRUEBA(strcmp(t, "Nota: 5.0 (Aprobado)") == 0);
    formato_nota(3.0, t, sizeof(t));
    PRUEBA(strcmp(t, "Nota: 3.0 (Suspenso)") == 0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
