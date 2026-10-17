/*
U02 — El bucle while.

OBJETIVO:
  - Repetir instrucciones MIENTRAS se cumpla una condicion (numero de vueltas desconocido).
  - Entender que la condicion se evalua ANTES de cada vuelta: puede no ejecutarse nunca.
  - Evitar los bucles infinitos actualizando siempre la variable de control.
  - Usar while para procesar digitos, buscar valores y repetir hasta un objetivo.
  - Reconocer cuando es mejor un for y cuando un while.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Estructura del while.
      while (condicion) {
          cuerpo
      }
      Si la condicion es falsa desde el principio, el cuerpo NO se ejecuta nunca.
    */
    printf("--- PRIMERA PARTE: Contador con while ---\n\n");

    int i = 1;
    while (i <= 5) {
        printf("vuelta %d\n", i);
        i++;           // IMPRESCINDIBLE: sin esto el bucle no terminaria nunca
    }

    /*
    SEGUNDA PARTE - Puede que no se ejecute ni una vez.
    */
    printf("\n--- SEGUNDA PARTE: Cero vueltas ---\n\n");

    int n = 10;
    while (n < 5) {
        printf("Esto no se imprime nunca\n");
        n++;
    }
    printf("El bucle no se ejecuto porque n (%d) no es menor que 5\n", n);

    /*
    TERCERA PARTE - Numero de vueltas desconocido: duplicar hasta superar.
      No sabemos cuantas veces habra que duplicar: es un caso tipico de while.
    */
    printf("\n--- TERCERA PARTE: Duplicar hasta pasar de 1000 ---\n\n");

    int cantidad = 3;
    int duplicaciones = 0;
    while (cantidad <= 1000) {
        cantidad *= 2;
        duplicaciones++;
    }
    printf("Empezando en 3 hacen falta %d duplicaciones para superar 1000 (llegamos a %d)\n",
           duplicaciones, cantidad);

    /*
    CUARTA PARTE - Procesar las cifras de un numero.
      n % 10 es la ultima cifra y n / 10 quita la ultima cifra.
    */
    printf("\n--- CUARTA PARTE: Suma de las cifras ---\n\n");

    int numero = 48291;
    int copia = numero;
    int suma_cifras = 0;
    int cifras = 0;
    while (copia > 0) {
        suma_cifras += copia % 10;
        copia /= 10;
        cifras++;
    }
    printf("%d tiene %d cifras que suman %d\n", numero, cifras, suma_cifras);

    /*
    QUINTA PARTE - Algoritmo de Euclides (maximo comun divisor).
      mcd(a, b) = mcd(b, a % b) hasta que b valga 0.
    */
    printf("\n--- QUINTA PARTE: MCD con Euclides ---\n\n");

    int a = 84, b = 36;
    int x = a, y = b;
    while (y != 0) {
        int resto = x % y;
        x = y;
        y = resto;
    }
    printf("mcd(%d, %d) = %d\n", a, b, x);

    /*
    SEXTA PARTE - Bucle infinito (error tipico).
      Se produce cuando la condicion siempre es verdadera:
          int k = 0;
          while (k < 5) { printf("%d", k); }   // se olvido k++
      Para cortar un programa colgado en la terminal: Ctrl + C.
    */
    printf("\n--- SEXTA PARTE: Cuidado con el bucle infinito ---\n\n");
    printf("Si olvidas actualizar la variable de la condicion, el bucle no acaba (Ctrl + C).\n");

    /*
    SEPTIMA PARTE - for o while?
      for:    sabes cuantas vueltas da (recorrer 1..n, tablas, arrays).
      while:  depende de una condicion que cambia sola (cifras, entrada de datos, busquedas).
    */
    printf("\n--- SEPTIMA PARTE: Elegir el bucle ---\n\n");
    printf("for = vueltas conocidas | while = hasta que algo ocurra\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
