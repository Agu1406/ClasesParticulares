/*
E08 - Copiar array (RESUELTO)

ENUNCIADO:
  Copia a[4]={1,2,3,4} en b[4] elemento a elemento y muestra b.

SOLUCION:
  Copia celda a celda.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int a[4] = {1, 2, 3, 4};
    int b[4];
    for (int i = 0; i < 4; i++) b[i] = a[i];
    for (int i = 0; i < 4; i++) {
        printf("%d", b[i]);
        if (i < 3) printf(" ");
    }
    printf("\n");
    return 0;
}
