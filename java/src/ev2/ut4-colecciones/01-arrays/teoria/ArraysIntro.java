package general.arrays;

/**
 * Teoría: arrays en Java.
 *
 * <p><b>Objetivo:</b> declarar arrays unidimensionales y bidimensionales, recorrerlos
 * con bucles y aplicar operaciones habituales (sumar, buscar, ordenar).</p>
 *
 * <p>Ejercicios por dificultad en {@code ejercicios/facil|medio|dificil/}
 * (carpetas {@code pendientes} y {@code resueltos}).</p>
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class ArraysIntro {

    public static void main(String[] args) {
        int[] numeros = {4, 6, 5, 7, 2};
        System.out.print("Array: ");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();
    }
}
