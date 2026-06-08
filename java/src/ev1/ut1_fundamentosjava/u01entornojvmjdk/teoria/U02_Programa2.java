// La linea llamada "package" podeis ignorarla por completo, mucho mas adelante se explica.
package ev1.ut1_fundamentosjava.u01entornojvmjdk.teoria;

/**
 * Finalmente, con estas bases sencillas del lenguaje, el ultimo concepto que quiero que
 * aprendaís es las llaves, ¿que significan? todas las cosas en la vida tienen un inicio
 * y un final, nada es eterno, nuestro código empieza con las llaves "{" y ahí donde se
 * cierran es donde termina el código, así que, aunque por ejemplo, este documento tenga
 * 28 lineas, lo cierto es que el verdadero código, es decir lo que nuestra maquina usa
 * de verdad es solo lo que existen dentro de esas llaves, es decir de la linea 22 hasta
 * la linea 26, mientras que el resto son solo comentarios que no aportan nada al código
 * más alla de una explicación (como esto) o contexto que JVM usa para ejecutar.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U02_Programa2 {
    public static void main(String[] args) {
        // Aqui le doy la instruccion de imprimir "!Hola mundo!".
        System.out.println("!Hola mundo!");

        // Aqui le doy la instruccion de imprimir mi nombre.
        System.out.println("!Mi nombre es Agustin!");
    }
}