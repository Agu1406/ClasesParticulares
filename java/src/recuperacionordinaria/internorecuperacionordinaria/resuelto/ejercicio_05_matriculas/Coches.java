package recuperacionordinaria.internorecuperacionordinaria.resuelto.ejercicio_05_matriculas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Clase de prueba — Ejercicio 5 recuperación ordinaria.
 */
public class Coches {

	public static List<String> crearLecturasPrueba() {
		List<String> lecturas = new ArrayList<>();
		lecturas.add("1234ABC");
		lecturas.add("5678XYZ");
		lecturas.add("1234ABC"); // duplicado
		lecturas.add("12AB567"); // inválida
		lecturas.add("9012BCD");
		lecturas.add("3456abc"); // inválida (minúsculas)
		lecturas.add("7890XYZ");
		lecturas.add("1111AAA");
		return lecturas;
	}

	public static void main(String[] args) {
		List<String> sinDuplicados = GestionMatriculas.eliminarDuplicados(crearLecturasPrueba());
		System.out.println("Sin duplicados: " + sinDuplicados);

		System.out.println("\nValidación:");
		for (String m : sinDuplicados) {
			System.out.println(m + " -> " + GestionMatriculas.esMatriculaValida(m));
		}

		System.out.println("\nAgrupación por última letra:");
		Map<Character, List<String>> agrupadas = GestionMatriculas.agruparPorUltimaLetra(sinDuplicados);
		agrupadas.forEach((letra, lista) -> System.out.println(letra + " -> " + lista));
	}
}
