/*
U02 - Entrada por teclado con scanf (lo basico).

OBJETIVO:
  - Leer enteros y reales del teclado con scanf.
  - Entender el operador & ("direccion de") como "donde guardar el dato".
  - Mostrar un mensaje antes de pedir un dato (prompt).
  - Leer varios datos en una sola llamada.
  - Hacer un programa completo: entrada -> calculo -> salida.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Leer un entero.
      scanf("%d", &edad);
        "%d"  -> formato: el usuario escribira un entero
        &edad -> DIRECCION de la variable (donde dejar el dato leido)
      scanf necesita saber DONDE guardar el valor; por eso lleva & delante.
      (Los punteros se estudian mas adelante: de momento, recuerda
      "en scanf, & antes de la variable").
    */
    printf("--- PRIMERA PARTE: Leer un entero ---\n\n");

    int edad = 0;
    printf("Introduce tu edad: ");
    scanf("%d", &edad);
    printf("Tienes %d anos y el ano que viene tendras %d\n", edad, edad + 1);

    /*
    SEGUNDA PARTE - Leer un real.
      IMPORTANTE: en scanf un double se lee con %lf (L de long float).
      En printf se usa %f, pero en scanf %f lee un float (4 bytes).
        float  -> scanf("%f",  &x)
        double -> scanf("%lf", &x)
    */
    printf("\n--- SEGUNDA PARTE: Leer un real ---\n\n");

    double altura = 0.0;
    printf("Introduce tu altura en metros (con punto, ej. 1.75): ");
    scanf("%lf", &altura);
    printf("Mides %.2f m, es decir %.0f cm\n", altura, altura * 100);

    /*
    TERCERA PARTE - Leer varios datos de una vez.
      Los datos se separan con espacios o saltos de linea al escribirlos.
      Cada %d consume un numero y cada & indica donde guardarlo, en orden.
    */
    printf("\n--- TERCERA PARTE: Dos datos en un scanf ---\n\n");

    int a = 0, b = 0;
    printf("Escribe dos numeros separados por un espacio: ");
    scanf("%d %d", &a, &b);
    printf("%d + %d = %d\n", a, b, a + b);
    printf("%d * %d = %d\n", a, b, a * b);

    /*
    CUARTA PARTE - Prompt: pedir el dato con un mensaje.
      El printf anterior al scanf es el "prompt". Sin el, el usuario ve el
      cursor parpadeando sin saber que debe hacer.
      Mensajes sin \n al final dejan el cursor en la misma linea.
      Si el mensaje no aparece antes de escribir, fflush(stdout) fuerza
      que el texto salga ya (a veces pasa al redirigir la salida).
    */
    printf("\n--- CUARTA PARTE: Prompt claro ---\n\n");

    int dias = 0;
    printf("Cuantos dias dura tu viaje? ");
    fflush(stdout);
    scanf("%d", &dias);
    printf("Son %d horas y %d minutos\n", dias * 24, dias * 24 * 60);

    /*
    QUINTA PARTE - Programa completo: entrada, calculo y salida.
      Siempre con el mismo esquema:  1) pedir datos  2) calcular  3) mostrar
    */
    printf("\n--- QUINTA PARTE: Programa completo ---\n\n");

    double base = 0.0, alt = 0.0;
    printf("Base del triangulo: ");
    scanf("%lf", &base);
    printf("Altura del triangulo: ");
    scanf("%lf", &alt);
    double area = base * alt / 2;
    printf("El area del triangulo es %.2f\n", area);

    /*
    SEXTA PARTE - Errores tipicos con scanf.
      1) Olvidar el &:             scanf("%d", edad);    -> el programa se cae
      2) Usar %f con un double:    scanf("%f", &altura); -> valor basura
      3) Poner \n dentro del formato: scanf("%d\n", &x); -> se queda esperando
      4) No inicializar la variable por si scanf falla (ver U04).
      Compila siempre con -Wall: avisa de los casos 1 y 2.
    */
    printf("\n--- SEXTA PARTE: Errores tipicos ---\n\n");
    printf("& obligatorio | %%lf para double | nada de \\n en el formato\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
