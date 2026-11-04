package ev1.ut3_stringsyenvolventes.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Convierte Programacion en Java a mayusculas y a minusculas, y comprueba que el original no cambia.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> toUpperCase y toLowerCase crean cadenas nuevas. El texto original sigue igual porque String es inmutable.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E05_MayusculasYMinusculas_Resuelto {
    public static void main(String[] args) {
        String texto = "Programacion en Java";
        String mayusculas = texto.toUpperCase();
        System.out.println("En mayusculas: " + mayusculas);
        String minusculas = texto.toLowerCase();
        System.out.println("En minusculas: " + minusculas);
        System.out.println("Texto original: " + texto);
    }
}
