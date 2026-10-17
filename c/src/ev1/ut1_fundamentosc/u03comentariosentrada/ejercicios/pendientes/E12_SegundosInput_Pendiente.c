/*
E12 - Segundos a horas, minutos y segundos (PENDIENTE)

ENUNCIADO:
  Pide un numero de segundos y muestralo como h:mm:ss (con %02d en minutos y segundos).

EJEMPLO DE EJECUCION:
  Segundos: 3725
  Tiempo: 1:02:05

PISTA:
  horas = s / 3600; minutos = (s % 3600) / 60; segundos = s % 60

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
    // TODO: calcula horas, minutos y segundos
    int horas = 0;
    int minutos = 0;
    int segundos = 0;
    printf("Tiempo: %d:%02d:%02d\n", horas, minutos, segundos);
    return 0;
}
