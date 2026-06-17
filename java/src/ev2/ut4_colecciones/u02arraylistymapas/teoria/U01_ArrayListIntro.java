package ev2.ut4_colecciones.u02arraylistymapas.teoria;

import java.util.ArrayList;

/**
 * Clase introductoria a {@link ArrayList}: listas dinamicas que crecen y se reducen en ejecucion.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U01_ArrayListIntro {

	public static void main(String[] args) {

		/*
		 * A diferencia de un array, ArrayList no tiene tamano fijo.
		 * Sintaxis: ArrayList<Tipo> nombre = new ArrayList<>();
		 *
		 * Indice    => [0][1][2]...
		 * Valores   => (vacia al crear)
		 */
		ArrayList<Integer> numeros = new ArrayList<>();

		/*
		 * add(valor) anade al final de la lista.
		 *
		 * Indice    => [0][1][2]
		 * Valores   => [10][20][30]
		 */
		numeros.add(10);
		numeros.add(20);
		numeros.add(30);

		/*
		 * size() devuelve cuantos elementos hay (no el ultimo indice).
		 * get(indice) lee el valor de una posicion, igual que en un array.
		 */
		System.out.println("Tamano: " + numeros.size());
		System.out.println("Primer elemento: " + numeros.get(0));

		/*
		 * set(indice, valor) sustituye el dato que habia en esa posicion.
		 *
		 * Antes     => [10][20][30]
		 * Despues   => [10][99][30]
		 */
		numeros.set(1, 99);
		System.out.println("Tras set(1, 99): " + numeros);

		/*
		 * Recorrido con for-each: recorre cada elemento sin usar el indice.
		 */
		System.out.println("Recorrido for-each:");
		for (int n : numeros) {
			System.out.println("Valor: " + n);
		}
	}
}
