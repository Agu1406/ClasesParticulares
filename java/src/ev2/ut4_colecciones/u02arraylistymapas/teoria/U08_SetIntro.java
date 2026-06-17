package ev2.ut4_colecciones.u02arraylistymapas.teoria;

import java.util.HashSet;

/**
 * Clase introductoria a los conjuntos ({@link HashSet}): elementos unicos, sin repeticiones.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U08_SetIntro {

	public static void main(String[] args) {

		/*
		 * Un Set guarda elementos SIN repetir.
		 * Si intentas anadir un dato que ya existe, el conjunto no cambia.
		 *
		 * A diferencia de ArrayList:
		 *   - No hay indices (no existe get(0)).
		 *   - No importa cuantas veces insertes el mismo valor.
		 *
		 * Sintaxis: HashSet<Tipo> nombre = new HashSet<>();
		 */
		HashSet<String> lenguajes = new HashSet<>();

		/*
		 * add(elemento) inserta un valor nuevo.
		 * Si el valor ya estaba, devuelve false y no lo duplica.
		 *
		 * Contenido => { Java, Python, C }
		 */
		lenguajes.add("Java");
		lenguajes.add("Python");
		lenguajes.add("C");
		lenguajes.add("Java"); // repetido: se ignora

		System.out.println("Conjunto: " + lenguajes);
		System.out.println("Tamano real (sin duplicados): " + lenguajes.size());

		/*
		 * contains(elemento) comprueba si ese dato esta en el conjunto.
		 */
		System.out.println("Contiene Java? " + lenguajes.contains("Java"));
		System.out.println("Contiene Kotlin? " + lenguajes.contains("Kotlin"));

		/*
		 * isEmpty() indica si no hay ningun elemento.
		 */
		HashSet<Integer> vacio = new HashSet<>();
		System.out.println("Conjunto vacio? " + vacio.isEmpty());
	}
}
