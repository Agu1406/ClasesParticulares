package madrid.iescanaveral.ejercicios.convocatoria2022;

import java.io.*;

/**
 * Ejercicio 14: ¿Qué se producirá si intenta compilar y ejecutar el código siguiente, 
 * pero no hay ningún archivo llamado Hello.txt en el directorio actual?
 * 
 * Analiza el manejo de excepciones y el bloque finally en Java.
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio14_ManejoExcepciones {
    public static void main(String[] argv) {
        Ejercicio14_ManejoExcepciones m = new Ejercicio14_ManejoExcepciones();
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
