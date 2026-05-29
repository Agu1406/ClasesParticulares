package general.bucles;

/**
 * Ejercicio 10 (while): Suma hasta superar 100
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio10_WHILE_RESUELTO {
    public static void main(String[] args) {
        int suma = 0;
                int i = 1;
                while (suma <= 100) {
                    suma += i;
                    i++;
                }
                System.out.println("Suma final: " + suma);
    }
}
