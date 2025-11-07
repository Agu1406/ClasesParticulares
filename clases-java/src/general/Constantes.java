/**
 * CONSTANTES EN JAVA
 * 
 * Esta clase explica qué son las constantes, cómo crearlas
 * y cuándo usarlas.
 * 
 * @author Clases Particulares
 * @version 1.0
 */

public class Constantes {
    
    /*
     * EXPLICACIÓN:
     * 
     * Una CONSTANTE es una variable cuyo valor NO puede cambiar.
     * Una vez que le das un valor, ese valor se mantiene siempre igual.
     * 
     * CÓMO CREAR CONSTANTES:
     * - Usa la palabra "final" antes del tipo
     * - Por convención, el nombre va TODO EN MAYÚSCULAS
     * - Si tiene varias palabras, usa guion bajo: MI_CONSTANTE
     * 
     * Ejemplo:
     *   final int MAXIMO = 100;
     *   final double PI = 3.14159;
     *   final String NOMBRE_APLICACION = "Mi App";
     * 
     * IMPORTANTE:
     * - Las constantes deben inicializarse al declararlas
     * - No puedes cambiar su valor después
     * - Si intentas cambiar una constante, Java dará error
     * - Útiles para valores que nunca cambian (como PI, velocidad de la luz, etc.)
     * 
     * DIFERENCIA entre constante y variable:
     * - Variable: puede cambiar su valor (int edad = 25; edad = 30; ✓)
     * - Constante: NO puede cambiar su valor (final int MAX = 100; MAX = 200; ✗)
     */
    
    /**
     * EJERCICIO 1: Crear constantes básicas
     * 
     * TAREA: Observa cómo se crean las constantes
     */
    public static void ejercicioCrearConstantes() {
        System.out.println("=== EJERCICIO: CREAR CONSTANTES ===");
        
        // Constantes numéricas
        final int MAXIMO_INTENTOS = 3;
        final double PI = 3.14159;
        final int DIAS_SEMANA = 7;
        final int HORAS_DIA = 24;
        
        // Constantes de texto
        final String NOMBRE_APLICACION = "Mi Programa";
        final String MENSAJE_BIENVENIDA = "¡Bienvenido!";
        
        // Constantes booleanas
        final boolean MODO_DEBUG = true;
        
        System.out.println("Constantes numéricas:");
        System.out.println("  final int MAXIMO_INTENTOS = " + MAXIMO_INTENTOS + ";");
        System.out.println("  final double PI = " + PI + ";");
        System.out.println("  final int DIAS_SEMANA = " + DIAS_SEMANA + ";");
        System.out.println("  final int HORAS_DIA = " + HORAS_DIA + ";");
        
        System.out.println("\nConstantes de texto:");
        System.out.println("  final String NOMBRE_APLICACION = \"" + NOMBRE_APLICACION + "\";");
        System.out.println("  final String MENSAJE_BIENVENIDA = \"" + MENSAJE_BIENVENIDA + "\";");
        
        System.out.println("\nConstantes booleanas:");
        System.out.println("  final boolean MODO_DEBUG = " + MODO_DEBUG + ";");
        
        System.out.println("\n✓ Las constantes se crean con 'final'");
        System.out.println("✓ Por convención, el nombre va en MAYÚSCULAS");
    }
    
    /**
     * EJERCICIO 2: Usar constantes
     * 
     * TAREA: Observa cómo se usan las constantes en el código
     */
    public static void ejercicioUsarConstantes() {
        System.out.println("\n=== EJERCICIO: USAR CONSTANTES ===");
        
        // Definir constantes
        final double PI = 3.14159;
        final int RADIO = 5;
        
        // Usar constantes en cálculos
        double area = PI * RADIO * RADIO;
        double perimetro = 2 * PI * RADIO;
        
        System.out.println("Constantes definidas:");
        System.out.println("  final double PI = " + PI + ";");
        System.out.println("  final int RADIO = " + RADIO + ";");
        
        System.out.println("\nUsando constantes en cálculos:");
        System.out.println("  area = PI * RADIO * RADIO");
        System.out.println("  area = " + PI + " * " + RADIO + " * " + RADIO + " = " + area);
        System.out.println("  perimetro = 2 * PI * RADIO");
        System.out.println("  perimetro = 2 * " + PI + " * " + RADIO + " = " + perimetro);
        
        System.out.println("\n✓ Las constantes se usan igual que las variables");
        System.out.println("✓ Pero su valor no puede cambiar");
    }
    
    /**
     * EJERCICIO 3: Intentar cambiar una constante (ERROR)
     * 
     * TAREA: Observa qué pasa si intentas cambiar una constante
     */
    public static void ejercicioErrorCambiarConstante() {
        System.out.println("\n=== EJERCICIO: ERROR AL CAMBIAR CONSTANTE ===");
        
        // Crear una constante
        final int MAXIMO = 100;
        System.out.println("Constante creada: final int MAXIMO = " + MAXIMO + ";");
        
        System.out.println("\nSi intentas cambiar una constante:");
        System.out.println("  MAXIMO = 200;  // ❌ ERROR: no se puede cambiar");
        System.out.println("Java dará un error de compilación.");
        
        // Esta línea daría error si la descomentamos:
        // MAXIMO = 200;  // ❌ ERROR: no se puede cambiar una constante
        
        System.out.println("\n✓ Las constantes NO pueden cambiar su valor");
        System.out.println("✓ Si intentas cambiarlas, Java dará error");
    }
    
    /**
     * EJERCICIO 4: Diferencia entre constante y variable
     * 
     * TAREA: Entiende la diferencia entre constantes y variables
     */
    public static void ejercicioDiferenciaConstanteVariable() {
        System.out.println("\n=== EJERCICIO: CONSTANTE vs VARIABLE ===");
        
        // VARIABLE: puede cambiar
        int edad = 25;
        System.out.println("VARIABLE (puede cambiar):");
        System.out.println("  int edad = " + edad + ";");
        edad = 30;  // ✓ Puedo cambiar el valor
        System.out.println("  edad = 30;  // ✓ Cambio permitido");
        System.out.println("  edad ahora vale: " + edad);
        
        // CONSTANTE: NO puede cambiar
        final int MAXIMO = 100;
        System.out.println("\nCONSTANTE (NO puede cambiar):");
        System.out.println("  final int MAXIMO = " + MAXIMO + ";");
        System.out.println("  MAXIMO = 200;  // ❌ ERROR: no se puede cambiar");
        System.out.println("  MAXIMO siempre vale: " + MAXIMO);
        
        System.out.println("\n✓ Variable: puede cambiar (int edad = 25; edad = 30; ✓)");
        System.out.println("✓ Constante: NO puede cambiar (final int MAX = 100; MAX = 200; ✗)");
    }
    
    /**
     * EJERCICIO 5: Cuándo usar constantes
     * 
     * TAREA: Aprende cuándo es útil usar constantes
     */
    public static void ejercicioCuandoUsarConstantes() {
        System.out.println("\n=== EJERCICIO: CUÁNDO USAR CONSTANTES ===");
        
        System.out.println("Usa constantes para valores que:");
        System.out.println("1. Nunca cambian (como PI, velocidad de la luz)");
        System.out.println("2. Se usan muchas veces en el código");
        System.out.println("3. Tienen un significado especial");
        
        // Ejemplos de constantes útiles
        final double PI = 3.14159;
        final int MAXIMO_INTENTOS = 3;
        final String NOMBRE_APLICACION = "Mi Programa";
        final int DIAS_SEMANA = 7;
        
        System.out.println("\nEjemplos de constantes útiles:");
        System.out.println("  final double PI = " + PI + ";  // Valor matemático que no cambia");
        System.out.println("  final int MAXIMO_INTENTOS = " + MAXIMO_INTENTOS + ";  // Límite fijo");
        System.out.println("  final String NOMBRE_APLICACION = \"" + NOMBRE_APLICACION + "\";  // Nombre fijo");
        System.out.println("  final int DIAS_SEMANA = " + DIAS_SEMANA + ";  // Valor que nunca cambia");
        
        System.out.println("\nVentajas de usar constantes:");
        System.out.println("  ✓ El código es más fácil de entender");
        System.out.println("  ✓ Si necesitas cambiar el valor, solo lo cambias en un lugar");
        System.out.println("  ✓ Evitas errores al cambiar valores que no deberían cambiar");
    }
    
    /**
     * EJERCICIO 6: Convenciones de nombres para constantes
     * 
     * TAREA: Aprende las convenciones para nombrar constantes
     */
    public static void ejercicioConvencionesNombres() {
        System.out.println("\n=== EJERCICIO: CONVENCIONES DE NOMBRES ===");
        
        System.out.println("CONVENCIONES para nombrar constantes:");
        System.out.println("1. Todo en MAYÚSCULAS");
        System.out.println("2. Si tiene varias palabras, usar guion bajo (_)");
        System.out.println("3. Nombres descriptivos");
        
        // Ejemplos correctos
        final int MAXIMO_INTENTOS = 3;
        final double PI = 3.14159;
        final String NOMBRE_APLICACION = "Mi App";
        final int DIAS_EN_SEMANA = 7;
        
        System.out.println("\nEjemplos CORRECTOS:");
        System.out.println("  final int MAXIMO_INTENTOS = " + MAXIMO_INTENTOS + ";");
        System.out.println("  final double PI = " + PI + ";");
        System.out.println("  final String NOMBRE_APLICACION = \"" + NOMBRE_APLICACION + "\";");
        System.out.println("  final int DIAS_EN_SEMANA = " + DIAS_EN_SEMANA + ";");
        
        System.out.println("\nEjemplos INCORRECTOS (aunque funcionan, no siguen convenciones):");
        System.out.println("  final int maximoIntentos = 3;  // ❌ Debería ser MAYÚSCULAS");
        System.out.println("  final double pi = 3.14159;     // ❌ Debería ser MAYÚSCULAS");
        
        System.out.println("\n✓ Por convención, las constantes van en MAYÚSCULAS");
        System.out.println("✓ Usa guion bajo para separar palabras: MI_CONSTANTE");
    }
    
    /**
     * Método principal - Punto de entrada del programa
     */
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                  CONSTANTES EN JAVA                    ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        
        ejercicioCrearConstantes();
        ejercicioUsarConstantes();
        ejercicioErrorCambiarConstante();
        ejercicioDiferenciaConstanteVariable();
        ejercicioCuandoUsarConstantes();
        ejercicioConvencionesNombres();
        
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║              ¡EJERCICIOS COMPLETADOS!                   ║");
        System.out.println("║     Revisa el código para ver las explicaciones        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}

