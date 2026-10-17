/*
E11 - Banner decorativo (RESUELTO)

ENUNCIADO:
  Dibuja este banner con printf (usa solo caracteres ASCII):
    ********************
    *   CLASE DE C     *
    *   BIENVENIDOS    *
    ********************

EJEMPLO DE EJECUCION:
  ********************
  *   CLASE DE C     *
  *   BIENVENIDOS    *
  ********************

PISTA:
  Cuenta los espacios para que el borde derecho quede alineado.

SOLUCION:
  Cada linea del banner es un printf; lo importante es cuidar los espacios.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("********************\n");
    printf("*   CLASE DE C     *\n");
    printf("*   BIENVENIDOS    *\n");
    printf("********************\n");
    return 0;
}
