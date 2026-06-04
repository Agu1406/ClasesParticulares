package ev3.ut9.pf.u04principios.ejercicios.pendientes;

import java.util.function.Predicate;

/**
 * Ejercicio 6 (Principios): funcion de orden superior (HOF).
 * 
 * Proposito:
 * Metodo que recibe comportamiento (Predicate) como parametro, habilitando reutilizacion y parametrizacion del filtrado.
 * 
 * Objetivos de aprendizaje:
 *   - filtrarCon(List, Predicate).
 *   - Implementar con stream filter collect.
 *   - Probar con lambda n%2==0.
 * 
 * Tu tarea:
 * Completa filtrarCon para filtrar lista segun predicado recibido. En main filtra pares de [1,2,3,4] e imprime [2, 4].
 * 
 * Salida esperada al ejecutar main:
 * [2, 4]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio6_HofEsPar_SIN_RESOLVER {
    static java.util.List<Integer> filtrarCon(java.util.List<Integer> lista, Predicate<Integer> p) {
        // TODO implementar con stream filter collect
        return java.util.List.of();
    }

    public static void main(String[] args) {
        // TODO: filtrarCon(List.of(1,2,3,4), n->n%2==0) imprimir
    }
}
