/*
E18 - Tarifa de taxi (PENDIENTE)

ENUNCIADO:
  Pide los km recorridos y si es de noche (1 = si, 0 = no). Tarifa: bajada 3.00,
  1.20 por km los 10 primeros y 0.90 por km el resto. De noche se suma un 20%.

EJEMPLO DE EJECUCION:
  Km y noche: 14 1
  Total: 22.32

PISTA:
  Calcula por tramos: min(km, 10) y max(km - 10, 0).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    double km = 0;
    int noche = 0;
    printf("Km y noche: ");
    scanf("%lf %d", &km, &noche);
    // TODO: calcula el total
    double total = 0;
    printf("Total: %.2f\n", total);
    return 0;
}
