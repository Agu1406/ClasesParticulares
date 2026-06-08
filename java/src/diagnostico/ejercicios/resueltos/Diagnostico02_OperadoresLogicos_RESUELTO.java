package diagnostico.ejercicios.resueltos;

import java.util.Scanner;

/**
 * Operadores logicos para validar conduccion
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que diga si una persona puede conducir.</li>
 * <li>Completa el metodo puedeConducir(int edad, boolean tieneCarnet).</li>
 * <li>Debe devolver true solo si la edad es mayor o igual que 18 y tiene carnet.</li>
 * <li>Usa el operador logico &&. En el main, lee edad y si tiene carnet (s/n) con Scanner teclado.</li>
 * </ul>
 *
 * <p>Diagnostico 02 — EV1 · ut2_controlflujometodos · RA3.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico02_OperadoresLogicos_RESUELTO {

    public static boolean puedeConducir(int edad, boolean tieneCarnet) {
        return edad >= 18 && tieneCarnet;
    }
    public static void main(String[] args) {
        Scanner teclado;
        int edad;
        String respuesta;
        boolean tieneCarnet;
        boolean resultado;
        teclado = new Scanner(System.in);
        System.out.print("Edad: ");
        edad = teclado.nextInt();
        System.out.print("Tiene carnet (s/n): ");
        respuesta = teclado.next();
        tieneCarnet = respuesta.equalsIgnoreCase("s");
        resultado = puedeConducir(edad, tieneCarnet);
        System.out.println("Puede conducir: " + resultado);
        teclado.close();
    }
}
