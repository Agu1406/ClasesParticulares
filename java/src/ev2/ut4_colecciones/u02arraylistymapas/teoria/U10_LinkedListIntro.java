package ev2.ut4_colecciones.u02arraylistymapas.teoria;

import java.util.LinkedList;

/**
 * Clase introductoria a {@link LinkedList}: lista enlazada con la misma interfaz que {@link java.util.ArrayList}.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U10_LinkedListIntro {

	public static void main(String[] args) {

		/*
		 * LinkedList tambien es una lista con indices, como ArrayList.
		 * Internamente cada elemento apunta al siguiente (lista enlazada).
		 *
		 * Sintaxis: LinkedList<Tipo> nombre = new LinkedList<>();
		 *
		 * Indice    => [0][1][2]...
		 * Enlaces   => A -> B -> C -> null
		 */
		LinkedList<String> ciudades = new LinkedList<>();

		/*
		 * add(valor) anade al final, igual que en ArrayList.
		 *
		 * Indice    => [0][1][2]
		 * Valores   => [Madrid][Barcelona][Sevilla]
		 */
		ciudades.add("Madrid");
		ciudades.add("Barcelona");
		ciudades.add("Sevilla");

		System.out.println("Lista: " + ciudades);
		System.out.println("Tamano: " + ciudades.size());

		/*
		 * get(indice) y set(indice, valor) funcionan igual que en ArrayList.
		 */
		System.out.println("Segunda ciudad: " + ciudades.get(1));
		ciudades.set(1, "Valencia");
		System.out.println("Tras set(1, Valencia): " + ciudades);

		/*
		 * Recorrido con for-each: identico al de ArrayList.
		 */
		System.out.println("--- Recorrido for-each ---");
		for (String ciudad : ciudades) {
			System.out.println("Ciudad: " + ciudad);
		}

		/*
		 * Cuando usar LinkedList frente a ArrayList (idea general en DAM):
		 *   - ArrayList: acceso rapido por indice (get).
		 *   - LinkedList: inserciones y borrados frecuentes al inicio o al final.
		 */
	}
}
