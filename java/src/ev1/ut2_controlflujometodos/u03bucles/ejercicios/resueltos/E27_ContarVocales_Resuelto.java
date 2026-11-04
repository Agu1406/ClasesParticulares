package ev1.ut2_controlflujometodos.u03bucles.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Usa un do-while para contar las vocales de la palabra desarrollo y muestra Vocales: con el total.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Se recorre la palabra con charAt. Cada vocal suma 1. Hay 5.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E27_ContarVocales_Resuelto {
    public static void main(String[] args) {
        String palabra = "desarrollo";
        int i = 0;
        int vocales = 0;
        do {
            char c = Character.toLowerCase(palabra.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vocales++;
            }
            i++;
        } while (i < palabra.length());
        System.out.println("Vocales: " + vocales);
    }
}
