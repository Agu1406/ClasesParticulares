package ev1.ut2_controlflujometodos.u01operadoresybasicos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Dados los enteros {@code a}, {@code b}, {@code c} y {@code d},
 * calcula {@code (a + b) * c / d} y muestra el resultado.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Los paréntesis fuerzan la suma antes del producto.
 * Con 4, 2, 3 y 2: {@code (4 + 2) * 3 / 2 = 9}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E09_OperacionesCombinadas_Resuelto {
    public static void main(String[] args) {
        int a = 4;
        int b = 2;
        int c = 3;
        int d = 2;
        int resultado = (a + b) * c / d;
        System.out.println(resultado);
    }
}
