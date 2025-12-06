/**
 * @file 05_operadores_logicos.c
 * @brief EJERCICIO 4: Operadores Lógicos y Relacionales
 * 
 * OBJETIVO: Aprender a comparar valores y usar lógica booleana
 * 
 * OPERADORES RELACIONALES (comparan valores):
 * == : Igual a
 * != : Diferente de
 * <  : Menor que
 * >  : Mayor que
 * <= : Menor o igual que
 * >= : Mayor o igual que
 * 
 * OPERADORES LÓGICOS:
 * && : AND (y)
 * 
 * @author Agustín. A. Marquez. Piña
 * @date 2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
 * || : OR (o)
 * !  : NOT (no)
 */

#include <stdio.h>
#include <stdbool.h>  // Para usar bool, true, false

int main(void) {
    int a = 10;
    int b = 5;
    int c = 10;
    
    // OPERADORES RELACIONALES
    // Retornan 1 (true) o 0 (false)
    printf("OPERADORES RELACIONALES:\n");
    printf("%d == %d: %d\n", a, c, a == c);  // 1 (verdadero)
    printf("%d == %d: %d\n", a, b, a == b);  // 0 (falso)
    printf("%d != %d: %d\n", a, b, a != b);  // 1 (verdadero)
    printf("%d < %d: %d\n", b, a, b < a);    // 1 (verdadero)
    printf("%d > %d: %d\n", a, b, a > b);    // 1 (verdadero)
    printf("%d <= %d: %d\n", a, c, a <= c);  // 1 (verdadero)
    printf("%d >= %d: %d\n", b, a, b >= a);  // 0 (falso)
    
    // OPERADORES LÓGICOS
    printf("\nOPERADORES LÓGICOS:\n");
    
    // AND (&&): Verdadero solo si ambas condiciones son verdaderas
    bool condicion1 = (a > b) && (a == c);
    printf("(%d > %d) && (%d == %d): %d\n", a, b, a, c, condicion1);
    
    bool condicion2 = (a < b) && (a == c);
    printf("(%d < %d) && (%d == %d): %d\n", a, b, a, c, condicion2);
    
    // OR (||): Verdadero si al menos una condición es verdadera
    bool condicion3 = (a < b) || (a == c);
    printf("(%d < %d) || (%d == %d): %d\n", a, b, a, c, condicion3);
    
    // NOT (!): Invierte el valor booleano
    bool condicion4 = !(a == b);
    printf("!(%d == %d): %d\n", a, b, condicion4);
    
    // EJEMPLOS PRÁCTICOS
    printf("\nEJEMPLOS PRÁCTICOS:\n");
    
    int edad = 20;
    bool tiene_licencia = 1;  // 1 = true, 0 = false
    
    // Puede conducir si tiene más de 18 años Y tiene licencia
    bool puede_conducir = (edad >= 18) && tiene_licencia;
    printf("Edad: %d, Licencia: %d, Puede conducir: %d\n", 
           edad, tiene_licencia, puede_conducir);
    
    int temperatura = 25;
    // Hace buen tiempo si está entre 20 y 30 grados
    bool buen_tiempo = (temperatura >= 20) && (temperatura <= 30);
    printf("Temperatura: %d°C, Buen tiempo: %d\n", temperatura, buen_tiempo);
    
    // Puede entrar gratis si es menor de 12 años O mayor de 65
    int edad_persona = 70;
    bool entrada_gratis = (edad_persona < 12) || (edad_persona > 65);
    printf("Edad: %d, Entrada gratis: %d\n", edad_persona, entrada_gratis);
    
    return 0;
}

/*
 * EJERCICIOS:
 * 1. Evalúa si un número está entre 10 y 20 (inclusive)
 * 2. Determina si un año es bisiesto (divisible por 4 pero no por 100, o divisible por 400)
 * 3. Verifica si un número es par Y positivo
 * 4. Crea condiciones para determinar si alguien puede votar (mayor de 18)
 */

