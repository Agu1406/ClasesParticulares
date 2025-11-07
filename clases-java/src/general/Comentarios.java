/**
 * COMENTARIOS EN JAVA
 * 
 * Esta clase explica los diferentes tipos de comentarios
 * y cómo usarlos correctamente.
 * 
 * @author Clases Particulares
 * @version 1.0
 */

public class Comentarios {
    
    /*
     * EXPLICACIÓN:
     * 
     * Los COMENTARIOS son texto que escribimos en el código pero que Java IGNORA.
     * Sirven para explicar el código a otros programadores (o a ti mismo).
     * 
     * TIPOS DE COMENTARIOS:
     * 
     * 1. COMENTARIO DE LÍNEA (//):
     *    - Todo lo que está después de // en esa línea es comentario
     *    - Ejemplo: int edad = 25; // Esta es la edad del usuario
     * 
     * 2. COMENTARIO DE BLOQUE (/* ... *\/):
     *    - Todo lo que está entre /* y *\/ es comentario
     *    - Puede ocupar varias líneas
     *    - Ejemplo:
     *      /* Este es un comentario
     *         que ocupa varias líneas *\/
     * 
     * 3. COMENTARIO DE DOCUMENTACIÓN (/** ... *\/):
     *    - Similar al comentario de bloque, pero con doble asterisco
     *    - Se usa para documentar clases y métodos
     *    - Java puede generar documentación automática con estos comentarios
     * 
     * ¿PARA QUÉ SIRVEN?
     * - Explicar qué hace el código
     * - Documentar funciones y clases
     * - Desactivar código temporalmente
     * - Hacer notas para el futuro
     * 
     * IMPORTANTE:
     * - Los comentarios NO afectan el funcionamiento del programa
     * - Son solo para humanos, Java los ignora completamente
     */
    
    /**
     * EJERCICIO 1: Comentarios de línea
     */
    public static void ejercicioComentariosLinea() {
        System.out.println("=== EJERCICIO: COMENTARIOS DE LÍNEA ===");
        
        // Este es un comentario de línea
        int edad = 25;  // Aquí guardamos la edad del usuario
        
        System.out.println("Ejemplo de comentarios de línea:");
        System.out.println("  // Este es un comentario de línea");
        System.out.println("  int edad = 25;  // Aquí guardamos la edad");
        
        System.out.println("\nEdad: " + edad);
        
        // También puedes poner solo el comentario en una línea
        // Esto es útil para explicar bloques de código
        
        System.out.println("\n✓ Los comentarios de línea empiezan con //");
        System.out.println("✓ Todo después de // en esa línea es comentario");
    }
    
    /**
     * EJERCICIO 2: Comentarios de bloque
     */
    public static void ejercicioComentariosBloque() {
        System.out.println("\n=== EJERCICIO: COMENTARIOS DE BLOQUE ===");
        
        /* Este es un comentario de bloque
           que puede ocupar varias líneas.
           Java ignora todo lo que está entre /* y *\/
        */
        
        int numero = 10;
        
        System.out.println("Ejemplo de comentario de bloque:");
        System.out.println("  /* Este es un comentario");
        System.out.println("     que ocupa varias líneas */");
        
        System.out.println("\nNúmero: " + numero);
        
        System.out.println("\n✓ Los comentarios de bloque van entre /* y */");
        System.out.println("✓ Pueden ocupar varias líneas");
    }
    
    /**
     * EJERCICIO 3: Comentarios de documentación
     */
    public static void ejercicioComentariosDocumentacion() {
        System.out.println("\n=== EJERCICIO: COMENTARIOS DE DOCUMENTACIÓN ===");
        
        System.out.println("Los comentarios de documentación usan /** ... */");
        System.out.println("Se usan para documentar clases y métodos:");
        System.out.println("  /**");
        System.out.println("   * Descripción del método");
        System.out.println("   * @param nombre Descripción del parámetro");
        System.out.println("   * @return Descripción del valor de retorno");
        System.out.println("   */");
        
        System.out.println("\n✓ Los comentarios de documentación usan /**");
        System.out.println("✓ Java puede generar documentación automática con ellos");
    }
    
    /**
     * EJERCICIO 4: Usar comentarios para explicar código
     */
    public static void ejercicioExplicarCodigo() {
        System.out.println("\n=== EJERCICIO: EXPLICAR CÓDIGO CON COMENTARIOS ===");
        
        // Calcular el área de un círculo
        double radio = 5.0;
        double pi = 3.14159;
        double area = pi * radio * radio;  // Fórmula: π * r²
        
        System.out.println("Código con comentarios explicativos:");
        System.out.println("  // Calcular el área de un círculo");
        System.out.println("  double radio = 5.0;");
        System.out.println("  double pi = 3.14159;");
        System.out.println("  double area = pi * radio * radio;  // Fórmula: π * r²");
        
        System.out.println("\nResultado: área = " + area);
        
        System.out.println("\n✓ Los comentarios ayudan a entender qué hace el código");
        System.out.println("✓ Especialmente útil para fórmulas y lógica compleja");
    }
    
    /**
     * EJERCICIO 5: Desactivar código con comentarios
     */
    public static void ejercicioDesactivarCodigo() {
        System.out.println("\n=== EJERCICIO: DESACTIVAR CÓDIGO CON COMENTARIOS ===");
        
        System.out.println("Puedes usar comentarios para desactivar código:");
        System.out.println("  // System.out.println(\"Este mensaje no se mostrará\");");
        
        // Código desactivado:
        // System.out.println("Este mensaje está comentado");
        // int numero = 100;
        
        System.out.println("\n✓ Puedes comentar código para desactivarlo temporalmente");
        System.out.println("✓ Útil para probar diferentes versiones del código");
    }
    
    /**
     * EJERCICIO 6: Buenas prácticas con comentarios
     */
    public static void ejercicioBuenasPracticas() {
        System.out.println("\n=== EJERCICIO: BUENAS PRÁCTICAS CON COMENTARIOS ===");
        
        System.out.println("BUENAS PRÁCTICAS:");
        System.out.println("1. Explica el 'por qué', no el 'qué'");
        System.out.println("   ❌ Mal: int edad = 25; // edad es 25");
        System.out.println("   ✓ Bien: int edad = 25; // Edad mínima requerida");
        
        System.out.println("\n2. Mantén los comentarios actualizados");
        System.out.println("   Si cambias el código, actualiza los comentarios");
        
        System.out.println("\n3. No comentes código obvio");
        System.out.println("   ❌ Mal: int x = 5; // x es 5");
        System.out.println("   ✓ Bien: int edadMinima = 18; // Edad legal");
        
        System.out.println("\n4. Usa comentarios para secciones grandes");
        System.out.println("   // ========================================");
        System.out.println("   // SECCIÓN: Cálculo de precios");
        System.out.println("   // ========================================");
        
        System.out.println("\n✓ Los comentarios deben ayudar, no confundir");
    }
    
    /**
     * EJERCICIO 7: Resumen de tipos de comentarios
     */
    public static void ejercicioResumen() {
        System.out.println("\n=== EJERCICIO: RESUMEN DE TIPOS DE COMENTARIOS ===");
        
        System.out.println("1. COMENTARIO DE LÍNEA (//):");
        System.out.println("   // Todo esto es comentario");
        System.out.println("   int x = 5;  // Esto también es comentario");
        
        System.out.println("\n2. COMENTARIO DE BLOQUE (/* ... */):");
        System.out.println("   /* Este comentario");
        System.out.println("      puede tener varias líneas */");
        
        System.out.println("\n3. COMENTARIO DE DOCUMENTACIÓN (/** ... */):");
        System.out.println("   /**");
        System.out.println("    * Documenta clases y métodos");
        System.out.println("    */");
        
        System.out.println("\n✓ Java ignora completamente los comentarios");
        System.out.println("✓ Son solo para humanos, no afectan el programa");
    }
    
    /**
     * Método principal
     */
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                  COMENTARIOS EN JAVA                    ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        
        ejercicioComentariosLinea();
        ejercicioComentariosBloque();
        ejercicioComentariosDocumentacion();
        ejercicioExplicarCodigo();
        ejercicioDesactivarCodigo();
        ejercicioBuenasPracticas();
        ejercicioResumen();
        
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║              ¡EJERCICIOS COMPLETADOS!                   ║");
        System.out.println("║     Revisa el código para ver las explicaciones        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}

