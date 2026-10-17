/*
E16 - Redondeo manual con cast (PENDIENTE)

ENUNCIADO:
  Redondea 7.6 y 7.4 al entero mas cercano SIN usar math.h:
  suma 0.5 y convierte a int con (int). Muestra ambos resultados.

EJEMPLO DE EJECUCION:
  7.6 -> 8
  7.4 -> 7

PISTA:
  (int)(x + 0.5) funciona para numeros positivos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    double a = 7.6, b = 7.4;
    // TODO: redondea a y b
    int ra = 0;
    int rb = 0;
    printf("%.1f -> %d\n", a, ra);
    printf("%.1f -> %d\n", b, rb);
    return 0;
}
