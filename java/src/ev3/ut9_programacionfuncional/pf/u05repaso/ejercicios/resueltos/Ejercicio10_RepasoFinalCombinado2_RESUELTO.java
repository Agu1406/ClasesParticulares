package ev3.ut9_programacionfuncional.pf.u05repaso.ejercicios.resueltos;

// Tipo List y factory List.of para crear secuencias fijas de elementos.
import java.util.List;
// Clase Optional para encadenar map/filter/flatMap sin NullPointerException.
import java.util.Optional;

/**
 * Repaso 10: combinado 2 - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Stream para busqueda + Optional para longitud condicional.
 * 
 * Que hace este codigo resuelto:
 * Usuario no encontrado imprime ? y longitud 0.
 * 
 * Conceptos que demuestra:
 *   - findFirst + orElse repaso.
 *   - Optional.ofNullable + map.
 *   - Integracion UT9 completa.
 * 
 * Salida al ejecutar main:
 * ?
0
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio10_RepasoFinalCombinado2_RESUELTO {
    public static void main(String[] args) {
        // Lista de usuarios ana y bob; buscaremos "car" que no existe.
        List<String> users = List.of("ana", "bob");
        // stream filter findFirst orElse devuelve ? cuando no hay coincidencia exacta.
        String usuarioEncontrado = users.stream().filter(usuario -> usuario.equals("car")).findFirst().orElse("?");
        // Muestra ?: usuario buscado no esta en la lista de usuarios.
        System.out.println(usuarioEncontrado);
        // Optional map length sobre null devuelve 0 via orElse cuando no hay valor util.
        System.out.println(Optional.ofNullable(usuarioEncontrado.equals("?") ? null : usuarioEncontrado).map(String::length).orElse(0));
    }
}
