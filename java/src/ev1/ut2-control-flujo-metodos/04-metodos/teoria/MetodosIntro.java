package general.metodos;

/**
 * Teoria: metodos (funciones) en Java.
 *
 * <p><b>Objetivo:</b> modularizar el codigo en bloques reutilizables con nombre,
 * parametros y, opcionalmente, valor de retorno.</p>
 *
 * <ul>
 *   <li><b>void</b> - no devuelve valor; solo ejecuta acciones.</li>
 *   <li><b>return</b> - devuelve un resultado (int, double, String, boolean, etc.).</li>
 *   <li><b>static</b> - en este curso, los metodos de practica suelen ser estaticos y se llaman desde {@code main}.</li>
 * </ul>
 *
 * <p>Sintaxis basica:</p>
 * <pre>{@code
 * public static void nombreMetodo() { }
 * public static int sumar(int a, int b) { return a + b; }
 * }</pre>
 *
 * <p>Practica en {@code ejercicios/pendientes} y {@code ejercicios/resueltos}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class MetodosIntro {

    public static void saludar() {
        System.out.println("Hola desde un metodo void.");
    }

    public static int sumar(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        saludar();
        System.out.println("3 + 5 = " + sumar(3, 5));
    }
}
