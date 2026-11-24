/*
E05 - Invertir array (RESUELTO)

ENUNCIADO:
  Invierte in-place int v[5]={1,2,3,4,5} y muestra el resultado.

SOLUCION:
  Auxiliar.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int v[5] = {1, 2, 3, 4, 5};
    int n = 5;
    for (int i = 0; i < n / 2; i++) {
        int aux = v[i];
        v[i] = v[n - 1 - i];
        v[n - 1 - i] = aux;
    }
    for (int i = 0; i < n; i++) {
        printf("%d", v[i]);
        if (i < n - 1) printf(" ");
    }
    printf("\n");
    return 0;
}
