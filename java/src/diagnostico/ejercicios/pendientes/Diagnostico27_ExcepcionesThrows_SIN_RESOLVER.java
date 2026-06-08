package diagnostico.ejercicios.pendientes;

import java.util.Scanner;

/**
 * Validacion con excepciones throws
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que calcule la raiz cuadrada entera de un numero.</li>
 * <li>Completa raizCuadrada(int numero): lanza IllegalArgumentException si numero es negativo.</li>
 * <li>En el main, lee el numero con Scanner teclado. Captura la excepcion si ocurre e imprime el mensaje.</li>
 * </ul>
 *
 * <p>Diagnostico 27 — EV2 · ut5_pooexcepcionesio · RA5.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico27_ExcepcionesThrows_SIN_RESOLVER {

    public static int raizCuadrada(int numero) {
        // TODO: lanzar IllegalArgumentException si numero < 0
        return 0;
    }
    public static void main(String[] args) {
        Scanner teclado;
        int numero;
        teclado = new Scanner(System.in);
        System.out.print("Numero: ");
        numero = teclado.nextInt();
        // TODO: llamar a raizCuadrada con try-catch
        try {
            System.out.println("Raiz: " + raizCuadrada(numero));
        } catch (IllegalArgumentException excepcion) {
            System.out.println(excepcion.getMessage());
        }
        teclado.close();
    }
}
