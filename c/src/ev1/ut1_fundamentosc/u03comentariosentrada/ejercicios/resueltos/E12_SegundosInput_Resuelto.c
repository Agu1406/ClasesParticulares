/*
E12 - Segundos a horas, minutos y segundos (RESUELTO)

ENUNCIADO:
  Pide un numero de segundos y muestralo como h:mm:ss (con %02d en minutos y segundos).

EJEMPLO DE EJECUCION:
  Segundos: 3725
  Tiempo: 1:02:05

PISTA:
  horas = s / 3600; minutos = (s % 3600) / 60; segundos = s % 60

SOLUCION:
  Division entera y resto encadenados.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int total = 0;
    printf("Segundos: ");
    scanf("%d", &total);
    int horas = total / 3600;
    int minutos = (total % 3600) / 60;
    int segundos = total % 60;
    printf("Tiempo: %d:%02d:%02d\n", horas, minutos, segundos);
    return 0;
}
