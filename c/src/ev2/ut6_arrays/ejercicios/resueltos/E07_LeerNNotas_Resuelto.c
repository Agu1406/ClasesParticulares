/*
E07 - Leer N notas (RESUELTO)

ENUNCIADO:
  Pide N (1..10), lee N doubles en un array y muestra la media.

SOLUCION:
  Tamano logico n.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int n = 0;
    double notas[10];
    double suma = 0.0;
    printf("N: ");
    scanf("%d", &n);
    if (n < 1 || n > 10) {
        printf("N no valido\n");
        return 1;
    }
    for (int i = 0; i < n; i++) {
        scanf("%lf", &notas[i]);
        suma += notas[i];
    }
    printf("Media: %.2f\n", suma / n);
    return 0;
}
