/*
E07 - Celsius a Fahrenheit y Kelvin (RESUELTO)

ENUNCIADO:
  Pide una temperatura en grados Celsius y muestrala en Fahrenheit (C * 9 / 5 + 32)
  y en Kelvin (C + 273.15).

EJEMPLO DE EJECUCION:
  Grados Celsius: 25
  Fahrenheit: 77.00
  Kelvin: 298.15

PISTA:
  Cuidado: 9 / 5 con enteros vale 1. Usa 9.0 / 5.0.

SOLUCION:
  Usar literales reales (9.0 / 5.0) evita la division entera.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    double celsius = 0;
    printf("Grados Celsius: ");
    scanf("%lf", &celsius);
    double fahrenheit = celsius * 9.0 / 5.0 + 32;
    double kelvin = celsius + 273.15;
    printf("Fahrenheit: %.2f\n", fahrenheit);
    printf("Kelvin: %.2f\n", kelvin);
    return 0;
}
