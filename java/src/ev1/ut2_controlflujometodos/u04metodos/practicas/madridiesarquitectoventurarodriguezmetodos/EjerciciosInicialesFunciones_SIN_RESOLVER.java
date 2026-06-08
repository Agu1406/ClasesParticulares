package ev1.ut2_controlflujometodos.u04metodos.practicas.madridiesarquitectoventurarodriguezmetodos;

import java.util.Scanner;

/**
 * UT3 - Ejercicios iniciales con funciones (IES Arquitecto Ventura Rodriguez).
 *
 * <p>Enunciado: {@code madrid-iesarquitectoventurarodriguez-ejercicios-funciones.pdf} (carpeta de la practica).</p>
 *
 * <p><b>Objetivo:</b> practicar metodos estaticos con distintos parametros, retornos y lectura por teclado.</p>
 *
 * <p>Para ello, implementa y prueba desde {@code main} estas funciones:</p>
 * <ol>
 *   <li>{@code esPar(int)} - devuelve si un entero es par.</li>
 *   <li>{@code esImpar(int)} - devuelve si un entero es impar.</li>
 *   <li>{@code mayor(int, int)} y {@code menor(int, int)}.</li>
 *   <li>{@code aleatorioEntre(int, int)} con {@code Math.random()}; genera 100 valores entre 1 y 6.</li>
 *   <li>{@code mostrarTiempoDesdeSegundos(int)} - dias, horas, minutos y segundos restantes.</li>
 *   <li>{@code mostrarTablaMultiplicar(int)}; tablas del 1 al 10.</li>
 *   <li>{@code dividir(float, float)} - pide divisor distinto de cero si hace falta; devuelve float.</li>
 *   <li>Calculadora avanzada con menu (+, -, *, /, factorial, potencia sin {@code Math.pow}).</li>
 *   <li>{@code esBisiesto(int año)}.</li>
 *   <li>{@code diasDelMes(int mes, int año)}.</li>
 *   <li>{@code esFechaCorrecta(int dia, int mes, int año)} usando {@code diasDelMes}.</li>
 *   <li>{@code diasEntreFechas(...)} - comprueba fechas y devuelve dias entre ambas (avanzado).</li>
 * </ol>
 *
 * <p>Utiliza {@code Scanner teclado}, variables declaradas al inicio de cada metodo y nombres descriptivos.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class EjerciciosInicialesFunciones_SIN_RESOLVER {

    public static boolean esPar(int numero) {
        // TODO
        return false;
    }

    public static boolean esImpar(int numero) {
        // TODO
        return false;
    }

    public static int mayor(int primero, int segundo) {
        // TODO
        return 0;
    }

    public static int menor(int primero, int segundo) {
        // TODO
        return 0;
    }

    public static int aleatorioEntre(int numeroInicial, int numeroFinal) {
        // TODO: (int)(Math.random() * (numeroFinal - numeroInicial + 1)) + numeroInicial
        return 0;
    }

    public static void mostrarTiempoDesdeSegundos(int segundosTotales) {
        // TODO: dias, horas, minutos y segundos maximos
    }

    public static void mostrarTablaMultiplicar(int numero) {
        // TODO: tabla del 1 al 10
    }

    public static float dividir(float dividendo, Scanner teclado) {
        // TODO: pedir divisor hasta que sea distinto de cero
        return 0;
    }

    public static void calculadoraAvanzada(Scanner teclado) {
        // TODO: menu +, -, *, /, factorial, potencia (sin Math.pow)
    }

    public static boolean esBisiesto(int año) {
        // TODO
        return false;
    }

    public static int diasDelMes(int mes, int año) {
        // TODO: usar esBisiesto para febrero
        return 0;
    }

    public static boolean esFechaCorrecta(int dia, int mes, int año) {
        // TODO
        return false;
    }

    public static int diasEntreFechas(int diaUno, int mesUno, int añoUno,
                                      int diaDos, int mesDos, int añoDos) {
        // TODO: validar fechas y calcular diferencia en dias
        return 0;
    }

    public static void main(String[] args) {
        Scanner teclado;
        teclado = new Scanner(System.in);
        // TODO: probar cada funcion del enunciado con casos de ejemplo
        teclado.close();
    }
}
