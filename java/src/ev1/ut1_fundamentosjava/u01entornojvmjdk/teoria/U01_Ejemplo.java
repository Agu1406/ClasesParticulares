package ev1.ut1_fundamentosjava.u01entornojvmjdk.teoria;

/**
 * <p><b>OBJETIVO:</b> Diferenciar JVM y JDK al instalar Java, y ejecutar un primer
 * {@code System.out.println} para comprobar que el entorno funciona.</p>
 *
 * <br>
 *
 * <p><b>CONTENIDO:</b> Al instalar Java suele haber dos piezas:</p>
 * <ul>
 * <li><b>JVM</b> (Java Virtual Machine): ejecuta bytecode y traduce el programa para el sistema.</li>
 * <li><b>JDK</b> (Java Development Kit): compila, depura y permite crear aplicaciones Java.</li>
 * </ul>
 * <p>El usuario final suele bastarle con la JVM; nosotros necesitamos JDK (y con el JDK ya ejecutamos
 * y compilamos). La linea {@code package} se explicara mas adelante; de momento puedes ignorarla.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U01_Ejemplo {
    public static void main(String[] args) {
        System.out.println("¡Hola mundo! Esta es tu primera leccion.");
    }
}
