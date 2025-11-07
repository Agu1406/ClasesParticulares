/**
 * TIPOS DE DATOS EN JAVA
 * 
 * Esta clase explica los diferentes tipos de datos que existen en Java
 * y cómo usarlos.
 * 
 * @author Clases Particulares
 * @version 1.0
 */

public class TiposDatos {
    
    /*
     * EXPLICACIÓN:
     * 
     * Los TIPOS DE DATOS definen qué tipo de información puede guardar una variable.
     * 
     * TIPOS PRIMITIVOS (valores básicos):
     * - int: números enteros (ej: 5, -10, 1000)
     *   Rango: -2,147,483,648 a 2,147,483,647
     *   Tamaño: 4 bytes
     * 
     * - double: números decimales (ej: 3.14, -2.5, 99.99)
     *   Tamaño: 8 bytes
     *   Precisión: ~15-17 dígitos decimales
     * 
     * - boolean: valores lógicos (true o false)
     *   Tamaño: 1 bit
     *   Solo dos valores posibles: true o false
     * 
     * - char: un solo carácter (ej: 'A', '5', '@')
     *   Tamaño: 2 bytes
     *   Va entre comillas simples: 'A'
     * 
     * - byte: números enteros pequeños (-128 a 127)
     *   Tamaño: 1 byte
     * 
     * - short: números enteros medianos (-32,768 a 32,767)
     *   Tamaño: 2 bytes
     * 
     * - long: números enteros muy grandes
     *   Tamaño: 8 bytes
     *   Rango: muy amplio
     * 
     * - float: números decimales (menos precisión que double)
     *   Tamaño: 4 bytes
     *   Precisión: ~6-7 dígitos decimales
     * 
     * TIPOS DE REFERENCIA (objetos):
     * - String: texto (ej: "Hola mundo")
     *   Va entre comillas dobles: "texto"
     *   Puede tener cualquier longitud
     * 
     * - Arrays: listas de valores
     * - Objetos de clases
     * 
     * IMPORTANTE: Cada tipo tiene un rango de valores permitidos
     */
    
    /**
     * EJERCICIO 1: Tipos primitivos básicos
     * 
     * TAREA: Observa los tipos primitivos más usados
     */
    public static void ejercicioTiposPrimitivos() {
        System.out.println("=== EJERCICIO: TIPOS PRIMITIVOS BÁSICOS ===");
        
        // int: números enteros
        int edad = 25;
        int temperatura = -5;
        int cantidad = 1000;
        
        // double: números decimales
        double precio = 99.99;
        double altura = 1.75;
        double temperaturaDecimal = -5.5;
        
        // boolean: verdadero o falso
        boolean esEstudiante = true;
        boolean esActivo = false;
        
        // char: un solo carácter
        char letra = 'A';
        char numero = '5';
        char simbolo = '@';
        
        System.out.println("int (enteros):");
        System.out.println("  edad = " + edad);
        System.out.println("  temperatura = " + temperatura);
        System.out.println("  cantidad = " + cantidad);
        
        System.out.println("\ndouble (decimales):");
        System.out.println("  precio = " + precio);
        System.out.println("  altura = " + altura);
        System.out.println("  temperaturaDecimal = " + temperaturaDecimal);
        
        System.out.println("\nboolean (lógico):");
        System.out.println("  esEstudiante = " + esEstudiante);
        System.out.println("  esActivo = " + esActivo);
        
        System.out.println("\nchar (carácter):");
        System.out.println("  letra = " + letra);
        System.out.println("  numero = " + numero);
        System.out.println("  simbolo = " + simbolo);
    }
    
    /**
     * EJERCICIO 2: Tipos primitivos adicionales
     * 
     * TAREA: Observa otros tipos primitivos menos comunes
     */
    public static void ejercicioTiposAdicionales() {
        System.out.println("\n=== EJERCICIO: TIPOS PRIMITIVOS ADICIONALES ===");
        
        // byte: números muy pequeños (-128 a 127)
        byte edadByte = 25;
        byte temperaturaByte = -10;
        
        // short: números medianos (-32,768 a 32,767)
        short cantidadShort = 1000;
        short año = 2024;
        
        // long: números muy grandes
        long poblacionMundial = 8000000000L;  // La L indica que es long
        long distancia = -5000000000L;
        
        // float: decimales con menos precisión
        float precioFloat = 99.99f;  // La f indica que es float
        float temperaturaFloat = -5.5f;
        
        System.out.println("byte (1 byte, -128 a 127):");
        System.out.println("  edadByte = " + edadByte);
        System.out.println("  temperaturaByte = " + temperaturaByte);
        
        System.out.println("\nshort (2 bytes, -32,768 a 32,767):");
        System.out.println("  cantidadShort = " + cantidadShort);
        System.out.println("  año = " + año);
        
        System.out.println("\nlong (8 bytes, números muy grandes):");
        System.out.println("  poblacionMundial = " + poblacionMundial);
        System.out.println("  distancia = " + distancia);
        System.out.println("  Nota: Se usa 'L' al final del número");
        
        System.out.println("\nfloat (4 bytes, decimales):");
        System.out.println("  precioFloat = " + precioFloat);
        System.out.println("  temperaturaFloat = " + temperaturaFloat);
        System.out.println("  Nota: Se usa 'f' al final del número");
    }
    
    /**
     * EJERCICIO 3: Tipo de referencia - String
     * 
     * TAREA: Observa cómo funciona el tipo String
     */
    public static void ejercicioTipoString() {
        System.out.println("\n=== EJERCICIO: TIPO DE REFERENCIA - STRING ===");
        
        // String: texto (va entre comillas dobles)
        String nombre = "Carlos";
        String apellido = "García";
        String mensaje = "Hola mundo";
        String numeroComoTexto = "123";  // Es texto, no número
        
        System.out.println("String (texto):");
        System.out.println("  nombre = \"" + nombre + "\"");
        System.out.println("  apellido = \"" + apellido + "\"");
        System.out.println("  mensaje = \"" + mensaje + "\"");
        System.out.println("  numeroComoTexto = \"" + numeroComoTexto + "\"");
        
        // Concatenar Strings
        String nombreCompleto = nombre + " " + apellido;
        System.out.println("\nConcatenación:");
        System.out.println("  nombre + \" \" + apellido = \"" + nombreCompleto + "\"");
        
        System.out.println("\n✓ String es un tipo de referencia (objeto)");
        System.out.println("✓ Va entre comillas dobles: \"texto\"");
        System.out.println("✓ Puede tener cualquier longitud");
    }
    
    /**
     * EJERCICIO 4: Diferencias entre tipos
     * 
     * TAREA: Observa las diferencias importantes entre tipos
     */
    public static void ejercicioDiferencias() {
        System.out.println("\n=== EJERCICIO: DIFERENCIAS ENTRE TIPOS ===");
        
        // int vs double
        int numeroEntero = 5;
        double numeroDecimal = 5.0;
        
        System.out.println("int vs double:");
        System.out.println("  int numeroEntero = " + numeroEntero + " (solo enteros)");
        System.out.println("  double numeroDecimal = " + numeroDecimal + " (permite decimales)");
        
        // char vs String
        char unCaracter = 'A';
        String texto = "A";
        
        System.out.println("\nchar vs String:");
        System.out.println("  char unCaracter = '" + unCaracter + "' (comillas simples, 1 carácter)");
        System.out.println("  String texto = \"" + texto + "\" (comillas dobles, puede ser más largo)");
        
        // boolean solo tiene dos valores
        boolean verdadero = true;
        boolean falso = false;
        
        System.out.println("\nboolean:");
        System.out.println("  Solo dos valores posibles:");
        System.out.println("    verdadero = " + verdadero);
        System.out.println("    falso = " + falso);
        
        System.out.println("\n✓ Cada tipo tiene sus propias características");
        System.out.println("✓ Es importante elegir el tipo correcto para cada variable");
    }
    
    /**
     * EJERCICIO 5: Tamaños en memoria
     * 
     * TAREA: Revisa cuánto espacio ocupa cada tipo en memoria
     */
    public static void ejercicioTamanosMemoria() {
        System.out.println("\n=== EJERCICIO: TAMAÑOS EN MEMORIA ===");
        
        System.out.println("Tamaño que ocupa cada tipo en memoria:");
        System.out.println("  byte:   1 byte  (8 bits)");
        System.out.println("  short:  2 bytes (16 bits)");
        System.out.println("  int:    4 bytes (32 bits)");
        System.out.println("  long:   8 bytes (64 bits)");
        System.out.println("  float:  4 bytes (32 bits)");
        System.out.println("  double: 8 bytes (64 bits)");
        System.out.println("  char:   2 bytes (16 bits)");
        System.out.println("  boolean: 1 bit  (true o false)");
        System.out.println("  String:  variable (depende de la longitud)");
        
        System.out.println("\nEjemplo práctico:");
        int edad = 25;           // Ocupa 4 bytes
        double precio = 99.99;   // Ocupa 8 bytes
        boolean activo = true;   // Ocupa 1 bit
        char letra = 'A';        // Ocupa 2 bytes
        String nombre = "Juan";   // Ocupa variable (depende del texto)
        
        System.out.println("  int edad = " + edad + " → 4 bytes");
        System.out.println("  double precio = " + precio + " → 8 bytes");
        System.out.println("  boolean activo = " + activo + " → 1 bit");
        System.out.println("  char letra = '" + letra + "' → 2 bytes");
        System.out.println("  String nombre = \"" + nombre + "\" → variable");
    }
    
    /**
     * Método principal - Punto de entrada del programa
     */
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                TIPOS DE DATOS EN JAVA                  ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        
        ejercicioTiposPrimitivos();
        ejercicioTiposAdicionales();
        ejercicioTipoString();
        ejercicioDiferencias();
        ejercicioTamanosMemoria();
        
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║              ¡EJERCICIOS COMPLETADOS!                   ║");
        System.out.println("║     Revisa el código para ver las explicaciones        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}

