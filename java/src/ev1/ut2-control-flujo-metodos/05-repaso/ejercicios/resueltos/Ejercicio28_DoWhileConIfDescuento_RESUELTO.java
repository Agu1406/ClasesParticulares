package general.repaso;

/**
 * Ejercicio: do-while con if
 * Objetivo: Aplica descuento si precio supera umbral usando if.
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio28_DoWhileConIfDescuento_RESUELTO {
    public static void main(String[] args) {
        double precio = 80;
        int intento = 1;
        do {
            if (precio > 50) {
                System.out.println("Precio " + precio + " con 10% descuento: " + (precio * 0.9));
            } else {
                System.out.println("Precio " + precio + " sin descuento");
            }
            precio += 15;
            intento++;
        } while (intento <= 3);
    }
}
