package ev1.ut2_controlflujometodos.u05repaso.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Simula menu con opciones 1..4 usando switch.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El main simula menu con opciones 1..4 usando switch.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E10_DoWhileConSwitchMenu_Resuelto {
    public static void main(String[] args) {
        int opcion = 1;
        do {
            switch (opcion) {
                case 1 -> System.out.println("Alta");
                case 2 -> System.out.println("Baja");
                case 3 -> System.out.println("Consulta");
                case 4 -> System.out.println("Salir");
                default -> System.out.println("Opcion invalida");
            }
            opcion++;
        } while (opcion <= 4);
    }
}
