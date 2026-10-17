/*
U01 — Condicional if.

OBJETIVO:
  - Ejecutar codigo solo cuando se cumple una condicion.
  - Probar if con int, double, bool y comparaciones (== != < > <= >=).
  - Entender que en C cualquier valor distinto de 0 es "verdadero".
  - Evitar los errores clasicos: if (x = 5), punto y coma tras el if y llaves omitidas.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - if simple.
      Sintaxis:
          if (condicion) {
              // se ejecuta solo si la condicion es verdadera
          }
      La condicion SIEMPRE va entre parentesis.
    */
    printf("--- PRIMERA PARTE: if simple ---\n\n");

    int temperatura = 32;
    if (temperatura > 30) {
        printf("Hace calor: %d grados\n", temperatura);
    }
    printf("Esta linea se ejecuta siempre.\n");

    /*
    SEGUNDA PARTE - if con nombres (como en clase).
      Cambia el valor de nombre y vuelve a ejecutar: solo entra
      en los if que se cumplen.
    */
    printf("\n--- SEGUNDA PARTE: if con un nombre ---\n\n");

    const char *nombre = "Edu";
    if (nombre[0] == 'E') {
        printf("¡Eres el alumno! Tu nombre empieza por E.\n");
    }
    if (nombre[0] == 'A') {
        printf("¡Eres el profesor!\n");
    }
    printf("Tu eres %s\n", nombre);

    /*
    TERCERA PARTE - if con double: la montana rusa.
      >= 1.50 puede subir. > 1.70 rueda extrema. == 1.70 club VIP.
    */
    printf("\n--- TERCERA PARTE: if con double (montana rusa) ---\n\n");

    double altura = 1.70;
    if (altura >= 1.50) {
        printf("¡Mides 1.50 o mas! Puedes subir a la montana rusa.\n");
    }
    if (altura > 1.70) {
        printf("¡Mides mas de 1.70! Te puedes subir a la rueda extrema.\n");
    }
    if (altura == 1.70) {
        printf("¡Mides exactamente 1.70! Bienvenido al club VIP.\n");
    }
    if (altura < 1.50) {
        printf("No puedes subir a la montana rusa.\n");
    }
    if (altura <= 2.00) {
        printf("¡Mides 2.00 o menos! Puedes subir a los carritos chocones.\n");
    }

    /*
    CUARTA PARTE - if con bool y !.
      true entra. false no entra. ! invierte.
    */
    printf("\n--- CUARTA PARTE: if con bool ---\n\n");

    bool humano = true;
    bool jirafa = false;
    if (humano) {
        printf("¡Es un ser humano!\n");
    }
    if (jirafa) {
        printf("¡Es una jirafa!\n");
    }
    if (!jirafa) {
        printf("¡No es una jirafa!\n");
    }

    /*
    QUINTA PARTE - Bloque { } con varias lineas y stock.
      Todo lo que va entre llaves pertenece al if.
    */
    printf("\n--- QUINTA PARTE: Bloque con varias lineas ---\n\n");

    int stock = 3;
    int pedido = 5;
    if (pedido > stock) {
        printf("Pedido: %d, stock: %d.\n", pedido, stock);
        printf("Faltan %d unidades.\n", pedido - stock);
    }

    /*
    SEXTA PARTE - Verdadero y falso en C.
      La condicion es falsa SOLO si vale 0. Cualquier otro valor es verdadero:
        if (5)  -> verdadero      if (-1) -> verdadero
        if (0)  -> falso
      Por eso se puede escribir  if (n)  en lugar de  if (n != 0).
      Es valido, pero if (n != 0) se lee mejor para principiantes.
    */
    printf("\n--- SEXTA PARTE: Que es verdadero ---\n\n");

    int n = 7;
    if (n) {
        printf("%d es distinto de 0: la condicion es verdadera\n", n);
    }
    if (!0) {
        printf("!0 es verdadero\n");
    }

    /*
    SEPTIMA PARTE - Errores clasicos (los que salen en examen).
      1) if (x = 5)      asigna 5 y es siempre verdadero (usa ==).
      2) if (x > 3);     el ; vacio ES el cuerpo del if: lo de debajo se ejecuta siempre.
      3) if (x > 3)
             a();
             b();        sin llaves SOLO a() pertenece al if. Pon siempre llaves.
      4) if (3 < x < 10) se lee como (3 < x) < 10: usa 3 < x && x < 10.
    */
    printf("\n--- SEPTIMA PARTE: Errores clasicos ---\n\n");

    int x = 2;
    if (x > 3) {
        printf("x es mayor que 3\n");
    }
    printf("Si pusieras ';' justo detras del if, esta linea saldria igual.\n");
    printf("Regla: if (x == 5)  y siempre con llaves.\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
