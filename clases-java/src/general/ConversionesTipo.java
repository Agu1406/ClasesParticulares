/**
 * CONVERSIONES DE TIPO (CASTING) EN JAVA
 * 
 * Esta clase explica las conversiones implícitas y explícitas
 * entre diferentes tipos de datos.
 * 
 * @author Clases Particulares
 * @version 1.0
 */

public class ConversionesTipo {
    
    /*
     * EXPLICACIÓN:
     * 
     * La CONVERSIÓN DE TIPO (casting) es cambiar un valor de un tipo a otro.
     * 
     * CONVERSIÓN IMPLÍCITA (automática):
     * - Java la hace automáticamente cuando es seguro
     * - Generalmente de tipos "pequeños" a "grandes"
     * - Ejemplo: int → double (un entero puede ser decimal)
     * 
     * CONVERSIÓN EXPLÍCITA (casting manual):
     * - Tú le dices a Java que convierta el tipo
     * - Se usa cuando puede haber pérdida de información
     * - Ejemplo: double → int (pierdes los decimales)
     * - Sintaxis: (tipo) valor
     * 
     * REGLAS:
     * - int → double: automático (implícito)
     * - double → int: requiere casting (explícito)
     * - char → int: automático (obtienes el código ASCII)
     * - int → char: requiere casting
     * 
     * IMPORTANTE:
     * - Al convertir double a int, se pierden los decimales (no redondea)
     * - Ejemplo: (int) 3.9 = 3 (no 4)
     */
    
    /**
     * EJERCICIO 1: Conversión implícita (automática)
     */
    public static void ejercicioConversionImplicita() {
        System.out.println("=== EJERCICIO: CONVERSIÓN IMPLÍCITA (AUTOMÁTICA) ===");
        
        int numeroEntero = 42;
        double numeroDecimal = numeroEntero;  // int → double (automático)
        
        System.out.println("int numeroEntero = " + numeroEntero + ";");
        System.out.println("double numeroDecimal = numeroEntero;");
        System.out.println("  → Java convierte automáticamente int a double");
        System.out.println("  → numeroDecimal = " + numeroDecimal);
        
        char letra = 'A';
        int codigoASCII = letra;  // char → int (automático)
        
        System.out.println("\nchar letra = '" + letra + "';");
        System.out.println("int codigoASCII = letra;");
        System.out.println("  → Java convierte automáticamente char a int");
        System.out.println("  → codigoASCII = " + codigoASCII + " (código ASCII de 'A')");
        
        System.out.println("\n✓ Las conversiones implícitas son automáticas");
        System.out.println("✓ Java las hace cuando es seguro (de pequeño a grande)");
    }
    
    /**
     * EJERCICIO 2: Conversión explícita (casting)
     */
    public static void ejercicioConversionExplicita() {
        System.out.println("\n=== EJERCICIO: CONVERSIÓN EXPLÍCITA (CASTING) ===");
        
        double precio = 99.99;
        int precioEntero = (int) precio;  // double → int (casting)
        
        System.out.println("double precio = " + precio + ";");
        System.out.println("int precioEntero = (int) precio;");
        System.out.println("  → Casting explícito: (int)");
        System.out.println("  → precioEntero = " + precioEntero);
        System.out.println("  ⚠️ Se pierden los decimales (no redondea)");
        
        double temperatura = 25.7;
        int tempEntera = (int) temperatura;
        System.out.println("\ndouble temperatura = " + temperatura + ";");
        System.out.println("int tempEntera = (int) temperatura;");
        System.out.println("  → tempEntera = " + tempEntera);
        System.out.println("  ⚠️ 25.7 se convierte en 25 (pierde .7)");
        
        System.out.println("\n✓ El casting explícito requiere escribir (tipo)");
        System.out.println("✓ Se usa cuando puede haber pérdida de información");
    }
    
    /**
     * EJERCICIO 3: Conversión char ↔ int
     */
    public static void ejercicioConversionCharInt() {
        System.out.println("\n=== EJERCICIO: CONVERSIÓN char ↔ int ===");
        
        // char → int (automático)
        char letra = 'A';
        int codigo = letra;
        System.out.println("char → int (automático):");
        System.out.println("  char letra = '" + letra + "';");
        System.out.println("  int codigo = letra;");
        System.out.println("  → codigo = " + codigo + " (código ASCII)");
        
        // int → char (casting)
        int numero = 66;
        char letraB = (char) numero;
        System.out.println("\nint → char (casting):");
        System.out.println("  int numero = " + numero + ";");
        System.out.println("  char letraB = (char) numero;");
        System.out.println("  → letraB = '" + letraB + "'");
        
        System.out.println("\n✓ char → int: automático (obtienes código ASCII)");
        System.out.println("✓ int → char: requiere casting (obtienes carácter)");
    }
    
    /**
     * EJERCICIO 4: Conversión en expresiones
     */
    public static void ejercicioConversionExpresiones() {
        System.out.println("\n=== EJERCICIO: CONVERSIÓN EN EXPRESIONES ===");
        
        int a = 5;
        int b = 2;
        
        // Sin casting: división entera
        int divisionEntera = a / b;
        System.out.println("Sin casting:");
        System.out.println("  int a = " + a + ", b = " + b + ";");
        System.out.println("  int divisionEntera = a / b;");
        System.out.println("  → divisionEntera = " + divisionEntera + " (solo parte entera)");
        
        // Con casting: división decimal
        double divisionDecimal = (double) a / b;
        System.out.println("\nCon casting:");
        System.out.println("  double divisionDecimal = (double) a / b;");
        System.out.println("  → divisionDecimal = " + divisionDecimal + " (resultado decimal)");
        
        System.out.println("\n✓ El casting permite obtener resultados decimales");
        System.out.println("✓ Sin casting, la división de enteros da entero");
    }
    
    /**
     * EJERCICIO 5: Pérdida de información
     */
    public static void ejercicioPerdidaInformacion() {
        System.out.println("\n=== EJERCICIO: PÉRDIDA DE INFORMACIÓN ===");
        
        System.out.println("Al convertir double a int, se pierden los decimales:");
        
        double valor1 = 3.9;
        int entero1 = (int) valor1;
        System.out.println("  (int) " + valor1 + " = " + entero1);
        System.out.println("  ⚠️ No redondea, solo quita decimales");
        
        double valor2 = 3.1;
        int entero2 = (int) valor2;
        System.out.println("  (int) " + valor2 + " = " + entero2);
        
        double valor3 = 99.99;
        int entero3 = (int) valor3;
        System.out.println("  (int) " + valor3 + " = " + entero3);
        
        System.out.println("\n✓ Al hacer casting de double a int, se trunca (corta)");
        System.out.println("✓ NO redondea, solo quita la parte decimal");
    }
    
    /**
     * EJERCICIO 6: Resumen de conversiones
     */
    public static void ejercicioResumen() {
        System.out.println("\n=== EJERCICIO: RESUMEN DE CONVERSIONES ===");
        
        System.out.println("CONVERSIONES IMPLÍCITAS (automáticas):");
        System.out.println("  int → double    ✓ Automático");
        System.out.println("  char → int      ✓ Automático (código ASCII)");
        System.out.println("  byte → int      ✓ Automático");
        
        System.out.println("\nCONVERSIONES EXPLÍCITAS (casting):");
        System.out.println("  double → int    (int) valor");
        System.out.println("  int → char      (char) valor");
        System.out.println("  double → float  (float) valor");
        
        System.out.println("\nEjemplo práctico:");
        int entero = 42;
        double decimal = entero;           // Implícito
        int deVuelta = (int) decimal;      // Explícito
        
        System.out.println("  int entero = " + entero + ";");
        System.out.println("  double decimal = entero;        // Implícito");
        System.out.println("  int deVuelta = (int) decimal;   // Explícito");
        System.out.println("  → deVuelta = " + deVuelta);
    }
    
    /**
     * Método principal
     */
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║          CONVERSIONES DE TIPO (CASTING) EN JAVA        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        
        ejercicioConversionImplicita();
        ejercicioConversionExplicita();
        ejercicioConversionCharInt();
        ejercicioConversionExpresiones();
        ejercicioPerdidaInformacion();
        ejercicioResumen();
        
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║              ¡EJERCICIOS COMPLETADOS!                   ║");
        System.out.println("║     Revisa el código para ver las explicaciones        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}

