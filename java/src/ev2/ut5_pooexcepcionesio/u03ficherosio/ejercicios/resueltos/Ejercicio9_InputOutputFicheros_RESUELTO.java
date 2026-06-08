package ev2.ut5_pooexcepcionesio.u03ficherosio.ejercicios.resueltos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Ejercicio 9: Validar existencia de JPG antes de copiar
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio9_InputOutputFicheros_RESUELTO {
    public static void main(String[] args) {
        String basePath = "src/ev2/ut4_colecciones/inputoutputficheros";
        File origen = new File(basePath + "/imagen_origen.jpg");
        if (!origen.exists()) {
            System.out.println("No existe imagen_origen.jpg");
            return;
        }
        byte[] buffer = new byte[4096];
        try (FileInputStream fis = new FileInputStream(origen);
             FileOutputStream fos = new FileOutputStream(basePath + "/imagen_copia3.jpg")) {
            int leidos;
            while ((leidos = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, leidos);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
