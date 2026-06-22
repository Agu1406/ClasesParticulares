package recuperacionordinaria.internorecuperacionordinaria.resuelto.ejercicio_04_rachas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Lógica del ejercicio 4 — análisis de rachas e invictos.
 */
public final class AnalisisTorneo {

	private AnalisisTorneo() {
	}

	/**
	 * Equipos invictos: al menos 3 partidas y ninguna puntuación &lt;= 0.
	 */
	public static Set<String> equiposInvictos(Map<String, List<Integer>> torneo) {
		Set<String> invictos = new HashSet<>();
		for (Map.Entry<String, List<Integer>> entrada : torneo.entrySet()) {
			List<Integer> partidas = entrada.getValue();
			if (partidas.size() < 3) {
				continue;
			}
			boolean invicto = true;
			for (int puntos : partidas) {
				if (puntos <= 0) {
					invicto = false;
					break;
				}
			}
			if (invicto) {
				invictos.add(entrada.getKey());
			}
		}
		return invictos;
	}

	/**
	 * Suma de la secuencia consecutiva positiva más larga (si empatan, la de mayor suma).
	 */
	public static int calcularMejorRacha(List<Integer> partidas) {
		int mejorSuma = 0;
		int maxLongitud = 0;
		int indice = 0;

		while (indice < partidas.size()) {
			if (partidas.get(indice) <= 0) {
				indice++;
				continue;
			}
			int fin = indice;
			int suma = 0;
			while (fin < partidas.size() && partidas.get(fin) > 0) {
				suma += partidas.get(fin);
				fin++;
			}
			int longitud = fin - indice;
			if (longitud > maxLongitud) {
				maxLongitud = longitud;
				mejorSuma = suma;
			} else if (longitud == maxLongitud && suma > mejorSuma) {
				mejorSuma = suma;
			}
			indice = fin;
		}
		return mejorSuma;
	}

	public static Map<String, Integer> mejoresRachasPorEquipo(Map<String, List<Integer>> torneo) {
		Map<String, Integer> resultado = new HashMap<>();
		for (Map.Entry<String, List<Integer>> entrada : torneo.entrySet()) {
			resultado.put(entrada.getKey(), calcularMejorRacha(entrada.getValue()));
		}
		return resultado;
	}
}
