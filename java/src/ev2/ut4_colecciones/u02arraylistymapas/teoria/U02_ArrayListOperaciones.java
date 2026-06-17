package ev2.ut4_colecciones.u02arraylistymapas.teoria;

import java.util.ArrayList;

/**
 * Operaciones habituales sobre {@link ArrayList}: insertar, eliminar y comprobar contenido.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U02_ArrayListOperaciones {

	public static void main(String[] args) {

		ArrayList<String> nombres = new ArrayList<>();
		nombres.add("Ana");
		nombres.add("Luis");
		nombres.add("Marta");

		/*
		 * add(indice, valor) inserta en una posicion concreta.
		 * Los elementos a partir de ese indice se desplazan a la derecha.
		 *
		 * Antes     => [Ana][Luis][Marta]
		 * Despues   => [Ana][Pedro][Luis][Marta]
		 */
		nombres.add(1, "Pedro");
		System.out.println("Tras insertar en posicion 1: " + nombres);

		/*
		 * contains(valor) indica si ese dato esta en la lista.
		 * isEmpty() indica si la lista no tiene elementos.
		 */
		System.out.println("Contiene a Luis? " + nombres.contains("Luis"));
		System.out.println("Esta vacia? " + nombres.isEmpty());

		/*
		 * remove(indice) elimina por posicion.
		 *
		 * Antes     => [Ana][Pedro][Luis][Marta]
		 * Despues   => [Ana][Pedro][Marta]   (se elimina Luis en indice 2)
		 */
		nombres.remove(2);
		System.out.println("Tras remove(2): " + nombres);

		/*
		 * remove(valor) elimina la primera coincidencia por valor.
		 */
		nombres.remove("Pedro");
		System.out.println("Tras remove(\"Pedro\"): " + nombres);

		/*
		 * clear() vacia toda la lista.
		 */
		nombres.clear();
		System.out.println("Tamano tras clear(): " + nombres.size());
	}
}
