package ev3.ut9.pf.u03optional.ejercicios.resueltos;

// Consumer
import java.util.function.Consumer;

/**
 * Ejercicio universidad (TPP Hoja3 ej.4): Consumer andThen orden.
 * 
 * Proposito:
 * Orden importa en Consumer.andThen.
 * 
 * Origen:
 *   TPP Hoja3 ej.4
 * 
 * Tu tarea:
 * print con prefijo y upper; comparar orden.
 * 
 * Salida esperada al ejecutar main:
 * (dos salidas distintas)
 * 
 * SOLUCION.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio12_UniConsumerAndThenOrden_RESUELTO {
    public static void main(String[] args) {
        // print
        java.util.function.Consumer<String> print = s -> System.out.print("<<" + s + ">>");
        // upper
        java.util.function.Consumer<String> upper = s -> System.out.println(s.toUpperCase());
        // dato
        String texto = "hola";
        // cabecera
        System.out.println("printThenUpper:");
        // orden1
        print.andThen(upper).accept(texto);
        // cabecera2
        System.out.println("upperThenPrint:");
        // orden2
        upper.andThen(print).accept(texto);
    }
}
