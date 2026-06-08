package ev3.ut9_programacionfuncional.pf.u02streams.ejercicios.resueltos;

// List.of fabrica listas inmutables de solo lectura, seguras como fuente de datos de prueba.
import java.util.List;

/**
 * Ejercicio 4 (Streams API): count > 5 - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Agregacion con count tras filtrado.
 * 
 * Que hace este codigo resuelto:
 * Filtra valores > 5 de [2,6,9,4,7], cuenta tres elementos e imprime.
 * 
 * Conceptos que demuestra:
 *   - Terminal count().
 *   - filter numerico.
 *   - Tipo long del conteo.
 * 
 * Salida al ejecutar main:
 * 3
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio4_CountMayorQueCinco_RESUELTO {
    public static void main(String[] args) {
        // Mezcla de valores; algunos superan 5 y seran contados por el filter.
        List<Integer> numeros = List.of(2, 6, 9, 4, 7);
        // filter(>5) + count() devuelve long sin crear lista intermedia.
        long cant = numeros.stream().filter(numero -> numero > 5).count();
        // Muestra 3: hay tres valores (6, 9, 7) estrictamente mayores que cinco.
        System.out.println(cant);
    }
}
