package ev1.ut2_controlflujometodos.u03bucles.ejercicios.resueltos;

/**
 * Ejercicio 7 (dowhile): Contar vocales en una palabra
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio7_DOWHILE_RESUELTO {
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
