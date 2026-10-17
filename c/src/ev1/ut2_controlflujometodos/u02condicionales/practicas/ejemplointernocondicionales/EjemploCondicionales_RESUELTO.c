/*
Practica ejemplo (condicionales): billete de tren (RESUELTO)

ENUNCIADO:
  Calcula el precio de un billete de tren segun la edad, la clase y si es de ida y vuelta.

PISTA:
  Descuentos con else if de menor a mayor edad.

SOLUCION:
  Primero el precio base, luego el descuento por edad y por ultimo el recargo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <ctype.h>

int main(void) {
    int edad = 0;
    char clase = ' ';
    char ida_vuelta = ' ';
    printf("Edad: ");
    scanf("%d", &edad);
    printf("Clase (T/P): ");
    scanf(" %c", &clase);
    printf("Ida y vuelta (s/n): ");
    scanf(" %c", &ida_vuelta);

    if (edad < 0) {
        printf("Edad no valida\n");
        return 1;
    }
    double precio = 0.0;
    switch (toupper((unsigned char)clase)) {
        case 'T':
            precio = 40.0;
            break;
        case 'P':
            precio = 65.0;
            break;
        default:
            printf("Clase no valida\n");
            return 1;
    }
    if (edad < 4) {
        precio = 0.0;
    } else if (edad <= 12) {
        precio *= 0.5;
    } else if (edad >= 65) {
        precio *= 0.7;
    }
    if (ida_vuelta == 's' || ida_vuelta == 'S') {
        precio *= 1.8;
    }
    printf("Precio final: %.2f\n", precio);
    return 0;
}
