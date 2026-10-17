/*
E01 - Funcion void que saluda (RESUELTO)

ENUNCIADO:
  Escribe la funcion void saludar(const char *nombre) que muestre 'Hola, <nombre>!'.
  Llamala desde main con 'Ana' y 'Luis'.

EJEMPLO DE EJECUCION:
  Hola, Ana!
  Hola, Luis!

PISTA:
  Una funcion void no lleva return con valor.

SOLUCION:
  La funcion recibe el nombre como parametro y lo imprime.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

void saludar(const char *nombre);

int main(void) {
    saludar("Ana");
    saludar("Luis");
    return 0;
}

void saludar(const char *nombre) {
    printf("Hola, %s!\n", nombre);
}
