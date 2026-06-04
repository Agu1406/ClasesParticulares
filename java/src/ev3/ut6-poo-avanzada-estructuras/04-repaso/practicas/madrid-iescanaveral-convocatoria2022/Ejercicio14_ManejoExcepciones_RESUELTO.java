package madrid.iescanaveral.ejercicios.convocatoria2022;

import java.io.*;

/**
 * Ejercicio 14: ?Que se producira si intenta compilar y ejecutar el codigo siguiente? - RESUELTO
 * 
 * RESPUESTA: No such file found, Doing finally, -1
 * 
 * Explicacion:
 * - Se intenta abrir "Hello.txt" que no existe
 * - Se lanza FileNotFoundException
 * - Se captura en el catch, imprime "No such file found" y retorna -1
 * - El bloque finally SIEMPRE se ejecuta, incluso si hay un return
 * - El finally imprime "Doing finally"
 * - El metodo retorna -1
 * - Salida: "No such file found\nDoing finally\n-1"
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio14_ManejoExcepciones_RESUELTO {
    public static void main(String[] argv) {
        Ejercicio14_ManejoExcepciones_RESUELTO m = new Ejercicio14_ManejoExcepciones_RESUELTO();
        System.out.println(m.amethod());
        // Salida:
        // No such file found
        // Doing finally
        // -1
    }
    
    public int amethod() {
        try {
            FileInputStream dis = new FileInputStream("Hello.txt");  // Lanza FileNotFoundException
        } catch (FileNotFoundException fne) {
            System.out.println("No such file found");  // Se ejecuta esto
            return -1;  // Retorna -1, pero el finally se ejecuta antes
        } catch (IOException ioe) {
            // No se ejecuta
        } finally {
            System.out.println("Doing finally");  // SIEMPRE se ejecuta, incluso con return
        }
        return 0;  // No se alcanza porque hay return en el catch
    }
}
