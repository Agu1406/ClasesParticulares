/*
E21 - Descuento por importe y socio (RESUELTO)

ENUNCIADO:
  Pide el importe de la compra y si el cliente es socio (1/0). Descuentos:
  importe >= 100 -> 10%; >= 50 -> 5%; si es socio se suma un 3% extra. Muestra el total.

EJEMPLO DE EJECUCION:
  Importe y socio: 120 1
  Descuento: 13%
  Total: 104.40

PISTA:
  Calcula el porcentaje total y aplica (1 - porcentaje / 100).

SOLUCION:
  Primero se decide el descuento y luego se aplica una sola vez.

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
    int descuento = 0;
    if (importe >= 100) {
        descuento = 10;
    } else if (importe >= 50) {
        descuento = 5;
    }
    if (socio == 1) {
        descuento += 3;
    }
    printf("Descuento: %d%%\n", descuento);
    printf("Total: %.2f\n", importe * (100 - descuento) / 100);
    return 0;
}
