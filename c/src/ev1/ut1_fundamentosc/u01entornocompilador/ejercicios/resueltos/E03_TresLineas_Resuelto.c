/*
E03 - Tres lineas con un solo printf (RESUELTO)

ENUNCIADO:
  Muestra tu nombre, tu ciudad y tu modulo en tres lineas distintas usando
  UN UNICO printf (el salto de linea se escribe dentro de la cadena).

EJEMPLO DE EJECUCION:
  Nombre: Lucia
  Ciudad: Madrid
  Modulo: Programacion

PISTA:
  Cada \n dentro de la misma cadena produce una nueva linea.

SOLUCION:
  Una cadena puede contener varios \n: printf los interpreta todos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("Nombre: Lucia\nCiudad: Madrid\nModulo: Programacion\n");
    return 0;
}
