/*
U05 — La biblioteca <math.h> (lo basico de aula).

OBJETIVO:
  - Usar sqrt, pow, fabs, floor, ceil y round.
  - Ver una tabla de redondeos y abs enteros vs reales.
  - Calcular la distancia entre dos puntos.
  - Recordar -lm en Linux/macOS.
  - No convertir la leccion en catalogo (sin trig, log ni rand).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <math.h>     /* sqrt, pow, fabs, ceil, floor, round — enlazar con -lm */
#include <stdlib.h>   /* abs (enteros) */

static void fila_redondeo(double x) {
    printf("%5.1f %6.0f %6.0f %6.0f %6d\n",
           x, floor(x), ceil(x), round(x), (int)x);
}

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Raiz y potencia.
      Trabajan con double. Compila: gcc ... -lm
    */
    printf("--- PRIMERA PARTE: sqrt y pow ---\n\n");

    printf("sqrt(144)   = %.0f\n", sqrt(144));
    printf("pow(2, 10)  = %.0f\n", pow(2, 10));
    printf("pow(9, 0.5) = %.1f\n", pow(9, 0.5));

    /*
    SEGUNDA PARTE - Redondeos y valor absoluto.
      floor abajo | ceil arriba | round al mas cercano | (int) trunca hacia 0
      fabs para double | abs para int
    */
    printf("\n--- SEGUNDA PARTE: Redondeos ---\n\n");

    printf("    x  floor   ceil  round  (int)\n");
    fila_redondeo(-2.5);
    fila_redondeo(2.5);
    fila_redondeo(2.4);

    printf("fabs(-7.25)=%.2f | abs(-7)=%d\n", fabs(-7.25), abs(-7));

    double precio = 3.14159;
    printf("%.5f a 2 decimales = %.2f\n", precio, round(precio * 100) / 100);

    /*
    TERCERA PARTE - Distancia entre dos puntos.
      d = sqrt((x2-x1)^2 + (y2-y1)^2)
    */
    printf("\n--- TERCERA PARTE: Distancia ---\n\n");

    double x1 = 1, y1 = 2, x2 = 4, y2 = 6;
    double distancia = sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
    printf("Entre (%.0f,%.0f) y (%.0f,%.0f) = %.2f\n", x1, y1, x2, y2, distancia);

    /* Misma idea sin pow: util si quieres evitar potencia. */
    double dx = x2 - x1;
    double dy = y2 - y1;
    printf("Misma distancia con dx*dx+dy*dy: %.2f\n", sqrt(dx * dx + dy * dy));

    /*
    CUARTA PARTE - Que NO hacemos en EV1.
      sin/cos/log/rand: utiles mas adelante, no hacen falta aqui.
    */
    printf("\n--- CUARTA PARTE: Limite de la leccion ---\n\n");
    printf("EV1: sqrt, pow, fabs, floor/ceil/round, abs y -lm.\n");
    printf("Fuera de EV1: trig, log, aleatorios.\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
