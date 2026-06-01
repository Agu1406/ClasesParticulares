package general.repaso;

/**
 * Ejercicio: do-while con switch
 * Objetivo: Simula menú con opciones 1..4 usando switch.
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio10_DoWhileConSwitchMenu_RESUELTO {
    public static void main(String[] args) {
        int opcion = 1;
        do {
            switch (opcion) {
                case 1 -> System.out.println("Alta");
                case 2 -> System.out.println("Baja");
                case 3 -> System.out.println("Consulta");
                case 4 -> System.out.println("Salir");
                default -> System.out.println("Opción inválida");
            }
            opcion++;
        } while (opcion <= 4);
    }
}
