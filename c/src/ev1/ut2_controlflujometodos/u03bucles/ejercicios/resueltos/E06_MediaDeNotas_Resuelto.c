/*
E06 - Media de N notas (RESUELTO)

ENUNCIADO:
  Pide cuantas notas hay (n > 0) y despues las n notas (reales). Muestra la media con 2 decimales.

EJEMPLO DE EJECUCION:
  Cuantas: 3
  Nota 1: 7
  Nota 2: 5.5
  Nota 3: 9
  Media: 7.17

PISTA:
  Acumula la suma y divide entre n al final.

SOLUCION:
  Un for de n vueltas lee y acumula las notas.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int n = 0;
    printf("Cuantas: ");
    scanf("%d", &n);
    if (n <= 0) {
        printf("Debe haber al menos una nota\n");
        return 1;
    }
    double suma = 0;
    for (int i = 1; i <= n; i++) {
        double nota = 0;
        printf("Nota %d: ", i);
        scanf("%lf", &nota);
        suma += nota;
    }
    printf("Media: %.2f\n", suma / n);
    return 0;
}
