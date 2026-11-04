package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con el texto Java, usa un if para mostrar Cadena con contenido si no esta vacio.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code !texto.isEmpty()} escribe Cadena con contenido.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E07_CadenaNoVacia_Resuelto {
    public static void main(String[] args) {
        String texto = "Java";
        if (!texto.isEmpty()) {
            System.out.println("Cadena con contenido");
        }
    }
}
