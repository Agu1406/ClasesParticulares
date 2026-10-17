/*
E14 - Adivina el numero secreto (PENDIENTE)

ENUNCIADO:
  El numero secreto es 42. Lee intentos hasta acertar.
  Si el intento es mayor muestra 'Demasiado alto', si es menor 'Demasiado bajo'.
  Al acertar muestra 'Acertaste en N intentos'.

EJEMPLO DE EJECUCION:
  Intento: 50
  Demasiado alto
  Intento: 30
  Demasiado bajo
  Intento: 42
  Acertaste en 3 intentos

PISTA:
  Un contador de intentos y un do-while.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    const int secreto = 42;
    int intento = 0;
    int intentos = 0;
    // TODO: pide intentos hasta acertar y da pistas
    printf("Acertaste en %d intentos\n", intentos);
    return 0;
}
