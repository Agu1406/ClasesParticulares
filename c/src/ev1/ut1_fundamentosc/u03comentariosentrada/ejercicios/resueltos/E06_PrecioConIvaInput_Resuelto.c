/*
E06 - Precio con IVA (RESUELTO)

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

SOLUCION:
  El porcentaje se divide entre 100 para obtener el factor.

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
    double importe = precio * porcentaje / 100;
    printf("Importe IVA: %.2f\n", importe);
    printf("Precio final: %.2f\n", precio + importe);
    return 0;
}
