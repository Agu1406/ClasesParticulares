/*
E05 - Media de tres notas (RESUELTO)

ENUNCIADO:
  Pide tres notas (reales) y muestra la media con dos decimales.
  Muestra tambien si el modulo esta aprobado (media >= 5) como SI o NO.

EJEMPLO DE EJECUCION:
  Nota 1: 6
  Nota 2: 4.5
  Nota 3: 7
  Media: 5.83
  Aprobado: SI

PISTA:
  Usa el operador ternario: media >= 5 ? "SI" : "NO".

SOLUCION:
  Se suma todo y se divide entre 3.0 (real) para no perder decimales.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    double n1 = 0, n2 = 0, n3 = 0;
    printf("Nota 1: ");
    scanf("%lf", &n1);
    printf("Nota 2: ");
    scanf("%lf", &n2);
    printf("Nota 3: ");
    scanf("%lf", &n3);
    double media = (n1 + n2 + n3) / 3;
    printf("Media: %.2f\n", media);
    printf("Aprobado: %s\n", media >= 5 ? "SI" : "NO");
    return 0;
}
