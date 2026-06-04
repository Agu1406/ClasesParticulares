package ev3.ut9.pf.u02streams.ejercicios.resueltos;

// List.of fabrica listas inmutables de solo lectura, seguras como fuente de datos de prueba.
import java.util.List;
// Optional representa un valor que puede faltar; findFirst devuelve Optional, no null.
import java.util.Optional;

/**
 * Ejercicio 8 (Streams API): findFirst - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Busqueda opcional del primer match en stream.
 * 
 * Que hace este codigo resuelto:
 * Filtra > 3, toma findFirst (4) e imprime; orElse(-1) actuaria si vacio.
 * 
 * Conceptos que demuestra:
 *   - findFirst -> Optional.
 *   - orElse valor por defecto.
 *   - Short-circuit: no recorre todo si no hace falta.
 * 
 * Salida al ejecutar main:
 * 4
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio8_FindFirst_RESUELTO {
    public static void main(String[] args) {
        // Cuatro numeros; el primero >3 tras filtrar sera 4 (findFirst).
        List<Integer> numeros = List.of(1, 3, 4, 8);
        // filter(>3).findFirst() devuelve Optional; orElse(-1) si no hubiera match.
        int primero = numeros.stream().filter(numero -> numero > 3).findFirst().orElse(-1);
        // Muestra 4: primer entero que supera 3; -1 seria el valor por defecto si vacio.
        System.out.println(primero);
    }
}
