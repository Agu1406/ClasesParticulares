package ev1.ut2_controlflujometodos.u05repaso.ejercicios.resueltos;

/**
 * Ejercicio: while con switch
 * Objetivo: Muestra accion segun color de semaforo usando switch.
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
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
                case "amarillo" -> System.out.println("Precaucion");
                case "verde" -> System.out.println("Avanzar");
                default -> System.out.println("Color desconocido");
            }
            i++;
        }
    }
}
