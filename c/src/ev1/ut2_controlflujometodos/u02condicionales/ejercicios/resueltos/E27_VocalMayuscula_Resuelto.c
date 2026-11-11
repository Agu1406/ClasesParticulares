/*
E27 - Vocal en mayuscula (RESUELTO)

ENUNCIADO:
  Pide un caracter. Si es vocal MAYUSCULA (A E I O U) muestra Vocal mayuscula; si es vocal minuscula, Vocal minuscula; si es otra letra, Otra letra; si no es letra, No es letra.

EJEMPLO DE EJECUCION:
  Letra: A
  Vocal mayuscula

SOLUCION:
  isalpha + toupper para no repetir mayus/minus.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <ctype.h>

int main(void) {
    char c = ' ';
    printf("Letra: ");
    scanf(" %c", &c);
    if (!isalpha((unsigned char)c)) {
        printf("No es letra\n");
    } else {
        char u = (char)toupper((unsigned char)c);
        if (u == 'A' || u == 'E' || u == 'I' || u == 'O' || u == 'U') {
            if (isupper((unsigned char)c)) {
                printf("Vocal mayuscula\n");
            } else {
                printf("Vocal minuscula\n");
            }
        } else {
            printf("Otra letra\n");
        }
    }
    return 0;
}
