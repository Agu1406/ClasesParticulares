package ev3.ut9.pf.optional.pendientes;

import java.util.Optional;

/**
 * Ejercicio 2 (Optional): orElse con Optional vacio.
 * 
 * Proposito:
 * Extraer valor de contenedor vacio de forma segura con valor por defecto inmediato.
 * 
 * Objetivos de aprendizaje:
 *   - Optional.empty().
 *   - orElse("defecto").
 *   - Imprimir String resultante.
 * 
 * Tu tarea:
 * Crea Optional vacio, obtiene texto con orElse("defecto") e imprimelo.
 * 
 * Salida esperada al ejecutar main:
 * defecto
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio2_OrElse_SIN_RESOLVER {
    public static void main(String[] args) {
        Optional<String> vacio = Optional.empty();
        // TODO: imprimir vacio.orElse("defecto")
    }
}
