package diagnostico.ejercicios.pendientes;

import java.util.Scanner;

/**
 * Conteo de vocales en cadenas
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que cuente las vocales de un texto.</li>
 * <li>Completa el metodo contarVocales(String texto).</li>
 * <li>Cuenta a, e, i, o, u en mayusculas y minusculas. Usa un bucle con indice sobre el array de caracteres.</li>
 * <li>En el main, lee una linea de texto con Scanner teclado e imprime el total de vocales.</li>
 * </ul>
 *
 * <p>Diagnostico 14 — EV1 · ut3_stringsyenvolventes · RA2.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico14_StringBasico_SIN_RESOLVER {

    public static int contarVocales(String texto) {
        // TODO: a,e,i,o,u (mayusculas y minusculas)
        return 0;
    }
    public static void main(String[] args) {
        Scanner teclado;
        String texto;
        int vocales;
        teclado = new Scanner(System.in);
        System.out.print("Texto: ");
        texto = teclado.nextLine();
        // TODO: llamar a contarVocales
        vocales = contarVocales(texto);
        System.out.println("Vocales: " + vocales);
        teclado.close();
    }
}
