package diagnostico.ejercicios.pendientes;

import java.util.Scanner;

/**
 * Dias de la semana con switch
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que muestre el nombre del dia de la semana segun un numero.</li>
 * <li>Completa el metodo nombreDia(int numero) usando switch.</li>
 * <li>1=Lunes, 2=Martes, ... 7=Domingo. Cualquier otro valor devuelve "Desconocido".</li>
 * <li>En el main, lee el numero con Scanner teclado e imprime el dia.</li>
 * </ul>
 *
 * <p>Diagnostico 06 — EV1 · ut2_controlflujometodos · RA3.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico06_CondicionalesSwitch_SIN_RESOLVER {

    public static String nombreDia(int numero) {
        // TODO: 1=Lunes ... 7=Domingo, otro valor -> Desconocido
        return null;
    }
    public static void main(String[] args) {
        Scanner teclado;
        int numero;
        String resultado;
        teclado = new Scanner(System.in);
        System.out.print("Numero de dia (1-7): ");
        numero = teclado.nextInt();
        // TODO: llamar a nombreDia
        resultado = nombreDia(numero);
        System.out.println("Dia: " + resultado);
        teclado.close();
    }
}
