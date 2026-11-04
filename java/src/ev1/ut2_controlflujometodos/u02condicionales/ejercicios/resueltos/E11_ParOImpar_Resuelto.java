package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con el entero 9, usa if-else para mostrar Par o Impar.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code numero % 2 == 0} elige Par. El 9 entra en else y escribe Impar.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E11_ParOImpar_Resuelto {
    public static void main(String[] args) {
        int numero = 9;
        if (numero % 2 == 0) {
            System.out.println("Par");
        } else {
            System.out.println("Impar");
        }
    }
}
