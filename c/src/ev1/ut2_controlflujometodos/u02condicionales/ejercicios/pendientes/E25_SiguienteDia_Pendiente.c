/*
E25 - Calcular el dia siguiente (PENDIENTE)

ENUNCIADO:
  Pide una fecha (dia mes anio) valida y muestra la del dia siguiente en formato d/m/aaaa.
  Ten en cuenta los meses de 28, 29, 30 y 31 dias y el cambio de ano.

EJEMPLO DE EJECUCION:
  Fecha: 31 12 2024
  Dia siguiente: 1/1/2025

PISTA:
  Calcula antes los dias del mes (con switch) y compara.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int dia = 0, mes = 0, anio = 0;
    printf("Fecha: ");
    scanf("%d %d %d", &dia, &mes, &anio);
    // TODO: calcula los dias del mes y la fecha del dia siguiente
    int dias_mes = 31;
    printf("Dia siguiente: %d/%d/%d\n", dia, mes, anio);
    return 0;
}
