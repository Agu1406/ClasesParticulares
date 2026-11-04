package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con la nota 6, usa switch para mostrar A (9-10), B (7-8), C (5-6) o D.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Los case 6 y 5 comparten el bloque y escriben C.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E29_LetraCalificacion_Resuelto {
    public static void main(String[] args) {
        int nota = 6;
        switch (nota) {
            case 10:
            case 9:
                System.out.println("A");
                break;
            case 8:
            case 7:
                System.out.println("B");
                break;
            case 6:
            case 5:
                System.out.println("C");
                break;
            default:
                System.out.println("D");
        }
    }
}
