/*
E02 - Saludo personalizado (RESUELTO)

ENUNCIADO:
  Pide el nombre (una palabra) y la ciudad (una palabra) y muestra:
    Hola <nombre>, que tal el tiempo en <ciudad>?

EJEMPLO DE EJECUCION:
  Nombre: Lucia
  Ciudad: Sevilla
  Hola Lucia, que tal el tiempo en Sevilla?

PISTA:
  Para cadenas se usa %s sin &, limitado: scanf("%29s", nombre);

SOLUCION:
  Un array de char guarda el texto; %29s limita la lectura al tamano del array.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    char nombre[30] = "";
    char ciudad[30] = "";
    printf("Nombre: ");
    scanf("%29s", nombre);
    printf("Ciudad: ");
    scanf("%29s", ciudad);
    printf("Hola %s, que tal el tiempo en %s?\n", nombre, ciudad);
    return 0;
}
