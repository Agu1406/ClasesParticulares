/*
E08 - Potencias y raices (RESUELTO)

ENUNCIADO:
  Muestra una pequena tabla con n, n al cuadrado, n al cubo y la raiz cuadrada de n
  para n = 1, 2, 3, 4 y 5 (sin bucles: cinco printf). Raiz con 3 decimales.

EJEMPLO DE EJECUCION:
  n=1  cuad=1  cubo=1  raiz=1.000
  ...
  n=5  cuad=25  cubo=125  raiz=2.236

PISTA:
  pow(n, 3) devuelve un double; usa %.0f para mostrarlo sin decimales.

SOLUCION:
  Una linea por valor de n; en la siguiente unidad lo haras con un bucle for.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <math.h>

int main(void) {
    printf("n=%d  cuad=%.0f  cubo=%.0f  raiz=%.3f\n", 1, pow(1, 2), pow(1, 3), sqrt(1));
    printf("n=%d  cuad=%.0f  cubo=%.0f  raiz=%.3f\n", 2, pow(2, 2), pow(2, 3), sqrt(2));
    printf("n=%d  cuad=%.0f  cubo=%.0f  raiz=%.3f\n", 3, pow(3, 2), pow(3, 3), sqrt(3));
    printf("n=%d  cuad=%.0f  cubo=%.0f  raiz=%.3f\n", 4, pow(4, 2), pow(4, 3), sqrt(4));
    printf("n=%d  cuad=%.0f  cubo=%.0f  raiz=%.3f\n", 5, pow(5, 2), pow(5, 3), sqrt(5));
    return 0;
}
