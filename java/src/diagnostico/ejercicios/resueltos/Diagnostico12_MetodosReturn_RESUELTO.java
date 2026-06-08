package diagnostico.ejercicios.resueltos;

import java.util.Scanner;

/**
 * Metodos con valor de retorno
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa con dos metodos que devuelven un resultado.</li>
 * <li>Completa esPar(int numero): devuelve true si el numero es par.</li>
 * <li>Completa absoluto(int numero): devuelve el valor sin signo.</li>
 * <li>En el main, lee un entero con Scanner teclado y muestra ambos resultados.</li>
 * </ul>
 *
 * <p>Diagnostico 12 — EV1 · ut2_controlflujometodos · RA3.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico12_MetodosReturn_RESUELTO {

    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    public static int absoluto(int numero) {
        return numero < 0 ? -numero : numero;
    }
    public static void main(String[] args) {
        Scanner teclado;
        int numero;
        boolean par;
        int valorAbsoluto;
        teclado = new Scanner(System.in);
        System.out.print("Numero entero: ");
        numero = teclado.nextInt();
        par = esPar(numero);
        valorAbsoluto = absoluto(numero);
        System.out.println("Es par: " + par);
        System.out.println("Absoluto: " + valorAbsoluto);
        teclado.close();
    }
}
