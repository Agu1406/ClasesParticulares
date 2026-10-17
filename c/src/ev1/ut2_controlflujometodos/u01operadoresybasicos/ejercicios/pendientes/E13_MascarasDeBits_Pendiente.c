/*
E13 - Encender, apagar e invertir bits (PENDIENTE)

ENUNCIADO:
  Con unsigned int v = 10 (en binario 1010) haz y muestra el valor
  decimal tras cada paso: encender el bit 0, apagar el bit 1, invertir el bit 3.

EJEMPLO DE EJECUCION:
  Inicial: 10
  Encender bit 0: 11
  Apagar bit 1: 9
  Invertir bit 3: 1

PISTA:
  Encender: v |= (1u << n). Apagar: v &= ~(1u << n). Invertir: v ^= (1u << n).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    unsigned int v = 10;   // 1010 en binario
    printf("Inicial: %u\n", v);
    // TODO: enciende el bit 0
    printf("Encender bit 0: %u\n", v);
    // TODO: apaga el bit 1
    printf("Apagar bit 1: %u\n", v);
    // TODO: invierte el bit 3
    printf("Invertir bit 3: %u\n", v);
    return 0;
}
