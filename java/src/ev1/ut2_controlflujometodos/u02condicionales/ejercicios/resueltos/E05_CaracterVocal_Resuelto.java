package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con el caracter e, pasalo a minuscula y usa un if para mostrar Es vocal si es a, e, i, o o u.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code Character.toLowerCase} y una condicion con {@code ||} escriben Es vocal.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E05_CaracterVocal_Resuelto {
    public static void main(String[] args) {
        char c = 'e';
        c = Character.toLowerCase(c);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            System.out.println("Es vocal");
        }
    }
}
