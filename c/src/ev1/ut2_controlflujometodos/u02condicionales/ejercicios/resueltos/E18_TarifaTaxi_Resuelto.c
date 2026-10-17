/*
E18 - Tarifa de taxi (RESUELTO)

ENUNCIADO:
  Pide los km recorridos y si es de noche (1 = si, 0 = no). Tarifa: bajada 3.00,
  1.20 por km los 10 primeros y 0.90 por km el resto. De noche se suma un 20%.

EJEMPLO DE EJECUCION:
  Km y noche: 14 1
  Total: 22.32

PISTA:
  Calcula por tramos: min(km, 10) y max(km - 10, 0).

SOLUCION:
  Dos tramos de precio y un recargo condicional.

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
    double total = 3.0;
    if (km <= 10) {
        total += km * 1.20;
    } else {
        total += 10 * 1.20 + (km - 10) * 0.90;
    }
    if (noche == 1) {
        total *= 1.20;
    }
    printf("Total: %.2f\n", total);
    return 0;
}
