/*
U02 - Funciones que devuelven un valor (return).

OBJETIVO:
  - Escribir funciones que calculan un resultado y lo devuelven con return.
  - Usar el valor devuelto: guardarlo, imprimirlo o usarlo en una expresion.
  - Devolver int, double, char y bool.
  - Entender que return termina la funcion inmediatamente.
  - Evitar el error de olvidar el return en funciones no void.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>

int numero_secreto(void);
double area_circulo(double radio);
bool es_par(int n);
char inicial_mayuscula(char letra);
int valor_absoluto(int n);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Devolver un valor.
      El tipo antes del nombre indica que devuelve la funcion. return valor;
      entrega ese valor a quien llamo. El valor se puede guardar o usar directamente.
    */
    printf("--- PRIMERA PARTE: Guardar el resultado ---\n\n");

    int secreto = numero_secreto();
    printf("numero_secreto() = %d\n", secreto);
    printf("Doble del secreto = %d\n", numero_secreto() * 2);

    /*
    SEGUNDA PARTE - Devolver double.
    */
    printf("\n--- SEGUNDA PARTE: double ---\n\n");

    double a = area_circulo(2.5);
    printf("Area de un circulo de radio 2.5: %.3f\n", a);

    /*
    TERCERA PARTE - Devolver bool: funciones "pregunta".
      Por convencion llevan nombres como es_algo, tiene_algo, puede_algo.
      Se usan directamente en un if.
    */
    printf("\n--- TERCERA PARTE: bool ---\n\n");

    for (int n = 1; n <= 4; n++) {
        if (es_par(n)) {
            printf("%d es par\n", n);
        } else {
            printf("%d es impar\n", n);
        }
    }

    /*
    CUARTA PARTE - Devolver char.
    */
    printf("\n--- CUARTA PARTE: char ---\n\n");

    printf("inicial_mayuscula('p') = %c\n", inicial_mayuscula('p'));
    printf("inicial_mayuscula('P') = %c\n", inicial_mayuscula('P'));
    printf("inicial_mayuscula('7') = %c (no es letra: se queda igual)\n", inicial_mayuscula('7'));

    /*
    QUINTA PARTE - return termina la funcion.
      En valor_absoluto, si n es negativo se devuelve -n y el resto de la
      funcion no se ejecuta. Una funcion puede tener varios return, pero
      todos los caminos deben devolver algo.
    */
    printf("\n--- QUINTA PARTE: Varios return ---\n\n");

    printf("valor_absoluto(-8) = %d\n", valor_absoluto(-8));
    printf("valor_absoluto(5)  = %d\n", valor_absoluto(5));

    /*
    SEXTA PARTE - Olvidar el return.
      En una funcion que NO es void, llegar al final sin return es un error
      logico (comportamiento indefinido si usas el valor). El compilador avisa
      con -Wall: "control reaches end of non-void function".
      Ignorar el valor devuelto SI esta permitido: printf tambien devuelve un int.
    */
    printf("\n--- SEXTA PARTE: Ignorar el valor ---\n\n");

    numero_secreto();   // se ejecuta, pero se descarta el resultado
    printf("Llamada sin guardar el resultado: permitida.\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

int numero_secreto(void) {
    return 42;
}

double area_circulo(double radio) {
    const double PI = 3.14159265358979;
    return PI * radio * radio;
}

bool es_par(int n) {
    return n % 2 == 0;
}

char inicial_mayuscula(char letra) {
    if (letra >= 'a' && letra <= 'z') {
        return (char)(letra - 'a' + 'A');
    }
    return letra;
}

int valor_absoluto(int n) {
    if (n < 0) {
        return -n;
    }
    return n;
}
