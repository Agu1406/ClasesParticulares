/*
E14 - Vocal, consonante u otro caracter (RESUELTO)

ENUNCIADO:
  Pide un caracter. Si es vocal (mayuscula o minuscula) muestra 'Vocal'; si es otra
  letra 'Consonante'; si no es letra 'No es una letra'. Usa switch para las vocales.

EJEMPLO DE EJECUCION:
  Letra: E
  Vocal

PISTA:
  Agrupa case 'a': case 'A': ... sin break entre ellos.

SOLUCION:
  El switch decide las vocales y el default comprueba si es letra con comparaciones.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    char c = ' ';
    printf("Letra: ");
    scanf(" %c", &c);
    switch (c) {
        case 'a': case 'e': case 'i': case 'o': case 'u':
        case 'A': case 'E': case 'I': case 'O': case 'U':
            printf("Vocal\n");
            break;
        default:
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                printf("Consonante\n");
            } else {
                printf("No es una letra\n");
            }
            break;
    }
    return 0;
}
