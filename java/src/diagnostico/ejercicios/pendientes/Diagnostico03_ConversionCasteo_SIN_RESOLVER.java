package diagnostico.ejercicios.pendientes;

import java.util.Scanner;

/**
 * Casteo explicito para truncar valores double
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que trunca un numero decimal a entero.</li>
 * <li>Completa el metodo truncarADouble(double valor) usando casteo explicito a int.</li>
 * <li>En el main, lee un double con Scanner teclado, llama al metodo e imprime el entero resultante.</li>
 * </ul>
 *
 * <p>Diagnostico 03 — EV1 · ut1_fundamentosjava · RA1.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico03_ConversionCasteo_SIN_RESOLVER {

    public static int truncarADouble(double valor) {
        // TODO: casteo explicito a int (truncar)
        return 0;
    }
    public static void main(String[] args) {
        Scanner teclado;
        double valor;
        int resultado;
        teclado = new Scanner(System.in);
        System.out.print("Valor decimal: ");
        valor = teclado.nextDouble();
        // TODO: llamar a truncarADouble
        resultado = truncarADouble(valor);
        System.out.println("Truncado: " + resultado);
        teclado.close();
    }
}
