// La linea llamada "package" podeis ignorarla por completo, mucho mas adelante se explica.
package ev1.ut1_fundamentosjava.u01entornojvmjdk.teoria;

/**
 * Finalmente, con estas bases sencillas del lenguaje, el último concepto que quiero que
 * aprendas es las llaves, ¿qué significan? Todas las cosas en la vida tienen un inicio
 * y un final, nada es eterno, nuestro código empieza con las llaves "{" y ahí donde se
 * cierran es donde termina el código, así que, aunque por ejemplo, este documento tenga
 * 28 líneas, lo cierto es que el verdadero código, es decir lo que nuestra máquina usa
 * de verdad es solo lo que existen dentro de esas llaves, es decir de la línea 22 hasta
 * la línea 26, mientras que el resto son solo comentarios que no aportan nada al código
 * más allá de una explicación (como esto) o contexto que JVM usa para ejecutar.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U02_Programa2 {
    public static void main(String[] args) {
        // Aquí le doy la instruction de imprimir "!Hola mundo!".
        System.out.println("!Hola mundo!");

        // Aquí le doy la instruction de imprimir mi nombre.
        System.out.println("!Mi nombre es Agustin!");
    }
}