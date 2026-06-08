package ev1.ut2_controlflujometodos.u04metodos.teoria;

/**
 * Teoria: introduccion a los metodos en Java.
 *
 * <p><b>Objetivo:</b> entender que es un metodo, por que sirve y como se declara y se llama.</p>
 *
 * <p>Un <b>metodo</b> es un bloque de codigo con nombre que realiza una tarea concreta.
 * Modularizar (dividir el programa en metodos) hace el codigo mas legible, reutilizable y facil de depurar.</p>
 *
 * <p><b>Partes de un metodo:</b></p>
 * <ul>
 *   <li><b>modificador</b> - en este curso usamos {@code public static} para llamar desde {@code main}.</li>
 *   <li><b>tipo de retorno</b> - {@code void} si no devuelve nada, o {@code int}, {@code double}, {@code String}, etc.</li>
 *   <li><b>nombre</b> - en camelCase, descriptivo ({@code calcularMedia}, {@code mostrarMenu}).</li>
 *   <li><b>parametros</b> - datos que recibe entre parentesis (puede no tener ninguno).</li>
 *   <li><b>cuerpo</b> - instrucciones entre llaves {@code { }}.</li>
 * </ul>
 *
 * <pre>{@code
 * public static void mostrarBienvenida() {
 *     System.out.println("Bienvenido al programa");
 * }
 *
 * public static int sumar(int a, int b) {
 *     return a + b;
 * }
 * }</pre>
 *
 * <p><b>Llamada a un metodo:</b> se escribe el nombre seguido de parentesis.
 * Si devuelve un valor, puedes guardarlo en una variable o imprimirlo.</p>
 *
 * <pre>{@code
 * mostrarBienvenida();                    // metodo void
 * int total = sumar(3, 5);                // metodo con return
 * System.out.println(sumar(10, 2));       // usar el valor directamente
 * }</pre>
 *
 * <p>Siguientes bloques: {@link U02_MetodosVoidIntro}, {@link U03_MetodosReturnIntro},
 * {@link U04_MetodosParametrosIntro}, {@link U05_MetodosEstructurasIntro},
 * {@link U06_MetodosSobrecargaIntro}, {@link U07_MetodosComparacionIntro}.</p>
 *
 * <p>Practica en {@code ejercicios/pendientes} y {@code ejercicios/resueltos}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U01_MetodosIntro {

    public static void mostrarBienvenida() {
        System.out.println("Bienvenido al programa");
    }

    public static int sumar(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int resultado;
        mostrarBienvenida();
        resultado = sumar(3, 5);
        System.out.println("3 + 5 = " + resultado);
        System.out.println("10 + 2 = " + sumar(10, 2));
    }
}
