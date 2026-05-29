package general.bucles;

/**
 * Ejercicio 6 (dowhile): Mostrar cubos del 1 al 10
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio6_DOWHILE_RESUELTO {
    public static void main(String[] args) {
        int i = 1;
                do {
                    System.out.println(i + "^3 = " + (i * i * i));
                    i++;
                } while (i <= 10);
    }
}
