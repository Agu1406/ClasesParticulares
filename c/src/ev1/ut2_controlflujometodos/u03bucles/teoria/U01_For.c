/*
U01 — El bucle for.

OBJETIVO:
  - Repetir instrucciones un numero conocido de veces.
  - Entender las tres partes del for: inicializacion, condicion y actualizacion.
  - Recorrer en orden ascendente, descendente y con saltos distintos de 1.
  - Usar acumuladores y contadores dentro de un for.
  - Declarar la variable de control en la propia cabecera (C99) y conocer su ambito.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Estructura del for.
      for (inicializacion; condicion; actualizacion) {
          cuerpo
      }
      Orden de ejecucion:
        1) inicializacion  (UNA sola vez)
        2) se evalua la condicion; si es falsa, el bucle termina
        3) se ejecuta el cuerpo
        4) actualizacion, y vuelta al paso 2
    */
    printf("--- PRIMERA PARTE: Contar del 1 al 5 ---\n\n");

    for (int i = 1; i <= 5; i++) {
        printf("i = %d\n", i);
    }

    /*
    SEGUNDA PARTE - Cuenta atras y saltos.
      La actualizacion puede ser cualquier cosa: i--, i += 2, i *= 2...
    */
    printf("\n--- SEGUNDA PARTE: Cuenta atras y saltos ---\n\n");

    printf("Cuenta atras: ");
    for (int i = 5; i >= 1; i--) {
        printf("%d ", i);
    }
    printf("Despegue!\n");

    printf("Pares hasta 10: ");
    for (int i = 2; i <= 10; i += 2) {
        printf("%d ", i);
    }
    printf("\n");

    printf("Potencias de 2: ");
    for (int p = 1; p <= 256; p *= 2) {
        printf("%d ", p);
    }
    printf("\n");

    /*
    TERCERA PARTE - Acumulador: sumar numeros.
      Una variable fuera del bucle va guardando el resultado parcial.
    */
    printf("\n--- TERCERA PARTE: Suma del 1 al 100 ---\n\n");

    int suma = 0;
    for (int i = 1; i <= 100; i++) {
        suma += i;
    }
    printf("1 + 2 + ... + 100 = %d\n", suma);

    /*
    CUARTA PARTE - Tabla de multiplicar.
    */
    printf("\n--- CUARTA PARTE: Tabla del 7 ---\n\n");

    int tabla = 7;
    for (int i = 1; i <= 10; i++) {
        printf("%d x %2d = %2d\n", tabla, i, tabla * i);
    }

    /*
    QUINTA PARTE - Contador con condicion: contar multiplos.
    */
    printf("\n--- QUINTA PARTE: Multiplos de 3 o de 5 ---\n\n");

    int cuantos = 0;
    for (int i = 1; i <= 50; i++) {
        if (i % 3 == 0 || i % 5 == 0) {
            cuantos++;
        }
    }
    printf("Entre 1 y 50 hay %d numeros multiplos de 3 o de 5\n", cuantos);

    /*
    SEXTA PARTE - Ambito de la variable del for.
      Si se declara en la cabecera (for (int i = ...)), solo existe dentro
      del bucle. Si necesitas su valor al terminar, declarala fuera.
    */
    printf("\n--- SEXTA PARTE: Ambito de la variable de control ---\n\n");

    int j;
    for (j = 0; j < 4; j++) {
        // el cuerpo puede estar vacio o hacer algo
    }
    printf("Al terminar el for, j vale %d\n", j);

    /*
    SEPTIMA PARTE - Partes opcionales y variantes.
      Las tres partes pueden omitirse:  for (;;) { ... }  es un bucle infinito
      (se corta con break). Tambien se pueden usar dos variables con coma.
    */
    printf("\n--- SEPTIMA PARTE: Dos variables en el for ---\n\n");

    for (int i = 0, k = 10; i <= k; i += 2, k -= 2) {
        printf("i = %2d | k = %2d\n", i, k);
    }

    /*
    OCTAVA PARTE - Errores tipicos (el resto de patrones va en u05repaso).
      Off by one: i < n (desde 0) vs i <= n (desde 1).
      Nunca pongas ';' justo despues del for (...).
      break / continue / acumuladores / centinela: u05repaso (como en C++/C#).
    */
    printf("\n--- OCTAVA PARTE: Errores tipicos ---\n\n");

    int vueltas = 0;
    for (int i = 0; i < 5; i++) {
        vueltas++;
    }
    printf("i = 0; i < 5  -> %d vueltas (no uses i <= 5 si quieres 5)\n", vueltas);
    printf("break, continue, centinela y menus: ver u05repaso.\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
