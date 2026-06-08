package diagnostico.ejercicios.resueltos;

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
public class Diagnostico27_ExcepcionesThrows_RESUELTO {

    public static int raizCuadrada(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("No hay raiz real de negativos");
        }
        return (int) Math.sqrt(numero);
    }
    public static void main(String[] args) {
        Scanner teclado;
        int numero;
        teclado = new Scanner(System.in);
        System.out.print("Numero: ");
        numero = teclado.nextInt();
        try {
            System.out.println("Raiz: " + raizCuadrada(numero));
        } catch (IllegalArgumentException excepcion) {
            System.out.println(excepcion.getMessage());
        }
        teclado.close();
    }
}
