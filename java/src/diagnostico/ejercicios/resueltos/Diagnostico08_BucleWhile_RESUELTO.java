package diagnostico.ejercicios.resueltos;

import java.util.Scanner;

/**
 * Conteo de digitos con bucle while
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que cuente cuantos digitos tiene un numero entero.</li>
 * <li>Completa el metodo contarDigitos(int numero) usando un bucle while.</li>
 * <li>Recuerda: el cero tiene 1 digito. Funciona tambien con numeros negativos.</li>
 * <li>En el main, lee el numero con Scanner teclado e imprime la cantidad de digitos.</li>
 * </ul>
 *
 * <p>Diagnostico 08 — EV1 · ut2_controlflujometodos · RA3.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico08_BucleWhile_RESUELTO {

    public static int contarDigitos(int numero) {
        int absoluto;
        int contador;
        absoluto = Math.abs(numero);
        if (absoluto == 0) {
            return 1;
        }
        contador = 0;
        while (absoluto > 0) {
            contador++;
            absoluto /= 10;
        }
        return contador;
    }
    public static void main(String[] args) {
        Scanner teclado;
        int numero;
        int resultado;
        teclado = new Scanner(System.in);
        System.out.print("Numero entero: ");
        numero = teclado.nextInt();
        resultado = contarDigitos(numero);
        System.out.println("Digitos: " + resultado);
        teclado.close();
    }
}
