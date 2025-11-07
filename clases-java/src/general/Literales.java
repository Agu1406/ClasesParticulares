/**
 * LITERALES EN JAVA
 * 
 * Esta clase explica qué son los literales y cómo se usan
 * en el código Java.
 * 
 * @author Clases Particulares
 * @version 1.0
 */

public class Literales {
    
    /*
     * EXPLICACIÓN:
     * 
     * Un LITERAL es un valor que escribimos directamente en el código.
     * Es el valor "tal cual", sin usar variables.
     * 
     * Ejemplos:
     * - Literales numéricos enteros: 5, 100, -30
     * - Literales numéricos decimales: 3.14, 2.5, -10.99
     * - Literales de texto (String): "Hola", "Mundo", "123"
     * - Literales de carácter (char): 'A', '5', '@'
     * - Literales booleanos: true, false
     * 
     * IMPORTANTE:
     * - Los textos van entre comillas dobles: "texto"
     * - Los caracteres van entre comillas simples: 'A'
     * - Los números no llevan comillas: 42
     * - Los booleanos son: true o false (sin comillas)
     * 
     * DIFERENCIA entre literal y variable:
     * - Literal: el valor directo (ej: 5, "Hola", true)
     * - Variable: un nombre que guarda un valor (ej: int edad = 5;)
     */
    
    /**
     * EJERCICIO 1: Literales numéricos enteros
     * 
     * TAREA: Observa los literales de números enteros
     */
    public static void ejercicioLiteralesEnteros() {
        System.out.println("=== EJERCICIO: LITERALES NUMÉRICOS ENTEROS ===");
        
        // Literales enteros positivos
        int numero1 = 42;        // 42 es un literal
        int numero2 = 100;        // 100 es un literal
        int numero3 = 0;          // 0 es un literal
        
        // Literales enteros negativos
        int numero4 = -15;       // -15 es un literal
        int numero5 = -1000;     // -1000 es un literal
        
        System.out.println("Literales enteros positivos:");
        System.out.println("  int numero1 = 42;     → " + numero1);
        System.out.println("  int numero2 = 100;    → " + numero2);
        System.out.println("  int numero3 = 0;      → " + numero3);
        
        System.out.println("\nLiterales enteros negativos:");
        System.out.println("  int numero4 = -15;    → " + numero4);
        System.out.println("  int numero5 = -1000; → " + numero5);
        
        System.out.println("\n✓ Los literales enteros son números sin decimales");
        System.out.println("✓ No llevan comillas");
    }
    
    /**
     * EJERCICIO 2: Literales numéricos decimales
     * 
     * TAREA: Observa los literales de números decimales
     */
    public static void ejercicioLiteralesDecimales() {
        System.out.println("\n=== EJERCICIO: LITERALES NUMÉRICOS DECIMALES ===");
        
        // Literales decimales positivos
        double precio1 = 99.99;      // 99.99 es un literal
        double altura = 1.75;         // 1.75 es un literal
        double pi = 3.14159;         // 3.14159 es un literal
        
        // Literales decimales negativos
        double temperatura = -5.5;   // -5.5 es un literal
        double saldo = -100.50;      // -100.50 es un literal
        
        System.out.println("Literales decimales positivos:");
        System.out.println("  double precio1 = 99.99;    → " + precio1);
        System.out.println("  double altura = 1.75;      → " + altura);
        System.out.println("  double pi = 3.14159;       → " + pi);
        
        System.out.println("\nLiterales decimales negativos:");
        System.out.println("  double temperatura = -5.5; → " + temperatura);
        System.out.println("  double saldo = -100.50;    → " + saldo);
        
        System.out.println("\n✓ Los literales decimales tienen punto (.)");
        System.out.println("✓ No llevan comillas");
    }
    
    /**
     * EJERCICIO 3: Literales de texto (String)
     * 
     * TAREA: Observa los literales de texto
     */
    public static void ejercicioLiteralesTexto() {
        System.out.println("\n=== EJERCICIO: LITERALES DE TEXTO (STRING) ===");
        
        // Literales de texto (String) - van entre comillas dobles
        String saludo = "Hola";              // "Hola" es un literal
        String mensaje = "Bienvenido";        // "Bienvenido" es un literal
        String numeroTexto = "123";           // "123" es un literal (texto, no número)
        String vacio = "";                    // "" es un literal (texto vacío)
        String frase = "Hola mundo";          // "Hola mundo" es un literal
        
        System.out.println("Literales de texto (String):");
        System.out.println("  String saludo = \"Hola\";         → \"" + saludo + "\"");
        System.out.println("  String mensaje = \"Bienvenido\";  → \"" + mensaje + "\"");
        System.out.println("  String numeroTexto = \"123\";     → \"" + numeroTexto + "\"");
        System.out.println("  String vacio = \"\";              → \"" + vacio + "\"");
        System.out.println("  String frase = \"Hola mundo\";   → \"" + frase + "\"");
        
        System.out.println("\n✓ Los literales de texto van entre comillas dobles: \"texto\"");
        System.out.println("✓ \"123\" es texto, no es el número 123");
    }
    
    /**
     * EJERCICIO 4: Literales de carácter (char)
     * 
     * TAREA: Observa los literales de carácter
     */
    public static void ejercicioLiteralesCaracter() {
        System.out.println("\n=== EJERCICIO: LITERALES DE CARÁCTER (CHAR) ===");
        
        // Literales de carácter - van entre comillas simples
        char letra = 'A';        // 'A' es un literal
        char numero = '5';        // '5' es un literal (carácter, no número)
        char simbolo = '@';       // '@' es un literal
        char espacio = ' ';      // ' ' es un literal (espacio)
        char letraMinuscula = 'a'; // 'a' es un literal
        
        System.out.println("Literales de carácter (char):");
        System.out.println("  char letra = 'A';          → '" + letra + "'");
        System.out.println("  char numero = '5';         → '" + numero + "'");
        System.out.println("  char simbolo = '@';        → '" + simbolo + "'");
        System.out.println("  char espacio = ' ';        → '" + espacio + "'");
        System.out.println("  char letraMinuscula = 'a'; → '" + letraMinuscula + "'");
        
        System.out.println("\n✓ Los literales de carácter van entre comillas simples: 'A'");
        System.out.println("✓ Solo pueden tener UN carácter");
        System.out.println("✓ '5' es un carácter, no es el número 5");
    }
    
    /**
     * EJERCICIO 5: Literales booleanos
     * 
     * TAREA: Observa los literales booleanos
     */
    public static void ejercicioLiteralesBooleanos() {
        System.out.println("\n=== EJERCICIO: LITERALES BOOLEANOS ===");
        
        // Literales booleanos - solo hay dos: true y false
        boolean esVerdadero = true;      // true es un literal
        boolean esFalso = false;          // false es un literal
        
        System.out.println("Literales booleanos:");
        System.out.println("  boolean esVerdadero = true;  → " + esVerdadero);
        System.out.println("  boolean esFalso = false;      → " + esFalso);
        
        System.out.println("\n✓ Solo hay dos literales booleanos: true y false");
        System.out.println("✓ No llevan comillas");
        System.out.println("✓ Son palabras reservadas");
    }
    
    /**
     * EJERCICIO 6: Usar literales directamente
     * 
     * TAREA: Observa cómo usar literales sin guardarlos en variables
     */
    public static void ejercicioLiteralesDirectos() {
        System.out.println("\n=== EJERCICIO: LITERALES DIRECTOS ===");
        
        System.out.println("Puedes usar literales directamente sin guardarlos en variables:");
        
        // Usar literales directamente en operaciones
        System.out.println("  5 + 3 = " + (5 + 3));
        System.out.println("  10.5 * 2 = " + (10.5 * 2));
        System.out.println("  \"Hola\" + \" mundo\" = " + ("Hola" + " mundo"));
        
        // Usar literales en comparaciones
        System.out.println("  10 > 5 = " + (10 > 5));
        System.out.println("  true && false = " + (true && false));
        
        // Usar literales en métodos
        System.out.println("  Literal de texto: \"Java\"");
        System.out.println("  Literal numérico: " + 42);
        System.out.println("  Literal booleano: " + true);
        
        System.out.println("\n✓ Los literales se pueden usar directamente");
        System.out.println("✓ No siempre necesitas guardarlos en variables");
    }
    
    /**
     * EJERCICIO 7: Diferencia entre literal y variable
     * 
     * TAREA: Entiende la diferencia entre literales y variables
     */
    public static void ejercicioDiferenciaLiteralVariable() {
        System.out.println("\n=== EJERCICIO: DIFERENCIA LITERAL vs VARIABLE ===");
        
        // LITERAL: el valor directo
        System.out.println("LITERALES (valores directos):");
        System.out.println("  42        → literal entero");
        System.out.println("  3.14      → literal decimal");
        System.out.println("  \"Hola\"    → literal de texto");
        System.out.println("  'A'       → literal de carácter");
        System.out.println("  true      → literal booleano");
        
        // VARIABLE: un nombre que guarda un valor
        int edad = 25;              // edad es variable, 25 es literal
        String nombre = "Juan";      // nombre es variable, "Juan" es literal
        boolean activo = true;       // activo es variable, true es literal
        
        System.out.println("\nVARIABLES (nombres que guardan valores):");
        System.out.println("  int edad = 25;");
        System.out.println("    → 'edad' es la variable");
        System.out.println("    → 25 es el literal");
        System.out.println("  String nombre = \"Juan\";");
        System.out.println("    → 'nombre' es la variable");
        System.out.println("    → \"Juan\" es el literal");
        
        System.out.println("\n✓ Literal = valor directo (5, \"Hola\", true)");
        System.out.println("✓ Variable = nombre que guarda un valor (edad, nombre)");
    }
    
    /**
     * Método principal - Punto de entrada del programa
     */
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                  LITERALES EN JAVA                    ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        
        ejercicioLiteralesEnteros();
        ejercicioLiteralesDecimales();
        ejercicioLiteralesTexto();
        ejercicioLiteralesCaracter();
        ejercicioLiteralesBooleanos();
        ejercicioLiteralesDirectos();
        ejercicioDiferenciaLiteralVariable();
        
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║              ¡EJERCICIOS COMPLETADOS!                   ║");
        System.out.println("║     Revisa el código para ver las explicaciones        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}

