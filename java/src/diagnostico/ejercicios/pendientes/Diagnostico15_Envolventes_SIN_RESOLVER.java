package diagnostico.ejercicios.pendientes;

import java.util.Scanner;

/**
 * Parseo seguro con envolventes Integer
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que convierta texto a entero de forma segura.</li>
 * <li>Completa el metodo parsearEntero(String texto) usando Integer.parseInt dentro de try-catch.</li>
 * <li>Si el texto no es un numero valido, devuelve null.</li>
 * <li>En el main, lee un texto con Scanner teclado e imprime el entero o null.</li>
 * </ul>
 *
 * <p>Diagnostico 15 — EV1 · ut3_stringsyenvolventes · RA2.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico15_Envolventes_SIN_RESOLVER {

    public static Integer parsearEntero(String texto) {
        // TODO: Integer.parseInt; devuelve null si falla
        return null;
    }
    public static void main(String[] args) {
        Scanner teclado;
        String texto;
        Integer valor;
        teclado = new Scanner(System.in);
        System.out.print("Texto numerico: ");
        texto = teclado.nextLine();
        // TODO: llamar a parsearEntero
        valor = parsearEntero(texto);
        System.out.println("Resultado: " + valor);
        teclado.close();
    }
}
