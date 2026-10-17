/*
E06 - Precio con IVA (PENDIENTE)

ENUNCIADO:
  Pide el precio sin IVA y el porcentaje de IVA (por ejemplo 21).
  Muestra el importe del IVA y el precio final.

EJEMPLO DE EJECUCION:
  Precio sin IVA: 50
  IVA (%): 21
  Importe IVA: 10.50
  Precio final: 60.50

PISTA:
  importe = precio * porcentaje / 100

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    double precio = 0, porcentaje = 0;
    printf("Precio sin IVA: ");
    scanf("%lf", &precio);
    printf("IVA (%%): ");
    scanf("%lf", &porcentaje);
    // TODO: calcula el importe del IVA
    double importe = 0;
    printf("Importe IVA: %.2f\n", importe);
    printf("Precio final: %.2f\n", precio + importe);
    return 0;
}
