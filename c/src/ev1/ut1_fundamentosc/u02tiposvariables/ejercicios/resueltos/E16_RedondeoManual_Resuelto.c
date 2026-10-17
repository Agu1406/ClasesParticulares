/*
E16 - Redondeo manual con cast (RESUELTO)

ENUNCIADO:
  Redondea 7.6 y 7.4 al entero mas cercano SIN usar math.h:
  suma 0.5 y convierte a int con (int). Muestra ambos resultados.

EJEMPLO DE EJECUCION:
  7.6 -> 8
  7.4 -> 7

PISTA:
  (int)(x + 0.5) funciona para numeros positivos.

SOLUCION:
  El cast a int trunca; sumar 0.5 antes hace que trunque al entero mas cercano.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    double a = 7.6, b = 7.4;
    int ra = (int)(a + 0.5);
    int rb = (int)(b + 0.5);
    printf("%.1f -> %d\n", a, ra);
    printf("%.1f -> %d\n", b, rb);
    return 0;
}
