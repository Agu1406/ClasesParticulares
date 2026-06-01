package general.repaso;

/**
 * Ejercicio: for con switch
 * Objetivo: Recorre del 1 al 7 y muestra el día de la semana con switch.
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio3_ForConSwitch_RESUELTO {
    public static void main(String[] args) {
        for (int dia = 1; dia <= 7; dia++) {
            switch (dia) {
                case 1 -> System.out.println("Lunes");
                case 2 -> System.out.println("Martes");
                case 3 -> System.out.println("Miércoles");
                case 4 -> System.out.println("Jueves");
                case 5 -> System.out.println("Viernes");
                case 6 -> System.out.println("Sábado");
                case 7 -> System.out.println("Domingo");
                default -> System.out.println("Día inválido");
            }
        }
    }
}
