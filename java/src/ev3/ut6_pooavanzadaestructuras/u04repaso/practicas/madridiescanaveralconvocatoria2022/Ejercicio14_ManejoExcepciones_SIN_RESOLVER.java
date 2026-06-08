package ev3.ut6_pooavanzadaestructuras.u04repaso.practicas.madridiescanaveralconvocatoria2022;

import java.io.*;

/**
 * Ejercicio 14: ?Que se producira si intenta compilar y ejecutar el codigo siguiente, 
 * pero no hay ningun archivo llamado Hello.txt en el directorio actual?
 * 
 * Analiza el manejo de excepciones y el bloque finally en Java.
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio14_ManejoExcepciones_SIN_RESOLVER {
    public static void main(String[] argv) {
        Ejercicio14_ManejoExcepciones_SIN_RESOLVER m = new Ejercicio14_ManejoExcepciones_SIN_RESOLVER();
        System.out.println(m.amethod());
    }
    
    public int amethod() {
        try {
            FileInputStream dis = new FileInputStream("Hello.txt");
        } catch (FileNotFoundException fne) {
            System.out.println("No such file found");
            return -1;
        } catch (IOException ioe) {
        } finally {
            System.out.println("Doing finally");
        }
        return 0;
    }
}
