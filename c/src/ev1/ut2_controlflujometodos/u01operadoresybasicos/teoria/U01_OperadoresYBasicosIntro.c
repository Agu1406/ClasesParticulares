/*
U01 - Operadores y operaciones basicas: mapa general.

OBJETIVO:
  - Repasar los grupos de operadores de C: aritmeticos, de asignacion,
    comparacion, logicos, de incremento y condicional (ternario).
  - Ver el operador sizeof y el operador coma como curiosidades utiles.
  - Entender la diferencia entre sentencia y expresion: toda expresion tiene valor.
  - Preparar la base para los condicionales y los bucles.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Mapa de operadores.
      Aritmeticos:   +  -  *  /  %
      Asignacion:    =  +=  -=  *=  /=  %=
      Incremento:    ++  --
      Comparacion:   ==  !=  <  >  <=  >=
      Logicos:       &&  ||  !
      Condicional:   condicion ? valor_si_cierta : valor_si_falsa
      Otros:         sizeof   (tipo)  &   *   ,
    */
    printf("--- PRIMERA PARTE: Mapa de operadores ---\n\n");
    printf("Aritmeticos | Asignacion | Incremento | Comparacion | Logicos | Ternario\n");

    /*
    SEGUNDA PARTE - Toda expresion tiene un valor.
      Una EXPRESION es cualquier cosa que produce un valor: 3 + 4, a > b,
      a = 5 (vale 5, lo asignado), x++ ...
      Una SENTENCIA (instruccion) termina en ; y ejecuta algo.
      Por eso son posibles cosas como   a = b = 7;   o   if ((n = leer()) > 0)
    */
    printf("\n--- SEGUNDA PARTE: Expresiones y su valor ---\n\n");

    int a, b;
    a = b = 7;                                  // b = 7 vale 7, que se asigna a 'a'
    printf("a = %d, b = %d\n", a, b);
    printf("(a = 10) vale %d\n", (a = 10));     // la asignacion es una expresion
    printf("(3 > 2) vale %d\n", 3 > 2);
    printf("(3 + 4) vale %d\n", 3 + 4);

    /*
    TERCERA PARTE - Operador ternario ( ? : ).
      Es un if-else dentro de una expresion. Cuando elige entre dos VALORES
      es mas corto que un if. No lo encadenes demasiado: pierde legibilidad.
    */
    printf("\n--- TERCERA PARTE: Ternario ---\n\n");

    int nota = 7;
    printf("Nota %d: %s\n", nota, nota >= 5 ? "Aprobado" : "Suspenso");

    int x = 12, y = 20;
    int mayor = x > y ? x : y;
    int menor = x < y ? x : y;
    printf("Entre %d y %d el mayor es %d y el menor es %d\n", x, y, mayor, menor);

    /*
    CUARTA PARTE - sizeof como operador.
      sizeof NO es una funcion: se evalua al compilar y devuelve el tamano
      en bytes. Funciona con tipos y con variables.
    */
    printf("\n--- CUARTA PARTE: sizeof ---\n\n");

    double precio = 9.99;
    printf("sizeof(double) = %lu, sizeof(precio) = %lu, sizeof(int) = %lu\n",
           (unsigned long)sizeof(double), (unsigned long)sizeof(precio), (unsigned long)sizeof(int));

    /*
    QUINTA PARTE - Operador coma.
      Evalua las expresiones de izquierda a derecha y devuelve la ultima.
      Su uso casi unico: poner dos contadores en la cabecera de un for.
    */
    printf("\n--- QUINTA PARTE: Operador coma ---\n\n");

    for (int i = 0, j = 10; i < j; i += 3, j -= 3) {
        printf("i = %2d, j = %2d\n", i, j);
    }

    /*
    SEXTA PARTE - Hacia los condicionales.
      Los operadores de comparacion y logicos producen la condicion que
      usaran if, while y for en las siguientes unidades.
    */
    printf("\n--- SEXTA PARTE: Siguiente paso ---\n\n");
    printf("Operadores -> condiciones -> if / switch / bucles\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
