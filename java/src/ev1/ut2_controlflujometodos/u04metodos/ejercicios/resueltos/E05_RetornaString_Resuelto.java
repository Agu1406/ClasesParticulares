package ev1.ut2_controlflujometodos.u04metodos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Crea el metodo String obtenerMensaje, que recibe una asignatura y devuelve Estudiando y el nombre. En main llamalo con Programacion e imprime el resultado.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> obtenerMensaje concatena el texto fijo con el parametro. main imprime lo que devuelve.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E05_RetornaString_Resuelto {
    public static String obtenerMensaje(String asignatura) {
        return "Estudiando " + asignatura;
    }

    public static void main(String[] args) {
        System.out.println(obtenerMensaje("Programacion"));
    }
}
