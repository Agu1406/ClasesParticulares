package ev3.ut9.pf.u03optional.ejercicios.resueltos;

// Optional evita null explicito al modelar resultados de busqueda que pueden no existir.
import java.util.Optional;

/**
 * Ejercicio 1 (Optional): buscar email - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Optional como tipo de retorno de busqueda simulada.
 * 
 * Que hace este codigo resuelto:
 * buscarEmail devuelve Optional.of para ana y empty para otros; main usa orElse e imprime email o mensaje sustituto.
 * 
 * Conceptos que demuestra:
 *   - Optional.of / Optional.empty.
 *   - orElse valor por defecto.
 *   - Evitar retornar null desde API.
 * 
 * Salida al ejecutar main:
 * ana@test.com
sin email
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio1_BuscarEmail_RESUELTO {
    // Metodo auxiliar que simula una API: devuelve Optional en lugar de null.
    static Optional<String> buscarEmail(String usuario) {
        // equals seguro con literal primero evita NPE si usuario fuera null.
        if ("ana".equals(usuario)) {
            // Optional.of envuelve el email cuando el usuario "ana" existe en el sistema simulado.
            return Optional.of("ana@test.com");
        }
        // Optional.empty() indica ausencia de dato sin usar null como valor de retorno.
        return Optional.empty();
    }


    public static void main(String[] args) {
        // orElse solo se usa si empty; aqui imprime ana@test.com directamente.
        System.out.println(buscarEmail("ana").orElse("sin email"));
        // Usuario desconocido produce empty; orElse imprime el texto sustituto sin email.
        System.out.println(buscarEmail("zzz").orElse("sin email"));
    }
}
