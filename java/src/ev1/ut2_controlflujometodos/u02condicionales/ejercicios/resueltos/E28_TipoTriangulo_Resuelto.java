package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con la opcion 3, usa switch para mostrar Equilatero, Isosceles o Escaleno. Otra opcion: No valido.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El case 3 escribe Escaleno.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E28_TipoTriangulo_Resuelto {
    public static void main(String[] args) {
        int opcion = 3;
        switch (opcion) {
            case 1:
                System.out.println("Equilatero");
                break;
            case 2:
                System.out.println("Isosceles");
                break;
            case 3:
                System.out.println("Escaleno");
                break;
            default:
                System.out.println("No valido");
        }
    }
}
