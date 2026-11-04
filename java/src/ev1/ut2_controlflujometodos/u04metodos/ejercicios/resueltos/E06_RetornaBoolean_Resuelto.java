package ev1.ut2_controlflujometodos.u04metodos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Crea el metodo boolean esPar, que devuelva true si el numero es par. En main imprime Es par? y el resultado de esPar(14).</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> esPar devuelve numero % 2 == 0. main prueba con 14.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E06_RetornaBoolean_Resuelto {
    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println("Es par? " + esPar(14));
    }
}
