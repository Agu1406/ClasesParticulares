/**
 * @file 02_casting.c
 * @brief EJERCICIO 6: Casting (Conversión de Tipos)
 * 
 * TEORÍA:
 * El casting (moldeado) es la conversión explícita de un tipo de dato a otro.
 * En C, hay dos tipos de conversiones:
 * 
 * 1. CONVERSIÓN IMPLÍCITA (automática):
 *    - Ocurre automáticamente cuando se mezclan tipos compatibles
 *    - El compilador convierte el tipo "menor" al tipo "mayor"
 *    - Ejemplo: int + float → float
 * 
 * 2. CONVERSIÓN EXPLÍCITA (casting):
 *    - El programador fuerza la conversión usando (tipo)
 *    - Sintaxis: (tipo_destino) variable
 *    - Útil cuando necesitas controlar la conversión
 * 
 * JERARQUÍA DE CONVERSIÓN (de menor a mayor):
 * char → int → float → double
 * 
 * @author Agustín. A. Marquez. Piña
 * @date 2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
 * 
 * IMPORTANTE:
 * - Al convertir de float/double a int, se trunca (pierde decimales)
 * - Al convertir de int a float, se mantiene el valor pero con decimales
 * - Al convertir de double a float, puede perder precisión
 */

#include <stdio.h>

int main(void) {
    // EJEMPLO 1: Conversión implícita
    printf("=== EJEMPLO 1: Conversión Implícita ===\n");
    int a = 5;
    float b = 3.5f;
    float resultado = a + b;  // int se convierte automáticamente a float
    printf("%d + %.1f = %.1f\n", a, b, resultado);
    
    int c = 10;
    double d = 2.5;
    double resultado2 = c * d;  // int se convierte automáticamente a double
    printf("%d * %.1f = %.1f\n", c, d, resultado2);
    
    // EJEMPLO 2: Conversión explícita (casting) - int a float
    printf("\n=== EJEMPLO 2: Casting int a float ===\n");
    int numero_entero = 7;
    float numero_decimal = (float)numero_entero;  // Casting explícito
    printf("Entero: %d\n", numero_entero);
    printf("Convertido a float: %.1f\n", numero_decimal);
    
    // División con casting para obtener decimales
    int x = 10;
    int y = 3;
    float division = (float)x / (float)y;  // Sin casting: 10/3 = 3
    printf("%d / %d = %.2f (con casting)\n", x, y, division);
    printf("%d / %d = %d (sin casting)\n", x, y, x / y);
    
    // EJEMPLO 3: Casting float/double a int (truncamiento)
    printf("\n=== EJEMPLO 3: Casting float a int (truncamiento) ===\n");
    float precio = 19.99f;
    int precio_entero = (int)precio;  // Trunca, no redondea
    printf("Precio original: %.2f\n", precio);
    printf("Precio truncado: %d\n", precio_entero);
    
    double altura = 1.75;
    int altura_entera = (int)altura;
    printf("Altura: %.2f metros\n", altura);
    printf("Altura truncada: %d metros\n", altura_entera);
    
    // EJEMPLO 4: Casting char a int (código ASCII)
    printf("\n=== EJEMPLO 4: Casting char a int ===\n");
    char letra = 'A';
    int codigo_ascii = (int)letra;  // O simplemente: int codigo = letra;
    printf("Letra: %c\n", letra);
    printf("Código ASCII: %d\n", codigo_ascii);
    
    // Casting int a char
    int numero = 65;
    char caracter = (char)numero;
    printf("Número: %d\n", numero);
    printf("Carácter correspondiente: %c\n", caracter);
    
    // EJEMPLO 5: Casting en expresiones
    printf("\n=== EJEMPLO 5: Casting en expresiones ===\n");
    int base = 10;
    int altura = 3;
    
    // Sin casting: división entera
    float area1 = base * altura / 2;  // Resultado: 15.0 (pero calculado como int)
    printf("Área sin casting: %.1f\n", area1);
    
    // Con casting: división decimal
    float area2 = (float)(base * altura) / 2.0f;  // Resultado: 15.0 (correcto)
    printf("Área con casting: %.1f\n", area2);
    
    // EJEMPLO 6: Casting para porcentajes
    printf("\n=== EJEMPLO 6: Casting para porcentajes ===\n");
    int total = 50;
    int parte = 15;
    
    // Sin casting: 15/50 = 0 (división entera)
    float porcentaje1 = parte / total * 100;
    printf("Porcentaje sin casting: %.1f%%\n", porcentaje1);
    
    // Con casting: 15.0/50.0 = 0.3 → 30%
    float porcentaje2 = (float)parte / (float)total * 100.0f;
    printf("Porcentaje con casting: %.1f%%\n", porcentaje2);
    
    // EJEMPLO 7: Casting double a float (pérdida de precisión)
    printf("\n=== EJEMPLO 7: Casting double a float ===\n");
    double valor_double = 3.141592653589793;
    float valor_float = (float)valor_double;
    printf("Double: %.15f\n", valor_double);
    printf("Float:  %.15f (puede perder precisión)\n", valor_float);
    
    // EJEMPLO 8: Casting para redondeo manual
    printf("\n=== EJEMPLO 8: Redondeo usando casting ===\n");
    float numero_redondear = 4.7f;
    int redondeado = (int)(numero_redondear + 0.5f);  // Técnica de redondeo
    printf("Número: %.1f\n", numero_redondear);
    printf("Redondeado: %d\n", redondeado);
    
    float numero2 = 4.3f;
    int redondeado2 = (int)(numero2 + 0.5f);
    printf("Número: %.1f\n", numero2);
    printf("Redondeado: %d\n", redondeado2);
    
    // EJEMPLO 9: Casting en operaciones mixtas
    printf("\n=== EJEMPLO 9: Operaciones mixtas ===\n");
    int horas = 2;
    int minutos = 30;
    
    // Convertir todo a minutos totales
    int total_minutos = horas * 60 + minutos;
    printf("%d horas y %d minutos = %d minutos totales\n", 
           horas, minutos, total_minutos);
    
    // Convertir a horas decimales
    float horas_decimales = (float)total_minutos / 60.0f;
    printf("En horas decimales: %.2f horas\n", horas_decimales);
    
    // EJEMPLO 10: Casting para evitar overflow
    printf("\n=== EJEMPLO 10: Casting para evitar overflow ===\n");
    int num1 = 2000000000;
    int num2 = 2000000000;
    
    // Sin casting: puede causar overflow
    long suma_int = (long)num1 + (long)num2;
    printf("%d + %d = %ld (con casting a long)\n", num1, num2, suma_int);
    
    return 0;
}

/*
 * RESUMEN:
 * 
 * CASTING EXPLÍCITO:
 * - Sintaxis: (tipo_destino) variable
 * - Ejemplo: (float)entero, (int)decimal, (char)numero
 * 
 * CUÁNDO USAR CASTING:
 * 1. División para obtener decimales: (float)a / (float)b
 * 2. Truncar decimales: (int)precio
 * 3. Convertir char a int (ASCII): (int)letra
 * 4. Evitar overflow: (long)num1 + (long)num2
 * 5. Forzar tipo específico en expresiones
 * 
 * PRECAUCIÓN:
 * - Casting de float/double a int TRUNCA (no redondea)
 * - Casting de double a float puede perder precisión
 * - Casting no valida rangos (puede causar overflow)
 * 
 * EJERCICIOS:
 * 1. Convierte 15/4 a decimal usando casting
 * 2. Trunca 9.99 a entero y muestra el resultado
 * 3. Calcula el 20% de 150 usando casting
 * 4. Convierte el carácter 'Z' a su código ASCII
 * 5. Calcula el promedio de 3 enteros como float
 */

