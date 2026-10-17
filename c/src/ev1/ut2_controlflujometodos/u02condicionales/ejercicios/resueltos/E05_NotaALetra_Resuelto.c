/*
E05 - Nota numerica a calificacion (RESUELTO)

ENUNCIADO:
  Pide una nota (0-10) y muestra: Sobresaliente (>=9), Notable (>=7), Bien (>=6),
  Suficiente (>=5) o Insuficiente. Si esta fuera de 0-10 muestra 'Nota no valida'.

EJEMPLO DE EJECUCION:
  Nota: 6.5
  Bien

PISTA:
  Ordena las condiciones de mayor a menor.

SOLUCION:
  La cadena else if solo ejecuta la primera rama verdadera, por eso el orden importa.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    double nota = 0;
    printf("Nota: ");
    scanf("%lf", &nota);
    if (nota < 0 || nota > 10) {
        printf("Nota no valida\n");
    } else if (nota >= 9) {
        printf("Sobresaliente\n");
    } else if (nota >= 7) {
        printf("Notable\n");
    } else if (nota >= 6) {
        printf("Bien\n");
    } else if (nota >= 5) {
        printf("Suficiente\n");
    } else {
        printf("Insuficiente\n");
    }
    return 0;
}
