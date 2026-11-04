package ev1.ut3_stringsyenvolventes.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Crea dos String, Juan y Perez, concatenalos con un espacio y muestra Nombre completo: y Hola, con el resultado.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> nombre y apellido se unen con +. Se imprime el nombre completo y un saludo con la misma concatenacion.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E01_CrearYConcatenarStrings_Resuelto {
    public static void main(String[] args) {
        String nombre = "Juan";
        String apellido = "Perez";
        String nombreCompleto = nombre + " " + apellido;
        System.out.println("Nombre completo: " + nombreCompleto);
        System.out.println("Hola, " + nombre + " " + apellido);
    }
}
