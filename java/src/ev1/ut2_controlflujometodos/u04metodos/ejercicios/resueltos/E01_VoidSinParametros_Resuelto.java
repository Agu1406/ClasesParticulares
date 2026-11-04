package ev1.ut2_controlflujometodos.u04metodos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Crea el metodo void mostrarMensaje, sin parametros, que imprima Hola desde la funcion. Llamalo desde main.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> mostrarMensaje imprime el mensaje y no devuelve nada. main solo lo llama.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E01_VoidSinParametros_Resuelto {
    public static void mostrarMensaje() {
        System.out.println("Hola desde la funcion");
    }

    public static void main(String[] args) {
        mostrarMensaje();
    }
}
