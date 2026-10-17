/*
Practica ejemplo (operadores): conversor de segundos (SIN RESOLVER)

ENUNCIADO:
  Lee un numero de segundos y conviertelo a dias, horas, minutos y segundos usando / y %.
  Muestra ademas si el numero es par o impar y si es multiplo de 8 usando operadores bit a bit.

PISTA:
  Horas = total / 3600; minutos = (total % 3600) / 60.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    long total = 0;
    printf("Segundos: ");
    if (scanf("%ld", &total) != 1 || total < 0) {
        printf("Valor no valido\n");
        return 1;
    }
    // TODO: calcula horas, minutos, segundos, dias y horas sobrantes
    long horas = 0, minutos = 0, segundos = 0, dias = 0, resto_h = 0;
    printf("%ld segundos = %ld h %ld min %ld s\n", total, horas, minutos, segundos);
    printf("= %ld dia(s) y %ld h\n", dias, resto_h);
    // TODO: par o impar con el operador &
    printf("(sin hacer)\n");
    // TODO: multiplo de 8 con el operador &
    printf("(sin hacer)\n");
    return 0;
}
