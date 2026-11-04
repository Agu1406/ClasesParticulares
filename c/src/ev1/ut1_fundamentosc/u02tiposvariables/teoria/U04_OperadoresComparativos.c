/*
U04 — Operadores de comparacion.

En C una comparacion vale 0 (falso) o 1 (verdadero).
Con <stdbool.h> puedes guardarla en un bool.

OBJETIVO:
  - Usar == != < > <= >= e imprimir el resultado con %d.
  - Escribir rangos con && (nunca 1 <= x <= 10).
  - Comparar caracteres por ASCII; las cadenas van con strcmp (UT3).
  - No confundir = (asignar) con == (comparar).

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
    PRIMERA PARTE - Los seis operadores (resultado 0 o 1).
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
    SEGUNDA PARTE - Guardar en bool y usar en decisiones.
    */
    printf("\n--- SEGUNDA PARTE: bool y notas ---\n\n");

    double precio_ayer = 12.50;
    double precio_hoy = 14.00;
    bool ha_subido = precio_hoy > precio_ayer;
    printf("¿Ha subido el precio? %d\n", ha_subido);

    int nota = 5;
    bool aprobado = nota >= 5;
    printf("nota %d -> aprobado: %d\n", nota, aprobado);
    if (aprobado) {
        printf("Enhorabuena.\n");
    } else {
        printf("A recuperar.\n");
    }

    /*
    TERCERA PARTE - Rangos.
      Bien:  x >= 1 && x <= 10
      Mal:   1 <= x <= 10   (C lo interpreta mal)
    */
    printf("\n--- TERCERA PARTE: Rangos ---\n\n");

    int edad = 17;
    bool adulto = edad >= 18;
    bool joven = edad >= 14 && edad <= 25;
    bool fuera = edad < 0 || edad > 120;
    printf("edad = %d -> adulto=%d joven=%d fuera=%d\n",
           edad, adulto, joven, fuera);

    int x = 50;
    int primera = 1 <= x;
    printf("(1 <= 50) <= 10 da %d (casi siempre 1: forma incorrecta)\n", primera <= 10);
    printf("1 <= x && x <= 10 da %d (forma correcta)\n", 1 <= x && x <= 10);

    /*
    CUARTA PARTE - Caracteres (ASCII). Cadenas: strcmp en UT3.
    */
    printf("\n--- CUARTA PARTE: Caracteres ---\n\n");

    char c1 = 'A', c2 = 'B';
    printf("'%c' < '%c' ? %d\n", c1, c2, c1 < c2);
    printf("'a' == 'A' ? %d (distinto codigo ASCII)\n", 'a' == 'A');

    /*
    QUINTA PARTE - = frente a ==.
      if (valor = 5) asigna y suele entrar siempre.
      Compila con -Wall. Truco: if (5 == valor).
    */
    printf("\n--- QUINTA PARTE: = vs == ---\n\n");

    int valor = 4;
    if (valor == 5) {
        printf("valor vale 5\n");
    } else {
        printf("valor NO vale 5 (vale %d)\n", valor);
    }
    printf("Nunca uses un solo = dentro del if para comparar.\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
