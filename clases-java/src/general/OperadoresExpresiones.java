/**
 * OPERADORES Y EXPRESIONES EN JAVA
 * 
 * Esta clase explica los diferentes operadores y cómo funcionan
 * las expresiones, incluyendo la precedencia de operadores.
 * 
 * @author Clases Particulares
 * @version 1.0
 */

public class OperadoresExpresiones {
    
    /*
     * EXPLICACIÓN:
     * 
     * Los OPERADORES son símbolos que realizan operaciones con valores.
     * Una EXPRESIÓN es una combinación de valores, variables y operadores.
     * 
     * TIPOS DE OPERADORES:
     * 
     * 1. ARITMÉTICOS (hacen cálculos):
     *    + suma (5 + 3 = 8)
     *    - resta (5 - 3 = 2)
     *    * multiplicación (5 * 3 = 15)
     *    / división (10 / 2 = 5)
     *    % módulo/resto (10 % 3 = 1)
     * 
     * 2. COMPARACIÓN (comparan valores):
     *    == igual a (5 == 5 es true)
     *    != diferente de (5 != 3 es true)
     *    > mayor que (5 > 3 es true)
     *    < menor que (5 < 3 es false)
     *    >= mayor o igual (5 >= 5 es true)
     *    <= menor o igual (3 <= 5 es true)
     * 
     * 3. LÓGICOS (combinan condiciones):
     *    && AND (y) - ambas deben ser true
     *    || OR (o) - al menos una debe ser true
     *    ! NOT (no) - invierte el valor
     * 
     * 4. ASIGNACIÓN:
     *    = asigna un valor (x = 5)
     *    += suma y asigna (x += 3 es igual a x = x + 3)
     *    -= resta y asigna
     *    *= multiplica y asigna
     *    /= divide y asigna
     * 
     * PRECEDENCIA DE OPERADORES (orden de ejecución):
     * 1. Paréntesis () - se ejecutan primero
     * 2. Multiplicación, división, módulo (*, /, %)
     * 3. Suma y resta (+, -)
     * 4. Comparación (>, <, ==, !=)
     * 5. Lógicos (&&, ||)
     * 6. Asignación (=)
     * 
     * Ejemplo: 2 + 3 * 4 = 2 + 12 = 14 (no 20)
     *          (2 + 3) * 4 = 5 * 4 = 20
     */
    
    /**
     * EJERCICIO 1: Operadores aritméticos
     */
    public static void ejercicioOperadoresAritmeticos() {
        System.out.println("=== EJERCICIO: OPERADORES ARITMÉTICOS ===");
        
        int a = 10;
        int b = 3;
        
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("\nOperaciones:");
        System.out.println("  a + b = " + a + " + " + b + " = " + (a + b));
        System.out.println("  a - b = " + a + " - " + b + " = " + (a - b));
        System.out.println("  a * b = " + a + " * " + b + " = " + (a * b));
        System.out.println("  a / b = " + a + " / " + b + " = " + (a / b));
        System.out.println("  a % b = " + a + " % " + b + " = " + (a % b) + " (resto)");
    }
    
    /**
     * EJERCICIO 2: Operadores de comparación
     */
    public static void ejercicioOperadoresComparacion() {
        System.out.println("\n=== EJERCICIO: OPERADORES DE COMPARACIÓN ===");
        
        int a = 10;
        int b = 3;
        int c = 10;
        
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        System.out.println("\nComparaciones:");
        System.out.println("  a == b → " + a + " == " + b + " = " + (a == b));
        System.out.println("  a == c → " + a + " == " + c + " = " + (a == c));
        System.out.println("  a != b → " + a + " != " + b + " = " + (a != b));
        System.out.println("  a > b  → " + a + " > " + b + "  = " + (a > b));
        System.out.println("  a < b  → " + a + " < " + b + "  = " + (a < b));
        System.out.println("  a >= c → " + a + " >= " + c + " = " + (a >= c));
        System.out.println("  a <= b → " + a + " <= " + b + " = " + (a <= b));
    }
    
    /**
     * EJERCICIO 3: Operadores lógicos
     */
    public static void ejercicioOperadoresLogicos() {
        System.out.println("\n=== EJERCICIO: OPERADORES LÓGICOS ===");
        
        boolean x = true;
        boolean y = false;
        
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("\nOperaciones lógicas:");
        System.out.println("  x && y → " + x + " && " + y + " = " + (x && y) + " (ambos deben ser true)");
        System.out.println("  x || y → " + x + " || " + y + " = " + (x || y) + " (al menos uno true)");
        System.out.println("  !x     → !" + x + "     = " + (!x) + " (invierte el valor)");
        System.out.println("  !y     → !" + y + "     = " + (!y) + " (invierte el valor)");
        
        System.out.println("\nTabla de verdad AND (&&):");
        System.out.println("  true && true  = " + (true && true));
        System.out.println("  true && false = " + (true && false));
        System.out.println("  false && true = " + (false && true));
        System.out.println("  false && false = " + (false && false));
    }
    
    /**
     * EJERCICIO 4: Operadores de asignación
     */
    public static void ejercicioOperadoresAsignacion() {
        System.out.println("\n=== EJERCICIO: OPERADORES DE ASIGNACIÓN ===");
        
        int c = 5;
        System.out.println("Valor inicial: c = " + c);
        
        c += 3;  // c = c + 3
        System.out.println("c += 3 → c = " + c);
        
        c -= 2;  // c = c - 2
        System.out.println("c -= 2 → c = " + c);
        
        c *= 2;  // c = c * 2
        System.out.println("c *= 2 → c = " + c);
        
        c /= 3;  // c = c / 3
        System.out.println("c /= 3 → c = " + c);
        
        System.out.println("\n✓ Estos operadores hacen la operación y asignan el resultado");
    }
    
    /**
     * EJERCICIO 5: Precedencia de operadores
     */
    public static void ejercicioPrecedencia() {
        System.out.println("\n=== EJERCICIO: PRECEDENCIA DE OPERADORES ===");
        
        System.out.println("Orden de precedencia:");
        System.out.println("1. Paréntesis ()");
        System.out.println("2. *, /, %");
        System.out.println("3. +, -");
        System.out.println("4. >, <, ==, !=");
        System.out.println("5. &&, ||");
        System.out.println("6. =");
        
        System.out.println("\nEjemplos:");
        int resultado1 = 2 + 3 * 4;
        System.out.println("  2 + 3 * 4 = " + resultado1);
        System.out.println("  (Primero 3*4=12, luego 2+12=14)");
        
        int resultado2 = (2 + 3) * 4;
        System.out.println("\n  (2 + 3) * 4 = " + resultado2);
        System.out.println("  (Primero paréntesis 2+3=5, luego 5*4=20)");
        
        boolean resultado3 = 5 > 3 && 2 < 4;
        System.out.println("\n  5 > 3 && 2 < 4 = " + resultado3);
        System.out.println("  (Primero comparaciones, luego lógico)");
        
        System.out.println("\n✓ Los paréntesis cambian el orden de ejecución");
    }
    
    /**
     * EJERCICIO 6: Expresiones complejas
     */
    public static void ejercicioExpresionesComplejas() {
        System.out.println("\n=== EJERCICIO: EXPRESIONES COMPLEJAS ===");
        
        int a = 5;
        int b = 3;
        int c = 2;
        
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        
        int resultado1 = a + b * c;
        System.out.println("\na + b * c = " + resultado1);
        System.out.println("  (b*c primero: 3*2=6, luego a+6=11)");
        
        int resultado2 = (a + b) * c;
        System.out.println("\n(a + b) * c = " + resultado2);
        System.out.println("  (a+b primero: 5+3=8, luego 8*2=16)");
        
        boolean resultado3 = a > b && b > c;
        System.out.println("\na > b && b > c = " + resultado3);
        System.out.println("  (5>3 es true, 3>2 es true, true&&true=true)");
        
        System.out.println("\n✓ Las expresiones pueden combinar varios operadores");
    }
    
    /**
     * Método principal
     */
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║          OPERADORES Y EXPRESIONES EN JAVA              ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        
        ejercicioOperadoresAritmeticos();
        ejercicioOperadoresComparacion();
        ejercicioOperadoresLogicos();
        ejercicioOperadoresAsignacion();
        ejercicioPrecedencia();
        ejercicioExpresionesComplejas();
        
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║              ¡EJERCICIOS COMPLETADOS!                   ║");
        System.out.println("║     Revisa el código para ver las explicaciones        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}

