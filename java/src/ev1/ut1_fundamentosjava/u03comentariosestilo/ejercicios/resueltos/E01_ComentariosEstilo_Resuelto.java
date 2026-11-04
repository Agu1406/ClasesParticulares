package ev1.ut1_fundamentosjava.u03comentariosestilo.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Escribe los tres comentarios de Java: uno de linea con {@code //},
 * uno de bloque con {@code /*} y un JavaDoc sobre {@code main}. El programa imprime Listo.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El JavaDoc va encima de {@code main}. Dentro hay un comentario
 * de bloque y otro de una linea. {@code println} muestra Listo.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E01_ComentariosEstilo_Resuelto {

    /**
     * Punto de entrada. Este bloque es un comentario JavaDoc.
     */
    public static void main(String[] args) {
        /*
         * Comentario de bloque: ocupa varias lineas y no se ejecuta.
         */
        // Comentario de una sola linea.
        System.out.println("Listo");
    }
}
