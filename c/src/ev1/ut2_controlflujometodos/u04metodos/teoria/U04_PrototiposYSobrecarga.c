/*
U04 - Prototipos, cabeceras y "sobrecarga" en C.

OBJETIVO:
  - Entender por que hacen falta prototipos y como se organizan.
  - Conocer como se dividiria un programa en varios ficheros (.h y .c).
  - Comprobar que C NO tiene sobrecarga de funciones (a diferencia de Java/C#/C++).
  - Resolverlo con nombres distintos, o con _Generic (C11) como curiosidad.
  - Conocer las funciones con parametros opcionales via valores especiales.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

/*
PROTOTIPOS.
  El compilador lee el fichero de arriba a abajo: si llamas a una funcion
  antes de definirla, necesita saber su "firma" (nombre, parametros y retorno).
  Si no hay prototipo, el compilador asume cosas que pueden ser erroneas.
  Los nombres de los parametros en el prototipo son opcionales.
*/
int maximo(int a, int b);
double area_rectangulo(double base, double altura);
double area_cuadrado(double lado);

/*
ORGANIZACION EN VARIOS FICHEROS (solo explicacion, no hace falta para el curso).
  geometria.h   -> prototipos:   double area_cuadrado(double lado);
  geometria.c   -> definiciones: #include "geometria.h"  y el codigo
  main.c        -> #include "geometria.h" y usa las funciones
  Compilar:  gcc main.c geometria.c -o programa
  Las cabeceras llevan guardas para no incluirse dos veces:
      #ifndef GEOMETRIA_H
      #define GEOMETRIA_H
      ... prototipos ...
      #endif
*/

/*
C NO PERMITE dos funciones con el mismo nombre. Esto da error de compilacion:
    int sumar(int a, int b);
    double sumar(double a, double b);    // error: conflicting types
Soluciones:
  1) Nombres distintos:  sumar_int, sumar_double
  2) _Generic (C11): elige la funcion segun el tipo del argumento.
*/
int sumar_int(int a, int b) { return a + b; }
double sumar_double(double a, double b) { return a + b; }

#define sumar(a, b) _Generic((a), \
    int: sumar_int,               \
    double: sumar_double)(a, b)

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Usar funciones declaradas con prototipo.
    */
    printf("--- PRIMERA PARTE: Prototipos ---\n\n");

    printf("maximo(7, 12) = %d\n", maximo(7, 12));
    printf("area_rectangulo(3, 4.5) = %.2f\n", area_rectangulo(3, 4.5));
    printf("area_cuadrado(5) = %.2f\n", area_cuadrado(5));

    /*
    SEGUNDA PARTE - Sin sobrecarga: nombres distintos.
      Es la solucion habitual en C: el nombre indica el tipo o el caso.
    */
    printf("\n--- SEGUNDA PARTE: Nombres distintos ---\n\n");

    printf("sumar_int(2, 3) = %d\n", sumar_int(2, 3));
    printf("sumar_double(2.5, 3.5) = %.1f\n", sumar_double(2.5, 3.5));

    /*
    TERCERA PARTE - _Generic (C11).
      La macro sumar(a, b) elige sumar_int o sumar_double segun el tipo de a.
      Es "sobrecarga" hecha a mano por el preprocesador: no hace falta
      dominarla, pero muestra que C puede hacerlo.
    */
    printf("\n--- TERCERA PARTE: _Generic ---\n\n");

    printf("sumar(4, 5)     = %d\n", sumar(4, 5));
    printf("sumar(1.5, 2.5) = %.1f\n", sumar(1.5, 2.5));

    /*
    CUARTA PARTE - Valores por defecto: no existen.
      En C++ se escribe  void f(int x = 0).  En C no.
      Se simula con un valor especial (por ejemplo -1 = "no indicado")
      o con una funcion auxiliar que fija el valor.
    */
    printf("\n--- CUARTA PARTE: Parametros opcionales simulados ---\n\n");

    printf("area_cuadrado(4) = %.1f\n", area_cuadrado(4));
    printf("area_rectangulo(4, 4) = %.1f (cuadrado como caso particular)\n", area_rectangulo(4, 4));

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

int maximo(int a, int b) {
    return a > b ? a : b;
}

double area_rectangulo(double base, double altura) {
    return base * altura;
}

double area_cuadrado(double lado) {
    return area_rectangulo(lado, lado);   // una funcion puede llamar a otra
}
