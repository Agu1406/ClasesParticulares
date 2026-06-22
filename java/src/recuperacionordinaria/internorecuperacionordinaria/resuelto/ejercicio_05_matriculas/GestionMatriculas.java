package recuperacionordinaria.internorecuperacionordinaria.resuelto.ejercicio_05_matriculas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class GestionMatriculas {

	private GestionMatriculas() {
	}

	/** Apartado A: elimina duplicados conservando el orden de primera aparición. */
	public static List<String> eliminarDuplicados(List<String> lecturas) {
		return new ArrayList<>(new LinkedHashSet<>(lecturas));
	}

	/** Apartado B: 4 dígitos + 3 letras mayúsculas (7 caracteres). */
	public static boolean esMatriculaValida(String matricula) {
		if (matricula == null || matricula.length() != 7) {
			return false;
		}
		for (int i = 0; i < 4; i++) {
			if (!Character.isDigit(matricula.charAt(i))) {
				return false;
			}
		}
		for (int i = 4; i < 7; i++) {
			char c = matricula.charAt(i);
			if (c < 'A' || c > 'Z') {
				return false;
			}
		}
		return true;
	}

	/** Apartado C: agrupa matrículas válidas por su última letra. */
	public static Map<Character, List<String>> agruparPorUltimaLetra(List<String> matriculas) {
		Map<Character, List<String>> mapa = new HashMap<>();
		for (String matricula : matriculas) {
			if (!esMatriculaValida(matricula)) {
				continue;
			}
			char clave = matricula.charAt(6);
			mapa.computeIfAbsent(clave, k -> new ArrayList<>()).add(matricula);
		}
		return mapa;
	}
}
