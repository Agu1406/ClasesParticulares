package ev2.ut5_pooexcepcionesio.u03ficherosio.ejercicios.resueltos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Ejercicio 5: Copiar contenido de un TXT a otro
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio5_InputOutputFicheros_RESUELTO {
    public static void main(String[] args) {
        String basePath = "src/ev2/ut4_colecciones/inputoutputficheros";
        try (BufferedReader br = new BufferedReader(new FileReader(basePath + "/salida2.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter(basePath + "/copia.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
