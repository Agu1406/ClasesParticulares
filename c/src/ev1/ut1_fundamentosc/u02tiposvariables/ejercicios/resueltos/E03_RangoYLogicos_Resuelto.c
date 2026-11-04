/*
E03 - Rangos y operadores logicos (RESUELTO)

ENUNCIADO:
  adulto, joven (14..25) y puede_atraccion (altura y edad) con edad=17, altura=150.

SOLUCION:
  Rangos con &&; imprimir bools con %d.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>

int main(void) {
    int edad = 17;
    int altura_cm = 150;
    bool adulto = edad >= 18;
    bool joven = edad >= 14 && edad <= 25;
    bool puede_atraccion = altura_cm >= 140 && edad >= 12;

    printf("adulto: %d\n", adulto);
    printf("joven: %d\n", joven);
    printf("puede_atraccion: %d\n", puede_atraccion);
    return 0;
}
