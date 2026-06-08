package diagnostico.ejercicios.resueltos;

import java.util.Scanner;

/**
 * Tabla de multiplicar con metodo void
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que imprima la tabla de multiplicar de un numero.</li>
 * <li>Completa el metodo void imprimirTabla(int numero).</li>
 * <li>Debe mostrar del 1 al 10 usando un bucle for con variable indice.</li>
 * <li>En el main, lee el numero con Scanner teclado y llama al metodo.</li>
 * </ul>
 *
 * <p>Diagnostico 11 — EV1 · ut2_controlflujometodos · RA3.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico11_MetodosVoid_RESUELTO {

    public static void imprimirTabla(int numero) {
        int multiplicador;
        for (multiplicador = 1; multiplicador <= 10; multiplicador++) {
            System.out.println(numero + " x " + multiplicador + " = " + (numero * multiplicador));
        }
    }
    public static void main(String[] args) {
        Scanner teclado;
        int numero;
        teclado = new Scanner(System.in);
        System.out.print("Numero para la tabla: ");
        numero = teclado.nextInt();
        imprimirTabla(numero);
        teclado.close();
    }
}
