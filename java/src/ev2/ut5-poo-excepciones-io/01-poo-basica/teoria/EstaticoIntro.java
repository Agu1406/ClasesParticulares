package general.poobasico;

/**
 * Teoría: miembros {@code static} en Java.
 *
 * <p><b>Objetivo:</b> compartir un atributo entre todas las instancias de la clase
 * (por ejemplo un contador de objetos creados).</p>
 *
 * <ul>
 *   <li>{@code static} — pertenece a la clase, no a un objeto concreto.</li>
 *   <li>Se accede con {@code NombreClase.atributo} o desde un objeto (menos claro).</li>
 * </ul>
 *
 * <p>Practica en {@code ejercicios/07-estatico/pendientes} y {@code resueltos}.</p>
 *
 * @author Agustín. A. Marquez. Piña
 * @since 02/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class EstaticoIntro {

    static class Usuario {
        static int total = 0;

        Usuario() {
            total++;
        }
    }

    public static void main(String[] args) {
        new Usuario();
        new Usuario();
        new Usuario();
        System.out.println("Usuarios creados: " + Usuario.total);
    }
}
