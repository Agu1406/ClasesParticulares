/*
E10 - Calculadora con switch (RESUELTO)

ENUNCIADO:
  Pide una operacion con el formato 'numero operador numero' (+ - * /) y muestra el
  resultado con 2 decimales. Controla la division entre cero y los operadores desconocidos.

EJEMPLO DE EJECUCION:
  Operacion: 9 / 4
  Resultado: 2.25

PISTA:
  scanf("%lf %c %lf", &a, &op, &b);

SOLUCION:
  El char del operador decide el case; la division necesita su propia comprobacion.

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
    switch (op) {
        case '+': printf("Resultado: %.2f\n", a + b); break;
        case '-': printf("Resultado: %.2f\n", a - b); break;
        case '*': printf("Resultado: %.2f\n", a * b); break;
        case '/':
            if (b == 0) {
                printf("Error: division entre cero\n");
            } else {
                printf("Resultado: %.2f\n", a / b);
            }
            break;
        default:
            printf("Operador no valido\n");
            break;
    }
    return 0;
}
