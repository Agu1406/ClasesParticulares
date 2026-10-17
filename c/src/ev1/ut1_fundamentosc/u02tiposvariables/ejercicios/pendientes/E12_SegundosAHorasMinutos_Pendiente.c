/*
E12 - Segundos a horas, minutos y segundos (PENDIENTE)

ENUNCIADO:
  Convierte 7384 segundos a horas, minutos y segundos usando / y %.

EJEMPLO DE EJECUCION:
  7384 s = 2 h 3 min 4 s

PISTA:
  horas = total / 3600; minutos = (total % 3600) / 60; segundos = total % 60

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int total = 7384;
    // TODO: calcula horas, minutos y segundos
    int horas = 0;
    int minutos = 0;
    int segundos = 0;
    printf("%d s = %d h %d min %d s\n", total, horas, minutos, segundos);
    return 0;
}
