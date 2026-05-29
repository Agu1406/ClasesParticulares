package general.inputoutputficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Ejercicio 10: Crear reporte TXT tras copiar JPG
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio10_InputOutputFicheros_RESUELTO {
    public static void main(String[] args) {
        String basePath = "src/ev2/ut4/inputoutputficheros";
        File copia = new File(basePath + "/imagen_copia3.jpg");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(basePath + "/reporte_copia.txt"))) {
            bw.write("Nombre: " + copia.getName());
            bw.newLine();
            bw.write("Tamaño bytes: " + copia.length());
            bw.newLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
