package ev1.ut2_controlflujometodos.u04metodos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Crea el metodo void saludar, que recibe un String nombre e imprime Hola, y el nombre. Llamalo desde main con Agustin.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> saludar concatena el saludo con el parametro. main llama a saludar con Agustin.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E02_VoidConParametros_Resuelto {
    public static void saludar(String nombre) {
        System.out.println("Hola, " + nombre);
    }

    public static void main(String[] args) {
        saludar("Agustin");
    }
}
