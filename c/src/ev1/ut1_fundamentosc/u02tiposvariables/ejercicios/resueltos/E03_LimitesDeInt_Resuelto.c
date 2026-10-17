/*
E03 - Limites de int y desbordamiento sin signo (RESUELTO)

ENUNCIADO:
  Muestra INT_MIN e INT_MAX (de <limits.h>) y el resultado de sumar 1 a un
  unsigned char que vale 255 (debe dar 0). Convierte el resultado a unsigned al imprimir.

EJEMPLO DE EJECUCION:
  INT_MIN = -2147483648
  INT_MAX = 2147483647
  255 + 1 = 0

PISTA:
  El tipo unsigned char da la vuelta al llegar a 255.

SOLUCION:
  Los tipos sin signo tienen aritmetica modular definida: 255 + 1 vuelve a 0.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <limits.h>

int main(void) {
    printf("INT_MIN = %d\n", INT_MIN);
    printf("INT_MAX = %d\n", INT_MAX);
    unsigned char byte = 255;
    byte = (unsigned char)(byte + 1);
    printf("255 + 1 = %u\n", (unsigned)byte);
    return 0;
}
