/**
 * IDENTIFICADORES EN JAVA
 * 
 * Esta clase explica qué son los identificadores y las reglas
 * para crear nombres válidos en Java.
 * 
 * @author Clases Particulares
 * @version 1.0
 */

public class Identificadores {
    
    /*
     * EXPLICACIÓN:
     * 
     * Un IDENTIFICADOR es el nombre que le damos a:
     * - Variables (ej: edad, nombre, precio)
     * - Métodos (ej: calcularTotal, mostrarDatos)
     * - Clases (ej: Persona, Calculadora)
     * 
     * REGLAS para crear identificadores:
     * 1. Pueden empezar con letra, guion bajo (_) o símbolo de dólar ($)
     * 2. Pueden contener letras, números, _ y $
     * 3. NO pueden tener espacios
     * 4. NO pueden ser palabras reservadas (como "int", "if", "class")
     * 5. Son sensibles a mayúsculas/minúsculas (edad ≠ Edad)
     * 
     * BUENAS PRÁCTICAS:
     * - Usar nombres descriptivos (edad en vez de e)
     * - Variables: empezar con minúscula (miVariable)
     * - Clases: empezar con mayúscula (MiClase)
     * - Constantes: todo en mayúsculas (MI_CONSTANTE)
     * - Si tiene varias palabras, usar camelCase (miVariableCompleta)
     */
    
    /**
     * EJERCICIO 1: Identificadores válidos
     * 
     * TAREA: Observa estos identificadores válidos
     */
    public static void ejercicioIdentificadoresValidos() {
        System.out.println("=== EJERCICIO: IDENTIFICADORES VÁLIDOS ===");
        
        // Identificadores válidos que empiezan con letra
        int edad = 25;
        String nombreCompleto = "Juan Pérez";
        double precioTotal = 99.99;
        boolean esActivo = true;
        
        // Identificadores válidos que empiezan con guion bajo
        int _contador = 10;
        String _nombreTemporal = "Temp";
        
        // Identificadores válidos que empiezan con $
        int $valor = 5;
        
        System.out.println("Edad: " + edad);
        System.out.println("Nombre completo: " + nombreCompleto);
        System.out.println("Precio total: " + precioTotal);
        System.out.println("¿Es activo? " + esActivo);
        System.out.println("Contador: " + _contador);
        System.out.println("Valor: " + $valor);
        
        System.out.println("\n✓ Todos estos son identificadores válidos");
    }
    
    /**
     * EJERCICIO 2: Identificadores inválidos
     * 
     * TAREA: Identifica por qué estos serían inválidos
     */
    public static void ejercicioIdentificadoresInvalidos() {
        System.out.println("\n=== EJERCICIO: IDENTIFICADORES INVÁLIDOS ===");
        
        System.out.println("Ejemplos de identificadores INVÁLIDOS:");
        System.out.println("1. 2edad - ❌ Empieza con número");
        System.out.println("2. mi-edad - ❌ Tiene guion (no guion bajo)");
        System.out.println("3. mi edad - ❌ Tiene espacio");
        System.out.println("4. int - ❌ Es palabra reservada");
        System.out.println("5. class - ❌ Es palabra reservada");
        System.out.println("6. edad@ - ❌ Tiene símbolo no permitido (@)");
        
        // Ejemplos válidos equivalentes:
        int edad2 = 20;           // ✓ Válido: número al final
        int mi_edad = 25;         // ✓ Válido: guion bajo
        int miEdad = 30;          // ✓ Válido: camelCase
        String nombreCompleto = "Juan"; // ✓ Válido: camelCase
        
        System.out.println("\nEjemplos VÁLIDOS equivalentes:");
        System.out.println("edad2 = " + edad2);
        System.out.println("mi_edad = " + mi_edad);
        System.out.println("miEdad = " + miEdad);
        System.out.println("nombreCompleto = " + nombreCompleto);
    }
    
    /**
     * EJERCICIO 3: Sensibilidad a mayúsculas/minúsculas
     * 
     * TAREA: Observa cómo Java diferencia entre mayúsculas y minúsculas
     */
    public static void ejercicioSensibilidadMayusculas() {
        System.out.println("\n=== EJERCICIO: SENSIBILIDAD A MAYÚSCULAS ===");
        
        // Estas son variables DIFERENTES porque Java diferencia mayúsculas/minúsculas
        int edad = 25;
        int Edad = 30;
        int EDAD = 35;
        
        System.out.println("edad (minúsculas) = " + edad);
        System.out.println("Edad (primera mayúscula) = " + Edad);
        System.out.println("EDAD (todas mayúsculas) = " + EDAD);
        
        System.out.println("\n✓ Java trata 'edad', 'Edad' y 'EDAD' como variables diferentes");
    }
    
    /**
     * EJERCICIO 4: Convenciones de nombres
     * 
     * TAREA: Observa las convenciones para nombrar diferentes elementos
     */
    public static void ejercicioConvenciones() {
        System.out.println("\n=== EJERCICIO: CONVENCIONES DE NOMBRES ===");
        
        // Variables: empezar con minúscula, camelCase
        int edadUsuario = 25;
        String nombreCompleto = "María García";
        double precioTotal = 99.99;
        
        // Constantes: todo en mayúsculas, guion bajo para separar palabras
        final int MAXIMO_INTENTOS = 3;
        final double PI = 3.14159;
        final String NOMBRE_APLICACION = "Mi Programa";
        
        // Clases: empezar con mayúscula, PascalCase
        // (Esta clase se llama "Identificadores" - empieza con mayúscula)
        
        System.out.println("Variables (camelCase, minúscula inicial):");
        System.out.println("  edadUsuario = " + edadUsuario);
        System.out.println("  nombreCompleto = " + nombreCompleto);
        System.out.println("  precioTotal = " + precioTotal);
        
        System.out.println("\nConstantes (MAYÚSCULAS, guion bajo):");
        System.out.println("  MAXIMO_INTENTOS = " + MAXIMO_INTENTOS);
        System.out.println("  PI = " + PI);
        System.out.println("  NOMBRE_APLICACION = " + NOMBRE_APLICACION);
        
        System.out.println("\nClases (PascalCase, mayúscula inicial):");
        System.out.println("  Identificadores (nombre de esta clase)");
    }
    
    /**
     * Método principal - Punto de entrada del programa
     */
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║              IDENTIFICADORES EN JAVA                  ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        
        ejercicioIdentificadoresValidos();
        ejercicioIdentificadoresInvalidos();
        ejercicioSensibilidadMayusculas();
        ejercicioConvenciones();
        
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║              ¡EJERCICIOS COMPLETADOS!                   ║");
        System.out.println("║     Revisa el código para ver las explicaciones        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}

