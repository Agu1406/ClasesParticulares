/*
E03 - Dia de la semana con switch (RESUELTO)

ENUNCIADO:
  Pide un numero del 1 al 7 y muestra el dia de la semana (1 = Lunes). Cualquier otro numero: 'Dia no valido'.

EJEMPLO DE EJECUCION:
  Dia: 3
  Miercoles

PISTA:
  Usa switch con default.

SOLUCION:
  Un case por dia, sin olvidar el break.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int dia = 0;
    printf("Dia: ");
    scanf("%d", &dia);
    switch (dia) {
        case 1: printf("Lunes\n"); break;
        case 2: printf("Martes\n"); break;
        case 3: printf("Miercoles\n"); break;
        case 4: printf("Jueves\n"); break;
        case 5: printf("Viernes\n"); break;
        case 6: printf("Sabado\n"); break;
        case 7: printf("Domingo\n"); break;
        default: printf("Dia no valido\n"); break;
    }
    return 0;
}
