/*
E03 - Maximo y minimo (RESUELTO)

ENUNCIADO:
  Con int v[6] = {4, -1, 9, 2, 9, 0}, muestra el maximo y el minimo.

SOLUCION:
  Un solo recorrido.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int v[6] = {4, -1, 9, 2, 9, 0};
    int max = v[0], min = v[0];
    for (int i = 1; i < 6; i++) {
        if (v[i] > max) max = v[i];
        if (v[i] < min) min = v[i];
    }
    printf("Max: %d\nMin: %d\n", max, min);
    return 0;
}
