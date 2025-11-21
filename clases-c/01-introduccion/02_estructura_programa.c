/**
 * @file 02_estructura_programa.c
 * @brief EJERCICIO 2: Estructura de un Programa en C
 * 
 * OBJETIVO: Entender las partes fundamentales de un programa en C
 * 
 * COMPONENTES:
 * 1. Directivas del preprocesador (#include)
 * 2. Comentarios (/* y //)
 * 3. Función main (obligatoria)
 * 4. Declaraciones y sentencias
 * 
 * @author Agustín. A. Marquez. Piña
 * @date 2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */

// Directiva del preprocesador: incluye la biblioteca estándar de entrada/salida
#include <stdio.h>

// La función main es el punto de entrada de todo programa en C
// int indica que retorna un número entero
// void indica que no recibe parámetros (por ahora)
int main(void) {
    // DECLARACIÓN: Reservamos espacio en memoria para una variable
    int numero;
    
    // ASIGNACIÓN: Guardamos un valor en la variable
    numero = 42;
    
    // SENTENCIA: Mostramos el valor usando printf
    printf("El valor de numero es: %d\n", numero);
    
    // También podemos declarar y asignar en una sola línea
    int otro_numero = 100;
    printf("El valor de otro_numero es: %d\n", otro_numero);
    
    // return termina la función y retorna un valor al sistema
    return 0;  // 0 significa "éxito"
}

/*
 * NOTAS IMPORTANTES:
 * - Todo programa en C debe tener una función main
 * - Las sentencias terminan con punto y coma (;)
 * - C distingue entre mayúsculas y minúsculas
 * - Los comentarios no afectan la ejecución del programa
 */

