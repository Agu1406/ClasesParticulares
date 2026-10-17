/*
E11 - Par o impar mirando el ultimo bit (PENDIENTE)

ENUNCIADO:
  Pide un entero y di si es par o impar usando el operador & (bit a bit) en vez de %.
  Pista: un numero es impar si su ultimo bit vale 1.

EJEMPLO DE EJECUCION:
  Numero: 27
  27 es impar

PISTA:
  n & 1 vale 1 si n es impar y 0 si es par.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int n = 0;
    printf("Numero: ");
    scanf("%d", &n);
    // TODO: muestra si es par o impar usando n & 1
    return 0;
}
