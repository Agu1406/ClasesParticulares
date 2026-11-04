package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con la nota 4.2, usa if-else para mostrar Aprobado o Suspenso.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code nota >= 5} escribe Aprobado. El 4.2 entra en else y escribe Suspenso.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E14_AprobadoOSuspenso_Resuelto {
    public static void main(String[] args) {
        double nota = 4.2;
        if (nota >= 5) {
            System.out.println("Aprobado");
        } else {
            System.out.println("Suspenso");
        }
    }
}
