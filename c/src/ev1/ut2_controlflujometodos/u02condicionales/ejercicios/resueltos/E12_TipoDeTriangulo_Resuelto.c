/*
E12 - Tipo de triangulo (RESUELTO)

ENUNCIADO:
  Pide los tres lados. Si no forman un triangulo (un lado >= suma de los otros dos)
  muestra 'No es un triangulo'; si si: equilatero, isosceles o escaleno.

EJEMPLO DE EJECUCION:
  Lados: 5 5 8
  Isosceles

PISTA:
  Un lado debe ser menor que la suma de los otros dos.

SOLUCION:
  Se comprueba primero la existencia y despues se cuenta cuantos lados son iguales.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int a = 0, b = 0, c = 0;
    printf("Lados: ");
    scanf("%d %d %d", &a, &b, &c);
    if (a + b <= c || a + c <= b || b + c <= a) {
        printf("No es un triangulo\n");
    } else if (a == b && b == c) {
        printf("Equilatero\n");
    } else if (a == b || a == c || b == c) {
        printf("Isosceles\n");
    } else {
        printf("Escaleno\n");
    }
    return 0;
}
