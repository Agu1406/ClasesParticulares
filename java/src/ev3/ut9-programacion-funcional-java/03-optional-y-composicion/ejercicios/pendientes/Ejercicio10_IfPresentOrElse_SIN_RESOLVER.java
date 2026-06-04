package ev3.ut9.pf.optional.pendientes;

import java.util.Optional;

/**
 * Ejercicio 10 (Optional): ifPresentOrElse.
 * 
 * Proposito:
 * Ejecutar accion distinta segun presencia o ausencia de valor sin if/else explicito sobre isPresent.
 * 
 * Objetivos de aprendizaje:
 *   - Optional con valor.
 *   - ifPresentOrElse Consumer, Runnable.
 *   - Probar tambien Optional empty.
 * 
 * Tu tarea:
 * Con dato presente imprime "Valor: PF"; con empty imprime "vacio". Usa ifPresentOrElse en ambos casos.
 * 
 * Salida esperada al ejecutar main:
 * Valor: PF
vacio
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio10_IfPresentOrElse_SIN_RESOLVER {
    public static void main(String[] args) {
        Optional<String> dato = Optional.of("PF");
        // TODO: ifPresentOrElse imprimir valor o mensaje vacio
    }
}
