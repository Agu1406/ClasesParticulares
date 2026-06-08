package ev1.ut2_controlflujometodos.u03bucles.teoria;

/**
 * Teoria: bucle {@code for} en Java.
 *
 * <p><b>Objetivo:</b> entender la sintaxis y el uso del {@code for} cuando conoces
 * de antemano cuantas veces debe repetirse un bloque.</p>
 *
 * <p>El {@code for} agrupa en una sola linea:</p>
 * <ul>
 *   <li><b>Inicializacion</b> - suele declarar el contador (ej. {@code int i = 0}).</li>
 *   <li><b>Condicion</b> - se evalua antes de cada vuelta; si es falsa, el bucle termina.</li>
 *   <li><b>Actualizacion</b> - se ejecuta al final de cada vuelta (ej. {@code i++}).</li>
 * </ul>
 *
 * <p>Sintaxis:</p>
 * <pre>{@code
 * for (inicializacion; condicion; actualizacion) {
 *     // cuerpo del bucle
 * }
 * }</pre>
 *
 * <p>Ejemplos tipicos: recorrer un rango de numeros, tablas de multiplicar, sumar acumuladores.
 * Practica en {@code ejercicios/01-for/} (pendientes y resueltos).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 02/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U02_BucleForIntro {

    public static void main(String[] args) {
        System.out.println("--- for: del 1 al 5 ---");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        System.out.println("--- for: pares del 2 al 10 ---");
        for (int i = 2; i <= 10; i += 2) {
            System.out.println(i);
        }

        System.out.println("--- for: cuenta atras 5 a 1 ---");
        for (int i = 5; i >= 1; i--) {
            System.out.println(i);
        }
    }
}
