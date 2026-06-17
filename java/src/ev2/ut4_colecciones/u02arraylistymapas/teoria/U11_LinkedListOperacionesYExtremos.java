package ev2.ut4_colecciones.u02arraylistymapas.teoria;

import java.util.LinkedList;

/**
 * Operaciones en los extremos de {@link LinkedList}: cola doble (inicio y final).
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U11_LinkedListOperacionesYExtremos {

	public static void main(String[] args) {

		LinkedList<Integer> turnos = new LinkedList<>();
		turnos.add(10);
		turnos.add(20);
		turnos.add(30);

		/*
		 * addFirst(valor) inserta al inicio de la lista.
		 *
		 * Antes     => [10][20][30]
		 * Despues   => [5][10][20][30]
		 */
		turnos.addFirst(5);
		System.out.println("Tras addFirst(5): " + turnos);

		/*
		 * addLast(valor) anade al final (equivalente a add).
		 */
		turnos.addLast(40);
		System.out.println("Tras addLast(40): " + turnos);

		/*
		 * getFirst() y getLast() leen el primer y el ultimo elemento sin eliminarlos.
		 */
		System.out.println("Primero: " + turnos.getFirst());
		System.out.println("Ultimo: " + turnos.getLast());

		/*
		 * removeFirst() y removeLast() eliminan y devuelven el extremo correspondiente.
		 *
		 * Antes     => [5][10][20][30][40]
		 * Despues   => [10][20][30]   (se quitan 5 y 40)
		 */
		int eliminadoInicio = turnos.removeFirst();
		int eliminadoFinal = turnos.removeLast();
		System.out.println("Eliminados: " + eliminadoInicio + " y " + eliminadoFinal);
		System.out.println("Lista actual: " + turnos);

		/*
		 * Uso tipico como cola (FIFO): quien entra por el final sale por el inicio.
		 *
		 * Llegan turnos 100, 101, 102  =>  [100][101][102]
		 * Atiendo el primero (removeFirst) => queda [101][102]
		 */
		LinkedList<String> cola = new LinkedList<>();
		cola.addLast("Cliente A");
		cola.addLast("Cliente B");
		cola.addLast("Cliente C");

		System.out.println("--- Cola FIFO ---");
		while (!cola.isEmpty()) {
			String atendido = cola.removeFirst();
			System.out.println("Atendiendo: " + atendido + " | Restantes: " + cola);
		}
	}
}
