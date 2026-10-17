/*
E04 - Columnas con tabulador (RESUELTO)

ENUNCIADO:
  Muestra la siguiente tabla separando las columnas con el tabulador \t:
    Nombre<TAB>Edad
    Ana<TAB>20
    Luis<TAB>22

EJEMPLO DE EJECUCION:
  Nombre	Edad
  Ana	20
  Luis	22

PISTA:
  El tabulador se escribe con la secuencia de escape \t.

SOLUCION:
  \t avanza hasta la siguiente tabulacion; las columnas quedan alineadas.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("Nombre\tEdad\n");
    printf("Ana\t20\n");
    printf("Luis\t22\n");
    return 0;
}
