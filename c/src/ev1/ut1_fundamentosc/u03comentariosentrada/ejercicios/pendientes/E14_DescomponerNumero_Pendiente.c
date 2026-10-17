/*
E14 - Cifras de un numero de tres digitos (PENDIENTE)

ENUNCIADO:
  Pide un numero de tres cifras y muestra por separado centenas, decenas y unidades
  y la suma de sus cifras (usa / y %).

EJEMPLO DE EJECUCION:
  Numero: 472
  Centenas: 4
  Decenas: 7
  Unidades: 2
  Suma de cifras: 13

PISTA:
  unidades = n % 10; decenas = (n / 10) % 10; centenas = n / 100

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int n = 0;
    printf("Numero: ");
    scanf("%d", &n);
    // TODO: separa centenas, decenas y unidades
    int centenas = 0;
    int decenas = 0;
    int unidades = 0;
    printf("Centenas: %d\n", centenas);
    printf("Decenas: %d\n", decenas);
    printf("Unidades: %d\n", unidades);
    printf("Suma de cifras: %d\n", centenas + decenas + unidades);
    return 0;
}
