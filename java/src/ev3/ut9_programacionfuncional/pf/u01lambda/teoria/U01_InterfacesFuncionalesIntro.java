package ev3.ut9_programacionfuncional.pf.u01lambda.teoria;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Interfaz SAM en otro archivo del mismo paquete (divide).
 */
@FunctionalInterface
interface CalculadoraDivide {
    int dividir(int numero1, int numero2);
}

/**
 * Teoria: interfaces funcionales SAM (PDF diapos 10-11).
 *
 * <p><b>Que es SAM?</b> Single Abstract Method: una interfaz con exactamente un metodo
 * abstracto. La lambda es la implementacion de ese metodo sin escribir {@code new ... { }}.</p>
 *
 * <p><b>Demo en este archivo (en orden):</b></p>
 * <ol>
 *   <li>Calculadoras propias (suma, resta, divide) como en la primera clase.</li>
 *   <li>Tipos estandar del JDK: Predicate, Function, Consumer, Supplier.</li>
 * </ol>
 *
 * <p><b>Guion de clase:</b> primero "contrato + lambda = comportamiento". Despues los tipos
 * del JDK que reutilizaras en filter, map, forEach y streams.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class U01_InterfacesFuncionalesIntro {

    @FunctionalInterface
    interface CalculadoraSuma {
        int sumar(int numero1, int numero2);
    }

    @FunctionalInterface
    interface CalculadoraResta {
        int resta(int numero1, int numero2);
    }

    public static void main(String[] args) {
        demostrarCalculadorasPropias();
        demostrarTiposDelJdk();
    }

    /**
     * Parte 1: SAM con interfaces que tu defines (metáfora de la calculadora).
     */
    private static void demostrarCalculadorasPropias() {
        System.out.println("=== Interfaces propias (SAM) ===");

        /**
         * Instancio la interfaz con una lambda: defino las reglas de la operacion.
         * Desde aqui puedo llamar a sumar / resta / dividir como si fuera un objeto util.
         */
        CalculadoraSuma calculadoraSuma = (numero1, numero2) -> numero1 + numero2;
        CalculadoraResta calculadoraResta = (numero1, numero2) -> numero1 - numero2;
        CalculadoraDivide calculadoraDivide = (numero1, numero2) -> numero1 / numero2;

        int resultadoSuma = calculadoraSuma.sumar(2, 6);
        System.out.println("Resultado suma (guardado en variable): " + resultadoSuma);

        System.out.println("Resultado resta: " + calculadoraResta.resta(10, 5));
        System.out.println("Resultado division: " + calculadoraDivide.dividir(100, 10));

        /**
         * Enfoque tradicional sin interfaz funcional: variables sueltas por operacion.
         * Funciona, pero si repites el patron muchas veces generas codigo similar (rompe D.R.Y).
         */
        int numero1 = 2;
        int numero2 = 4;
        int resultadoTradicional = numero1 + numero2;
        System.out.println("Resultado tradicional de suma: " + resultadoTradicional);
        System.out.println();
    }

    /**
     * Parte 2: Java ya trae interfaces funcionales para casos comunes (java.util.function).
     */
    private static void demostrarTiposDelJdk() {
        System.out.println("=== Tipos del JDK (java.util.function) ===");

        /**
         * Predicate<T>  -> pregunta si cumple condicion (test). Uso: filter, removeIf.
         * Function<T,R> -> transforma T en R (apply). Uso: map.
         * Consumer<T>   -> recibe T y no devuelve nada (accept). Uso: forEach.
         * Supplier<T>   -> no recibe nada, produce T (get). Uso: fabricas, valores lazy.
         */
        Predicate<String> esLarga = texto -> texto.length() > 5;
        Function<String, Integer> longitud = String::length;
        Consumer<String> imprimir = texto -> System.out.println(">> " + texto);
        Supplier<Double> aleatorio = Math::random;

        System.out.println("esLarga('lambda'): " + esLarga.test("lambda"));
        System.out.println("longitud('stream'): " + longitud.apply("stream"));
        imprimir.accept("Consumer de ejemplo");
        System.out.println("aleatorio: " + aleatorio.get());
    }
}
