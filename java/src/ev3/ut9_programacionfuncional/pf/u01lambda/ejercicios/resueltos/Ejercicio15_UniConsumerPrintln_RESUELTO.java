package ev3.ut9_programacionfuncional.pf.u01lambda.ejercicios.resueltos;



/**
 * Ejercicio universidad (TPP Hoja2 ej.5): Consumer println.
 * 
 * Proposito:
 * System.out::println como Consumer<String>.
 * 
 * Origen:
 *   TPP Hoja2 ej.5
 * 
 * Tu tarea:
 * Imprimir dos mensajes con :: y lambda.
 * 
 * Salida esperada al ejecutar main:
 * (dos lineas)
 * 
 * SOLUCION.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio15_UniConsumerPrintln_RESUELTO {
    public static void main(String[] args) {
        // referencia
        java.util.function.Consumer<String> ref = System.out::println;
        // lambda
        java.util.function.Consumer<String> lam = m -> System.out.println(m);
        // primera
        ref.accept("con referencia");
        // segunda
        lam.accept("con lambda");
    }
}
