package ev3.ut9.pf.u01lambda.ejercicios.resueltos;

// List.of
import java.util.List;

/**
 * Ejercicio universidad (sesion1 ej.10): forEach doble reales.
 * 
 * Proposito:
 * forEach imprime el doble de cada Double.
 * 
 * Origen:
 *   sesion1 ej.10
 * 
 * Tu tarea:
 * Una linea por valor.
 * 
 * Salida esperada al ejecutar main:
 * 2.0
5.0
6.4
9.6
 * 
 * SOLUCION.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio23_UniForEachDobleReales_RESUELTO {
    public static void main(String[] args) {
        // lista
        java.util.List<Double> reals = java.util.List.of(1.0, 2.5, 3.2, 4.8);
        // doble
        reals.forEach(x -> System.out.println(x * 2));
    }
}
