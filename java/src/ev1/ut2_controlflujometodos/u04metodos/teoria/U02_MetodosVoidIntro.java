package ev1.ut2_controlflujometodos.u04metodos.teoria;

/**
 * Teoria: metodos {@code void} en Java.
 *
 * <p><b>Objetivo:</b> crear metodos que ejecutan una accion pero no devuelven ningun valor.</p>
 *
 * <p>Un metodo <b>void</b> se usa cuando solo quieres <em>hacer algo</em>: imprimir un mensaje,
 * dibujar un menu en pantalla, mostrar un resultado que ya calculaste antes, etc.</p>
 *
 * <pre>{@code
 * public static void mostrarMensaje() {
 *     System.out.println("Hola desde un metodo void");
 * }
 *
 * public static void saludar(String nombre) {
 *     System.out.println("Hola, " + nombre);
 * }
 * }</pre>
 *
 * <ul>
 *   <li><b>Sin parametros</b> - {@code mostrarMensaje()} no necesita datos externos.</li>
 *   <li><b>Con parametros</b> - {@code saludar(String nombre)} recibe el nombre para personalizar el saludo.</li>
 *   <li><b>Sin return</b> - el metodo termina al llegar a la ultima linea o con {@code return;} vacio (salida anticipada).</li>
 * </ul>
 *
 * <p>Equivale al Ejercicio 1 (void sin parametros) y Ejercicio 2 (void con parametros)
 * en {@code ejercicios/}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U02_MetodosVoidIntro {

    public static void mostrarMensaje() {
        System.out.println("Hola desde un metodo void");
    }

    public static void saludar(String nombre) {
        System.out.println("Hola, " + nombre);
    }

    public static void mostrarSeparador() {
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        mostrarSeparador();
        mostrarMensaje();
        saludar("Ana");
        saludar("Luis");
        mostrarSeparador();
    }
}
