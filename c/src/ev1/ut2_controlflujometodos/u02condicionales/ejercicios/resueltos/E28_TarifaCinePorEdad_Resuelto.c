/*
E28 - Tarifa de cine por edad (RESUELTO)

ENUNCIADO:
  Pide la edad. Precio: <4 gratis (0.00); 4-17 -> 5.50; 18-64 -> 8.00; >=65 -> 4.00. Edad negativa: Edad no valida.

EJEMPLO DE EJECUCION:
  Edad: 70
  Precio: 4.00

SOLUCION:
  Franjas exclusivas con else if.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int edad = 0;
    double precio = 0.0;
    printf("Edad: ");
    scanf("%d", &edad);
    if (edad < 0) {
        printf("Edad no valida\n");
    } else {
        if (edad < 4) {
            precio = 0.0;
        } else if (edad <= 17) {
            precio = 5.50;
        } else if (edad <= 64) {
            precio = 8.00;
        } else {
            precio = 4.00;
        }
        printf("Precio: %.2f\n", precio);
    }
    return 0;
}
