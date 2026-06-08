package ev2.ut5_pooexcepcionesio.u03ficherosio.ejercicios.resueltos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Ejercicio 1: Crear un TXT y escribir una linea
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio1_InputOutputFicheros_RESUELTO {
    public static void main(String[] args) {
        String basePath = "src/ev2/ut4_colecciones/inputoutputficheros";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(basePath + "/salida1.txt"))) {
            bw.write("Hola fichero");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
