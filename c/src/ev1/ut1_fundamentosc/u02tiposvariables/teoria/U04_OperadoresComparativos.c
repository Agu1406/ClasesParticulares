/*
U04 — Operadores de comparacion.

Los comparadores devuelven 0 (falso) o 1 (verdadero). Con <stdbool.h>
puedes guardarlos en un bool.

OBJETIVO:
  - Usar == != < > <= >=
  - Guardar el resultado en un bool o imprimirlo directamente.
  - Evitar el error clasico: = (asignar) frente a == (comparar).
  - No escribir rangos como 1 <= x <= 10 (en C falla; usa &&).

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
    PRIMERA PARTE - Los seis operadores.
        ==  igual      !=  distinto
        <   menor      >   mayor
        <=  menor o igual      >=  mayor o igual
    */
    printf("--- PRIMERA PARTE: Comparaciones ---\n\n");

    int a = 8, b = 5;
    printf("%d == %d -> %d\n", a, b, a == b);
    printf("%d != %d -> %d\n", a, b, a != b);
    printf("%d <  %d -> %d\n", a, b, a < b);
    printf("%d >  %d -> %d\n", a, b, a > b);
    printf("%d <= %d -> %d\n", a, b, a <= b);
    printf("%d >= %d -> %d\n", a, b, a >= b);

    /*
    SEGUNDA PARTE - Guardar el resultado en bool (ejemplos de clase).
    */
    printf("\n--- SEGUNDA PARTE: bool e ingresos ---\n\n");

    double ingresos_anterior = 1400.56;
    double ingresos_actual = 2345.12;
    bool iguales = ingresos_actual == ingresos_anterior;
    bool han_subido = ingresos_actual > ingresos_anterior;
    printf("¿Ingresos iguales? %s\n", iguales ? "true" : "false");
    printf("¿Han subido? %s\n", han_subido ? "true" : "false");

    int nota = 5;
    printf("nota (%d) >= 5 ? %s\n", nota, nota >= 5 ? "true" : "false");
    printf("nota (%d) <= 4 ? %s\n", nota, nota <= 4 ? "true" : "false");

    /*
    TERCERA PARTE - Rangos: dentro y fuera.
      "x esta entre 1 y 10" ->  x >= 1 && x <= 10
      NO: 1 <= x <= 10 (se lee mal, pero a veces compila).
    */
    printf("\n--- TERCERA PARTE: Rangos ---\n\n");

    int edad = 17;
    bool adulto = edad >= 18;
    bool joven = edad >= 14 && edad <= 25;
    bool fuera = edad < 0 || edad > 120;
    printf("edad = %d -> adulto: %d, joven: %d, fuera: %d\n",
           edad, adulto, joven, fuera);

    int x = 50;
    int primera = 1 <= x;
    printf("(1 <= 50) <= 10 da %d aunque 50 NO esta entre 1 y 10\n", primera <= 10);
    printf("1 <= x && x <= 10 da %d (forma correcta)\n", 1 <= x && x <= 10);

    /*
    CUARTA PARTE - Caracteres: se comparan por codigo ASCII.
      En C no compares cadenas con == (eso es para UT3: strcmp).
    */
    printf("\n--- CUARTA PARTE: Comparar caracteres ---\n\n");

    char c1 = 'A', c2 = 'B';
    printf("'%c' < '%c' ? %s\n", c1, c2, c1 < c2 ? "true" : "false");
    printf("'a' == 'A' ? %s (distinto codigo ASCII)\n",
           'a' == 'A' ? "true" : "false");

    /*
    QUINTA PARTE - = frente a ==.
      if (x = 5) asigna y suele ser siempre verdadero.
      Truco: if (5 == x) convierte el descuido en error de compilacion.
      Compila siempre con -Wall.
    */
    printf("\n--- QUINTA PARTE: = vs == ---\n\n");

    int valor = 4;
    if (valor == 5) {
        printf("valor vale 5\n");
    } else {
        printf("valor NO vale 5 (vale %d)\n", valor);
    }
    printf("Si hubieras escrito (valor = 5) la condicion seria verdadera.\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
