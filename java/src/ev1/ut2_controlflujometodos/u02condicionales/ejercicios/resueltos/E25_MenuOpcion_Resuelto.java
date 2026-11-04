package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con la opcion 2, usa switch para mostrar Nuevo archivo, Abrir archivo, Guardar o Salir. Otra opcion: Opcion invalida.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El case 2 escribe Abrir archivo.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E25_MenuOpcion_Resuelto {
    public static void main(String[] args) {
        int opcion = 2;
        switch (opcion) {
            case 1:
                System.out.println("Nuevo archivo");
                break;
            case 2:
                System.out.println("Abrir archivo");
                break;
            case 3:
                System.out.println("Guardar");
                break;
            case 4:
                System.out.println("Salir");
                break;
            default:
                System.out.println("Opcion invalida");
        }
    }
}
