package general.inputoutputficheros;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Ejercicio 7: Copiar imagen JPG con FileInputStream/FileOutputStream
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio7_InputOutputFicheros_RESUELTO {
    public static void main(String[] args) {
        String basePath = "src/ev2/ut4/inputoutputficheros";
        try (FileInputStream fis = new FileInputStream(basePath + "/imagen_origen.jpg");
             FileOutputStream fos = new FileOutputStream(basePath + "/imagen_copia1.jpg")) {
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
