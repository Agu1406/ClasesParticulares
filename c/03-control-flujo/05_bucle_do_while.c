/**
 * @file 05_bucle_do_while.c
 * @brief EJERCICIO 5: Bucle do-while
 * 
 * TEORÍA:
 * El bucle do-while es similar al while, pero con una diferencia importante:
 * el código se ejecuta AL MENOS UNA VEZ antes de verificar la condición.
 * 
 * SINTAXIS:
 * do {
 *     // código a repetir
 * } while (condicion);
 * 
 * DIFERENCIAS:
 * - while: verifica la condición ANTES de ejecutar
 * - do-while: ejecuta PRIMERO, luego verifica la condición
 * 
 * USOS COMUNES:
 * - Menús interactivos
 * - Validación de entrada
 * - Cuando necesitas ejecutar al menos una vez
 * 
 * @author Agustín. A. Marquez. Piña
 * @date 2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */

#include <stdio.h>

int main(void) {
    // EJEMPLO 1: Diferencia entre while y do-while
    printf("=== EJEMPLO 1: Diferencia con while ===\n");
    
    // Con while: no se ejecuta si la condición es falsa desde el inicio
    int i = 10;
    printf("Con while (i < 5):\n");
    while (i < 5) {
        printf("Esto no se imprime\n");
        i++;
    }
    
    // Con do-while: se ejecuta al menos una vez
    i = 10;
    printf("\nCon do-while (i < 5):\n");
    do {
        printf("Esto SÍ se imprime (i = %d)\n", i);
        i++;
    } while (i < 5);
    
    // EJEMPLO 2: Menú interactivo
    printf("\n=== EJEMPLO 2: Menú interactivo ===\n");
    int opcion;
    
    // Simulamos un menú que se repite hasta elegir salir
    opcion = 1;  // Inicializamos
    do {
        printf("\n--- Menú ---\n");
        printf("1. Ver perfil\n");
        printf("2. Configuración\n");
        printf("3. Ayuda\n");
        printf("0. Salir\n");
        printf("Opción seleccionada: %d\n", opcion);
        
        // Simulamos cambio de opción
        if (opcion == 1) {
            printf("Mostrando perfil...\n");
            opcion = 2;  // Cambiamos a siguiente opción
        } else if (opcion == 2) {
            printf("Abriendo configuración...\n");
            opcion = 0;  // Salimos
        }
    } while (opcion != 0);
    printf("Saliendo del programa...\n");
    
    // EJEMPLO 3: Validación de entrada
    printf("\n=== EJEMPLO 3: Validación de entrada ===\n");
    int numero;
    
    // Simulamos que pedimos un número entre 1 y 10
    // do {
    //     printf("Ingresa un número entre 1 y 10: ");
    //     scanf("%d", &numero);
    // } while (numero < 1 || numero > 10);
    
    // Para el ejemplo, simulamos valores
    int valores[] = {15, -5, 25, 7};  // Último es válido
    int indice = 0;
    numero = valores[indice];
    
    do {
        if (numero < 1 || numero > 10) {
            printf("Número inválido: %d. Debe estar entre 1 y 10\n", numero);
            indice++;
            numero = valores[indice];
        }
    } while (numero < 1 || numero > 10);
    printf("Número válido: %d\n", numero);
    
    // EJEMPLO 4: Juego de adivinanza
    printf("\n=== EJEMPLO 4: Juego de adivinanza ===\n");
    int numero_secreto = 7;
    int intento;
    int intentos = 0;
    
    // Simulamos intentos
    int intentos_simulados[] = {3, 10, 5, 7};
    indice = 0;
    
    do {
        intento = intentos_simulados[indice];
        intentos++;
        
        if (intento < numero_secreto) {
            printf("Intento %d: %d es muy bajo\n", intentos, intento);
        } else if (intento > numero_secreto) {
            printf("Intento %d: %d es muy alto\n", intentos, intento);
        }
        
        indice++;
    } while (intento != numero_secreto);
    
    printf("¡Correcto! Adivinaste en %d intentos\n", intentos);
    
    // EJEMPLO 5: Suma de números positivos
    printf("\n=== EJEMPLO 5: Suma de números positivos ===\n");
    int suma = 0;
    int num;
    
    // Simulamos entrada de números (termina con número negativo)
    int numeros[] = {5, 10, 3, 8, -1};
    indice = 0;
    num = numeros[indice];
    
    do {
        if (num > 0) {
            suma += num;
            printf("Sumando %d. Suma actual: %d\n", num, suma);
        }
        indice++;
        num = numeros[indice];
    } while (num > 0);
    
    printf("Suma total: %d\n", suma);
    
    // EJEMPLO 6: Contador con do-while
    printf("\n=== EJEMPLO 6: Contador ===\n");
    int contador = 1;
    
    do {
        printf("Contador: %d\n", contador);
        contador++;
    } while (contador <= 5);
    
    // EJEMPLO 7: Calcular promedio (al menos un número)
    printf("\n=== EJEMPLO 7: Promedio ===\n");
    float promedio;
    int cantidad = 0;
    int total = 0;
    int valor;
    
    // Simulamos entrada de valores (termina con 0)
    int valores_promedio[] = {10, 20, 30, 15, 0};
    indice = 0;
    valor = valores_promedio[indice];
    
    do {
        if (valor != 0) {
            total += valor;
            cantidad++;
            printf("Valor %d: %d\n", cantidad, valor);
        }
        indice++;
        valor = valores_promedio[indice];
    } while (valor != 0);
    
    if (cantidad > 0) {
        promedio = (float)total / cantidad;
        printf("Promedio: %.2f\n", promedio);
    }
    
    return 0;
}

/*
 * EJERCICIOS PRÁCTICOS:
 * 
 * 1. Crea un menú que se repita hasta que el usuario elija salir
 * 2. Pide al usuario un número positivo (valida con do-while)
 * 3. Calcula el promedio de números hasta que se ingrese 0
 * 4. Crea un juego donde el usuario debe adivinar un número
 * 5. Pide una contraseña hasta que sea correcta (simulado)
 * 
 * RECUERDA: do-while garantiza al menos una ejecución,
 * útil para menús y validaciones donde necesitas pedir
 * entrada al menos una vez.
 */

