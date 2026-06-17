package ev2.ut4_colecciones.u02arraylistymapas.teoria;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Operaciones y recorridos de {@link HashSet}: eliminar, unir conjuntos y recorrer elementos unicos.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U09_SetOperacionesYRecorridos {

	public static void main(String[] args) {

		HashSet<String> grupoA = new HashSet<>();
		grupoA.add("Ana");
		grupoA.add("Luis");
		grupoA.add("Marta");

		/*
		 * remove(elemento) elimina un dato del conjunto.
		 * Devuelve true si existia y se elimino.
		 */
		boolean eliminado = grupoA.remove("Luis");
		System.out.println("Se elimino a Luis? " + eliminado);
		System.out.println("Tras remove: " + grupoA);

		/*
		 * addAll(otroSet) une dos conjuntos sin repetir elementos.
		 */
		HashSet<String> grupoB = new HashSet<>();
		grupoB.add("Marta");
		grupoB.add("Pedro");

		grupoA.addAll(grupoB);
		System.out.println("Union de grupos: " + grupoA);

		/*
		 * Recorrido con for-each: igual que en ArrayList, pero cada valor aparece una sola vez.
		 */
		System.out.println("--- Recorrido for-each ---");
		for (String alumno : grupoA) {
			System.out.println("Alumno: " + alumno);
		}

		/*
		 * Uso tipico: eliminar duplicados de una lista pasandola a un Set.
		 *
		 * Lista original => [1, 2, 2, 3, 1, 4]
		 * Set resultante => {1, 2, 3, 4}
		 */
		ArrayList<Integer> numerosConRepetidos = new ArrayList<>();
		numerosConRepetidos.add(1);
		numerosConRepetidos.add(2);
		numerosConRepetidos.add(2);
		numerosConRepetidos.add(3);
		numerosConRepetidos.add(1);
		numerosConRepetidos.add(4);

		HashSet<Integer> unicos = new HashSet<>(numerosConRepetidos);
		System.out.println("Lista con repetidos: " + numerosConRepetidos);
		System.out.println("Sin duplicados (Set): " + unicos);

		/*
		 * clear() vacia el conjunto por completo.
		 */
		grupoB.clear();
		System.out.println("grupoB tras clear: " + grupoB + " (vacio? " + grupoB.isEmpty() + ")");
	}
}
