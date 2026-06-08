package ev3.ut9_programacionfuncional.pf.u04principios.ejercicios.resueltos;

// List.of fabrica listas inmutables de solo lectura, seguras como fuente de datos de prueba.
import java.util.List;

/**
 * Ejercicio 4 (Principios): List.of - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Demostracion de inmutabilidad en tiempo de ejecucion.
 * 
 * Que hace este codigo resuelto:
 * Imprime [x,y], falla add y captura UnsupportedOperationException mostrando inmutable.
 * 
 * Conceptos que demuestra:
 *   - List.of factory inmutable.
 *   - Fail-fast en mutacion.
 *   - Programacion funcional favorece inmutabilidad.
 * 
 * Salida al ejecutar main:
 * [x, y]
inmutable
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio4_ListOf_RESUELTO {
    public static void main(String[] args) {
        // List.of("x","y") no permite add; intentarlo lanza UnsupportedOperationException.
        List<String> fija = List.of("x", "y");
        // Imprime [x, y] antes de demostrar que la lista no admite modificacion.
        System.out.println(fija);
        // try/catch captura excepcion al mutar lista fija e imprime mensaje inmutable.
        try { fija.add("z"); } catch (UnsupportedOperationException e) { System.out.println("inmutable"); }
    }
}
