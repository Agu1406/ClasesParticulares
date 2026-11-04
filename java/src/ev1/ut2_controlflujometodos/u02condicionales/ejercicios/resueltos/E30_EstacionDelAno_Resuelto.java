package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con el mes 11, usa switch para mostrar Invierno, Primavera, Verano u Otono. Otro mes: Mes invalido.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Los meses 9, 10 y 11 escriben Otono.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E30_EstacionDelAno_Resuelto {
    public static void main(String[] args) {
        int mes = 11;
        switch (mes) {
            case 12:
            case 1:
            case 2:
                System.out.println("Invierno");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Primavera");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Verano");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Otono");
                break;
            default:
                System.out.println("Mes invalido");
        }
    }
}
