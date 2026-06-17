package ev2.ut4_colecciones.u02arraylistymapas.teoria;

import java.util.ArrayList;

/**
 * Recorridos de {@link ArrayList} con indice y busqueda del mayor valor.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U03_ArrayListRecorridos {

	public static void main(String[] args) {

		ArrayList<Integer> numeros = new ArrayList<>();
		numeros.add(14);
		numeros.add(7);
		numeros.add(23);
		numeros.add(5);

		/*
		 * Recorrido con for clasico: de 0 hasta size() - 1.
		 * Util cuando necesitamos el indice o modificar mientras recorremos.
		 */
		System.out.println("Recorrido con indice:");
		for (int i = 0; i < numeros.size(); i++) {
			System.out.println("Posicion " + i + " -> " + numeros.get(i));
		}

		/*
		 * Buscar el mayor recorriendo la lista.
		 * Empezamos asumiendo que el primero es el mayor y vamos comparando.
		 */
		int mayor = numeros.get(0);
		for (int i = 1; i < numeros.size(); i++) {
			if (numeros.get(i) > mayor) {
				mayor = numeros.get(i);
			}
		}
		System.out.println("Mayor valor: " + mayor);

		/*
		 * Crear una segunda lista solo con los valores mayores que un umbral.
		 * Patron habitual: lista original + lista filtrada nueva.
		 */
		ArrayList<Integer> mayoresQueDiez = new ArrayList<>();
		for (int n : numeros) {
			if (n > 10) {
				mayoresQueDiez.add(n);
			}
		}
		System.out.println("Mayores que 10: " + mayoresQueDiez);
	}
}
