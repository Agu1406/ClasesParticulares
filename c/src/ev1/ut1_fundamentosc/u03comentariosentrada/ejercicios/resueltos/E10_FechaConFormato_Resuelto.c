/*
E10 - Leer una fecha dd/mm/aaaa (RESUELTO)

ENUNCIADO:
  Pide una fecha en formato dd/mm/aaaa (con las barras) leyendola con UN solo scanf
  y muestrala como 'aaaa-mm-dd' con el mes y el dia de dos cifras.

EJEMPLO DE EJECUCION:
  Fecha (dd/mm/aaaa): 5/3/2025
  Formato ISO: 2025-03-05

PISTA:
  scanf("%d/%d/%d", &dia, &mes, &anio); y en printf usa %02d.

SOLUCION:
  Las barras del formato de scanf deben coincidir con las que escribe el usuario.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int dia = 0, mes = 0, anio = 0;
    printf("Fecha (dd/mm/aaaa): ");
    scanf("%d/%d/%d", &dia, &mes, &anio);
    printf("Formato ISO: %d-%02d-%02d\n", anio, mes, dia);
    return 0;
}
