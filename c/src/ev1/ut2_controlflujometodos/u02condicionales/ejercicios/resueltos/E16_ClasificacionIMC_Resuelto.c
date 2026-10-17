/*
E16 - Indice de masa corporal (RESUELTO)

ENUNCIADO:
  Pide peso (kg) y altura (m), calcula el IMC (peso / altura^2) y clasificalo:
  < 18.5 bajo peso, < 25 normal, < 30 sobrepeso, resto obesidad.

EJEMPLO DE EJECUCION:
  Peso y altura: 80 1.75
  IMC 26.1 -> Sobrepeso

PISTA:
  Muestra el IMC con una decimal.

SOLUCION:
  Se calcula el IMC una vez y se compara por tramos.

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
    double imc = peso / (altura * altura);
    printf("IMC %.1f -> ", imc);
    if (imc < 18.5) {
        printf("Bajo peso\n");
    } else if (imc < 25) {
        printf("Normal\n");
    } else if (imc < 30) {
        printf("Sobrepeso\n");
    } else {
        printf("Obesidad\n");
    }
    return 0;
}
