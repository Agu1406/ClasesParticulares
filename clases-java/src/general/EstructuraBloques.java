/**
 * ESTRUCTURA Y BLOQUES FUNDAMENTALES
 * 
 * Esta clase explica la estructura básica de un programa Java
 * y cómo funcionan los bloques de código.
 * 
 * @author Clases Particulares
 * @version 1.0
 */

public class EstructuraBloques {
    
    /*
     * EXPLICACIÓN:
     * 
     * Una clase en Java tiene esta estructura básica:
     * 
     * public class NombreClase {
     *     // Aquí va el código
     * }
     * 
     * - "public" es un modificador de acceso (permite que la clase sea visible)
     * - "class" es la palabra clave para crear una clase
     * - "NombreClase" es el nombre que le damos (debe empezar con mayúscula)
     * - Las llaves { } definen un BLOQUE de código
     * 
     * Los bloques son como "cajas" que contienen código:
     * - Bloque de clase: contiene todo el código de la clase
     * - Bloque de método: contiene el código de un método
     * - Bloque de if/for/while: contiene código que se ejecuta condicionalmente
     * 
     * IMPORTANTE:
     * - Cada bloque debe tener su llave de apertura { y su llave de cierre }
     * - Los bloques pueden estar dentro de otros bloques (anidados)
     * - La indentación (espacios al inicio) ayuda a ver qué código está dentro de qué bloque
     */
    
    /**
     * EJERCICIO 1: Identificar bloques
     * 
     * Observa la estructura de esta clase:
     * 1. Tiene un nombre: EstructuraBloques
     * 2. Está dentro de llaves { } - este es el BLOQUE DE CLASE
     * 3. Contiene métodos (funciones) - cada método tiene su propio BLOQUE DE MÉTODO
     */
    public static void ejercicioIdentificarBloques() {
        System.out.println("=== EJERCICIO: IDENTIFICAR BLOQUES ===");
        System.out.println("Este método está dentro de un bloque de método.");
        System.out.println("El bloque empieza con { y termina con }");
        
        // Este es otro bloque (dentro del método)
        if (true) {
            System.out.println("Este es un bloque dentro de otro bloque (anidado)");
            System.out.println("Está dentro de un 'if'");
        }
        
        System.out.println("Este código está fuera del bloque 'if'");
    }
    
    /**
     * EJERCICIO 2: Bloques anidados
     * 
     * Los bloques pueden estar dentro de otros bloques.
     * Observa cómo se organizan los diferentes niveles.
     */
    public static void ejercicioBloquesAnidados() {
        System.out.println("\n=== EJERCICIO: BLOQUES ANIDADOS ===");
        
        // Bloque nivel 1: método
        System.out.println("Nivel 1: Dentro del método");
        
        // Bloque nivel 2: if
        if (true) {
            System.out.println("  Nivel 2: Dentro del if");
            
            // Bloque nivel 3: for
            for (int i = 0; i < 2; i++) {
                System.out.println("    Nivel 3: Dentro del for (iteración " + i + ")");
            }
            
            System.out.println("  Nivel 2: De vuelta en el if");
        }
        
        System.out.println("Nivel 1: De vuelta en el método");
    }
    
    /**
     * EJERCICIO 3: Estructura de una clase completa
     * 
     * Observa todos los elementos que forman parte de una clase:
     * - Nombre de la clase
     * - Variables (atributos)
     * - Métodos (funciones)
     */
    public static void ejercicioEstructuraCompleta() {
        System.out.println("\n=== EJERCICIO: ESTRUCTURA COMPLETA ===");
        
        System.out.println("Estructura de una clase Java:");
        System.out.println("1. public class NombreClase {");
        System.out.println("2.     // Variables (atributos)");
        System.out.println("3.     // Métodos (funciones)");
        System.out.println("4. }");
        
        System.out.println("\nEsta clase tiene:");
        System.out.println("- Nombre: EstructuraBloques");
        System.out.println("- Varios métodos (ejercicioIdentificarBloques, etc.)");
        System.out.println("- Un método main (punto de entrada)");
    }
    
    /**
     * Método principal - Punto de entrada del programa
     * 
     * Este método se ejecuta cuando inicias el programa.
     * Es el BLOQUE PRINCIPAL donde comienza la ejecución.
     */
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║     ESTRUCTURA Y BLOQUES FUNDAMENTALES EN JAVA        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        
        ejercicioIdentificarBloques();
        ejercicioBloquesAnidados();
        ejercicioEstructuraCompleta();
        
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║              ¡EJERCICIOS COMPLETADOS!                   ║");
        System.out.println("║     Revisa el código para ver las explicaciones        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}

