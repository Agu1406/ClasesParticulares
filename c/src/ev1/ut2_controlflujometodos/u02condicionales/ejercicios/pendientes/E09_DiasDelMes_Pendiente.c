/*
E09 - Dias de un mes (PENDIENTE)

ENUNCIADO:
  Pide el mes (1-12) y el ano y muestra cuantos dias tiene (febrero depende de si el
  ano es bisiesto). Agrupa los meses de 30 dias con case sin break.

EJEMPLO DE EJECUCION:
  Mes y ano: 2 2024
  29 dias

PISTA:
  Bisiesto: (anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0

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
    // TODO: calcula los dias con un switch
    int dias = 0;
    if (dias == 0) {
        printf("Mes no valido\n");
    } else {
        printf("%d dias\n", dias);
    }
    return 0;
}
