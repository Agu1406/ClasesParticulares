package ev3.ut9.pf.u04principios.ejercicios.pendientes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Ejercicio 3 (Principios): reescribir forEach malo a collect.
 * 
 * Proposito:
 * Anti-patron: usar forEach para llenar lista externa; solucion idiomatica con map + collect expresando transformacion.
 * 
 * Objetivos de aprendizaje:
 *   - Evitar dst.add dentro de forEach.
 *   - map toUpperCase + collect.
 *   - Imprimir lista destino.
 * 
 * Tu tarea:
 * Transforma src a mayusculas creando dst solo con map+collect (sin forEach que muta dst).
 * 
 * Salida esperada al ejecutar main:
 * [A, B]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio3_ForEachMaloACollect_SIN_RESOLVER {
    public static void main(String[] args) {
        List<String> src = List.of("a", "b");
        List<String> dst = new ArrayList<>();
        // TODO: NO usar forEach que haga dst.add; usar map+collect
    }
}
