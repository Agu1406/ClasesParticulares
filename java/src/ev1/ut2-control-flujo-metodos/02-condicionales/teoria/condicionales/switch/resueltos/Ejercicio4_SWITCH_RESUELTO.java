package general.condicionales;

/**
 * Ejercicio 4 (switch): Clasificar nota por tramo
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio4_SWITCH_RESUELTO {
    public static void main(String[] args) {
        int nota = 8;
                switch (nota) {
                    case 10:
                    case 9: System.out.println("Sobresaliente"); break;
                    case 8:
                    case 7: System.out.println("Notable"); break;
                    case 6:
                    case 5: System.out.println("Aprobado"); break;
                    default: System.out.println("Suspenso");
                }
    }
}
