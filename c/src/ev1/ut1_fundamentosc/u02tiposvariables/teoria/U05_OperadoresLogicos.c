/*
U05 — Operadores logicos.

Permiten combinar condiciones: si "X" cumple varias reglas, el programa
actua de una forma u otra.

OBJETIVO:
  - Usar && (AND), || (OR) y ! (NOT).
  - Encadenar varias condiciones con ejemplos de la vida real.
  - Entender la evaluacion en cortocircuito.
  - Conocer las leyes de De Morgan a nivel basico.

En C:
  - and  -> &&
  - or   -> ||
  - not  -> !

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>

static bool comprobar(const char *nombre, bool valor) {
    printf("    (se evalua %s -> %d)\n", nombre, valor);
    return valor;
}

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    int edad_p = 26;
    double altura_p = 1.76;
    const char *nombre_p = "Agustin";

    int edad_a = 29;
    double altura_a = 1.74;
    const char *nombre_a = "Eduardo";

    /*
    PRIMERA PARTE - && (AND): las DOS (o mas) condiciones deben ser true.
    */
    printf("--- PRIMERA PARTE: Montana rusa (&&) ---\n\n");

    bool puede_subir = altura_p >= 1.75 && edad_p >= 18;
    printf("¿El profesor puede subir? %s\n", puede_subir ? "true" : "false");

    puede_subir = altura_a >= 1.75 && edad_a >= 18;
    printf("¿El alumno puede subir? %s\n", puede_subir ? "true" : "false");

    printf("\n--- Club de Eduardos (varios &&) ---\n\n");
    bool puede_entrar = edad_a >= 18 && altura_a > 1.50 && nombre_a[0] == 'E';
    printf("¿El alumno puede entrar? %s\n", puede_entrar ? "true" : "false");
    puede_entrar = edad_p >= 18 && altura_p > 1.50 && nombre_p[0] == 'E';
    printf("¿El profesor puede entrar? %s\n", puede_entrar ? "true" : "false");

    /*
    SEGUNDA PARTE - || (OR): basta con que UNA condicion sea true.
    */
    printf("\n--- SEGUNDA PARTE: Tinto de verano (||) ---\n\n");

    bool hoy_cobre = true;
    bool hoy_sabado = false;
    bool hoy_domingo = false;
    bool compro_tinto = hoy_cobre || hoy_sabado || hoy_domingo;
    printf("¿Compro tinto de verano? %s\n", compro_tinto ? "true" : "false");

    /*
    TERCERA PARTE - ! (NOT): invierte el valor.
    */
    printf("\n--- TERCERA PARTE: Parque con NOT (!) ---\n\n");

    bool hoy_llueve = false;
    bool vamos_parque = !hoy_llueve;
    printf("¿Hoy llueve? %s | ¿Vamos al parque? %s\n",
           hoy_llueve ? "true" : "false",
           vamos_parque ? "true" : "false");

    bool fin_de_semana = hoy_sabado || hoy_domingo;
    bool dia_ideal = fin_de_semana && !hoy_llueve;
    printf("¿Dia ideal para parque? %s\n", dia_ideal ? "true" : "false");

    /*
    CUARTA PARTE - Tabla de verdad y precedencia.
      Precedencia: ! primero, luego &&, luego ||. Usa parentesis.
    */
    printf("\n--- CUARTA PARTE: Tabla de verdad ---\n\n");

    printf(" A  B | A&&B  A||B | !A\n");
    printf("------+------------+----\n");
    for (int i = 1; i >= 0; i--) {
        for (int j = 1; j >= 0; j--) {
            printf(" %d  %d |  %d     %d   |  %d\n", i, j, i && j, i || j, !i);
        }
    }

    /*
    QUINTA PARTE - Cortocircuito.
      En A && B, si A es falso no se evalua B.
      En A || B, si A es verdadero no se evalua B.
      Util: if (divisor != 0 && total / divisor > 2)
    */
    printf("\n--- QUINTA PARTE: Cortocircuito ---\n\n");

    printf("falso && algo:\n");
    comprobar("A", false) && comprobar("B", true);
    printf("verdadero || algo:\n");
    comprobar("A", true) || comprobar("B", true);

    int total = 10, divisor = 0;
    if (divisor != 0 && total / divisor > 2) {
        printf("division mayor que 2\n");
    } else {
        printf("No se dividio entre 0 gracias al cortocircuito\n");
    }

    /*
    SEXTA PARTE - De Morgan (resumen).
        !(A && B)  ==  !A || !B
        !(A || B)  ==  !A && !B
    */
    printf("\n--- SEXTA PARTE: De Morgan ---\n\n");

    bool p = true, q = false;
    printf("!(p && q) = %d   y   !p || !q = %d\n", !(p && q), !p || !q);
    printf("!(p || q) = %d   y   !p && !q = %d\n", !(p || q), !p && !q);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
