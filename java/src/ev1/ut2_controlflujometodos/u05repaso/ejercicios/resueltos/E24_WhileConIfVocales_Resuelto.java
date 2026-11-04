package ev1.ut2_controlflujometodos.u05repaso.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Recorre caracteres de palabra y detecta vocales con if.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El main recorre caracteres de palabra y detecta vocales con if.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E24_WhileConIfVocales_Resuelto {
    public static void main(String[] args) {
        String palabra = "murcielago";
        int i = 0;
        while (i < palabra.length()) {
            char c = Character.toLowerCase(palabra.charAt(i));
            if ("aeiou".indexOf(c) >= 0) {
                System.out.println("Vocal: " + c);
            }
            i++;
        }
    }
}
