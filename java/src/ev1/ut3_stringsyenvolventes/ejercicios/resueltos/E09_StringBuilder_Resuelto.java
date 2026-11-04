package ev1.ut3_stringsyenvolventes.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con un StringBuilder une Hola, un espacio, mundo y !. Con otro, escribe Numeros: y los enteros del 1 al 5 separados por coma.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> append modifica el mismo objeto. toString obtiene el texto. El segundo ejemplo anade la coma solo si no es el ultimo numero.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E09_StringBuilder_Resuelto {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hola");
        sb.append(" ");
        sb.append("mundo");
        sb.append("!");
        String resultado = sb.toString();
        System.out.println("Resultado: " + resultado);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Numeros: ");
        for (int i = 1; i <= 5; i++) {
            sb2.append(i);
            if (i < 5) {
                sb2.append(", ");
            }
        }
        System.out.println(sb2.toString());
    }
}
