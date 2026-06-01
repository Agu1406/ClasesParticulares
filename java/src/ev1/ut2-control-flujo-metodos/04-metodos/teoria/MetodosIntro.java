package general.metodos;

/**
 * Teoría: métodos (funciones) en Java.
 *
 * <p><b>Objetivo:</b> modularizar el código en bloques reutilizables con nombre,
 * parámetros y, opcionalmente, valor de retorno.</p>
 *
 * <ul>
 *   <li><b>void</b> — no devuelve valor; solo ejecuta acciones.</li>
 *   <li><b>return</b> — devuelve un resultado (int, double, String, boolean, etc.).</li>
 *   <li><b>static</b> — en este curso, los métodos de práctica suelen ser estáticos y se llaman desde {@code main}.</li>
 * </ul>
 *
 * <p>Sintaxis básica:</p>
 * <pre>{@code
 * public static void nombreMetodo() { }
 * public static int sumar(int a, int b) { return a + b; }
 * }</pre>
 *
 * <p>Practica en {@code ejercicios/pendientes} y {@code ejercicios/resueltos}.</p>
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class MetodosIntro {

    public static void saludar() {
        System.out.println("Hola desde un método void.");
    }

    public static int sumar(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        saludar();
        System.out.println("3 + 5 = " + sumar(3, 5));
    }
}
