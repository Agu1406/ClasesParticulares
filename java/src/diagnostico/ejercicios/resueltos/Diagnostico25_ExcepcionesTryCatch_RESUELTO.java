package diagnostico.ejercicios.resueltos;

import java.util.Scanner;

/**
 * Division segura con try-catch
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que divida dos enteros de forma segura.</li>
 * <li>Completa dividir(int dividendo, int divisor) con try-catch.</li>
 * <li>Si hay division por cero (ArithmeticException), devuelve -1.</li>
 * <li>En el main, lee dividendo y divisor con Scanner teclado e imprime el resultado.</li>
 * </ul>
 *
 * <p>Diagnostico 25 — EV2 · ut5_pooexcepcionesio · RA5.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico25_ExcepcionesTryCatch_RESUELTO {

    public static int dividir(int dividendo, int divisor) {
        try {
            return dividendo / divisor;
        } catch (ArithmeticException excepcion) {
            return -1;
        }
    }
    public static void main(String[] args) {
        Scanner teclado;
        int dividendo;
        int divisor;
        int resultado;
        teclado = new Scanner(System.in);
        System.out.print("Dividendo: ");
        dividendo = teclado.nextInt();
        System.out.print("Divisor: ");
        divisor = teclado.nextInt();
        resultado = dividir(dividendo, divisor);
        System.out.println("Resultado: " + resultado);
        teclado.close();
    }
}
