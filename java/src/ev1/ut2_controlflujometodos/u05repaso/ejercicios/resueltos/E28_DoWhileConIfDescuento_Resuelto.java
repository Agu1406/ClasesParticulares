package ev1.ut2_controlflujometodos.u05repaso.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Aplica descuento si precio supera umbral usando if.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El main aplica descuento si precio supera umbral usando if.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E28_DoWhileConIfDescuento_Resuelto {
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
