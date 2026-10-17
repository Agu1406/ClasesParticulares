/*
U01 — Variables y tipos basicos en C.

En esta primera clase de variables aprenderemos los conceptos basicos:
como se declaran, como funcionan y que se puede guardar en ellas.

OBJETIVO:
  - Declarar variables con tipo explicito (int, double, char, bool...).
  - Diferenciar declarar, inicializar y asignar.
  - Conocer las reglas para nombrar identificadores.
  - Entender el ambito de una variable (el bloque { } donde vive).
  - Saber por que NUNCA hay que leer una variable sin inicializar.

REGLAS:
  - Toda variable tiene un tipo fijo (a diferencia de Python).
  - Cada instruccion termina en punto y coma (;).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Declarar, inicializar y asignar.
      Una variable es un trozo de memoria con nombre y tipo.
        DECLARAR:     int edad;        (reserva el espacio, el valor es BASURA)
        INICIALIZAR:  int edad = 18;   (declara y da el primer valor a la vez)
        ASIGNAR:      edad = 19;       (cambia el valor mas adelante)
      Se lee asi: "edad recibe 19". El = de C NO es igualdad matematica.
    */
    printf("--- PRIMERA PARTE: Declarar, inicializar, asignar ---\n\n");

    int edad = 18;
    printf("edad vale %d\n", edad);

    edad = 19;
    printf("edad ahora vale %d\n", edad);

    edad = edad + 1;
    printf("edad despues de edad + 1: %d\n", edad);

    /*
    SEGUNDA PARTE - Varias variables a la vez.
      Se pueden declarar varias del mismo tipo separadas por comas, pero
      es mas legible una por linea.
    */
    printf("\n--- SEGUNDA PARTE: Varias variables ---\n\n");

    int a = 3, b = 4, c;
    c = a + b;
    printf("%d + %d = %d\n", a, b, c);

    int x, y;
    x = y = 10;
    printf("x = %d, y = %d\n", x, y);

    /*
    TERCERA PARTE - Reglas para los nombres (identificadores).
      Validos:    edad, nota1, _total, precio_final, precioFinal
      NO validos: 1nota (empieza por numero), mi edad (espacio),
                  total$ (simbolo), int (palabra reservada)
      C distingue mayusculas: Edad, edad y EDAD son TRES variables distintas.
      Convencion del curso: snake_case o camelCase, nombres que expliquen
      el contenido (nota_final) y no letras sueltas (n, x) salvo en bucles.
    */
    printf("\n--- TERCERA PARTE: Nombres de variables ---\n\n");

    int nota1 = 7;
    int nota2 = 9;
    int _contador = 0;
    int precio_final = 120;
    int edad_alumno = 17;
    printf("nota1=%d nota2=%d _contador=%d precio_final=%d edad_alumno=%d\n",
           nota1, nota2, _contador, precio_final, edad_alumno);

    int Edad = 50;
    printf("edad=%d y Edad=%d son variables distintas\n", edad, Edad);

    /*
    CUARTA PARTE - Ambito (scope).
      Una variable solo existe dentro del bloque { } donde se declara.
      Al salir del bloque desaparece. Dos bloques distintos pueden usar el
      mismo nombre sin que se mezclen.
    */
    printf("\n--- CUARTA PARTE: Ambito de una variable ---\n\n");

    int numero = 1;
    {
        int numero_interno = 100;
        int numero = 5;
        printf("dentro del bloque: numero = %d, numero_interno = %d\n", numero, numero_interno);
    }
    printf("fuera del bloque: numero = %d (la de fuera no cambio)\n", numero);
    // printf("%d", numero_interno);  // ERROR: numero_interno ya no existe aqui

    /*
    QUINTA PARTE - Variables sin inicializar.
      En C una variable local NO se inicializa sola: contiene basura de la
      memoria. Leerla es comportamiento indefinido. Por eso:
        REGLA: inicializa SIEMPRE al declarar (aunque sea a 0).
    */
    printf("\n--- QUINTA PARTE: Inicializar siempre ---\n\n");

    int contador = 0;
    int suma = 0;
    contador = contador + 1;
    suma = suma + 10;
    printf("contador = %d, suma = %d\n", contador, suma);

    /*
    SEXTA PARTE - Declarar donde se necesita (C99).
      Desde C99 se puede declarar una variable en cualquier punto, incluso
      en la cabecera de un for. Mejor declararla lo mas cerca posible de
      donde se usa.
    */
    printf("\n--- SEXTA PARTE: Declarar cerca de su uso ---\n\n");

    for (int i = 1; i <= 3; i++) {
        printf("i = %d\n", i);
    }

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
