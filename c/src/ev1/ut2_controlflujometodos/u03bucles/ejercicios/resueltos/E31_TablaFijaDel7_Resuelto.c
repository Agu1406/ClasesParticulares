/*
E31 - Tabla fija del 7 (RESUELTO)

ENUNCIADO:
  Muestra la tabla de multiplicar del 7 (7 x 1 … 7 x 10) sin pedir datos.

EJEMPLO DE EJECUCION:
  7 x 1 = 7
  ...
  7 x 10 = 70

SOLUCION:
  Misma idea que E01 pero sin scanf.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    const int n = 7;
    for (int i = 1; i <= 10; i++) {
        printf("%d x %d = %d\n", n, i, n * i);
    }
    return 0;
}
