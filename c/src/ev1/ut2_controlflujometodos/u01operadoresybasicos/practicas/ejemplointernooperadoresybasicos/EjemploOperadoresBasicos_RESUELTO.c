/*
Practica ejemplo (operadores): conversor de segundos (RESUELTO)

ENUNCIADO:
  Lee un numero de segundos y conviertelo a dias, horas, minutos y segundos usando / y %.
  Muestra ademas si el numero es par o impar y si es multiplo de 8 usando operadores bit a bit.

PISTA:
  Horas = total / 3600; minutos = (total % 3600) / 60.

SOLUCION:
  Division entera para cada unidad y resto para lo que queda.

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
    long horas = total / 3600;
    long minutos = (total % 3600) / 60;
    long segundos = total % 60;
    long dias = horas / 24;
    long resto_h = horas % 24;
    printf("%ld segundos = %ld h %ld min %ld s\n", total, horas, minutos, segundos);
    printf("= %ld dia(s) y %ld h\n", dias, resto_h);
    printf("%s\n", (total & 1) ? "Es impar" : "Es par");
    printf("Multiplo de 8: %s\n", (total & 7) == 0 ? "si" : "no");
    return 0;
}
