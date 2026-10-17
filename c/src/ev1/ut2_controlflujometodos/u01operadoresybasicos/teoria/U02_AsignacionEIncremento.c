/*
U02 - Asignacion compuesta e incremento / decremento.

OBJETIVO:
  - Usar los operadores compuestos += -= *= /= %=.
  - Distinguir el incremento prefijo (++x) del postfijo (x++).
  - Entender cuando importa el valor devuelto y cuando no.
  - Evitar expresiones ambiguas como x = x++ o a[i] = i++ (comportamiento indefinido).
  - Usar contadores y acumuladores, base de los bucles.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Asignacion compuesta.
      x += 5   equivale a   x = x + 5
      Existe para  +=  -=  *=  /=  %=
    */
    printf("--- PRIMERA PARTE: Asignacion compuesta ---\n\n");

    int valor = 20;
    printf("valor inicial: %d\n", valor);
    valor += 5;
    printf("valor += 5  -> %d\n", valor);
    valor -= 3;
    printf("valor -= 3  -> %d\n", valor);
    valor *= 2;
    printf("valor *= 2  -> %d\n", valor);
    valor /= 4;
    printf("valor /= 4  -> %d\n", valor);
    valor %= 4;
    printf("valor %%= 4  -> %d\n", valor);

    double saldo = 1000.0;
    saldo *= 1.05;   // sube un 5%
    printf("saldo con 5%% de interes: %.2f\n", saldo);

    /*
    SEGUNDA PARTE - Incremento y decremento.
      x++  y  ++x  suman 1 a x.      x--  y  --x  restan 1.
      Como sentencia independiente (x++;) son identicos.
    */
    printf("\n--- SEGUNDA PARTE: ++ y -- ---\n\n");

    int contador = 0;
    contador++;
    contador++;
    ++contador;
    printf("contador despues de tres incrementos: %d\n", contador);
    contador--;
    printf("contador despues de un decremento: %d\n", contador);

    /*
    TERCERA PARTE - Prefijo frente a postfijo.
      Cuando se usan DENTRO de una expresion hay diferencia:
        y = x++;   -> y recibe el valor ANTIGUO de x, y despues x sube.
        y = ++x;   -> x sube primero, y recibe el valor NUEVO.
      Regla para recordarlo: el signo ++ delante actua "antes", detras "despues".
    */
    printf("\n--- TERCERA PARTE: Prefijo y postfijo ---\n\n");

    int x = 5;
    int y = x++;
    printf("y = x++  -> y = %d, x = %d\n", y, x);

    x = 5;
    y = ++x;
    printf("y = ++x  -> y = %d, x = %d\n", y, x);

    int i = 3;
    printf("printf con i++: %d\n", i++);
    printf("despues i vale: %d\n", i);
    printf("printf con ++i: %d\n", ++i);

    /*
    CUARTA PARTE - Lo que NO hay que hacer.
      Modificar la misma variable dos veces en una expresion sin un
      punto de secuencia es COMPORTAMIENTO INDEFINIDO:
          x = x++;        a[i] = i++;        printf("%d %d", i, i++);
      Cada compilador puede dar un resultado distinto. Escribe cada
      modificacion en su propia linea.
    */
    printf("\n--- CUARTA PARTE: Evitar ambiguedades ---\n\n");

    int n = 10;
    n++;                       // BIEN: una modificacion por sentencia
    int doble = n * 2;
    printf("n = %d, doble = %d\n", n, doble);

    /*
    QUINTA PARTE - Contadores y acumuladores.
      CONTADOR:    cuenta cuantas veces ocurre algo        -> contador++
      ACUMULADOR:  va sumando valores                      -> suma += valor
    */
    printf("\n--- QUINTA PARTE: Contador y acumulador ---\n\n");

    int pares = 0;
    int suma_pares = 0;
    for (int k = 1; k <= 10; k++) {
        if (k % 2 == 0) {
            pares++;
            suma_pares += k;
        }
    }
    printf("Entre 1 y 10 hay %d pares y suman %d\n", pares, suma_pares);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
