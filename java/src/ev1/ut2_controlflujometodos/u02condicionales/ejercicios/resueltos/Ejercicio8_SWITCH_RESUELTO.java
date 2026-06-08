package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * Ejercicio 8 (switch): Tipo de triangulo por opcion
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio8_SWITCH_RESUELTO {
    public static void main(String[] args) {
        int opcion = 3;
                switch (opcion) {
                    case 1: System.out.println("Equilatero"); break;
                    case 2: System.out.println("Isosceles"); break;
                    case 3: System.out.println("Escaleno"); break;
                    default: System.out.println("No valido");
                }
    }
}
