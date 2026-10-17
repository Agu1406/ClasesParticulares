/*
E21 - Adivina el numero (RESUELTO)

ENUNCIADO:
  El numero secreto es 42. Pide intentos hasta acertar: indica 'Mas alto' o 'Mas bajo'
  en cada fallo y muestra el total de intentos al acertar.

EJEMPLO DE EJECUCION:
  Intento: 50 -> Mas bajo
  Intento: 30 -> Mas alto
  Intento: 42 -> Correcto en 3 intentos

PISTA:
  Cuenta los intentos con un contador.

SOLUCION:
  Un bucle repite hasta que el intento coincide con el secreto.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    const int SECRETO = 42;
    int intento = 0, intentos = 0;
    do {
        printf("Intento: ");
        if (scanf("%d", &intento) != 1) {
            printf("Entrada agotada\n");
            return 1;
        }
        intentos++;
        if (intento > SECRETO) {
            printf("Mas bajo\n");
        } else if (intento < SECRETO) {
            printf("Mas alto\n");
        }
    } while (intento != SECRETO);
    printf("Correcto en %d intentos\n", intentos);
    return 0;
}
