/**
 * @file 02_switch.c
 * @brief EJERCICIO 2: Estructura switch
 * 
 * TEORÍA:
 * La estructura switch permite seleccionar una de varias opciones
 * basándose en el valor de una variable. Es más eficiente que múltiples
 * if-else cuando se comparan muchos valores específicos.
 * 
 * SINTAXIS:
 * switch (variable) {
 *     case valor1:
 *         // código para valor1
 *         break;
 *     case valor2:
 *         // código para valor2
 *         break;
 *     default:
 *         // código si no coincide con ningún case
 * }
 * 
 * IMPORTANTE:
 * - La variable debe ser de tipo entero o carácter
 * - Cada case debe terminar con break (excepto si quieres que continúe)
 * - default es opcional pero recomendado
 * 
 * @author Agustín. A. Marquez. Piña
 * @date 2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */

#include <stdio.h>

int main(void) {
    // EJEMPLO 1: switch básico con números
    printf("=== EJEMPLO 1: switch básico ===\n");
    int opcion = 2;
    
    switch (opcion) {
        case 1:
            printf("Seleccionaste la opción 1\n");
            break;
        case 2:
            printf("Seleccionaste la opción 2\n");
            break;
        case 3:
            printf("Seleccionaste la opción 3\n");
            break;
        default:
            printf("Opción no válida\n");
    }
    
    // EJEMPLO 2: switch con caracteres
    printf("\n=== EJEMPLO 2: switch con caracteres ===\n");
    char operacion = '+';
    int x = 10, y = 5, resultado;
    
    switch (operacion) {
        case '+':
            resultado = x + y;
            printf("%d + %d = %d\n", x, y, resultado);
            break;
        case '-':
            resultado = x - y;
            printf("%d - %d = %d\n", x, y, resultado);
            break;
        case '*':
            resultado = x * y;
            printf("%d * %d = %d\n", x, y, resultado);
            break;
        case '/':
            if (y != 0) {
                resultado = x / y;
                printf("%d / %d = %d\n", x, y, resultado);
            } else {
                printf("No se puede dividir por cero\n");
            }
            break;
        default:
            printf("Operación no válida\n");
    }
    
    // EJEMPLO 3: Días de la semana
    printf("\n=== EJEMPLO 3: Días de la semana ===\n");
    int dia = 3;
    
    switch (dia) {
        case 1:
            printf("Lunes\n");
            break;
        case 2:
            printf("Martes\n");
            break;
        case 3:
            printf("Miércoles\n");
            break;
        case 4:
            printf("Jueves\n");
            break;
        case 5:
            printf("Viernes\n");
            break;
        case 6:
            printf("Sábado\n");
            break;
        case 7:
            printf("Domingo\n");
            break;
        default:
            printf("Día no válido (debe ser 1-7)\n");
    }
    
    // EJEMPLO 4: Múltiples cases sin break (fall-through)
    printf("\n=== EJEMPLO 4: Fall-through ===\n");
    int mes = 2;  // Febrero
    
    switch (mes) {
        case 12:
        case 1:
        case 2:
            printf("Es invierno\n");
            break;
        case 3:
        case 4:
        case 5:
            printf("Es primavera\n");
            break;
        case 6:
        case 7:
        case 8:
            printf("Es verano\n");
            break;
        case 9:
        case 10:
        case 11:
            printf("Es otoño\n");
            break;
        default:
            printf("Mes no válido\n");
    }
    
    // EJEMPLO 5: Calificaciones con letras
    printf("\n=== EJEMPLO 5: Sistema de calificaciones ===\n");
    char calificacion = 'B';
    
    switch (calificacion) {
        case 'A':
        case 'a':
            printf("Excelente (90-100)\n");
            break;
        case 'B':
        case 'b':
            printf("Muy bien (80-89)\n");
            break;
        case 'C':
        case 'c':
            printf("Bien (70-79)\n");
            break;
        case 'D':
        case 'd':
            printf("Suficiente (60-69)\n");
            break;
        case 'F':
        case 'f':
            printf("Reprobado (0-59)\n");
            break;
        default:
            printf("Calificación no válida\n");
    }
    
    // EJEMPLO 6: Menú interactivo (simulado)
    printf("\n=== EJEMPLO 6: Menú ===\n");
    int menu_opcion = 1;
    
    switch (menu_opcion) {
        case 1:
            printf("1. Ver perfil\n");
            printf("   Mostrando perfil del usuario...\n");
            break;
        case 2:
            printf("2. Configuración\n");
            printf("   Abriendo configuración...\n");
            break;
        case 3:
            printf("3. Salir\n");
            printf("   Cerrando aplicación...\n");
            break;
        default:
            printf("Opción no válida\n");
    }
    
    return 0;
}

/*
 * EJERCICIOS PRÁCTICOS:
 * 
 * 1. Crea un menú con 4 opciones usando switch
 * 2. Pide al usuario un número del 1 al 12 y muestra el mes correspondiente
 * 3. Crea una calculadora simple con switch (+, -, *, /)
 * 4. Determina el tipo de triángulo según sus lados usando switch
 * 5. Crea un sistema de calificaciones que convierta números a letras
 * 
 * NOTA: switch solo funciona con valores constantes (números o caracteres),
 * no funciona con rangos o expresiones complejas. Para rangos, usa if-else.
 */

