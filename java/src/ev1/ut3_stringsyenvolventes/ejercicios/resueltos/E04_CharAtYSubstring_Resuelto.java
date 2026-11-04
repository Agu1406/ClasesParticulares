package ev1.ut3_stringsyenvolventes.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con el String Programacion muestra el primer caracter, el ultimo, la subcadena de 0 a 4 y el texto desde la posicion 4.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> charAt(0) es P y charAt(length - 1) es n. substring(0, 4) es Prog y substring(4) es ramacion.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E04_CharAtYSubstring_Resuelto {
    public static void main(String[] args) {
        String texto = "Programacion";
        char primerCaracter = texto.charAt(0);
        System.out.println("Primer caracter: " + primerCaracter);
        char ultimoCaracter = texto.charAt(texto.length() - 1);
        System.out.println("Ultimo caracter: " + ultimoCaracter);
        String subcadena = texto.substring(0, 4);
        System.out.println("Subcadena (0-4): " + subcadena);
        String desdeMedio = texto.substring(4);
        System.out.println("Desde la posicion 4 hasta el final: " + desdeMedio);
    }
}
