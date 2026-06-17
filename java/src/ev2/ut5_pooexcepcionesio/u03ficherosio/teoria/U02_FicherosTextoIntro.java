package ev2.ut5_pooexcepcionesio.u03ficherosio.teoria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Teoria: ficheros de texto — crear, leer y borrar.
 *
 * <p><b>Objetivo:</b> trabajar con archivos legibles por humanos (`.txt`) usando
 * {@code FileWriter}, {@code BufferedWriter}, {@code FileReader} y {@code BufferedReader}.</p>
 *
 * <p>Conceptos previos: {@link U01_FicherosIntro}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U02_FicherosTextoIntro {

	private static final String CARPETA_DEMO =
			"src/ev2/ut5_pooexcepcionesio/u03ficherosio/teoria/datos_demo";
	private static final String FICHERO = CARPETA_DEMO + "/demo_texto.txt";

	public static void main(String[] args) {
		System.out.println("=== FICHEROS DE TEXTO ===\n");

		crearCarpetaDemo();
		crearYEscribir();
		anadirLinea();
		leer();
		borrar();
	}

	private static void crearCarpetaDemo() {
		try {
			Files.createDirectories(Path.of(CARPETA_DEMO));
		} catch (IOException e) {
			System.out.println("No se pudo crear la carpeta demo: " + e.getMessage());
		}
	}

	private static void crearYEscribir() {
		System.out.println("1) CREAR y ESCRIBIR (sobrescribe si el fichero ya existe)");
		/*
		 * FileWriter abre el fichero para escribir caracteres.
		 * BufferedWriter mejora el rendimiento y ofrece newLine().
		 * try-with-resources cierra el fichero automaticamente al salir del bloque.
		 */
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO))) {
			bw.write("Linea 1: Hola");
			bw.newLine();
			bw.write("Linea 2: Fichero de texto en Java");
			bw.newLine();
			bw.write("Linea 3: RA5 - entrada/salida");
			System.out.println("   Escritura completada en: " + FICHERO);
		} catch (IOException e) {
			System.out.println("   Error al escribir: " + e.getMessage());
		}
		System.out.println();
	}

	private static void anadirLinea() {
		System.out.println("2) ANADIR al final (append = true)");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO, true))) {
			bw.newLine();
			bw.write("Linea 4: anadida con append");
			System.out.println("   Linea anadida.");
		} catch (IOException e) {
			System.out.println("   Error al anadir: " + e.getMessage());
		}
		System.out.println();
	}

	private static void leer() {
		System.out.println("3) LEER linea a linea");
		/*
		 * readLine() devuelve null cuando no quedan mas lineas.
		 * El while clasico de los ejercicios 4, 5 y 6 del subtema.
		 */
		try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println("   " + linea);
			}
		} catch (IOException e) {
			System.out.println("   Error al leer: " + e.getMessage());
		}
		System.out.println();
	}

	private static void borrar() {
		System.out.println("4) BORRAR el fichero");
		File fichero = new File(FICHERO);
		/*
		 * delete() devuelve true si el fichero existia y se elimino.
		 * Alternativa moderna: Files.deleteIfExists(Path.of(FICHERO))
		 */
		if (fichero.exists() && fichero.delete()) {
			System.out.println("   Fichero borrado: " + FICHERO);
		} else {
			System.out.println("   No se pudo borrar (o no existia).");
		}
	}
}
