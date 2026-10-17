/*
U06 - Estilo de codigo y buenas practicas.

OBJETIVO:
  - Escribir codigo legible: nombres claros, sangria y llaves coherentes.
  - Evitar numeros magicos usando constantes con nombre.
  - Comparar un programa "mal escrito" con el mismo programa bien escrito.
  - Conocer la regla de oro: el codigo se lee muchas mas veces de las que se escribe.
  - Revisar una lista de comprobacion antes de entregar un ejercicio.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

#define HORAS_JORNADA 8
#define PRECIO_HORA 12.5
#define PLUS_NOCTURNO 0.25

/*
VERSION MALA: funciona, pero nadie entiende que hace.
  - nombres de una letra, sin sangria, sin constantes, todo en una linea.
*/
static double f(int a, int b) { double c = a * 12.5; if (b == 1) { c = c + c * 0.25; } return c; }

/*
VERSION BUENA: el mismo calculo, pero se lee como una frase.
*/
static double calcular_salario_diario(int horas_trabajadas, int es_turno_nocturno) {
    double salario = horas_trabajadas * PRECIO_HORA;

    if (es_turno_nocturno) {
        salario = salario + salario * PLUS_NOCTURNO;   // plus del 25% por nocturnidad
    }

    return salario;
}

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Mismo resultado, distinta calidad.
    */
    printf("--- PRIMERA PARTE: Malo frente a bueno ---\n\n");

    printf("f(8, 1)                           = %.2f\n", f(8, 1));
    printf("calcular_salario_diario(8, 1)     = %.2f\n", calcular_salario_diario(HORAS_JORNADA, 1));

    /*
    SEGUNDA PARTE - Nombres.
      Reglas:
        - Nombres que describan el contenido: nota_final, total_alumnos.
        - Un estilo coherente: snake_case (todo en minusculas con guion bajo).
        - Variables en minuscula, constantes en MAYUSCULAS.
        - Las funciones son verbos: calcular_media, imprimir_menu.
        - Letras sueltas (i, j) solo como contadores de bucle.
        - Sin tildes ni enie, y mejor en un solo idioma.
    */
    printf("\n--- SEGUNDA PARTE: Nombres ---\n\n");

    int nota_final = 8;               // BIEN
    int n = 8;                        // MAL: que es n?
    printf("nota_final = %d, n = %d (cual es mas claro?)\n", nota_final, n);

    /*
    TERCERA PARTE - Sangria y llaves.
      - 4 espacios por nivel (o un tabulador, pero NUNCA mezclar).
      - Llaves SIEMPRE, aunque el if tenga una sola instruccion:
          if (x > 0) { ... }
        Sin llaves, anadir una segunda linea despues rompe el programa.
      - Una instruccion por linea.
      Los editores formatean solos: en VS Code, Shift + Alt + F.
    */
    printf("\n--- TERCERA PARTE: Sangria y llaves ---\n\n");

    int temperatura = 31;
    if (temperatura > 30) {
        printf("Hace calor\n");
        printf("Bebe agua\n");        // dentro del if gracias a las llaves
    }

    /*
    CUARTA PARTE - Numeros magicos.
      Un numero suelto en el codigo (8, 12.5, 0.25) no explica nada.
      Dale nombre con #define o const: HORAS_JORNADA, PRECIO_HORA...
      Asi cambias el valor en UN solo sitio.
    */
    printf("\n--- CUARTA PARTE: Constantes con nombre ---\n\n");

    printf("Jornada: %d h | Precio hora: %.2f | Plus nocturno: %.0f%%\n",
           HORAS_JORNADA, PRECIO_HORA, PLUS_NOCTURNO * 100);

    /*
    QUINTA PARTE - Funciones cortas y con una sola tarea.
      Si una funcion no cabe en una pantalla, o necesitas la palabra "y"
      para describirla (lee Y calcula Y muestra), dividela.
    */
    printf("\n--- QUINTA PARTE: Una tarea por funcion ---\n\n");
    printf("calcular_salario_diario solo calcula: no lee ni imprime.\n");

    /*
    SEXTA PARTE - Lista de comprobacion antes de entregar.
      [ ] Compila sin errores NI avisos con -Wall -Wextra
      [ ] Todas las variables estan inicializadas
      [ ] Los nombres se entienden sin comentarios
      [ ] No hay numeros magicos
      [ ] Cada scanf comprueba su retorno (cuando el dato importa)
      [ ] El programa muestra mensajes claros al usuario
      [ ] Probado con casos normales y casos limite (0, negativos, muy grandes)
    */
    printf("\n--- SEXTA PARTE: Checklist ---\n\n");
    printf("Compila limpio | Inicializado | Nombres claros | Sin numeros magicos | Probado\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
