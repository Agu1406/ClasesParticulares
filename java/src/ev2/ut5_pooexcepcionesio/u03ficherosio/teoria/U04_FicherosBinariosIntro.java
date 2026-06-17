package ev2.ut5_pooexcepcionesio.u03ficherosio.teoria;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Teoria: ficheros binarios — crear, leer y borrar.
 *
 * <p><b>Objetivo:</b> trabajar con bytes en bruto (imagenes, copias, datos primitivos)
 * usando {@code FileInputStream}, {@code FileOutputStream}, {@code DataInputStream}
 * y {@code DataOutputStream}.</p>
 *
 * <p>Conceptos previos: {@link U01_FicherosIntro}. Objeto: {@link U03_FicherosObjetoIntro}.</p>
 *
 * <p><b>Diferencia con texto y objeto:</b></p>
 * <ul>
 *   <li><b>Texto</b> — caracteres legibles ({@code readLine()}).</li>
 *   <li><b>Objeto</b> — serializacion de instancias Java ({@code writeObject()}).</li>
 *   <li><b>Binario</b> — secuencia de bytes; no se lee con {@code readLine()}.</li>
 * </ul>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U04_FicherosBinariosIntro {

	private static final String CARPETA_DEMO =
			"src/ev2/ut5_pooexcepcionesio/u03ficherosio/teoria/datos_demo";
	private static final String FICHERO_DATOS = CARPETA_DEMO + "/demo_datos.bin";
	private static final String FICHERO_COPIA = CARPETA_DEMO + "/demo_copia.bin";

	public static void main(String[] args) {
		System.out.println("=== FICHEROS BINARIOS ===\n");

		crearCarpetaDemo();
		escribirDatosPrimitivos();
		leerDatosPrimitivos();
		copiarConBuffer();
		borrar();
	}

	private static void crearCarpetaDemo() {
		try {
			Files.createDirectories(Path.of(CARPETA_DEMO));
		} catch (IOException e) {
			System.out.println("No se pudo crear la carpeta demo: " + e.getMessage());
		}
	}

	private static void escribirDatosPrimitivos() {
		System.out.println("1) CREAR fichero binario con tipos primitivos");
		/*
		 * DataOutputStream escribe int, double, boolean, String (UTF)...
		 * en formato binario. No es un .txt legible.
		 */
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FICHERO_DATOS))) {
			dos.writeInt(42);
			dos.writeDouble(3.14);
			dos.writeBoolean(true);
			dos.writeUTF("Java binario");
			System.out.println("   Datos escritos en: " + FICHERO_DATOS);
		} catch (IOException e) {
			System.out.println("   Error al escribir: " + e.getMessage());
		}
		System.out.println();
	}

	private static void leerDatosPrimitivos() {
		System.out.println("2) LEER datos binarios (mismo orden que al escribir)");
		try (DataInputStream dis = new DataInputStream(new FileInputStream(FICHERO_DATOS))) {
			int entero = dis.readInt();
			double decimal = dis.readDouble();
			boolean activo = dis.readBoolean();
			String texto = dis.readUTF();
			System.out.println("   int: " + entero);
			System.out.println("   double: " + decimal);
			System.out.println("   boolean: " + activo);
			System.out.println("   String UTF: " + texto);
		} catch (IOException e) {
			System.out.println("   Error al leer: " + e.getMessage());
		}
		System.out.println();
	}

	private static void copiarConBuffer() {
		System.out.println("3) COPIAR bytes (como una imagen .jpg en ejercicios 7-9)");
		/*
		 * Para ficheros que no son texto ni objetos Java (imagenes, audio, PDF...)
		 * se copian byte a byte o con un buffer byte[].
		 * read() devuelve -1 cuando no quedan bytes.
		 */
		byte[] buffer = new byte[1024];
		try (FileInputStream fis = new FileInputStream(FICHERO_DATOS);
			 FileOutputStream fos = new FileOutputStream(FICHERO_COPIA)) {
			int leidos;
			while ((leidos = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, leidos);
			}
			File copia = new File(FICHERO_COPIA);
			System.out.println("   Copia creada: " + FICHERO_COPIA);
			System.out.println("   Tamano bytes: " + copia.length());
		} catch (IOException e) {
			System.out.println("   Error al copiar: " + e.getMessage());
		}
		System.out.println();
	}

	private static void borrar() {
		System.out.println("4) BORRAR ficheros binarios");
		borrarSiExiste(FICHERO_DATOS);
		borrarSiExiste(FICHERO_COPIA);
	}

	private static void borrarSiExiste(String ruta) {
		File fichero = new File(ruta);
		if (fichero.exists() && fichero.delete()) {
			System.out.println("   Borrado: " + ruta);
		}
	}
}
