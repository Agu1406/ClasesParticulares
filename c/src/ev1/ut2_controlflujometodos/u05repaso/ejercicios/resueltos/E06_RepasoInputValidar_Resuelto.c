/*
E06 - Validar un numero entre 1 y 10 (RESUELTO)

ENUNCIADO:
  Pide un numero entre 1 y 10 y repite la peticion mientras no sea valido. Al final muestra 'Valor aceptado: N'.

EJEMPLO DE EJECUCION:
  Numero (1-10): 0
  Numero (1-10): 15
  Numero (1-10): 7
  Valor aceptado: 7

PISTA:
  El do-while ejecuta el cuerpo al menos una vez.

SOLUCION:
  do { pedir } while (fuera de rango);

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int n = 0;
    do {
        printf("Numero (1-10): ");
        scanf("%d", &n);
    } while (n < 1 || n > 10);
    printf("Valor aceptado: %d\n", n);
    return 0;
}
