package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con el entero 35, usa un if para mostrar Multiplo de 5 si el resto al dividir entre 5 es 0.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code numero % 5 == 0} escribe Multiplo de 5.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E03_MultiploDeCinco_Resuelto {
    public static void main(String[] args) {
        int numero = 35;
        if (numero % 5 == 0) {
            System.out.println("Multiplo de 5");
        }
    }
}
