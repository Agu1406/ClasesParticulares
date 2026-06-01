package general.condicionales;

/**
 * Ejercicio 8 (ifelse): Elegir descuento por ser mayor de 65
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio8_IFELSE_RESUELTO {
    public static void main(String[] args) {
        int edad = 70;
                if (edad >= 65) {
                    System.out.println("Tiene descuento");
                } else {
                    System.out.println("Sin descuento");
                }
    }
}
