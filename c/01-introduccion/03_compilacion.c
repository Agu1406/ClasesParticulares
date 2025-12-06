/**
 * @file 03_compilacion.c
 * @brief EJERCICIO 3: Compilación y Ejecución
 * 
 * OBJETIVO: Aprender a compilar y ejecutar programas en C
 * 
 * PASOS PARA COMPILAR Y EJECUTAR:
 * 
 * @author Agustín. A. Marquez. Piña
 * @date 2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
 * 
 * 1. COMPILAR (crear el ejecutable):
 *    gcc 03_compilacion.c -o programa
 *    
 *    O en Windows con MinGW:
 *    gcc 03_compilacion.c -o programa.exe
 * 
 * 2. EJECUTAR:
 *    En Linux/Mac: ./programa
 *    En Windows: programa.exe
 * 
 * 3. COMPILAR Y EJECUTAR EN UN SOLO PASO:
 *    gcc 03_compilacion.c -o programa && ./programa
 */

#include <stdio.h>

int main(void) {
    printf("Este programa fue compilado exitosamente!\n");
    printf("Si ves este mensaje, todo está funcionando correctamente.\n");
    
    // Podemos hacer cálculos simples
    int resultado = 5 + 3;
    printf("5 + 3 = %d\n", resultado);
    
    return 0;
}

/*
 * ERRORES COMUNES AL COMPILAR:
 * 
 * 1. Error de sintaxis: falta punto y coma, llaves, etc.
 * 2. Error de enlace: función no definida (falta #include)
 * 3. Warning: el programa compila pero hay advertencias
 * 
 * EJERCICIO:
 * Intenta compilar este programa y ejecutarlo.
 * Luego modifica algo para generar un error y observa el mensaje.
 */

