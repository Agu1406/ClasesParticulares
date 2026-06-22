package recuperacionordinaria.internorecuperacionordinaria.pendiente.ejercicio_04_rachas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Datos de prueba. Implementa los métodos en esta clase o en una auxiliar.
 */
public class Torneo {

	public static Map<String, List<Integer>> crearDatosPrueba() {
		Map<String, List<Integer>> torneo = new HashMap<>();
		torneo.put("Leones", List.of(10, 5, 8, 12));
		torneo.put("Tiburones", List.of(10, -5, 20, 15, -2, 30));
		torneo.put("Halcones", List.of(3, 0, 7));
		torneo.put("Lobos", List.of(4, 6, 1));
		return torneo;
	}

	// TODO Apartado A: Set<String> equiposInvictos(Map<...> torneo)

	// TODO Apartado B: int calcularMejorRacha(List<Integer> partidas)

	// TODO Apartado C: Map<String, Integer> mejoresRachasPorEquipo(Map<...> torneo)

	public static void main(String[] args) {
		Map<String, List<Integer>> torneo = crearDatosPrueba();
		// TODO: probar tus métodos
	}
}
