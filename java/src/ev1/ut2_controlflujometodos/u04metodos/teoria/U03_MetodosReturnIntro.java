package ev1.ut2_controlflujometodos.u04metodos.teoria;

/**
 * Teoria: metodos con valor de retorno ({@code return}) en Java.
 *
 * <p><b>Objetivo:</b> escribir metodos que calculan un resultado y lo devuelven al codigo que los llama.</p>
 *
 * <p>El tipo que va delante del nombre del metodo indica <b>que devuelve</b>:</p>
 * <ul>
 *   <li>{@code int} - numeros enteros ({@code sumar}, {@code contarDigitos}).</li>
 *   <li>{@code double} - numeros decimales ({@code calcularAreaCirculo}).</li>
 *   <li>{@code String} - cadenas de texto ({@code obtenerMensaje}).</li>
 *   <li>{@code boolean} - true o false ({@code esPar}, {@code esMayorDeEdad}).</li>
 * </ul>
 *
 * <pre>{@code
 * public static int sumar(int a, int b) {
 *     return a + b;
 * }
 *
 * public static boolean esPar(int numero) {
 *     return numero % 2 == 0;
 * }
 * }</pre>
 *
 * <p><b>Reglas importantes:</b></p>
 * <ul>
 *   <li>Todo camino del metodo debe acabar en un {@code return} del tipo declarado (salvo {@code void}).</li>
 *   <li>El valor devuelto se puede guardar: {@code int resultado = sumar(7, 5);}</li>
 *   <li>Tambien puedes usarlo directamente: {@code System.out.println(esPar(14));}</li>
 * </ul>
 *
 * <p>Equivale a los Ejercicios 3-6 en {@code ejercicios/}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U03_MetodosReturnIntro {

    public static int sumar(int a, int b) {
        return a + b;
    }

    public static double calcularAreaCirculo(double radio) {
        return Math.PI * radio * radio;
    }

    public static String obtenerMensaje(String asignatura) {
        return "Estudiando " + asignatura;
    }

    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    public static void main(String[] args) {
        int suma;
        double area;
        String mensaje;
        boolean par;
        suma = sumar(7, 5);
        area = calcularAreaCirculo(3);
        mensaje = obtenerMensaje("Programacion");
        par = esPar(14);
        System.out.println("Suma: " + suma);
        System.out.println("Area: " + area);
        System.out.println(mensaje);
        System.out.println("Es par: " + par);
    }
}
