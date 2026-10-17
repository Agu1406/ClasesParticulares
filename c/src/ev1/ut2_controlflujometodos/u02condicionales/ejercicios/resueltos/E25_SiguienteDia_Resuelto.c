/*
E25 - Calcular el dia siguiente (RESUELTO)

ENUNCIADO:
  Pide una fecha (dia mes anio) valida y muestra la del dia siguiente en formato d/m/aaaa.
  Ten en cuenta los meses de 28, 29, 30 y 31 dias y el cambio de ano.

EJEMPLO DE EJECUCION:
  Fecha: 31 12 2024
  Dia siguiente: 1/1/2025

PISTA:
  Calcula antes los dias del mes (con switch) y compara.

SOLUCION:
  Se suma 1 al dia y se reinicia el dia/mes/ano cuando se pasa del final del mes/ano.

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
    int dias_mes;
    switch (mes) {
        case 4: case 6: case 9: case 11: dias_mes = 30; break;
        case 2: dias_mes = ((anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0) ? 29 : 28; break;
        default: dias_mes = 31; break;
    }
    dia++;
    if (dia > dias_mes) {
        dia = 1;
        mes++;
        if (mes > 12) {
            mes = 1;
            anio++;
        }
    }
    printf("Dia siguiente: %d/%d/%d\n", dia, mes, anio);
    return 0;
}
