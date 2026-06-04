package ev3.ut9.pf.lambda.pendientes;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Ejercicio 5 (Lambda y SAM): map con Function a longitudes.
 * 
 * Proposito:
 * Pasar de operaciones sobre listas imperativas a un primer pipeline stream: transformar cada elemento sin bucle explicito.
 * 
 * Objetivos de aprendizaje:
 *   - Abrir stream() sobre una lista.
 *   - Aplicar map con referencia a metodo String::length.
 *   - Materializar resultado con collect(Collectors.toList()).
 * 
 * Tu tarea:
 * Convierte cada palabra de la lista en su longitud (entero) usando stream, map y collect. Imprime la lista de longitudes.
 * 
 * Salida esperada al ejecutar main:
 * [3, 12, 2]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio5_MapFunctionLongitudes_SIN_RESOLVER {
    public static void main(String[] args) {
        List<String> palabras = List.of("sol", "programacion", "pf");
        // TODO: stream, map String::length, collect toList
        // TODO: imprimir lista de enteros
    }
}
