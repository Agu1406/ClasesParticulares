/*
E08 - Tabla alineada con anchuras (PENDIENTE)

ENUNCIADO:
  Muestra esta tabla usando anchuras de campo: %-10s para el texto (alineado a la
  izquierda) y %6.2f para el precio (6 columnas, 2 decimales):
    Producto   Precio
    Cafe         1.50
    Tostada      2.25
    Zumo         3.00

EJEMPLO DE EJECUCION:
  Producto   Precio
  Cafe         1.50
  Tostada      2.25
  Zumo         3.00

PISTA:
  printf("%-10s %6.2f\n", "Cafe", 1.5);

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("%-10s %6s\n", "Producto", "Precio");
    // TODO: muestra las tres filas con %-10s y %6.2f
    return 0;
}
