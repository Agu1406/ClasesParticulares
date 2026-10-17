/*
U05 - La biblioteca matematica <math.h>.

OBJETIVO:
  - Usar sqrt, pow, fabs, ceil, floor, round y trunc.
  - Calcular hipotenusa, areas, distancias y potencias.
  - Usar funciones trigonometricas con radianes.
  - Recordar que en Linux/macOS hay que enlazar con -lm.
  - Generar numeros aleatorios con rand y srand (<stdlib.h>).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdlib.h>   // rand, srand, RAND_MAX, abs
#include <math.h>     // sqrt, pow, fabs, ceil, floor, round, sin, cos...
#include <time.h>     // time

/* M_PI no es estandar C: lo definimos nosotros por si el compilador no lo trae. */
#define PI 3.14159265358979323846

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Raiz y potencia.
      sqrt(x)    raiz cuadrada             pow(x, y)  x elevado a y
      cbrt(x)    raiz cubica               hypot(a,b) raiz(a*a + b*b)
      Todas trabajan con double y devuelven double.
      En Linux/macOS compila con:  gcc ... -lm
    */
    printf("--- PRIMERA PARTE: sqrt y pow ---\n\n");

    printf("sqrt(144)    = %.0f\n", sqrt(144));
    printf("pow(2, 10)   = %.0f\n", pow(2, 10));
    printf("pow(9, 0.5)  = %.1f\n", pow(9, 0.5));
    printf("cbrt(27)     = %.0f\n", cbrt(27));
    printf("hypot(3, 4)  = %.0f  (hipotenusa)\n", hypot(3, 4));

    /*
    SEGUNDA PARTE - Redondeos.
      floor(x)   hacia abajo           ceil(x)   hacia arriba
      round(x)   al mas cercano        trunc(x)  quita los decimales
      fabs(x)    valor absoluto de un double (abs() es solo para int)
    */
    printf("\n--- SEGUNDA PARTE: Redondeos ---\n\n");

    double x = -2.5, y = 2.5, z = 2.4;
    printf("%5s %6s %6s %6s %6s\n", "x", "floor", "ceil", "round", "trunc");
    printf("%5.1f %6.0f %6.0f %6.0f %6.0f\n", x, floor(x), ceil(x), round(x), trunc(x));
    printf("%5.1f %6.0f %6.0f %6.0f %6.0f\n", y, floor(y), ceil(y), round(y), trunc(y));
    printf("%5.1f %6.0f %6.0f %6.0f %6.0f\n", z, floor(z), ceil(z), round(z), trunc(z));
    printf("fabs(-7.25) = %.2f | abs(-7) = %d\n", fabs(-7.25), abs(-7));

    // Redondear a 2 decimales: multiplicar, redondear, dividir.
    double precio = 3.14159;
    printf("%.5f redondeado a 2 decimales = %.2f\n", precio, round(precio * 100) / 100);

    /*
    TERCERA PARTE - Trigonometria (los angulos van en RADIANES).
      radianes = grados * PI / 180
    */
    printf("\n--- TERCERA PARTE: Trigonometria ---\n\n");

    double grados = 30.0;
    double rad = grados * PI / 180.0;
    printf("sin(%.0f grados) = %.3f\n", grados, sin(rad));
    printf("cos(%.0f grados) = %.3f\n", grados, cos(rad));
    printf("tan(45 grados)  = %.3f\n", tan(45 * PI / 180));
    printf("atan(1) en grados = %.1f\n", atan(1) * 180 / PI);

    /*
    CUARTA PARTE - Logaritmos y exponencial.
      log(x)  logaritmo neperiano (base e)      log10(x)  base 10      exp(x)  e^x
    */
    printf("\n--- CUARTA PARTE: log y exp ---\n\n");

    printf("log10(1000) = %.0f\n", log10(1000));
    printf("log(e)      = %.0f\n", log(exp(1.0)));
    printf("Cifras de 123456 = %d\n", (int)log10(123456) + 1);

    /*
    QUINTA PARTE - Numeros aleatorios con rand.
      rand() devuelve un entero pseudoaleatorio entre 0 y RAND_MAX.
      srand(semilla) inicializa la secuencia. Con srand(time(NULL)) cada
      ejecucion cambia; con una semilla fija sale SIEMPRE lo mismo.
      Numero entre 1 y 6:  rand() % 6 + 1
      Entre min y max:     min + rand() % (max - min + 1)
    */
    printf("\n--- QUINTA PARTE: rand y srand ---\n\n");

    srand(12345);   // semilla fija: para clase es util que los resultados no varien
    printf("Tres dados con semilla fija: %d %d %d\n", rand() % 6 + 1, rand() % 6 + 1, rand() % 6 + 1);

    srand((unsigned)time(NULL));   // semilla distinta cada ejecucion
    int dado = rand() % 6 + 1;
    printf("Dado aleatorio (cambia en cada ejecucion): entre 1 y 6 -> %s\n",
           (dado >= 1 && dado <= 6) ? "valido" : "error");

    /*
    SEXTA PARTE - Distancia entre dos puntos.
      d = raiz((x2 - x1)^2 + (y2 - y1)^2)
    */
    printf("\n--- SEXTA PARTE: Distancia entre puntos ---\n\n");

    double x1 = 1, y1 = 2, x2 = 4, y2 = 6;
    double distancia = sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
    printf("Distancia entre (%.0f,%.0f) y (%.0f,%.0f) = %.2f\n", x1, y1, x2, y2, distancia);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
