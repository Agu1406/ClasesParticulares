/*
E26 - Estacion del ano (RESUELTO)

ENUNCIADO:
  Pide un mes (1-12). Muestra Primavera (3-5), Verano (6-8), Otono (9-11) o Invierno (12,1,2). Si el mes no es valido: Mes no valido.

EJEMPLO DE EJECUCION:
  Mes: 7
  Verano

SOLUCION:
  Rangos con &&; 12/1/2 caen en el else final.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int mes = 0;
    printf("Mes: ");
    scanf("%d", &mes);
    if (mes < 1 || mes > 12) {
        printf("Mes no valido\n");
    } else if (mes >= 3 && mes <= 5) {
        printf("Primavera\n");
    } else if (mes >= 6 && mes <= 8) {
        printf("Verano\n");
    } else if (mes >= 9 && mes <= 11) {
        printf("Otono\n");
    } else {
        printf("Invierno\n");
    }
    return 0;
}
