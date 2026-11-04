package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con a = 7 y b = 11, usa if-else para mostrar cual es mayor, o si son iguales.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code a > b} escribe a es mayor. En otro caso escribe b es mayor o son iguales.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E13_MayorDeDos_Resuelto {
    public static void main(String[] args) {
        int a = 7;
        int b = 11;
        if (a > b) {
            System.out.println("a es mayor");
        } else {
            System.out.println("b es mayor o son iguales");
        }
    }
}
