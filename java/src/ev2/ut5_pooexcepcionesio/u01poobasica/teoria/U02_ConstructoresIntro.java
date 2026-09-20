package ev2.ut5_pooexcepcionesio.u01poobasica.teoria;

/**
 * Teoria: constructores en Java.
 *
 * <p><b>Objetivo:</b> inicializar objetos al crearlos con un metodo especial que lleva
 * el mismo nombre que la clase. {@code this} distingue atributos del objeto de los
 * parametros.</p>
 *
 * <p>Practica en {@code ejercicios/} (constructores).</p>
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
        /*
         * this permite saber a que objeto se asignan titulo/autor
         * (libro1 vs libro2) al ejecutar el constructor.
         */
        Libro libro1 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes");
        Libro libro2 = new Libro("La granja animal", "George Orwell");

        System.out.println(
                "¡Datos del primer libro!\n"
                        + "- Titulo: " + libro1.titulo + ".\n"
                        + "- Autor: " + libro1.autor + ".\n");
        System.out.println(
                "¡Datos del segundo libro!\n"
                        + "- Titulo: " + libro2.titulo + ".\n"
                        + "- Autor: " + libro2.autor + ".\n");
    }
}
