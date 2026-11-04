package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con la nota 5.0, usa un if para mostrar Aprobado si es 5 o mas.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code nota >= 5} escribe Aprobado.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E04_NotaMinima_Resuelto {
    public static void main(String[] args) {
        double nota = 5.0;
        if (nota >= 5) {
            System.out.println("Aprobado");
        }
    }
}
