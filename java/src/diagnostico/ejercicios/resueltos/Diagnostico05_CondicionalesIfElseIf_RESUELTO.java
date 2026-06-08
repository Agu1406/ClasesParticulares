package diagnostico.ejercicios.resueltos;

import java.util.Scanner;

/**
 * Calificaciones academicas con if-else if
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que convierta una nota numerica (0-10) en calificacion textual.</li>
 * <li>Completa el metodo calificacion(int nota) con if / else if.</li>
 * <li>Rangos: 0-4 Suspenso, 5-6 Aprobado, 7-8 Notable, 9-10 Sobresaliente.</li>
 * <li>En el main, lee la nota con Scanner teclado e imprime el resultado.</li>
 * </ul>
 *
 * <p>Diagnostico 05 — EV1 · ut2_controlflujometodos · RA3.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico05_CondicionalesIfElseIf_RESUELTO {

    public static String calificacion(int nota) {
        if (nota <= 4) {
            return "Suspenso";
        }
        if (nota <= 6) {
            return "Aprobado";
        }
        if (nota <= 8) {
            return "Notable";
        }
        return "Sobresaliente";
    }
    public static void main(String[] args) {
        Scanner teclado;
        int nota;
        String resultado;
        teclado = new Scanner(System.in);
        System.out.print("Nota (0-10): ");
        nota = teclado.nextInt();
        resultado = calificacion(nota);
        System.out.println("Calificacion: " + resultado);
        teclado.close();
    }
}
