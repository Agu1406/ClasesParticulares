/*
E05 - Area y perimetro de un rectangulo (RESUELTO)

ENUNCIADO:
  Un rectangulo mide 8.5 de base y 4 de altura. Calcula y muestra su area y su
  perimetro con dos decimales.

EJEMPLO DE EJECUCION:
  Area: 34.00
  Perimetro: 25.00

PISTA:
  area = base * altura; perimetro = 2 * (base + altura)

SOLUCION:
  Se guardan los resultados en variables antes de mostrarlos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    double base = 8.5, altura = 4;
    double area = base * altura;
    double perimetro = 2 * (base + altura);
    printf("Area: %.2f\n", area);
    printf("Perimetro: %.2f\n", perimetro);
    return 0;
}
