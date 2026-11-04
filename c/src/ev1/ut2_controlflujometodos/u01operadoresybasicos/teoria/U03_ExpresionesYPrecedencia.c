/*
U03 — Expresiones, precedencia y asociatividad.

OBJETIVO:
  - Conocer el orden en que C agrupa los operadores (precedencia).
  - Saber la asociatividad (izquierda/derecha) y usar parentesis.
  - Detectar la trampa flags & 4 == 4 (en C SI compila y falla en silencio).
  - Distinguir precedencia (agrupacion) de orden de evaluacion.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Tabla de precedencia (de mayor a menor, resumen).
       1  ()  []  ->  .   x++  x--
       2  ++x  --x  +x  -x  !  ~  (tipo)  sizeof
       3  *  /  %
       4  +  -
       5  <<  >>
       6  <  <=  >  >=
       7  ==  !=
       8  &
       9  ^
      10  |
      11  &&
      12  ||
      13  ? :
      14  =  +=  -=  ...
      15  ,
      No memorices todo: lo comun + parentesis.
    */
    printf("--- PRIMERA PARTE: Aritmetica y parentesis ---\n\n");

    printf("2 + 3 * 4        = %d\n", 2 + 3 * 4);
    printf("(2 + 3) * 4      = %d\n", (2 + 3) * 4);
    printf("10 - 4 - 3       = %d (izquierda a derecha)\n", 10 - 4 - 3);
    printf("100 / 5 / 2      = %d\n", 100 / 5 / 2);
    printf("-3 * 2           = %d (menos unario primero)\n", -3 * 2);
    printf("7 %% 4 * 2        = %d (%% y * misma precedencia)\n", 7 % 4 * 2);

    /*
    SEGUNDA PARTE - Asociatividad.
      Misma precedencia: a - b - c -> (a - b) - c
      Asignacion: a = b = c -> a = (b = c)
    */
    printf("\n--- SEGUNDA PARTE: Asociatividad ---\n\n");

    int a, b, c;
    a = b = c = 4;
    printf("a = b = c = 4 -> a=%d b=%d c=%d\n", a, b, c);
    printf("2 * 3 %% 4 = %d  ((2*3)%%4)\n", 2 * 3 % 4);

    /*
    TERCERA PARTE - Comparacion y logica.
      ! > aritmeticos > relaciones > == != > && > ||
      a || b && c  equivale a  a || (b && c)  — escribe parentesis.
    */
    printf("\n--- TERCERA PARTE: Logica ---\n\n");

    int p = 1, q = 0, r = 0;
    printf("p || (q && r)    = %d (agrupacion por defecto)\n", p || (q && r));
    printf("(p || q) && r    = %d (otro resultado)\n", (p || q) && r);
    printf("!p || q          = %d (! primero)\n", !p || q);
    printf("5 + 3 > 2 * 3    = %d (aritmetica antes de comparar)\n", 5 + 3 > 2 * 3);

    /*
    CUARTA PARTE - Trampa: & frente a == (C SI la compila).
      & tiene MENOS precedencia que ==:
          flags & 4 == 4   ->   flags & (4 == 4)  = flags & 1
      En Java eso ni compila. En C falla en silencio. Usa parentesis:
          (flags & 4) == 4
    */
    printf("\n--- CUARTA PARTE: & frente a == ---\n\n");

    int flags = 4;
    int mal_escrito = flags & (4 == 4);
    int bien_escrito = (flags & 4) == 4;
    printf("flags & 4 == 4   se lee flags & 1  = %d (falla)\n", mal_escrito);
    printf("(flags & 4) == 4                   = %d (correcto)\n", bien_escrito);

    /*
    QUINTA PARTE - Parentesis que salvan una formula.
      Ejemplo clasico: Celsius desde Fahrenheit.
    */
    printf("\n--- QUINTA PARTE: Parentesis en formulas ---\n\n");

    int fahrenheit = 98;
    int celsius = (fahrenheit - 32) * 5 / 9;
    int mal_celsius = fahrenheit - 32 * 5 / 9;
    printf("(98 - 32) * 5 / 9 = %d (correcto)\n", celsius);
    printf("98 - 32 * 5 / 9   = %d (sin parentesis, mal)\n", mal_celsius);

    /*
    SEXTA PARTE - Precedencia no es orden de evaluacion.
      En f() + g() * h() la precedencia agrupa el *, pero NO dice
      cual funcion se llama primero. Solo && || ?: y la coma
      garantizan izquierda a derecha. No dependas del orden.
    */
    printf("\n--- SEXTA PARTE: Orden de evaluacion ---\n\n");
    printf("Precedencia = como se agrupa. Orden de llamada = otra cosa.\n");
    printf("Confia en && || ?: y la coma; en el resto usa variables intermedias.\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
