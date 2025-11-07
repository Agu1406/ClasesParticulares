/**
 * PALABRAS RESERVADAS EN JAVA
 * 
 * Esta clase explica qué son las palabras reservadas
 * y cómo se usan en Java.
 * 
 * @author Clases Particulares
 * @version 1.0
 */

public class PalabrasReservadas {
    
    /*
     * EXPLICACIÓN:
     * 
     * Las PALABRAS RESERVADAS son palabras que Java usa para su propio lenguaje.
     * NO podemos usarlas como nombres de variables, métodos o clases.
     * 
     * Ejemplos importantes:
     * 
     * TIPOS DE DATOS:
     * - int, double, boolean, char, byte, short, long, float
     * - void (indica que no retorna valor)
     * 
     * CONTROL DE FLUJO:
     * - if, else, switch, case, default
     * - for, while, do
     * - break, continue, return
     * 
     * CLASES Y OBJETOS:
     * - class, public, private, protected
     * - static, final, abstract
     * - new, this, super
     * 
     * OTROS:
     * - import, package
     * - try, catch, finally, throw, throws
     * - extends, implements
     * - instanceof
     * 
     * IMPORTANTE:
     * - Estas palabras tienen un significado especial en Java
     * - No pueden ser usadas como identificadores
     * - Si intentas usarlas como nombre de variable, Java dará error
     */
    
    /**
     * EJERCICIO 1: Palabras reservadas de tipos de datos
     * 
     * TAREA: Observa cómo se usan las palabras reservadas para tipos
     */
    public static void ejercicioTiposDatos() {
        System.out.println("=== EJERCICIO: PALABRAS RESERVADAS - TIPOS DE DATOS ===");
        
        // "int" es palabra reservada (tipo de dato entero)
        int numero = 10;
        
        // "double" es palabra reservada (tipo de dato decimal)
        double precio = 99.99;
        
        // "boolean" es palabra reservada (tipo de dato lógico)
        boolean esVerdadero = true;
        
        // "char" es palabra reservada (tipo de dato carácter)
        char letra = 'A';
        
        // "String" NO es palabra reservada, es una clase
        String texto = "Hola";
        
        System.out.println("int numero = " + numero);
        System.out.println("double precio = " + precio);
        System.out.println("boolean esVerdadero = " + esVerdadero);
        System.out.println("char letra = " + letra);
        System.out.println("String texto = " + texto);
        
        System.out.println("\n✓ int, double, boolean, char son palabras reservadas");
    }
    
    /**
     * EJERCICIO 2: Palabras reservadas de control de flujo
     * 
     * TAREA: Observa cómo se usan las palabras reservadas para controlar el flujo
     */
    public static void ejercicioControlFlujo() {
        System.out.println("\n=== EJERCICIO: PALABRAS RESERVADAS - CONTROL DE FLUJO ===");
        
        // "if" es palabra reservada
        int numero = 15;
        
        if (numero > 10) {
            // "if" controla si se ejecuta este bloque
            System.out.println("El número es mayor que 10");
        } else {
            // "else" es palabra reservada
            System.out.println("El número no es mayor que 10");
        }
        
        // "for" es palabra reservada (bucle)
        System.out.println("\nBucle for:");
        for (int i = 0; i < 3; i++) {
            System.out.println("  Iteración: " + i);
        }
        
        // "while" es palabra reservada (bucle)
        System.out.println("\nBucle while:");
        int contador = 0;
        while (contador < 2) {
            System.out.println("  Contador: " + contador);
            contador++;
        }
        
        // "return" es palabra reservada (retorna un valor)
        System.out.println("\n✓ if, else, for, while, return son palabras reservadas");
    }
    
    /**
     * EJERCICIO 3: Palabras reservadas de clases y objetos
     * 
     * TAREA: Observa cómo se usan las palabras reservadas relacionadas con clases
     */
    public static void ejercicioClasesObjetos() {
        System.out.println("\n=== EJERCICIO: PALABRAS RESERVADAS - CLASES Y OBJETOS ===");
        
        // "public" es palabra reservada (modificador de acceso)
        // "class" es palabra reservada (define una clase)
        // "static" es palabra reservada (método estático)
        // "void" es palabra reservada (no retorna valor)
        
        System.out.println("Palabras reservadas usadas en este método:");
        System.out.println("  - public: hace el método visible");
        System.out.println("  - static: hace el método pertenecer a la clase");
        System.out.println("  - void: indica que no retorna valor");
        
        // "new" es palabra reservada (crea un objeto)
        String mensaje = new String("Hola Mundo");
        System.out.println("\nUsando 'new' para crear un objeto:");
        System.out.println("  String mensaje = new String(\"Hola Mundo\");");
        System.out.println("  Resultado: " + mensaje);
        
        System.out.println("\n✓ public, class, static, void, new son palabras reservadas");
    }
    
    /**
     * EJERCICIO 4: Intentar usar palabras reservadas como identificadores
     * 
     * TAREA: Observa qué pasa si intentas usar palabras reservadas como nombres
     */
    public static void ejercicioErrorReservadas() {
        System.out.println("\n=== EJERCICIO: ERRORES CON PALABRAS RESERVADAS ===");
        
        System.out.println("Si intentas usar palabras reservadas como nombres de variables,");
        System.out.println("Java dará un error de compilación.");
        
        System.out.println("\nEjemplos que darían ERROR:");
        System.out.println("  int int = 5;        // ❌ ERROR: 'int' es palabra reservada");
        System.out.println("  String class = \"x\"; // ❌ ERROR: 'class' es palabra reservada");
        System.out.println("  boolean if = true;   // ❌ ERROR: 'if' es palabra reservada");
        System.out.println("  double for = 3.14;   // ❌ ERROR: 'for' es palabra reservada");
        
        System.out.println("\nSoluciones correctas:");
        System.out.println("  int numero = 5;           // ✓ Correcto");
        System.out.println("  String clase = \"x\";      // ✓ Correcto");
        System.out.println("  boolean condicion = true;  // ✓ Correcto");
        System.out.println("  double valor = 3.14;       // ✓ Correcto");
        
        // Ejemplos correctos
        int numero = 5;
        String clase = "x";
        boolean condicion = true;
        double valor = 3.14;
        
        System.out.println("\nEjemplos correctos ejecutados:");
        System.out.println("  numero = " + numero);
        System.out.println("  clase = " + clase);
        System.out.println("  condicion = " + condicion);
        System.out.println("  valor = " + valor);
    }
    
    /**
     * EJERCICIO 5: Lista de palabras reservadas comunes
     * 
     * TAREA: Revisa esta lista de palabras reservadas importantes
     */
    public static void ejercicioListaReservadas() {
        System.out.println("\n=== EJERCICIO: LISTA DE PALABRAS RESERVADAS ===");
        
        System.out.println("TIPOS DE DATOS:");
        System.out.println("  int, double, boolean, char, byte, short, long, float, void");
        
        System.out.println("\nCONTROL DE FLUJO:");
        System.out.println("  if, else, switch, case, default");
        System.out.println("  for, while, do");
        System.out.println("  break, continue, return");
        
        System.out.println("\nCLASES Y OBJETOS:");
        System.out.println("  class, public, private, protected");
        System.out.println("  static, final, abstract");
        System.out.println("  new, this, super");
        
        System.out.println("\nOTROS:");
        System.out.println("  import, package");
        System.out.println("  try, catch, finally, throw, throws");
        System.out.println("  extends, implements");
        System.out.println("  instanceof");
        
        System.out.println("\n⚠️ IMPORTANTE: Estas palabras NO pueden usarse como nombres");
        System.out.println("   de variables, métodos o clases.");
    }
    
    /**
     * Método principal - Punto de entrada del programa
     */
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║            PALABRAS RESERVADAS EN JAVA                ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        
        ejercicioTiposDatos();
        ejercicioControlFlujo();
        ejercicioClasesObjetos();
        ejercicioErrorReservadas();
        ejercicioListaReservadas();
        
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║              ¡EJERCICIOS COMPLETADOS!                   ║");
        System.out.println("║     Revisa el código para ver las explicaciones        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}

