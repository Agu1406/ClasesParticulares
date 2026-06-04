package ev1.ut2.u02condicionales.teoria;

/**
 * Teoria: {@code if-else} en Java.
 *
 * <p><b>Objetivo:</b> elegir entre dos caminos segun una condicion.</p>
 *
 * <pre>{@code
 * if (condicion) {
 *     // rama A
 * } else {
 *     // rama B
 * }
 * }</pre>
 *
 * <p>Practica en {@code ejercicios/02-ifelse/} (pendientes y resueltos).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U02_IfElseIntro {

    public static void main(String[] args) {
        int edad = 17;
        if (edad >= 18) {
            System.out.println("Mayor de edad");
        } else {
            System.out.println("Menor de edad");
        }
    }
}
