package ev2.ut5_pooexcepcionesio.u01poobasica.teoria;

/**
 * Teoria: miembros {@code static} en Java.
 *
 * <p><b>Objetivo:</b> compartir un atributo entre todas las instancias de la clase
 * (por ejemplo un contador de objetos creados) y generar IDs unicos.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 02/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U04_EstaticoIntro {

    static class Usuario {
        static int contador = 0;
        String id;

        Usuario() {
            contador++;
            this.id = "ID" + contador;
        }
    }

    public static void main(String[] args) {
        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario();
        Usuario u3 = new Usuario();
        System.out.println("Usuarios creados: " + Usuario.contador);
        System.out.println(u1.id + ", " + u2.id + ", " + u3.id);
    }
}
