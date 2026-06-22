package recuperacionordinaria.internorecuperacionordinaria.resuelto.ejercicio_04_rachas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Clase de prueba — Ejercicio 4 recuperación ordinaria.
 */
public class Torneo {

	public static Map<String, List<Integer>> crearDatosPrueba() {
		Map<String, List<Integer>> torneo = new HashMap<>();
		torneo.put("Leones", List.of(10, 5, 8, 12));
		torneo.put("Tiburones", List.of(10, -5, 20, 15, -2, 30));
		torneo.put("Halcones", List.of(3, 0, 7));
		torneo.put("Lobos", List.of(4, 6, 1));
		torneo.put("Osos", List.of(10, -5, 20, 15, 2, 30));
		return torneo;
	}

	public static void main(String[] args) {
		Map<String, List<Integer>> torneo = crearDatosPrueba();

		System.out.println("=== Equipos invictos ===");
		Set<String> invictos = AnalisisTorneo.equiposInvictos(torneo);
		invictos.forEach(e -> System.out.println("- " + e));

		System.out.println("\n=== Mejor racha (ejemplo enunciado) ===");
		int rachaEjemplo = AnalisisTorneo.calcularMejorRacha(List.of(10, -5, 20, 15, -2, 30));
		System.out.println("[10, -5, 20, 15, -2, 30] -> " + rachaEjemplo);

		System.out.println("\n=== Mejores rachas por equipo ===");
		AnalisisTorneo.mejoresRachasPorEquipo(torneo)
				.forEach((equipo, racha) -> System.out.println(equipo + " -> " + racha));
	}
}
