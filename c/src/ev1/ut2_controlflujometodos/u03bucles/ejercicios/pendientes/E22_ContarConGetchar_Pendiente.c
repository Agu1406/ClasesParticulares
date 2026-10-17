/*
E22 - Contar caracteres con getchar (PENDIENTE)

ENUNCIADO:
  Lee texto con getchar hasta el fin de linea. Cuenta cuantas letras, digitos y espacios
  hay y muestralo (usa comparaciones de rango sobre el char).

EJEMPLO DE EJECUCION:
  Texto: Hola 2024 mundo
  Letras: 9
  Digitos: 4
  Espacios: 2

PISTA:
  getchar() devuelve int; compara con '\n' y EOF.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int letras = 0, digitos = 0, espacios = 0;
    printf("Texto: ");
    int c;
    // TODO: lee con getchar y clasifica cada caracter
    printf("Letras: %d\n", letras);
    printf("Digitos: %d\n", digitos);
    printf("Espacios: %d\n", espacios);
    return 0;
}
