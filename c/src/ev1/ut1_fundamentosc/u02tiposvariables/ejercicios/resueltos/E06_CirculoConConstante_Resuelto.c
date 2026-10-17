/*
E06 - Circulo con constante PI (RESUELTO)

ENUNCIADO:
  Declara const double PI = 3.14159265358979 y calcula la longitud y el area de un
  circulo de radio 3. Muestra ambos con 3 decimales.

EJEMPLO DE EJECUCION:
  Longitud: 18.850
  Area: 28.274

PISTA:
  longitud = 2 * PI * radio; area = PI * radio * radio

SOLUCION:
  PI es una constante: si intentas modificarla el compilador da error.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    const double PI = 3.14159265358979;
    double radio = 3;
    double longitud = 2 * PI * radio;
    double area = PI * radio * radio;
    printf("Longitud: %.3f\n", longitud);
    printf("Area: %.3f\n", area);
    return 0;
}
