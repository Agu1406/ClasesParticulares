package ev1.ut2.u03bucles.ejercicios.resueltos;

/**
 * Ejercicio 2 (while): Mostrar numeros pares del 2 al 20
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio2_WHILE_RESUELTO {
    public static void main(String[] args) {
        int i = 2;
                while (i <= 20) {
                    System.out.println(i);
                    i += 2;
                }
    }
}
