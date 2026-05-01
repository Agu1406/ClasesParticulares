package general.condicionales;

/**
 * Ejercicio 7 (ifelse): Comprobar si un año es bisiesto simple
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio7_IFELSE_RESUELTO {
    public static void main(String[] args) {
        int anio = 2023;
                if (anio % 4 == 0) {
                    System.out.println("Bisiesto");
                } else {
                    System.out.println("No bisiesto");
                }
    }
}
