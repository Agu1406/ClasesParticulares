package ev3.ut9_programacionfuncional.pf.u01lambda.ejercicios.pendientes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Ejercicio 1 (Lambda y SAM): ordenar palabras por longitud.
 * 
 * Proposito:
 * Practicar el uso de expresiones lambda como implementacion anonima de Comparator para ordenar colecciones sin escribir una clase comparadora completa.
 * 
 * Objetivos de aprendizaje:
 *   - Usar Collections.sort sobre una lista mutable.
 *   - Escribir una lambda que compare la longitud de dos String.
 *   - Comprender que sort modifica el orden de la lista original, no crea una copia.
 * 
 * Tu tarea:
 * Completa el TODO en main: ordena la lista palabras de menor a mayor numero de caracteres usando Collections.sort y una expresion lambda. Imprime el resultado.
 * 
 * Salida esperada al ejecutar main:
 * [pf, java, funcional, programacion]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio1_OrdenarPorLongitud_SIN_RESOLVER {
    public static void main(String[] args) {
        List<String> palabras = new ArrayList<>(List.of("programacion", "funcional", "java", "pf"));
        // TODO: ordenar con Collections.sort y una expresion lambda que compare longitudes
        // TODO: imprimir la lista resultante con System.out.println
    }
}
