/**
 * VARIABLES EN JAVA
 * 
 * Esta clase explica qué son las variables, cómo declararlas,
 * inicializarlas, utilizarlas y cómo se almacenan en memoria.
 * 
 * @author Clases Particulares
 * @version 1.0
 */

public class Variables {
    
    /*
     * EXPLICACIÓN:
     * 
     * Una VARIABLE es como una "caja" donde guardamos información.
     * 
     * DECLARACIÓN: Le decimos a Java que vamos a usar una variable
     *   Ejemplo: int edad;
     * 
     * INICIALIZACIÓN: Le damos un valor por primera vez
     *   Ejemplo: edad = 25;
     * 
     * DECLARACIÓN + INICIALIZACIÓN (en una línea):
     *   Ejemplo: int edad = 25;
     * 
     * UTILIZACIÓN: Usamos la variable en nuestro código
     *   Ejemplo: System.out.println(edad);
     * 
     * ALMACENAMIENTO EN MEMORIA:
     * - Cuando declaras una variable, Java reserva espacio en la memoria RAM
     * - Cada tipo de dato ocupa diferente cantidad de espacio:
     *   * int: 4 bytes (números enteros)
     *   * double: 8 bytes (números decimales)
     *   * boolean: 1 bit (true o false)
     *   * char: 2 bytes (un carácter)
     *   * String: variable (depende de la longitud del texto)
     * - La variable guarda el valor hasta que se cambie o termine el programa
     * - Cada variable tiene una dirección de memoria única
     */
    
    /**
     * EJERCICIO 1: Declaración de variables
     * 
     * TAREA: Observa cómo se declaran las variables
     */
    public static void ejercicioDeclaracion() {
        System.out.println("=== EJERCICIO: DECLARACIÓN DE VARIABLES ===");
        
        // DECLARACIÓN (sin valor inicial)
        int numero1;
        String nombre;
        double precio;
        boolean esActivo;
        
        System.out.println("Variables declaradas:");
        System.out.println("  int numero1;");
        System.out.println("  String nombre;");
        System.out.println("  double precio;");
        System.out.println("  boolean esActivo;");
        
        System.out.println("\n⚠️ Estas variables aún no tienen valor");
        System.out.println("   Debes inicializarlas antes de usarlas");
    }
    
    /**
     * EJERCICIO 2: Inicialización de variables
     * 
     * TAREA: Observa cómo se inicializan las variables
     */
    public static void ejercicioInicializacion() {
        System.out.println("\n=== EJERCICIO: INICIALIZACIÓN DE VARIABLES ===");
        
        // Primero declaramos
        int edad;
        String nombre;
        
        // Luego inicializamos (damos un valor)
        edad = 25;
        nombre = "María";
        
        System.out.println("Paso 1: Declaración");
        System.out.println("  int edad;");
        System.out.println("  String nombre;");
        
        System.out.println("\nPaso 2: Inicialización");
        System.out.println("  edad = 25;");
        System.out.println("  nombre = \"María\";");
        
        System.out.println("\nResultado:");
        System.out.println("  edad = " + edad);
        System.out.println("  nombre = " + nombre);
    }
    
    /**
     * EJERCICIO 3: Declaración e inicialización en una línea
     * 
     * TAREA: Observa la forma más común de crear variables
     */
    public static void ejercicioDeclaracionInicializacion() {
        System.out.println("\n=== EJERCICIO: DECLARACIÓN + INICIALIZACIÓN ===");
        
        // Declaración e inicialización en una sola línea
        int numero = 10;
        String nombre = "Carlos";
        double precio = 15.50;
        boolean esVerdadero = true;
        char letra = 'A';
        
        System.out.println("Forma más común (todo en una línea):");
        System.out.println("  int numero = 10;");
        System.out.println("  String nombre = \"Carlos\";");
        System.out.println("  double precio = 15.50;");
        System.out.println("  boolean esVerdadero = true;");
        System.out.println("  char letra = 'A';");
        
        System.out.println("\nValores:");
        System.out.println("  numero = " + numero);
        System.out.println("  nombre = " + nombre);
        System.out.println("  precio = " + precio);
        System.out.println("  esVerdadero = " + esVerdadero);
        System.out.println("  letra = " + letra);
    }
    
    /**
     * EJERCICIO 4: Utilización de variables
     * 
     * TAREA: Observa cómo se usan las variables en el código
     */
    public static void ejercicioUtilizacion() {
        System.out.println("\n=== EJERCICIO: UTILIZACIÓN DE VARIABLES ===");
        
        // Crear variables
        int edad = 20;
        String nombre = "Ana";
        double altura = 1.65;
        
        // USAR las variables en operaciones
        int edadFutura = edad + 10;
        String mensaje = "Hola, soy " + nombre;
        double alturaCm = altura * 100;
        
        System.out.println("Variables originales:");
        System.out.println("  edad = " + edad);
        System.out.println("  nombre = " + nombre);
        System.out.println("  altura = " + altura);
        
        System.out.println("\nVariables usadas en cálculos:");
        System.out.println("  edadFutura = edad + 10 = " + edadFutura);
        System.out.println("  mensaje = \"Hola, soy \" + nombre = " + mensaje);
        System.out.println("  alturaCm = altura * 100 = " + alturaCm);
        
        // Cambiar el valor de una variable
        edad = 25;
        System.out.println("\nDespués de cambiar edad:");
        System.out.println("  edad = " + edad);
    }
    
    /**
     * EJERCICIO 5: Almacenamiento en memoria
     * 
     * TAREA: Entiende cómo se almacenan las variables en memoria
     */
    public static void ejercicioAlmacenamientoMemoria() {
        System.out.println("\n=== EJERCICIO: ALMACENAMIENTO EN MEMORIA ===");
        
        System.out.println("Cuando declaras una variable, Java:");
        System.out.println("1. Reserva espacio en la memoria RAM");
        System.out.println("2. Asigna una dirección de memoria única");
        System.out.println("3. Guarda el valor en esa dirección");
        
        System.out.println("\nTamaño que ocupa cada tipo en memoria:");
        System.out.println("  int:    4 bytes (32 bits)");
        System.out.println("  double: 8 bytes (64 bits)");
        System.out.println("  boolean: 1 bit (true o false)");
        System.out.println("  char:    2 bytes (16 bits)");
        System.out.println("  String:  variable (depende del texto)");
        
        // Ejemplo práctico
        int numero = 42;
        double decimal = 3.14;
        boolean verdadero = true;
        char letra = 'X';
        String texto = "Hola";
        
        System.out.println("\nEjemplo de variables en memoria:");
        System.out.println("  int numero = " + numero + " (ocupa 4 bytes)");
        System.out.println("  double decimal = " + decimal + " (ocupa 8 bytes)");
        System.out.println("  boolean verdadero = " + verdadero + " (ocupa 1 bit)");
        System.out.println("  char letra = " + letra + " (ocupa 2 bytes)");
        System.out.println("  String texto = \"" + texto + "\" (ocupa variable)");
        
        System.out.println("\n✓ Cada variable tiene su propio espacio en memoria");
        System.out.println("✓ El valor se mantiene hasta que lo cambies o termine el programa");
    }
    
    /**
     * EJERCICIO 6: Cambiar valores de variables
     * 
     * TAREA: Observa cómo cambiar el valor de una variable
     */
    public static void ejercicioCambiarValores() {
        System.out.println("\n=== EJERCICIO: CAMBIAR VALORES DE VARIABLES ===");
        
        // Crear variable con un valor
        int contador = 0;
        System.out.println("Valor inicial: contador = " + contador);
        
        // Cambiar el valor
        contador = 5;
        System.out.println("Después de cambiar: contador = " + contador);
        
        // Cambiar usando operaciones
        contador = contador + 3;
        System.out.println("Después de sumar 3: contador = " + contador);
        
        // Forma abreviada
        contador += 2;
        System.out.println("Después de += 2: contador = " + contador);
        
        // Incrementar en 1
        contador++;
        System.out.println("Después de ++: contador = " + contador);
        
        System.out.println("\n✓ Las variables pueden cambiar su valor");
        System.out.println("✓ El nuevo valor reemplaza al anterior en memoria");
    }
    
    /**
     * Método principal - Punto de entrada del programa
     */
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                  VARIABLES EN JAVA                     ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        
        ejercicioDeclaracion();
        ejercicioInicializacion();
        ejercicioDeclaracionInicializacion();
        ejercicioUtilizacion();
        ejercicioAlmacenamientoMemoria();
        ejercicioCambiarValores();
        
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║              ¡EJERCICIOS COMPLETADOS!                   ║");
        System.out.println("║     Revisa el código para ver las explicaciones        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}

