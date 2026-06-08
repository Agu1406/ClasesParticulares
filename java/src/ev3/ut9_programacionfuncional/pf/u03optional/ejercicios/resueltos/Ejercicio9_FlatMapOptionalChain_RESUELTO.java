package ev3.ut9_programacionfuncional.pf.u03optional.ejercicios.resueltos;

// Clase Optional para encadenar map/filter/flatMap sin NullPointerException.
import java.util.Optional;

/**
 * Ejercicio 9 (Optional): flatMap optional chain - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Pipeline monadico Optional: usuario -> email -> dominio.
 * 
 * Que hace este codigo resuelto:
 * flatMap encadena busqueda y extraccion; imprime test.com para ana y ? para desconocido.
 * 
 * Conceptos que demuestra:
 *   - flatMap en Optional.
 *   - Evitar get() prematuro.
 *   - orElse al final del pipeline.
 * 
 * Salida al ejecutar main:
 * test.com
?
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio9_FlatMapOptionalChain_RESUELTO {
    // obtenerEmail devuelve Optional simulando consulta a base de datos de usuarios.
    static Optional<String> obtenerEmail(String u) {
        // Rama positiva: usuario "ana" tiene email y se envuelve con Optional.of.
        if ("ana".equals(u)) { return Optional.of("ana@test.com"); }
        // Usuario desconocido: retorno empty sin lanzar excepcion ni devolver null.
        return Optional.empty();
    }

    // dominioDe parsea la parte tras @; devuelve Optional por si el email es invalido.
    static Optional<String> dominioDe(String email) {
        // indexOf('@') localiza separador entre usuario y dominio en la direccion.
        int indiceArroba = email.indexOf('@');
        // Sin arroba no hay dominio; empty comunica fallo de forma segura.
        if (indiceArroba < 0) { return Optional.empty(); }
        // substring(indiceArroba+1) extrae test.com de ana@test.com.
        return Optional.of(email.substring(indiceArroba + 1));
    }


    public static void main(String[] args) {
        // flatMap encadena obtenerEmail y dominioDe sin get() intermedio ni null checks.
        System.out.println(obtenerEmail("ana").flatMap(Ejercicio9_FlatMapOptionalChain_RESUELTO::dominioDe).orElse("?"));
        // Segunda prueba con usuario inexistente; orElse("?") al final del pipeline.
        System.out.println(obtenerEmail("x").flatMap(Ejercicio9_FlatMapOptionalChain_RESUELTO::dominioDe).orElse("?"));
    }
}
