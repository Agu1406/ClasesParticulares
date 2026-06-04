package ev3.ut9.pf.u04principios.ejercicios.resueltos;

// Predicate<T> devuelve boolean; se usa en filter, removeIf y composicion con and/or.
import java.util.function.Predicate;

/**
 * Ejercicio 6 (Principios): HOF esPar - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Abstraccion de filtrado parametrizado por Predicate.
 * 
 * Que hace este codigo resuelto:
 * filtrarCon aplica predicado via stream e imprime pares [2,4].
 * 
 * Conceptos que demuestra:
 *   - Funcion de orden superior.
 *   - Predicate como estrategia intercambiable.
 *   - Delegacion a stream filter.
 * 
 * Salida al ejecutar main:
 * [2, 4]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio6_HofEsPar_RESUELTO {
    // filtrarCon es funcion de orden superior: recibe Predicate como parametro de comportamiento.
    static java.util.List<Integer> filtrarCon(java.util.List<Integer> lista, Predicate<Integer> p) {
        // filter(p) delega la condicion al llamador; el metodo no fija la regla de filtrado.
        return lista.stream().filter(p).collect(java.util.stream.Collectors.toList());
    }


    public static void main(String[] args) {
        // Main invoca filtrarCon con lambda par; demuestra parametrizacion del filtro.
        System.out.println(filtrarCon(java.util.List.of(1, 2, 3, 4), numero -> numero % 2 == 0));
    }
}
