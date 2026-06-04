package ev1.ut2.u02condicionales.ejercicios.resueltos;

/**
 * Ejercicio 5 (switch): Elegir opcion de menu
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio5_SWITCH_RESUELTO {
    public static void main(String[] args) {
        int opcion = 2;
                switch (opcion) {
                    case 1: System.out.println("Nuevo archivo"); break;
                    case 2: System.out.println("Abrir archivo"); break;
                    case 3: System.out.println("Guardar"); break;
                    case 4: System.out.println("Salir"); break;
                    default: System.out.println("Opcion invalida");
                }
    }
}
