package general.bucles;

/**
 * Ejercicio 9 (while): Mostrar divisores de 30
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio9_WHILE_RESUELTO {
    public static void main(String[] args) {
        int numero = 30;
                int i = 1;
                while (i <= numero) {
                    if (numero % i == 0) {
                        System.out.println(i);
                    }
                    i++;
                }
    }
}
