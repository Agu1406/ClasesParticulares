package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con el entero 12, usa un if para mostrar Es par si el resto al dividir entre 2 es 0.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code numero % 2 == 0} escribe Es par.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E09_NumeroPar_Resuelto {
    public static void main(String[] args) {
        int numero = 12;
        if (numero % 2 == 0) {
            System.out.println("Es par");
        }
    }
}
