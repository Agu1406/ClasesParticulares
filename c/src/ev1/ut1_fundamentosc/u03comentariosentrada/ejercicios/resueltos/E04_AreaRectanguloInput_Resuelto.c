/*
E04 - Area y perimetro con datos del usuario (RESUELTO)

ENUNCIADO:
  Pide la base y la altura de un rectangulo (numeros reales) y muestra el area y el
  perimetro con dos decimales.

EJEMPLO DE EJECUCION:
  Base: 6.5
  Altura: 4
  Area: 26.00
  Perimetro: 21.00

PISTA:
  Un double se lee con %lf (con ele) en scanf.

SOLUCION:
  scanf("%lf") lee un double; printf usa %f o %.2f para escribirlo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    double base = 0, altura = 0;
    printf("Base: ");
    scanf("%lf", &base);
    printf("Altura: ");
    scanf("%lf", &altura);
    printf("Area: %.2f\n", base * altura);
    printf("Perimetro: %.2f\n", 2 * (base + altura));
    return 0;
}
