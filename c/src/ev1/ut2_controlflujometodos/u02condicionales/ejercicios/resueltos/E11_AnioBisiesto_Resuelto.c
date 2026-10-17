/*
E11 - Ano bisiesto (RESUELTO)

ENUNCIADO:
  Pide un ano y di si es bisiesto (divisible entre 4, salvo siglos no divisibles entre 400).

EJEMPLO DE EJECUCION:
  Ano: 1900
  1900 NO es bisiesto

PISTA:
  Prueba con 2000, 1900, 2024 y 2023.

SOLUCION:
  La regla se resuelve con una unica expresion logica.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int anio = 0;
    printf("Ano: ");
    scanf("%d", &anio);
    if ((anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0) {
        printf("%d es bisiesto\n", anio);
    } else {
        printf("%d NO es bisiesto\n", anio);
    }
    return 0;
}
