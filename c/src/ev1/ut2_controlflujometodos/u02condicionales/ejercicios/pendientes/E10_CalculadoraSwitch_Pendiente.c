/*
E10 - Calculadora con switch (PENDIENTE)

ENUNCIADO:
  Pide una operacion con el formato 'numero operador numero' (+ - * /) y muestra el
  resultado con 2 decimales. Controla la division entre cero y los operadores desconocidos.

EJEMPLO DE EJECUCION:
  Operacion: 9 / 4
  Resultado: 2.25

PISTA:
  scanf("%lf %c %lf", &a, &op, &b);

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    double a = 0, b = 0;
    char op = ' ';
    printf("Operacion: ");
    scanf("%lf %c %lf", &a, &op, &b);
    // TODO: calcula segun el operador con un switch
    return 0;
}
