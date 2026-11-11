/*
E22 - Minutos a horas y minutos (RESUELTO)

ENUNCIADO:
  Pide un numero de minutos (int >= 0). Muestra horas y minutos restantes con / y %.

EJEMPLO DE EJECUCION:
  Minutos: 135
  2 h y 15 min

SOLUCION:
  Division entera y modulo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int minutos = 0;
    printf("Minutos: ");
    scanf("%d", &minutos);
    printf("%d h y %d min\n", minutos / 60, minutos % 60);
    return 0;
}
