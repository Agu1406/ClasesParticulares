/*
E08 - Dia de la semana con switch (RESUELTO)

ENUNCIADO:
  Pide un numero del 1 al 7 y muestra el dia (1 = lunes). Para 6 y 7 muestra
  'sabado (fin de semana)' y 'domingo (fin de semana)'. Otro valor: 'Dia no valido'.

EJEMPLO DE EJECUCION:
  Dia: 6
  sabado (fin de semana)

PISTA:
  Usa switch con un break en cada case.

SOLUCION:
  switch evita una cadena larga de if cuando se comparan valores exactos.

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
        case 1: printf("lunes\n"); break;
        case 2: printf("martes\n"); break;
        case 3: printf("miercoles\n"); break;
        case 4: printf("jueves\n"); break;
        case 5: printf("viernes\n"); break;
        case 6: printf("sabado (fin de semana)\n"); break;
        case 7: printf("domingo (fin de semana)\n"); break;
        default: printf("Dia no valido\n"); break;
    }
    return 0;
}
