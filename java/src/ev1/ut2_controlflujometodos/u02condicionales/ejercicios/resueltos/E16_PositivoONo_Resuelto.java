package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con el entero -3, usa if-else para mostrar Positivo o Cero o negativo.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code numero > 0} escribe Positivo. El -3 entra en else.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E16_PositivoONo_Resuelto {
    public static void main(String[] args) {
        int numero = -3;
        if (numero > 0) {
            System.out.println("Positivo");
        } else {
            System.out.println("Cero o negativo");
        }
    }
}
