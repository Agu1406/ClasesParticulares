package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con la nota 8, usa switch para mostrar Sobresaliente (9-10), Notable (7-8), Aprobado (5-6) o Suspenso.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Los case 8 y 7 comparten el bloque y escriben Notable.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E24_NotaPorTramo_Resuelto {
    public static void main(String[] args) {
        int nota = 8;
        switch (nota) {
            case 10:
            case 9:
                System.out.println("Sobresaliente");
                break;
            case 8:
            case 7:
                System.out.println("Notable");
                break;
            case 6:
            case 5:
                System.out.println("Aprobado");
                break;
            default:
                System.out.println("Suspenso");
        }
    }
}
