/*
U06 - Recursividad: funciones que se llaman a si mismas.

OBJETIVO:
  - Entender una funcion recursiva: caso base + caso recursivo.
  - Escribir factorial, suma, potencia, Fibonacci y MCD de forma recursiva.
  - Comparar la version recursiva con la iterativa (bucle).
  - Visualizar la pila de llamadas.
  - Conocer los riesgos: desbordamiento de pila y coste exponencial.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

long long factorial(int n);
long long factorial_iterativo(int n);
int suma_hasta(int n);
long long potencia(int base, int exponente);
int fibonacci(int n);
int mcd(int a, int b);
void cuenta_atras(int n);
void mostrar_traza(int n, int nivel);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Idea.
      Una funcion recursiva resuelve un problema reduciendolo a una version
      mas pequena de si mismo. Necesita SIEMPRE:
        1) CASO BASE: cuando la solucion es directa (para y devuelve).
        2) CASO RECURSIVO: se llama a si misma con un problema mas pequeno.
      Sin caso base (o sin acercarse a el) se llama infinitamente y el
      programa se cierra por desbordamiento de pila (stack overflow).
    */
    printf("--- PRIMERA PARTE: Cuenta atras recursiva ---\n\n");

    cuenta_atras(5);

    /*
    SEGUNDA PARTE - Factorial.
      n! = n * (n - 1)!        con caso base 0! = 1
    */
    printf("\n--- SEGUNDA PARTE: Factorial ---\n\n");

    printf("factorial(5)            = %lld\n", factorial(5));
    printf("factorial_iterativo(5)  = %lld\n", factorial_iterativo(5));
    printf("factorial(15)           = %lld\n", factorial(15));

    /*
    TERCERA PARTE - La pila de llamadas.
      Cada llamada espera a que termine la siguiente. Se ven bajar y subir.
    */
    printf("\n--- TERCERA PARTE: Traza de la pila ---\n\n");

    mostrar_traza(3, 0);

    /*
    CUARTA PARTE - Suma y potencia.
      suma_hasta(n)   = n + suma_hasta(n - 1)        base: suma_hasta(0) = 0
      potencia(b, e)  = b * potencia(b, e - 1)       base: potencia(b, 0) = 1
    */
    printf("\n--- CUARTA PARTE: Suma y potencia ---\n\n");

    printf("suma_hasta(10) = %d\n", suma_hasta(10));
    printf("potencia(2, 10) = %lld\n", potencia(2, 10));

    /*
    QUINTA PARTE - MCD de Euclides (muy natural en recursivo).
      mcd(a, b) = mcd(b, a % b)       base: mcd(a, 0) = a
    */
    printf("\n--- QUINTA PARTE: MCD ---\n\n");

    printf("mcd(84, 36) = %d\n", mcd(84, 36));

    /*
    SEXTA PARTE - Fibonacci: elegante pero ineficiente.
      fib(n) = fib(n - 1) + fib(n - 2). Cada llamada genera dos mas: el coste
      crece de forma exponencial. fib(40) ya tarda segundos; con un bucle es instantaneo.
    */
    printf("\n--- SEXTA PARTE: Fibonacci ---\n\n");

    printf("Primeros 12 terminos: ");
    for (int i = 0; i < 12; i++) {
        printf("%d ", fibonacci(i));
    }
    printf("\n");

    /*
    SEPTIMA PARTE - Cuando usar recursividad.
      Util en problemas que se definen asi: arboles, directorios, divide y
      venceras, backtracking. Para repetir algo simple, un bucle es mas
      claro y rapido.
    */
    printf("\n--- SEPTIMA PARTE: Recursivo o iterativo ---\n\n");
    printf("Recursivo: naturalidad | Iterativo: velocidad y memoria\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

void cuenta_atras(int n) {
    if (n == 0) {                 // caso base
        printf("Despegue!\n");
        return;
    }
    printf("%d\n", n);
    cuenta_atras(n - 1);          // caso recursivo
}

long long factorial(int n) {
    if (n <= 1) {
        return 1;                 // caso base
    }
    return n * factorial(n - 1);  // caso recursivo
}

long long factorial_iterativo(int n) {
    long long resultado = 1;
    for (int i = 2; i <= n; i++) {
        resultado *= i;
    }
    return resultado;
}

void mostrar_traza(int n, int nivel) {
    printf("%*sentra n=%d\n", nivel * 2, "", n);
    if (n > 0) {
        mostrar_traza(n - 1, nivel + 1);
    }
    printf("%*ssale  n=%d\n", nivel * 2, "", n);
}

int suma_hasta(int n) {
    if (n == 0) {
        return 0;
    }
    return n + suma_hasta(n - 1);
}

long long potencia(int base, int exponente) {
    if (exponente == 0) {
        return 1;
    }
    return base * potencia(base, exponente - 1);
}

int fibonacci(int n) {
    if (n < 2) {
        return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}

int mcd(int a, int b) {
    if (b == 0) {
        return a;
    }
    return mcd(b, a % b);
}
