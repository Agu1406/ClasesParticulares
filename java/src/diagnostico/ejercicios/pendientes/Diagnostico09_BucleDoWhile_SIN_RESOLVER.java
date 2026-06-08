package diagnostico.ejercicios.pendientes;

import java.util.Scanner;

/**
 * Lectura repetida hasta valor positivo con do-while
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que no acepte numeros hasta que el usuario escriba uno positivo.</li>
 * <li>Completa el metodo leerHastaPositivo(Scanner teclado) usando do-while.</li>
 * <li>Repite la lectura mientras el valor sea menor o igual que cero.</li>
 * <li>En el main, crea Scanner teclado, llama al metodo e imprime el valor valido.</li>
 * </ul>
 *
 * <p>Diagnostico 09 — EV1 · ut2_controlflujometodos · RA3.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico09_BucleDoWhile_SIN_RESOLVER {

    public static int leerHastaPositivo(Scanner teclado) {
        int valor;
        // TODO: DO-WHILE leyendo de teclado hasta obtener un valor > 0
        return 0;
    }
    public static void main(String[] args) {
        Scanner teclado;
        int resultado;
        teclado = new Scanner(System.in);
        // TODO: llamar a leerHastaPositivo(teclado)
        resultado = leerHastaPositivo(teclado);
        System.out.println("Valor leido: " + resultado);
        teclado.close();
    }
}
