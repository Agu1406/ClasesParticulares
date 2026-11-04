/*
U02 — Asignacion compuesta e incremento / decremento.

OBJETIVO:
  - Usar += -= *= /= %=.
  - Distinguir prefijo (++x) y postfijo (x++).
  - Evitar modificar la misma variable dos veces en una expresion (UB en C).
  - Usar contadores y acumuladores (base de los bucles).

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
      x += 5  equivale a  x = x + 5
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
    saldo *= 1.05;
    printf("saldo con 5%% de interes: %.2f\n", saldo);

    int segundos = 125;
    segundos %= 60;
    printf("125 segundos, resto al pasar a minutos: %d\n", segundos);

    double total_compra = 0.0;
    total_compra += 12.50;
    total_compra += 3.20;
    total_compra += 7.80;
    printf("total de 3 lineas de ticket: %.2f\n", total_compra);

    /*
    SEGUNDA PARTE - ++ y -- como sentencia.
      Sueltos en su linea, prefijo y postfijo hacen lo mismo.
    */
    printf("\n--- SEGUNDA PARTE: ++ y -- sueltos ---\n\n");

    int contador = 0;
    contador++;
    contador++;
    ++contador;
    printf("contador tras tres incrementos: %d\n", contador);
    contador--;
    printf("contador tras un decremento: %d\n", contador);

    /*
    TERCERA PARTE - Prefijo frente a postfijo.
      y = x++  -> y recibe el valor antiguo; luego x sube.
      y = ++x  -> x sube primero; y recibe el valor nuevo.
    */
    printf("\n--- TERCERA PARTE: Prefijo y postfijo ---\n\n");

    int x = 5;
    int y = x++;
    printf("y = x++  -> y = %d, x = %d\n", y, x);

    x = 5;
    y = ++x;
    printf("y = ++x  -> y = %d, x = %d\n", y, x);

    int i = 3;
    printf("printf de i++: %d\n", i++);
    printf("despues i vale: %d\n", i);
    printf("printf de ++i: %d\n", ++i);

    /*
    CUARTA PARTE - Lo que NO hay que hacer (UB en C).
      Modificar la misma variable dos veces sin punto de secuencia
      es COMPORTAMIENTO INDEFINIDO:
          x = x++;   a[i] = i++;   printf("%d %d", i, i++);
      En Java n = n++ esta definido (aunque confunde). En C no lo writes.
      Una modificacion por linea.
    */
    printf("\n--- CUARTA PARTE: Evitar ambiguedades (UB) ---\n\n");

    int n = 10;
    n++;                       /* BIEN */
    int doble = n * 2;
    printf("tras n++ en su linea: n = %d, doble = %d\n", n, doble);
    printf("No ejecutes x = x++ en C: el resultado no esta garantizado.\n");

    /*
    QUINTA PARTE - Contador y acumulador.
      CONTADOR:    cuantas veces ocurre algo   -> pares++
      ACUMULADOR:  va sumando valores          -> suma += k
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

    int vidas = 3;
    printf("Vidas restantes: ");
    while (vidas > 0) {
        printf("%d ", vidas);
        vidas--;
    }
    printf("(game over)\n");

    int suma = 0;
    for (int k = 1; k <= 5; k++) {
        suma += k;
    }
    printf("Suma del 1 al 5: %d\n", suma);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
