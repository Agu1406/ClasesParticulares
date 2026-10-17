/*
E07 - Decimales con %.2f (RESUELTO)

ENUNCIADO:
  Declara double precio = 19.5 y double iva = 0.21.
  Muestra el precio y el IVA con DOS decimales:
    Precio: 19.50
    IVA: 0.21

EJEMPLO DE EJECUCION:
  Precio: 19.50
  IVA: 0.21

PISTA:
  %.2f indica dos decimales.

SOLUCION:
  %.2f redondea y muestra siempre dos decimales (19.5 -> 19.50).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    double precio = 19.5;
    double iva = 0.21;
    printf("Precio: %.2f\n", precio);
    printf("IVA: %.2f\n", iva);
    return 0;
}
