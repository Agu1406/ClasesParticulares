package general.bucles;

/**
 * Teoria: bucle {@code do-while} en Java.
 *
 * <p><b>Objetivo:</b> ejecutar el cuerpo del bucle al menos una vez y repetir mientras
 * la condicion sea verdadera.</p>
 *
 * <p>Sintaxis:</p>
 * <pre>{@code
 * do {
 *     // cuerpo (siempre se ejecuta al menos una vez)
 * } while (condicion);
 * }</pre>
 *
 * <p>Diferencia clave respecto a {@code while}:</p>
 * <ul>
 *   <li>La condicion se comprueba <em>despues</em> del cuerpo.</li>
 *   <li>Garantiza una ejecucion minima (menus, peticion de datos al usuario).</li>
 * </ul>
 *
 * <p>Practica en {@code ejercicios/03-dowhile/} (pendientes y resueltos).</p>
 *
 * @author Agustin. A. Marquez. Pina
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

        System.out.println("--- do-while: menu simplificado (sale con 0) ---");
        int opcion;
        int intentos = 0;
        do {
            intentos++;
            opcion = intentos == 1 ? 1 : 0; // simulacion: primera vuelta 1, luego 0
            System.out.println("Opcion simulada: " + opcion);
        } while (opcion != 0);
    }
}
