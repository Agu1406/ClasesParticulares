package diagnostico.ejercicios.resueltos;

import java.util.Scanner;

/**
 * Clasificacion de numeros con if-else
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que clasifique un numero entero como positivo, negativo o cero.</li>
 * <li>Completa el metodo clasificar(int numero) con if / else.</li>
 * <li>Debe devolver exactamente: "positivo", "negativo" o "cero".</li>
 * <li>En el main, lee el numero con Scanner teclado e imprime la clasificacion.</li>
 * </ul>
 *
 * <p>Diagnostico 04 — EV1 · ut2_controlflujometodos · RA3.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico04_CondicionalesIfElse_RESUELTO {

    public static String clasificar(int numero) {
        if (numero > 0) {
            return "positivo";
        }
        if (numero < 0) {
            return "negativo";
        }
        return "cero";
    }
    public static void main(String[] args) {
        Scanner teclado;
        int numero;
        String resultado;
        teclado = new Scanner(System.in);
        System.out.print("Numero entero: ");
        numero = teclado.nextInt();
        resultado = clasificar(numero);
        System.out.println("Clasificacion: " + resultado);
        teclado.close();
    }
}
