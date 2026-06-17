package ev2.ut5_pooexcepcionesio.u03ficherosio.teoria;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Teoria: conceptos base de ficheros e I/O en Java (RA5).
 *
 * <p><b>Objetivo:</b> entender que es un fichero, como se representa una ruta,
 * que son los streams, por que se usa {@code try-with-resources} y que tipos
 * de fichero existen antes de entrar en texto, objeto y binario.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U01_FicherosIntro {

	private static final String CARPETA_DEMO =
			"src/ev2/ut5_pooexcepcionesio/u03ficherosio/teoria/datos_demo";
	private static final String FICHERO_PRUEBA = CARPETA_DEMO + "/conceptos_prueba.txt";

	public static void main(String[] args) {
		System.out.println("=== FICHEROS: CONCEPTOS BASE ===\n");

		explicarPersistencia();
		consultarRutaConFile();
		consultarRutaConPath();
		demostrarTryWithResources();
		resumirTiposDeFichero();
	}

	private static void explicarPersistencia() {
		System.out.println("1) QUE ES UN FICHERO Y PARA QUE SIRVE");
		/*
		 * Hasta ahora las variables viven en la RAM: al cerrar el programa, se pierden.
		 * Un fichero guarda datos en disco de forma persistente.
		 *
		 * Entrada (input)  -> leer del fichero hacia el programa.
		 * Salida (output)  -> escribir del programa hacia el fichero.
		 *
		 * En Java el paquete principal es java.io (y java.nio.file para rutas modernas).
		 */
		System.out.println("   Los datos en variables se pierden al terminar el programa.");
		System.out.println("   Un fichero permite guardar y recuperar informacion en disco.");
		System.out.println("   I/O = Input/Output (entrada y salida de datos).");
		System.out.println();
	}

	private static void consultarRutaConFile() {
		System.out.println("2) RUTA Y CLASE File");
		/*
		 * La ruta es un String. Puede ser relativa al directorio desde el que ejecutas
		 * el programa (en el IDE suele ser la raiz del proyecto java/).
		 *
		 * File NO lee ni escribe contenido: representa un fichero o carpeta en disco
		 * y permite consultar exists(), length(), getName(), delete()...
		 */
		File fichero = new File(FICHERO_PRUEBA);
		File carpeta = new File(CARPETA_DEMO);

		System.out.println("   Ruta relativa: " + FICHERO_PRUEBA);
		System.out.println("   Existe el fichero? " + fichero.exists());
		System.out.println("   Nombre: " + fichero.getName());
		System.out.println("   Es directorio la carpeta? " + carpeta.isDirectory());
		System.out.println("   Ruta absoluta: " + fichero.getAbsolutePath());
		System.out.println();
	}

	private static void consultarRutaConPath() {
		System.out.println("3) CLASE Path Y Files (NIO)");
		/*
		 * Path.of(ruta) es la forma moderna de trabajar con rutas.
		 * Files ofrece utilidades: crear carpetas, borrar, leer todo el fichero...
		 */
		Path carpeta = Path.of(CARPETA_DEMO);
		Path fichero = Path.of(FICHERO_PRUEBA);

		try {
			Files.createDirectories(carpeta);
			System.out.println("   Carpeta creada o ya existente: " + carpeta);
			System.out.println("   Existe? " + Files.exists(fichero));
		} catch (IOException e) {
			System.out.println("   Error con Path/Files: " + e.getMessage());
		}
		System.out.println();
	}

	private static void demostrarTryWithResources() {
		System.out.println("4) STREAMS, IOException Y try-with-resources");
		/*
		 * Al leer/escribir se abre un canal (stream) con el disco.
		 * Ese canal debe CERRARSE siempre, haya error o no.
		 *
		 * try (recurso) { ... } cierra automaticamente al salir del bloque.
		 * Las operaciones de I/O lanzan IOException: hay que capturarla o declarar throws.
		 */
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO_PRUEBA))) {
			bw.write("Dato de prueba para conceptos");
			System.out.println("   Fichero escrito con try-with-resources.");
		} catch (IOException e) {
			System.out.println("   IOException capturada: " + e.getMessage());
		}

		File creado = new File(FICHERO_PRUEBA);
		if (creado.exists()) {
			System.out.println("   Tamano en bytes: " + creado.length());
			creado.delete();
			System.out.println("   Fichero de prueba borrado.");
		}
		System.out.println();
	}

	private static void resumirTiposDeFichero() {
		System.out.println("5) TIPOS DE FICHERO EN ESTE SUBTEMA");
		/*
		 * Texto   -> caracteres legibles (.txt). Clases: FileWriter, BufferedReader...
		 * Objeto  -> instancias Java serializadas (.obj). Clases: ObjectOutputStream...
		 * Binario -> bytes en bruto (.jpg, .bin). Clases: FileInputStream, DataOutputStream...
		 *
		 * Cada tipo se practica en su clase de teoria (U02, U03, U04).
		 */
		System.out.println("   TEXTO   -> humanos pueden leerlo. Ej: logs, listas, CSV simple.");
		System.out.println("            Clases: FileWriter, BufferedWriter, FileReader, BufferedReader");
		System.out.println();
		System.out.println("   OBJETO  -> guardas un objeto Java entero (serializacion).");
		System.out.println("            Clases: ObjectOutputStream, ObjectInputStream + Serializable");
		System.out.println();
		System.out.println("   BINARIO -> secuencia de bytes (imagenes, audio, datos primitivos).");
		System.out.println("            Clases: FileInputStream, FileOutputStream, DataInputStream...");
	}
}
