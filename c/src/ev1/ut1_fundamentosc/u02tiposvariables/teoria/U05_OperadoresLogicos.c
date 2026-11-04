/*
U05 — Operadores logicos.

Combinan condiciones: && (Y), || (O), ! (NO).
El resultado es 0 o 1 (o un bool).

OBJETIVO:
  - Usar &&, || y ! con ejemplos claros.
  - Ver la tabla de verdad y la precedencia (! luego && luego ||).
  - Entender el cortocircuito (evita dividir entre 0).
  - Conocer De Morgan a nivel basico.

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
    PRIMERA PARTE - && : las DOS condiciones deben cumplirse.
      Ejemplo: para conducir hace falta edad y carnet.
    */
    printf("--- PRIMERA PARTE: && (Y) ---\n\n");

    int edad = 20;
    bool tiene_carnet = true;
    bool puede_conducir = edad >= 18 && tiene_carnet;
    printf("edad=%d carnet=%d -> puede conducir: %d\n",
           edad, tiene_carnet, puede_conducir);

    edad = 16;
    puede_conducir = edad >= 18 && tiene_carnet;
    printf("edad=%d carnet=%d -> puede conducir: %d\n",
           edad, tiene_carnet, puede_conducir);

    /*
    SEGUNDA PARTE - || : basta con que UNA se cumpla.
    */
    printf("\n--- SEGUNDA PARTE: || (O) ---\n\n");

    bool es_festivo = false;
    bool es_fin_de_semana = true;
    bool libre = es_festivo || es_fin_de_semana;
    printf("festivo=%d finde=%d -> dia libre: %d\n",
           es_festivo, es_fin_de_semana, libre);

    /*
    TERCERA PARTE - ! : invierte.
    */
    printf("\n--- TERCERA PARTE: ! (NO) ---\n\n");

    bool llueve = false;
    bool salgo = !llueve;
    printf("llueve=%d -> salgo: %d\n", llueve, salgo);

    bool dia_ideal = es_fin_de_semana && !llueve;
    printf("finde y no llueve -> dia ideal: %d\n", dia_ideal);

    /*
    CUARTA PARTE - Tabla de verdad (0 y 1).
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
      En A && B, si A es 0 no se evalua B.
      En A || B, si A es 1 no se evalua B.
      Util para no dividir entre cero.
    */
    printf("\n--- QUINTA PARTE: Cortocircuito ---\n\n");

    int total = 10;
    int divisor = 0;
    if (divisor != 0 && total / divisor > 2) {
        printf("cociente mayor que 2\n");
    } else {
        printf("No se dividio entre 0: primero se comprobo divisor != 0\n");
    }

    /*
    SEXTA PARTE - De Morgan (resumen).
      !(A && B) equivale a !A || !B
      !(A || B) equivale a !A && !B
    */
    printf("\n--- SEXTA PARTE: De Morgan ---\n\n");

    bool p = true;
    bool q = false;
    printf("!(p && q)=%d  |  !p || !q=%d\n", !(p && q), !p || !q);
    printf("!(p || q)=%d  |  !p && !q=%d\n", !(p || q), !p && !q);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
