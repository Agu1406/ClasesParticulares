/*
E15 - Calculadora por lineas (PENDIENTE)

ENUNCIADO:
  Lee operaciones con el formato: operador numero1 numero2 (por ejemplo + 6 3).
  Soporta + - * / y muestra el resultado con 2 decimales. Si divide entre 0 muestra 'No se puede dividir entre 0'.
  El operador 'q' termina el programa. Cualquier otro: 'Operador no valido'.

EJEMPLO DE EJECUCION:
  > + 6 3
  Resultado: 9.00
  > / 8 0
  No se puede dividir entre 0
  > q

PISTA:
  Lee el operador con " %c" (el espacio salta los saltos de linea).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    char op = ' ';
    while (1) {
        printf("> ");
        if (scanf(" %c", &op) != 1 || op == 'q') {
            break;
        }
        double a = 0.0;
        double b = 0.0;
        scanf("%lf %lf", &a, &b);
        // TODO: calcula segun el operador
    }
    printf("Fin\n");
    return 0;
}
