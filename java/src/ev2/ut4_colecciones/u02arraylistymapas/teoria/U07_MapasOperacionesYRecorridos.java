package ev2.ut4_colecciones.u02arraylistymapas.teoria;

import java.util.HashMap;
import java.util.Map;

/**
 * Operaciones y recorridos de {@link HashMap}: actualizar, eliminar y recorrer pares clave-valor.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U07_MapasOperacionesYRecorridos {

	public static void main(String[] args) {

		HashMap<String, Double> notas = new HashMap<>();
		notas.put("Ana", 7.5);
		notas.put("Luis", 4.0);
		notas.put("Marta", 8.5);

		/*
		 * put sobre una clave que ya existe sustituye el valor anterior.
		 *
		 * Antes     => Luis -> 4.0
		 * Despues   => Luis -> 6.0
		 */
		notas.put("Luis", 6.0);
		System.out.println("Nota actualizada de Luis: " + notas.get("Luis"));

		/*
		 * remove(clave) elimina el par completo del mapa.
		 */
		notas.remove("Luis");
		System.out.println("Tras eliminar a Luis: " + notas);

		/*
		 * Recorrido con entrySet(): accedemos a cada par clave y valor.
		 * Es la forma mas habitual cuando necesitamos los dos datos.
		 */
		System.out.println("--- Todos los pares (entrySet) ---");
		for (Map.Entry<String, Double> entrada : notas.entrySet()) {
			System.out.println(entrada.getKey() + " -> " + entrada.getValue());
		}

		/*
		 * keySet() devuelve solo las claves.
		 * values() devuelve solo los valores.
		 */
		System.out.println("Claves: " + notas.keySet());
		System.out.println("Valores: " + notas.values());

		/*
		 * Recorrer solo claves para sumar todas las notas.
		 */
		double suma = 0;
		for (String alumno : notas.keySet()) {
			suma += notas.get(alumno);
		}
		System.out.println("Suma de notas: " + suma);
	}
}
