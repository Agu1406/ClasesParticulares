package ev2.ut5.u01poobasica.teoria;

/**
 * Teoria: constructores en Java.
 *
 * <p><b>Objetivo:</b> inicializar objetos al crearlos con un metodo especial que lleva
 * el mismo nombre que la clase.</p>
 *
 * <pre>{@code
 * class Libro {
 *     String titulo;
 *     Libro(String titulo) {
 *         this.titulo = titulo;
 *     }
 * }
 * Libro l = new Libro("Java");
 * }</pre>
 *
 * <p>Practica en {@code ejercicios/03-constructores/pendientes} y {@code resueltos}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 02/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U02_ConstructoresIntro {

    static class Libro {
        String titulo;
        String autor;

        Libro(String titulo, String autor) {
            this.titulo = titulo;
            this.autor = autor;
        }
    }

    public static void main(String[] args) {
        Libro libro = new Libro("Clean Code", "Robert C. Martin");
        System.out.println(libro.titulo + " - " + libro.autor);
    }
}
