/*
E16 - Indice de masa corporal (PENDIENTE)

ENUNCIADO:
  Pide peso (kg) y altura (m), calcula el IMC (peso / altura^2) y clasificalo:
  < 18.5 bajo peso, < 25 normal, < 30 sobrepeso, resto obesidad.

EJEMPLO DE EJECUCION:
  Peso y altura: 80 1.75
  IMC 26.1 -> Sobrepeso

PISTA:
  Muestra el IMC con una decimal.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    double peso = 0, altura = 1;
    printf("Peso y altura: ");
    scanf("%lf %lf", &peso, &altura);
    // TODO: calcula el IMC
    double imc = 0;
    printf("IMC %.1f -> ", imc);
    // TODO: muestra la clasificacion
    return 0;
}
