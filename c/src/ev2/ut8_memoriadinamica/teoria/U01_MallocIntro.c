/*
U01 — Introduccion a malloc (esqueleto EV2).

OBJETIVO:
  - Reservar memoria con malloc y liberarla con free.
  - Comprobar NULL. El resto de UT7 amplia calloc/realloc y fugas.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int n = 5;
    int *datos = malloc((size_t)n * sizeof(int));
    if (datos == NULL) {
        printf("No hay memoria\n");
        return 1;
    }
    for (int i = 0; i < n; i++) {
        datos[i] = (i + 1) * 10;
        printf("datos[%d] = %d\n", i, datos[i]);
    }
    free(datos);
    return 0;
}
