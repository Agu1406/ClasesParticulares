package ev3.ut9.pf.u03optional.ejercicios.pendientes;

import java.util.Optional;

/**
 * Ejercicio 1 (Optional): buscar email de usuario.
 * 
 * Proposito:
 * Modelar ausencia de valor sin null explicito usando Optional, evitando NullPointerException en codigo cliente.
 * 
 * Objetivos de aprendizaje:
 *   - Metodo que devuelve Optional<String>.
 *   - Optional.of cuando hay dato, empty cuando no.
 *   - orElse en main para valor por defecto al mostrar.
 * 
 * Tu tarea:
 * Implementa buscarEmail(usuario): devuelve email si usuario es "ana", si no empty. En main imprime orElse("sin email") para "ana" y para un usuario inexistente.
 * 
 * Salida esperada al ejecutar main:
 * ana@test.com
sin email
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio1_BuscarEmail_SIN_RESOLVER {
    // TODO: devolver Optional.of(email) si existe, Optional.empty() si no
    static Optional<String> buscarEmail(String usuario) {
        return Optional.empty();
    }

    public static void main(String[] args) {
        // TODO: implementar buscarEmail y mostrar orElse para usuario existente e inexistente
    }
}
