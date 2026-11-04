package ev1.ut2_controlflujometodos.u04metodos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Crea el metodo String calificarNota, que reciba un double y devuelva Aprobado si la nota es mayor o igual que 5, y Suspenso en caso contrario. En main imprime calificarNota(6.5).</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El if comprueba nota &gt;= 5 y cada rama hace return. main prueba con 6.5.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E07_ConIfElse_Resuelto {
    public static String calificarNota(double nota) {
        if (nota >= 5) {
            return "Aprobado";
        } else {
            return "Suspenso";
        }
    }

    public static void main(String[] args) {
        System.out.println(calificarNota(6.5));
    }
}
