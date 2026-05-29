package general.condicionales;

/**
 * Ejercicio 7 (switch): Días del mes (sin bisiesto)
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio7_SWITCH_RESUELTO {
    public static void main(String[] args) {
        int mes = 2;
                switch (mes) {
                    case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                        System.out.println("31 días"); break;
                    case 4: case 6: case 9: case 11:
                        System.out.println("30 días"); break;
                    case 2:
                        System.out.println("28 días"); break;
                    default:
                        System.out.println("Mes inválido");
                }
    }
}
