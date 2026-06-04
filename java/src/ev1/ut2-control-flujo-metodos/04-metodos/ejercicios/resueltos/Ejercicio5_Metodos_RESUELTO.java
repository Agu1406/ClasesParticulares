package general.metodos;

/**
 * Ejercicio 5: Funcion que retorna String
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio5_Metodos_RESUELTO {

    public static String obtenerMensaje(String asignatura) {
            return "Estudiando " + asignatura;
        }

    public static void main(String[] args) {
        System.out.println(obtenerMensaje("Programacion"));
    }
}
