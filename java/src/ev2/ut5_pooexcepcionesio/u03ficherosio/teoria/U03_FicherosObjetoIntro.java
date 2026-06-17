package ev2.ut5_pooexcepcionesio.u03ficherosio.teoria;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Teoria: ficheros de objeto — crear, leer, modificar y borrar.
 *
 * <p><b>Objetivo:</b> guardar un objeto Java en disco con {@code ObjectOutputStream},
 * recuperarlo con {@code ObjectInputStream}, actualizarlo y eliminar el fichero.</p>
 *
 * <p>Conceptos previos: {@link U01_FicherosIntro}. Texto: {@link U02_FicherosTextoIntro}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U03_FicherosObjetoIntro {

	private static final String CARPETA_DEMO =
			"src/ev2/ut5_pooexcepcionesio/u03ficherosio/teoria/datos_demo";
	private static final String FICHERO = CARPETA_DEMO + "/demo_alumno.obj";

	public static void main(String[] args) {
		System.out.println("=== FICHEROS DE OBJETO (SERIALIZACION) ===\n");

		crearCarpetaDemo();
		AlumnoDemo original = new AlumnoDemo("Laura", 17, "1DAW");
		escribirObjeto(original);
		leerObjeto("2) LEER objeto recien guardado");
		modificarObjeto();
		leerObjeto("4) LEER objeto tras modificar");
		borrarFichero();
	}

	private static void crearCarpetaDemo() {
		try {
			Files.createDirectories(Path.of(CARPETA_DEMO));
		} catch (IOException e) {
			System.out.println("No se pudo crear la carpeta demo: " + e.getMessage());
		}
	}

	private static void escribirObjeto(AlumnoDemo alumno) {
		System.out.println("1) CREAR fichero y GUARDAR objeto");
		/*
		 * La clase debe implementar Serializable.
		 * ObjectOutputStream escribe el objeto en formato binario propio de Java.
		 * Si el fichero ya existe, writeObject lo SOBRESCRIBE por completo.
		 */
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
			oos.writeObject(alumno);
			System.out.println("   Objeto guardado: " + alumno);
			System.out.println("   Ruta: " + FICHERO);
		} catch (IOException e) {
			System.out.println("   Error al escribir objeto: " + e.getMessage());
		}
		System.out.println();
	}

	private static void leerObjeto(String titulo) {
		System.out.println(titulo);
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))) {
			/*
			 * readObject() devuelve Object: hay que hacer cast al tipo real.
			 * Puede lanzar ClassNotFoundException si la clase no existe en el classpath.
			 */
			AlumnoDemo recuperado = (AlumnoDemo) ois.readObject();
			System.out.println("   Objeto leido: " + recuperado);
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("   Error al leer objeto: " + e.getMessage());
		}
		System.out.println();
	}

	private static void modificarObjeto() {
		System.out.println("3) MODIFICAR objeto (leer -> cambiar -> volver a guardar)");
		/*
		 * No se puede editar un .obj linea a linea como un .txt.
		 * El flujo es: deserializar, cambiar el objeto en memoria y serializar de nuevo.
		 * El segundo writeObject sustituye todo el contenido anterior del fichero.
		 */
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))) {
			AlumnoDemo alumno = (AlumnoDemo) ois.readObject();
			System.out.println("   Antes de modificar: " + alumno);

			alumno.setEdad(18);
			alumno.setCurso("2DAW");

			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
				oos.writeObject(alumno);
			}
			System.out.println("   Despues de modificar y guardar: " + alumno);
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("   Error al modificar: " + e.getMessage());
		}
		System.out.println();
	}

	private static void borrarFichero() {
		System.out.println("5) BORRAR el fichero de objeto");
		/*
		 * Borrar el fichero elimina el objeto del disco.
		 * No queda rastro del objeto hasta que vuelvas a serializarlo.
		 */
		File fichero = new File(FICHERO);
		if (fichero.exists() && fichero.delete()) {
			System.out.println("   Fichero borrado: " + FICHERO);
		} else {
			System.out.println("   No se pudo borrar (o no existia).");
		}
	}

	/*
	 * Clase serializable de ejemplo.
	 * serialVersionUID identifica la version del objeto guardado en disco.
	 * Los campos transient NO se guardan al serializar.
	 */
	static class AlumnoDemo implements Serializable {

		private static final long serialVersionUID = 1L;

		private String nombre;
		private int edad;
		private String curso;
		private transient int intentosLogin;

		AlumnoDemo(String nombre, int edad, String curso) {
			this.nombre = nombre;
			this.edad = edad;
			this.curso = curso;
			this.intentosLogin = 0;
		}

		void setEdad(int edad) {
			this.edad = edad;
		}

		void setCurso(String curso) {
			this.curso = curso;
		}

		@Override
		public String toString() {
			return "AlumnoDemo{nombre='" + nombre + "', edad=" + edad
					+ ", curso='" + curso + "', intentosLogin=" + intentosLogin + " (transient)}";
		}
	}
}
