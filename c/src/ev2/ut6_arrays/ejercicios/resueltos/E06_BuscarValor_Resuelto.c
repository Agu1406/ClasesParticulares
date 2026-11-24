/*
E06 - Buscar un valor (RESUELTO)

ENUNCIADO:
  Busca si aparece el valor 7 en {2,7,4,7,9}. Muestra la primera posicion o -1.

SOLUCION:
  Bandera/posicion.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int v[5] = {2, 7, 4, 7, 9};
    int pos = -1;
    for (int i = 0; i < 5; i++) {
        if (v[i] == 7) { pos = i; break; }
    }
    printf("Posicion: %d\n", pos);
    return 0;
}
