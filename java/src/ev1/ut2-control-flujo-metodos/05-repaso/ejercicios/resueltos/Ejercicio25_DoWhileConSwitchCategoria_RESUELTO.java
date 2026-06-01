package general.repaso;

/**
 * Ejercicio: do-while con switch
 * Objetivo: Clasifica productos por categoría numérica con switch.
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio25_DoWhileConSwitchCategoria_RESUELTO {
    public static void main(String[] args) {
        int cat = 1;
        do {
            switch (cat) {
                case 1 -> System.out.println("Categoría 1: Alimentación");
                case 2 -> System.out.println("Categoría 2: Electrónica");
                case 3 -> System.out.println("Categoría 3: Hogar");
                default -> System.out.println("Categoría desconocida");
            }
            cat++;
        } while (cat <= 3);
    }
}
