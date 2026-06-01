package general.bucles;

/**
 * Teoría: bucle {@code while} en Java.
 *
 * <p><b>Objetivo:</b> repetir un bloque mientras se cumpla una condición, sin fijar
 * el número de iteraciones en la cabecera del bucle.</p>
 *
 * <p>Sintaxis:</p>
 * <pre>{@code
 * while (condición) {
 *     // cuerpo
 * }
 * }</pre>
 *
 * <p>Para ello debes:</p>
 * <ul>
 *   <li>Evaluar la condición <em>antes</em> de cada vuelta.</li>
 *   <li>Modificar dentro del cuerpo las variables que intervienen en la condición
 *       (si no, el bucle puede ser infinito).</li>
 *   <li>Inicializar el contador o acumulador <em>antes</em> del {@code while}.</li>
 * </ul>
 *
 * <p>Útil cuando no sabes cuántas repeticiones harán falta (lectura hasta sentinel,
 * validación de menú, etc.). Practica en {@code ejercicios/while/}.</p>
 *
 * @author Agustín. A. Marquez. Piña
 * @since 02/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class BucleWhileIntro {

    public static void main(String[] args) {
        System.out.println("--- while: del 1 al 5 ---");
        int i = 1;
        while (i <= 5) {
            System.out.println(i);
            i++;
        }

        System.out.println("--- while: suma acumulada 1+2+3+4+5 ---");
        int suma = 0;
        int n = 1;
        while (n <= 5) {
            suma += n;
            n++;
        }
        System.out.println("Suma = " + suma);
    }
}
