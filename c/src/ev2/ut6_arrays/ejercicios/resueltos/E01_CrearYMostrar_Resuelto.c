/*
E01 - Crear y mostrar array (RESUELTO)

ENUNCIADO:
  Declara int v[5] = {2,4,6,8,10} y muestra todos los elementos con su indice.

SOLUCION:
  Recorrido basico.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int v[5] = {2, 4, 6, 8, 10};
    for (int i = 0; i < 5; i++) {
        printf("v[%d]=%d\n", i, v[i]);
    }
    return 0;
}
