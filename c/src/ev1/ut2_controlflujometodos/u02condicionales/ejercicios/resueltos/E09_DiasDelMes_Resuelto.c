/*
E09 - Dias de un mes (RESUELTO)

ENUNCIADO:
  Pide el mes (1-12) y el ano y muestra cuantos dias tiene (febrero depende de si el
  ano es bisiesto). Agrupa los meses de 30 dias con case sin break.

EJEMPLO DE EJECUCION:
  Mes y ano: 2 2024
  29 dias

PISTA:
  Bisiesto: (anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0

SOLUCION:
  Los cases consecutivos sin break comparten el mismo bloque.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int mes = 0, anio = 0;
    printf("Mes y ano: ");
    scanf("%d %d", &mes, &anio);
    int dias = 0;
    switch (mes) {
        case 4: case 6: case 9: case 11:
            dias = 30;
            break;
        case 2:
            dias = ((anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0) ? 29 : 28;
            break;
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            dias = 31;
            break;
        default:
            dias = 0;
            break;
    }
    if (dias == 0) {
        printf("Mes no valido\n");
    } else {
        printf("%d dias\n", dias);
    }
    return 0;
}
