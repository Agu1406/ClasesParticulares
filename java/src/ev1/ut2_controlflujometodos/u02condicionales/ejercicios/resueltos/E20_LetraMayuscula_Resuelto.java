package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con el caracter G, usa if-else para mostrar Mayuscula o No mayuscula.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code Character.isUpperCase} escribe Mayuscula para G.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E20_LetraMayuscula_Resuelto {
    public static void main(String[] args) {
        char c = 'G';
        if (Character.isUpperCase(c)) {
            System.out.println("Mayuscula");
        } else {
            System.out.println("No mayuscula");
        }
    }
}
