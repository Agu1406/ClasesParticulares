package general.condicionales;

/**
 * Ejercicio 10 (switch): Estación del año por mes
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio10_SWITCH_RESUELTO {
    public static void main(String[] args) {
        int mes = 11;
                switch (mes) {
                    case 12: case 1: case 2: System.out.println("Invierno"); break;
                    case 3: case 4: case 5: System.out.println("Primavera"); break;
                    case 6: case 7: case 8: System.out.println("Verano"); break;
                    case 9: case 10: case 11: System.out.println("Otoño"); break;
                    default: System.out.println("Mes inválido");
                }
    }
}
