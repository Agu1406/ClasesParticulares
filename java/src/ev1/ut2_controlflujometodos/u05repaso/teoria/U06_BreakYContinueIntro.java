package ev1.ut2_controlflujometodos.u05repaso.teoria;

/**
 * Teoria: {@code break} y {@code continue} en repaso mixto.
 *
 * <p><b>Objetivo:</b> controlar el flujo dentro de bucles anidados o con condicionales.</p>
 *
 * <ul>
 *   <li><b>break</b> - sale del bucle mas interno inmediatamente (ej. primo encontrado un divisor).</li>
 *   <li><b>continue</b> - salta al siguiente ciclo sin ejecutar el resto del cuerpo.</li>
 * </ul>
 *
 * <p>Ejemplo clasico (primos): bucle externo recorre candidatos; bucle interno busca divisores.
 * Si encuentra uno, {@code break} evita comprobar mas divisores.</p>
 *
 * <pre>{@code
 * for (candidato = 2; candidato <= limite; candidato++) {
 *     boolean esPrimo = true;
 *     for (divisor = 2; divisor * divisor <= candidato; divisor++) {
 *         if (candidato % divisor == 0) {
 *             esPrimo = false;
 *             break;
 *         }
 *     }
 *     if (esPrimo) {
 *         System.out.println(candidato);
 *     }
 * }
 * }</pre>
 *
 * <p>Ver tambien {@code Ejercicio20_ForConIfPrimos} en {@code ejercicios/resueltos}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U06_BreakYContinueIntro {

    public static void main(String[] args) {
        int candidato;
        int divisor;
        int limite;
        boolean esPrimo;
        limite = 30;
        System.out.println("--- Primos hasta " + limite + " (break) ---");
        for (candidato = 2; candidato <= limite; candidato++) {
            esPrimo = true;
            for (divisor = 2; divisor * divisor <= candidato; divisor++) {
                if (candidato % divisor == 0) {
                    esPrimo = false;
                    break;
                }
            }
            if (esPrimo) {
                System.out.println(candidato);
            }
        }
        System.out.println("--- Multiplos de 3 sin el 15 (continue) ---");
        for (candidato = 1; candidato <= 20; candidato++) {
            if (candidato % 3 != 0) {
                continue;
            }
            if (candidato == 15) {
                continue;
            }
            System.out.println(candidato);
        }
    }
}
