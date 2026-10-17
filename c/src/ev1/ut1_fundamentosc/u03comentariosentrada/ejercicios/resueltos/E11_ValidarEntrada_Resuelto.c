/*
E11 - Comprobar el retorno de scanf (RESUELTO)

ENUNCIADO:
  Pide un numero entero. Si scanf lee correctamente muestra su cuadrado; si no,
  muestra 'Entrada no valida'.

EJEMPLO DE EJECUCION:
  Numero: 9    ->  Cuadrado: 81
  Numero: hola ->  Entrada no valida

PISTA:
  scanf devuelve el numero de datos leidos: debe ser 1.

SOLUCION:
  if (scanf(...) == 1) distingue una lectura correcta de una entrada erronea.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int numero = 0;
    printf("Numero: ");
    if (scanf("%d", &numero) == 1) {
        printf("Cuadrado: %d\n", numero * numero);
    } else {
        printf("Entrada no valida\n");
    }
    return 0;
}
