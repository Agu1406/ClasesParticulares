/*
U04 - Depurador paso a paso (GDB y VS Code).

OBJETIVO:
  - Entender para que sirve un depurador: parar, mirar y avanzar.
  - Compilar con simbolos de depuracion (-g).
  - Usar puntos de interrupcion, paso a paso, inspeccion de variables
    y pila de llamadas.
  - Practicar sobre un programa pensado para depurarlo.

COMO USAR ESTE FICHERO:
  1) Compila:   gcc -std=c11 -g -O0 U04_DepuradorGdbYVSCode.c -o depurar
  2) Con GDB:   gdb ./depurar
  3) O en VS Code: pon puntos rojos al lado de las lineas y pulsa F5.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

static int factorial(int n);
static int suma_digitos(int n);
static int contar_collatz(int n);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Comandos basicos de GDB.
      break main         punto de interrupcion en main
      break U04...c:80   punto de interrupcion en una linea
      run                ejecuta hasta el primer punto
      next (n)           siguiente linea (sin entrar en funciones)
      step (s)           siguiente linea (entrando en funciones)
      print x   (p x)    muestra el valor de x
      display x          muestra x cada vez que se detiene
      backtrace (bt)     pila de llamadas
      finish             ejecuta hasta salir de la funcion actual
      continue (c)       sigue hasta el siguiente punto
      quit (q)           salir

      -g  anade informacion de depuracion; -O0 evita que el compilador
      reordene el codigo y las variables "desaparezcan".
    */
    printf("--- PRIMERA PARTE: Comandos de GDB ---\n\n");
    printf("Compila con -g -O0 y prueba: break main, run, next, print\n");

    /*
    SEGUNDA PARTE - Depurador en VS Code.
      - Clic al lado del numero de linea: punto de interrupcion (rojo).
      - F5 inicia la depuracion. F10 = next, F11 = step, Shift+F11 = finish.
      - Panel VARIABLES: valores actuales. PILA DE LLAMADAS: quien llamo a quien.
      - Puntos de interrupcion condicionales: clic derecho -> "Expression",
        por ejemplo  i == 7  para parar solo en esa vuelta.
    */
    printf("\n--- SEGUNDA PARTE: VS Code ---\n\n");
    printf("F5 iniciar | F10 next | F11 step | Shift+F11 finish\n");

    /*
    TERCERA PARTE - Programa para practicar.
      Pon un punto de interrupcion en la linea de cada llamada y avanza con step
      para ver como cambian las variables.
    */
    printf("\n--- TERCERA PARTE: Practica ---\n\n");

    int f = factorial(5);
    printf("factorial(5)        = %d\n", f);

    int sd = suma_digitos(4821);
    printf("suma_digitos(4821)  = %d\n", sd);

    int pasos = contar_collatz(6);
    printf("pasos Collatz(6)    = %d\n", pasos);

    /*
    CUARTA PARTE - Ejercicio guiado.
      1) Punto de interrupcion en 'int f = factorial(5);'.
      2) Entra con step en factorial y mira 'n' y 'resultado' en cada vuelta.
      3) Usa 'bt' dentro de suma_digitos: ves main -> suma_digitos.
      4) En contar_collatz pon un punto condicional (n == 1) y mira 'pasos'.
    */
    printf("\n--- CUARTA PARTE: Ejercicio guiado ---\n\n");
    printf("Sigue los 4 pasos del comentario anterior.\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

static int factorial(int n) {
    int resultado = 1;
    for (int i = 2; i <= n; i++) {
        resultado *= i;
    }
    return resultado;
}

static int suma_digitos(int n) {
    int suma = 0;
    while (n > 0) {
        int digito = n % 10;
        suma += digito;
        n /= 10;
    }
    return suma;
}

static int contar_collatz(int n) {
    int pasos = 0;
    while (n != 1) {
        if (n % 2 == 0) {
            n /= 2;
        } else {
            n = 3 * n + 1;
        }
        pasos++;
    }
    return pasos;
}
