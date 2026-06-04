package ev3.ut9.pf.streams.pendientes;

import java.util.List;
import java.util.Optional;

/**
 * Ejercicio 8 (Streams API): findFirst en stream filtrado.
 * 
 * Proposito:
 * Operacion terminal que devuelve Optional: buscar primer elemento que cumple condicion con valor por defecto si no hay ninguno.
 * 
 * Objetivos de aprendizaje:
 *   - filter + findFirst().
 *   - orElse para valor sustituto.
 *   - Optional como contenedor de resultado opcional.
 * 
 * Tu tarea:
 * Obtiene el primer entero mayor que 3 de la lista; si no hubiera ninguno usa -1. Imprime el valor.
 * 
 * Salida esperada al ejecutar main:
 * 4
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio8_FindFirst_SIN_RESOLVER {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(1, 3, 4, 8);
        // TODO: filter >3 findFirst y orElse -1
    }
}
