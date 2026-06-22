package recuperacionordinaria.internorecuperacionordinaria.resuelto.ejercicio_01_conservatorio;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 1 — Recuperación ordinaria: concierto del conservatorio.
 */
public class Main {

	public static void main(String[] args) {
		List<Interprete> escenario = new ArrayList<>();
		escenario.add(new Pianista("Ana Ruiz"));
		escenario.add(new Pianista("Luis Gómez"));
		escenario.add(new Cantante("María López"));
		escenario.add(new Cantante("Pedro Sánchez"));

		prepararConcierto(escenario);

		System.out.println("\n--- Interpretaciones ---");
		for (Interprete interprete : escenario) {
			interprete.interpretar("Final de curso");
		}
	}

	/**
	 * Prepara el concierto usando polimorfismo e interfaces.
	 */
	public static void prepararConcierto(List<Interprete> interpretes) {
		System.out.println("=== Preparando concierto ===");
		for (Interprete interprete : interpretes) {
			if (interprete instanceof Instrumentista instrumentista) {
				instrumentista.afinarInstrumento();
			}
			if (interprete instanceof Vocalista vocalista) {
				vocalista.calentarVoz();
			}
			interprete.saludar();
		}
	}
}
