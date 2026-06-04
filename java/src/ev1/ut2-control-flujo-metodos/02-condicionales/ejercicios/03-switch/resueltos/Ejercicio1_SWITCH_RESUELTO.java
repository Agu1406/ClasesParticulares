package general.condicionales;

/**
 * Ejercicio 1 (switch): Mostrar dia de la semana por numero (1-7)
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio1_SWITCH_RESUELTO {
    public static void main(String[] args) {
        int dia = 3;
                switch (dia) {
                    case 1: System.out.println("Lunes"); break;
                    case 2: System.out.println("Martes"); break;
                    case 3: System.out.println("Miercoles"); break;
                    case 4: System.out.println("Jueves"); break;
                    case 5: System.out.println("Viernes"); break;
                    case 6: System.out.println("Sabado"); break;
                    case 7: System.out.println("Domingo"); break;
                    default: System.out.println("Valor invalido");
                }
    }
}
