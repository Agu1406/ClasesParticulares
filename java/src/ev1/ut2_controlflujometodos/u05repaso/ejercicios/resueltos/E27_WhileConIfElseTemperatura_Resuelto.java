package ev1.ut2_controlflujometodos.u05repaso.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Clasifica temperaturas en frio/calor con if-else.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El main clasifica temperaturas en frio/calor con if-else.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E27_WhileConIfElseTemperatura_Resuelto {
    public static void main(String[] args) {
        int[] temps = {2, 15, 28, 5, 31};
        int posicion = 0;
        while (posicion < temps.length) {
            if (temps[posicion] < 15) {
                System.out.println(temps[posicion] + " grados frio");
            } else {
                System.out.println(temps[posicion] + " grados calor");
            }
            posicion++;
        }
    }
}
