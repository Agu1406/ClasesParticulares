package general.repaso;

/**
 * Ejercicio: while con if-else
 * Objetivo: Clasifica temperaturas en frío/calor con if-else.
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio27_WhileConIfElseTemperatura_RESUELTO {
    public static void main(String[] args) {
        int[] temps = {2, 15, 28, 5, 31};
        int i = 0;
        while (i < temps.length) {
            if (temps[i] < 15) {
                System.out.println(temps[i] + "° frío");
            } else {
                System.out.println(temps[i] + "° calor");
            }
            i++;
        }
    }
}
