package ev1.ut2_controlflujometodos.u05repaso.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Recorre un String y cuenta vocales usando if.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El main recorre un String y cuenta vocales usando if.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E08_ForConIfVocales_Resuelto {
    public static void main(String[] args) {
        String texto = "programacion";
        int vocales = 0;
        for (int i = 0; i < texto.length(); i++) {
            char c = Character.toLowerCase(texto.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vocales++;
            }
        }
        System.out.println("Vocales: " + vocales);
    }
}
