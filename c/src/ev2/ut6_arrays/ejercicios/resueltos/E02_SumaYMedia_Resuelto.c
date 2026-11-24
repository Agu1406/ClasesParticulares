/*
E02 - Suma y media (RESUELTO)

ENUNCIADO:
  Con int v[4] = {5,7,9,3}, calcula suma y media (double) y las muestra.

SOLUCION:
  Suma en bucle.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int v[4] = {5, 7, 9, 3};
    int suma = 0;
    for (int i = 0; i < 4; i++) suma += v[i];
    printf("Suma: %d\n", suma);
    printf("Media: %.2f\n", suma / 4.0);
    return 0;
}
