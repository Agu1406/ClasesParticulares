package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con el mes 2, usa switch para mostrar 31, 30 o 28 dias. Febrero se queda en 28. Otro mes: Mes invalido.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Varios case seguidos comparten el mismo println. El mes 2 escribe 28 dias.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E27_DiasDelMes_Resuelto {
    public static void main(String[] args) {
        int mes = 2;
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("31 dias");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("30 dias");
                break;
            case 2:
                System.out.println("28 dias");
                break;
            default:
                System.out.println("Mes invalido");
        }
    }
}
