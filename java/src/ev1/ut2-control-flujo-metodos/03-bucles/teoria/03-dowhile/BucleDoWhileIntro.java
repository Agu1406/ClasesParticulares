package general.bucles;

/**
 * Teoría: bucle {@code do-while} en Java.
 *
 * <p><b>Objetivo:</b> ejecutar el cuerpo del bucle al menos una vez y repetir mientras
 * la condición sea verdadera.</p>
 *
 * <p>Sintaxis:</p>
 * <pre>{@code
 * do {
 *     // cuerpo (siempre se ejecuta al menos una vez)
 * } while (condición);
 * }</pre>
 *
 * <p>Diferencia clave respecto a {@code while}:</p>
 * <ul>
 *   <li>La condición se comprueba <em>después</em> del cuerpo.</li>
 *   <li>Garantiza una ejecución mínima (menús, petición de datos al usuario).</li>
 * </ul>
 *
 * <p>Practica en {@code ejercicios/03-dowhile/} (pendientes y resueltos).</p>
 *
 * @author Agustín. A. Marquez. Piña
 * @since 02/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class BucleDoWhileIntro {

    public static void main(String[] args) {
        System.out.println("--- do-while: del 1 al 5 ---");
        int i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i <= 5);

        System.out.println("--- do-while: menú simplificado (sale con 0) ---");
        int opcion;
        int intentos = 0;
        do {
            intentos++;
            opcion = intentos == 1 ? 1 : 0; // simulación: primera vuelta 1, luego 0
            System.out.println("Opción simulada: " + opcion);
        } while (opcion != 0);
    }
}
