package ev1.ut2.u05repaso.ejercicios.resueltos;

/**
 * Ejercicio: do-while con switch
 * Objetivo: Muestra nombre de dia para codigos 1..7 con switch.
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio22_DoWhileConSwitchDia_RESUELTO {
    public static void main(String[] args) {
        int codigo = 1;
        do {
            switch (codigo) {
                case 1 -> System.out.println("Lunes");
                case 2 -> System.out.println("Martes");
                case 3 -> System.out.println("Miercoles");
                case 4 -> System.out.println("Jueves");
                case 5 -> System.out.println("Viernes");
                case 6 -> System.out.println("Sabado");
                case 7 -> System.out.println("Domingo");
                default -> System.out.println("Codigo invalido");
            }
            codigo++;
        } while (codigo <= 7);
    }
}
