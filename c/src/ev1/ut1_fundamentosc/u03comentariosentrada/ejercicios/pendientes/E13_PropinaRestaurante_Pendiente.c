/*
E13 - Cuenta del restaurante con propina (PENDIENTE)

ENUNCIADO:
  Pide el importe de la cuenta, el porcentaje de propina y el numero de comensales.
  Muestra la propina, el total y lo que paga cada comensal.

EJEMPLO DE EJECUCION:
  Cuenta: 84
  Propina (%): 10
  Comensales: 4
  Propina: 8.40
  Total: 92.40
  Cada uno paga: 23.10

PISTA:
  Reparte con division real para no perder decimales.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    double cuenta = 0, porcentaje = 0;
    int comensales = 1;
    printf("Cuenta: ");
    scanf("%lf", &cuenta);
    printf("Propina (%%): ");
    scanf("%lf", &porcentaje);
    printf("Comensales: ");
    scanf("%d", &comensales);
    // TODO: calcula propina, total y pago por persona
    double propina = 0;
    double total = 0;
    double por_persona = 0;
    printf("Propina: %.2f\n", propina);
    printf("Total: %.2f\n", total);
    printf("Cada uno paga: %.2f\n", por_persona);
    return 0;
}
