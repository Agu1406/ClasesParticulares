/*
E29 - Calificacion A-F sobre 100 (RESUELTO)

ENUNCIADO:
  Pide una nota entera 0-100. Muestra A (>=90), B (>=80), C (>=70), D (>=60) o F. Fuera de rango: Nota no valida.

EJEMPLO DE EJECUCION:
  Nota: 83
  B

SOLUCION:
  Misma idea que nota a texto, escala 100.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int nota = 0;
    printf("Nota: ");
    scanf("%d", &nota);
    if (nota < 0 || nota > 100) {
        printf("Nota no valida\n");
    } else if (nota >= 90) {
        printf("A\n");
    } else if (nota >= 80) {
        printf("B\n");
    } else if (nota >= 70) {
        printf("C\n");
    } else if (nota >= 60) {
        printf("D\n");
    } else {
        printf("F\n");
    }
    return 0;
}
