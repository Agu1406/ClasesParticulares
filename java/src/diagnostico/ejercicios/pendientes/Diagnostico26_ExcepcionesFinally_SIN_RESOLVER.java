package diagnostico.ejercicios.pendientes;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Registro de intentos con finally
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que registre un intento de division aunque falle.</li>
 * <li>Completa dividirConRegistro(int a, int b): devuelve un array de 2 enteros [resultado, intentos].</li>
 * <li>Usa try-catch-finally: en finally pon intentos = 1.</li>
 * <li>En el main, lee a y b con Scanner teclado e imprime el array resultante.</li>
 * </ul>
 *
 * <p>Diagnostico 26 — EV2 · ut5_pooexcepcionesio · RA5.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico26_ExcepcionesFinally_SIN_RESOLVER {

    public static int[] dividirConRegistro(int a, int b) {
        // TODO: [resultado, intentos]; finally incrementa intentos aunque falle
        return null;
    }
    public static void main(String[] args) {
        Scanner teclado;
        int a;
        int b;
        int[] salida;
        teclado = new Scanner(System.in);
        System.out.print("Dividendo: ");
        a = teclado.nextInt();
        System.out.print("Divisor: ");
        b = teclado.nextInt();
        // TODO: llamar a dividirConRegistro
        salida = dividirConRegistro(a, b);
        System.out.println(Arrays.toString(salida));
        teclado.close();
    }
}
