/*
U03 - Parametros de las funciones: paso por valor.

OBJETIVO:
  - Pasar datos a una funcion mediante parametros.
  - Diferenciar PARAMETRO (en la definicion) de ARGUMENTO (en la llamada).
  - Entender que C pasa SIEMPRE por valor: la funcion recibe una COPIA.
  - Comprobar que modificar un parametro no cambia la variable original.
  - Usar varios parametros y mezclar tipos (con conversion implicita).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

void saludar_a(const char *nombre);
int sumar(int a, int b);
double media_de_tres(double a, double b, double c);
void intentar_duplicar(int x);
void repetir_texto(const char *texto, int veces);
double precio_con_descuento(double precio, int porcentaje);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Parametros y argumentos.
      void saludar_a(const char *nombre)   <- PARAMETRO: variable local de la funcion
      saludar_a("Lucia");                  <- ARGUMENTO: valor concreto que se pasa
      Los argumentos se asignan a los parametros EN ORDEN.
    */
    printf("--- PRIMERA PARTE: Un parametro ---\n\n");

    saludar_a("Lucia");
    saludar_a("Pablo");

    /*
    SEGUNDA PARTE - Varios parametros.
      El orden y el tipo importan. Los argumentos pueden ser valores,
      variables o expresiones.
    */
    printf("\n--- SEGUNDA PARTE: Varios parametros ---\n\n");

    int x = 4, y = 9;
    printf("sumar(%d, %d) = %d\n", x, y, sumar(x, y));
    printf("sumar(x * 2, 10) = %d\n", sumar(x * 2, 10));
    printf("media_de_tres(6, 7.5, 9) = %.2f\n", media_de_tres(6, 7.5, 9));

    /*
    TERCERA PARTE - Paso por valor (la copia).
      La funcion recibe una COPIA del argumento. Cambiar el parametro dentro
      de la funcion NO cambia la variable de fuera.
      (Para modificar la original se usan punteros: ver U07.)
    */
    printf("\n--- TERCERA PARTE: Paso por valor ---\n\n");

    int numero = 5;
    printf("Antes de la llamada: numero = %d\n", numero);
    intentar_duplicar(numero);
    printf("Despues de la llamada: numero = %d (no ha cambiado)\n", numero);

    /*
    CUARTA PARTE - Funcion con parametros y bucle.
    */
    printf("\n--- CUARTA PARTE: Repetir ---\n\n");

    repetir_texto("Hola ", 3);
    repetir_texto("-", 20);

    /*
    QUINTA PARTE - Conversion de argumentos.
      Si pasas un int donde se espera un double, C lo convierte solo.
      Al reves (double a int) pierdes los decimales: ten cuidado.
    */
    printf("\n--- QUINTA PARTE: Conversion implicita ---\n\n");

    printf("Precio 80 con 15%% de descuento: %.2f\n", precio_con_descuento(80, 15));
    printf("Precio 59.99 con 10%% de descuento: %.2f\n", precio_con_descuento(59.99, 10));

    /*
    SEXTA PARTE - Errores tipicos.
      - Pasar menos o mas argumentos de los esperados: error de compilacion
        (cuando hay prototipo; sin el, comportamiento indefinido).
      - Intercambiar el orden de argumentos del mismo tipo: compila y falla.
      - Esperar que la funcion cambie la variable original sin punteros.
    */
    printf("\n--- SEXTA PARTE: Errores tipicos ---\n\n");
    printf("Mismo numero y tipo de argumentos, en el mismo orden que los parametros.\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

void saludar_a(const char *nombre) {
    printf("Hola, %s!\n", nombre);
}

int sumar(int a, int b) {
    return a + b;
}

double media_de_tres(double a, double b, double c) {
    return (a + b + c) / 3;
}

void intentar_duplicar(int x) {
    x = x * 2;                         // solo cambia la copia
    printf("  Dentro de la funcion: x = %d\n", x);
}

void repetir_texto(const char *texto, int veces) {
    for (int i = 0; i < veces; i++) {
        printf("%s", texto);
    }
    printf("\n");
}

double precio_con_descuento(double precio, int porcentaje) {
    return precio * (100 - porcentaje) / 100.0;
}
