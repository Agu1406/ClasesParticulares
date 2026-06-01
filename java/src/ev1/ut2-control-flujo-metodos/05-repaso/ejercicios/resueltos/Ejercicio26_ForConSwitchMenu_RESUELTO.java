package general.repaso;

/**
 * Ejercicio: for con switch
 * Objetivo: Simula selección de menú 1..5 con switch en un for.
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio26_ForConSwitchMenu_RESUELTO {
    public static void main(String[] args) {
        for (int opcion = 1; opcion <= 5; opcion++) {
            switch (opcion) {
                case 1 -> System.out.println("Nuevo");
                case 2 -> System.out.println("Abrir");
                case 3 -> System.out.println("Guardar");
                case 4 -> System.out.println("Imprimir");
                case 5 -> System.out.println("Salir");
                default -> System.out.println("Opción inválida");
            }
        }
    }
}
