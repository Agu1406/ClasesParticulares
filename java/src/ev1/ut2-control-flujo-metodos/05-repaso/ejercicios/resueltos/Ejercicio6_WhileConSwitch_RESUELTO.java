package general.repaso;

/**
 * Ejercicio: while con switch
 * Objetivo: Recorre meses 1..12 y muestra nombre de mes con switch.
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio6_WhileConSwitch_RESUELTO {
    public static void main(String[] args) {
        int mes = 1;
        while (mes <= 12) {
            switch (mes) {
                case 1 -> System.out.println("Enero");
                case 2 -> System.out.println("Febrero");
                case 3 -> System.out.println("Marzo");
                case 4 -> System.out.println("Abril");
                case 5 -> System.out.println("Mayo");
                case 6 -> System.out.println("Junio");
                case 7 -> System.out.println("Julio");
                case 8 -> System.out.println("Agosto");
                case 9 -> System.out.println("Septiembre");
                case 10 -> System.out.println("Octubre");
                case 11 -> System.out.println("Noviembre");
                case 12 -> System.out.println("Diciembre");
                default -> System.out.println("Mes invalido");
            }
            mes++;
        }
    }
}
