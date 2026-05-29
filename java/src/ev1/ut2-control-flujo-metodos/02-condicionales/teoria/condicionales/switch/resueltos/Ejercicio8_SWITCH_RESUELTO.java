package general.condicionales;

/**
 * Ejercicio 8 (switch): Tipo de triángulo por opción
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio8_SWITCH_RESUELTO {
    public static void main(String[] args) {
        int opcion = 3;
                switch (opcion) {
                    case 1: System.out.println("Equilátero"); break;
                    case 2: System.out.println("Isósceles"); break;
                    case 3: System.out.println("Escaleno"); break;
                    default: System.out.println("No válido");
                }
    }
}
