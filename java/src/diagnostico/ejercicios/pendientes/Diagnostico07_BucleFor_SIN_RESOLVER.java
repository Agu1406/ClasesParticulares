package diagnostico.ejercicios.pendientes;

import java.util.Scanner;

/**
 * Suma acumulativa con bucle for
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que sume los enteros del 1 hasta un limite dado.</li>
 * <li>Completa el metodo sumarHasta(int limite) usando un bucle for.</li>
 * <li>El bucle debe usar una variable indice declarada al inicio del metodo.</li>
 * <li>En el main, lee el limite con Scanner teclado e imprime la suma.</li>
 * </ul>
 *
 * <p>Diagnostico 07 — EV1 · ut2_controlflujometodos · RA3.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico07_BucleFor_SIN_RESOLVER {

    public static int sumarHasta(int limite) {
        // TODO: usar FOR para sumar 1 + 2 + ... + limite
        return 0;
    }
    public static void main(String[] args) {
        Scanner teclado;
        int limite;
        int resultado;
        teclado = new Scanner(System.in);
        System.out.print("Limite superior: ");
        limite = teclado.nextInt();
        // TODO: llamar a sumarHasta
        resultado = sumarHasta(limite);
        System.out.println("Suma: " + resultado);
        teclado.close();
    }
}
