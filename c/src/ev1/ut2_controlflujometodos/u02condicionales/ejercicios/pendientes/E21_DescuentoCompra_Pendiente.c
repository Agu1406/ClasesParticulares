/*
E21 - Descuento por importe y socio (PENDIENTE)

ENUNCIADO:
  Pide el importe de la compra y si el cliente es socio (1/0). Descuentos:
  importe >= 100 -> 10%; >= 50 -> 5%; si es socio se suma un 3% extra. Muestra el total.

EJEMPLO DE EJECUCION:
  Importe y socio: 120 1
  Descuento: 13%
  Total: 104.40

PISTA:
  Calcula el porcentaje total y aplica (1 - porcentaje / 100).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    double importe = 0;
    int socio = 0;
    printf("Importe y socio: ");
    scanf("%lf %d", &importe, &socio);
    // TODO: calcula el porcentaje de descuento
    int descuento = 0;
    printf("Descuento: %d%%\n", descuento);
    printf("Total: %.2f\n", importe * (100 - descuento) / 100);
    return 0;
}
