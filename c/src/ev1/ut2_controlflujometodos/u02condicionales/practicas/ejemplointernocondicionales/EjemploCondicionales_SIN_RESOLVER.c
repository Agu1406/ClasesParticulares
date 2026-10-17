/*
Practica ejemplo (condicionales): billete de tren (SIN RESOLVER)

ENUNCIADO:
  Calcula el precio de un billete de tren segun la edad, la clase y si es de ida y vuelta.

PISTA:
  Descuentos con else if de menor a mayor edad.

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
    // TODO: precio base segun la clase con un switch
    precio = 0.0;
    // TODO: descuento por edad
    /* sin descuento */
    // TODO: recargo de ida y vuelta
    /* sin recargo */
    printf("Precio final: %.2f\n", precio);
    return 0;
}
