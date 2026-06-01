package general.repaso;

/**
 * Ejercicio: while con switch
 * Objetivo: Muestra acción según color de semáforo usando switch.
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio30_WhileConSwitchSemaforo_RESUELTO {
    public static void main(String[] args) {
        String[] colores = {"rojo", "amarillo", "verde", "rojo"};
        int i = 0;
        while (i < colores.length) {
            switch (colores[i]) {
                case "rojo" -> System.out.println("Detenerse");
                case "amarillo" -> System.out.println("Precaución");
                case "verde" -> System.out.println("Avanzar");
                default -> System.out.println("Color desconocido");
            }
            i++;
        }
    }
}
