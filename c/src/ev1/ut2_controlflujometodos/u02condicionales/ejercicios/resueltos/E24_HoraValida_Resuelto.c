/*
E24 - Validar una hora (RESUELTO)

ENUNCIADO:
  Pide una hora con formato h:m:s (por ejemplo 23:59:07). Comprueba que las horas esten
  entre 0 y 23, y los minutos y segundos entre 0 y 59. Muestra 'Hora valida' o 'Hora no valida'.

EJEMPLO DE EJECUCION:
  Hora (h:m:s): 24:10:00
  Hora no valida

PISTA:
  scanf("%d:%d:%d", &h, &m, &s) devuelve 3 si el formato es correcto.

SOLUCION:
  Se valida el formato (retorno de scanf) y despues cada rango.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int h = 0, m = 0, s = 0;
    printf("Hora (h:m:s): ");
    int leidos = scanf("%d:%d:%d", &h, &m, &s);
    if (leidos == 3 && h >= 0 && h <= 23 && m >= 0 && m <= 59 && s >= 0 && s <= 59) {
        printf("Hora valida\n");
    } else {
        printf("Hora no valida\n");
    }
    return 0;
}
