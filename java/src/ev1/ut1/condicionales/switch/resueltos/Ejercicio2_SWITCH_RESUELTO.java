package general.condicionales;

/**
 * Ejercicio 2 (switch): Mostrar mes por número (1-12)
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio2_SWITCH_RESUELTO {
    public static void main(String[] args) {
        int mes = 8;
                switch (mes) {
                    case 1: System.out.println("Enero"); break;
                    case 2: System.out.println("Febrero"); break;
                    case 3: System.out.println("Marzo"); break;
                    case 4: System.out.println("Abril"); break;
                    case 5: System.out.println("Mayo"); break;
                    case 6: System.out.println("Junio"); break;
                    case 7: System.out.println("Julio"); break;
                    case 8: System.out.println("Agosto"); break;
                    case 9: System.out.println("Septiembre"); break;
                    case 10: System.out.println("Octubre"); break;
                    case 11: System.out.println("Noviembre"); break;
                    case 12: System.out.println("Diciembre"); break;
                    default: System.out.println("Mes inválido");
                }
    }
}
