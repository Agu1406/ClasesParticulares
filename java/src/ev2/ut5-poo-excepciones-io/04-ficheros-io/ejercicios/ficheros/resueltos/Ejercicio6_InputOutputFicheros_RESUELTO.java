package general.inputoutputficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Ejercicio 6: Contar líneas de un TXT
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio6_InputOutputFicheros_RESUELTO {
    public static void main(String[] args) {
        String basePath = "src/ev2/ut4/inputoutputficheros";
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(basePath + "/salida2.txt"))) {
            while (br.readLine() != null) {
                contador++;
            }
            System.out.println("Líneas: " + contador);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
