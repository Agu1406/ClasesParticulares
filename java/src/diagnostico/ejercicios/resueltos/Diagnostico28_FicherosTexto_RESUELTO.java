package diagnostico.ejercicios.resueltos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Lectura y escritura de ficheros de texto
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que escriba y lea lineas de texto en un fichero temporal.</li>
 * <li>Completa leerLineas(Path archivo) y escribirLineas(Path archivo, List<String> lineas) con Files de NIO.</li>
 * <li>En el main, lee lineas con Scanner teclado (vacia para terminar), escribelas en un fichero temporal y vuelve a leerlas.</li>
 * </ul>
 *
 * <p>Diagnostico 28 — EV2 · ut5_pooexcepcionesio · RA5.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico28_FicherosTexto_RESUELTO {

    public static List<String> leerLineas(Path archivo) throws IOException {
        return Files.readAllLines(archivo);
    }

    public static void escribirLineas(Path archivo, List<String> lineas) throws IOException {
        Files.write(archivo, lineas);
    }
    public static void main(String[] args) throws IOException {
        Scanner teclado;
        List<String> lineas;
        String linea;
        Path archivo;
        List<String> leidas;
        teclado = new Scanner(System.in);
        System.out.println("Lineas de texto (vacia para terminar):");
        linea = teclado.nextLine();
        lineas = new ArrayList<>();
        while (!linea.isEmpty()) {
            lineas.add(linea);
            linea = teclado.nextLine();
        }
        archivo = Files.createTempFile("diag28", ".txt");
        escribirLineas(archivo, lineas);
        leidas = leerLineas(archivo);
        System.out.println("Contenido leido: " + leidas);
        Files.deleteIfExists(archivo);
        teclado.close();
    }
}
