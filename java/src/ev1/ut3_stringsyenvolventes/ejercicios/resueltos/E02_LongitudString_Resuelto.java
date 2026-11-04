package ev1.ut3_stringsyenvolventes.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Crea el String Programacion en Java y muestra su longitud con length().</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> length() devuelve 20. Se imprime el texto entre comillas y, en otra linea, Longitud:.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E02_LongitudString_Resuelto {
    public static void main(String[] args) {
        String texto = "Programacion en Java";
        int longitud = texto.length();
        System.out.println("El texto \"" + texto + "\" tiene " + longitud + " caracteres");
        System.out.println("Longitud: " + texto.length());
    }
}
