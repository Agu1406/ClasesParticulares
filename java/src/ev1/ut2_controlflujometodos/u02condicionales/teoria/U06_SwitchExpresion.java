package ev1.ut2_controlflujometodos.u02condicionales.teoria;

/**
 * <p><b>OBJETIVO:</b> contrastar el {@code switch} clasico (con {@code break})
 * y el {@code switch} expresion (con {@code ->} y valor de retorno).</p>
 *
 * <p>Relacionado con la practica Galicia datas (U2T2).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 18/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U06_SwitchExpresion {

    public static void main(String[] args) {
        int mes;
        int diasClasico;
        int diasExpresion;

        mes = 2;

        /*
         * Clasico: si olvidas un break, "caes" al case siguiente (bug tipico).
         */
        diasClasico = 0;
        switch (mes) {
            case 2:
                diasClasico = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diasClasico = 30;
                break;
            default:
                diasClasico = 31;
        }

        /*
         * Expresion: cada rama devuelve un valor; no hay caida entre cases.
         */
        diasExpresion = switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28;
            default -> -1;
        };

        System.out.println("Clasico mes " + mes + ": " + diasClasico);
        System.out.println("Expresion mes " + mes + ": " + diasExpresion);
    }
}
