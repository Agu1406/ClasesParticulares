package ev1.ut3_stringsyenvolventes.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Quita los espacios de '   Programacion en Java   ' con trim, sustituye a por A y Java por Python.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> trim recorta los extremos. replace de un char y replace de un substring crean cadenas nuevas.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E07_ReemplazarYTrim_Resuelto {
    public static void main(String[] args) {
        String textoConEspacios = "   Programacion en Java   ";
        System.out.println("Texto original: '" + textoConEspacios + "'");
        System.out.println("Longitud: " + textoConEspacios.length());
        String textoSinEspacios = textoConEspacios.trim();
        System.out.println("Texto sin espacios: '" + textoSinEspacios + "'");
        System.out.println("Longitud: " + textoSinEspacios.length());
        String textoReemplazado = textoSinEspacios.replace('a', 'A');
        System.out.println("Reemplazando 'a' por 'A': " + textoReemplazado);
        String textoReemplazadoSubstring = textoSinEspacios.replace("Java", "Python");
        System.out.println("Reemplazando 'Java' por 'Python': " + textoReemplazadoSubstring);
    }
}
