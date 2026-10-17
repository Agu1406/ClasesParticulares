/*
E12 - Potencias de 2 con desplazamientos (RESUELTO)

ENUNCIADO:
  Muestra 2^0, 2^3, 2^8 y 2^16 usando el operador << (1 << n). Despues muestra
  40 multiplicado por 8 y dividido entre 4 usando solo desplazamientos.

EJEMPLO DE EJECUCION:
  2^0 = 1
  2^3 = 8
  2^8 = 256
  2^16 = 65536
  40 * 8 = 320
  40 / 4 = 10

PISTA:
  x << n equivale a x * 2^n y x >> n a x / 2^n.

SOLUCION:
  Desplazar a la izquierda multiplica por potencias de 2; a la derecha divide.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("2^0 = %d\n", 1 << 0);
    printf("2^3 = %d\n", 1 << 3);
    printf("2^8 = %d\n", 1 << 8);
    printf("2^16 = %d\n", 1 << 16);
    printf("40 * 8 = %d\n", 40 << 3);
    printf("40 / 4 = %d\n", 40 >> 2);
    return 0;
}
