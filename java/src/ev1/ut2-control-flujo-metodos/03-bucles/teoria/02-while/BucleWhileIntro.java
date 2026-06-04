package general.bucles;

/**
 * Teoria: bucle {@code while} en Java.
 *
 * <p><b>Objetivo:</b> repetir un bloque mientras se cumpla una condicion, sin fijar
 * el numero de iteraciones en la cabecera del bucle.</p>
 *
 * <p>Sintaxis:</p>
 * <pre>{@code
 * while (condicion) {
 *     // cuerpo
 * }
 * }</pre>
 *
 * <p>Para ello debes:</p>
 * <ul>
 *   <li>Evaluar la condicion <em>antes</em> de cada vuelta.</li>
 *   <li>Modificar dentro del cuerpo las variables que intervienen en la condicion
 *       (si no, el bucle puede ser infinito).</li>
 *   <li>Inicializar el contador o acumulador <em>antes</em> del {@code while}.</li>
 * </ul>
 *
 * <p>Util cuando no sabes cuantas repeticiones haran falta (lectura hasta sentinel,
 * validacion de menu, etc.). Practica en {@code ejercicios/02-while/} (pendientes y resueltos).</p>
 *
 * @author Agustin. A. Marquez. Pina
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
