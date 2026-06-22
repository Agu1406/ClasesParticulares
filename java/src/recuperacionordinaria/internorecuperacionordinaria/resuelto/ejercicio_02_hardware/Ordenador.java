package recuperacionordinaria.internorecuperacionordinaria.resuelto.ejercicio_02_hardware;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ordenador {

	private final List<Componente> componentes = new ArrayList<>();

	public void agregarComponente(Componente componente) {
		componentes.add(componente);
	}

	public List<Componente> getComponentes() {
		return Collections.unmodifiableList(componentes);
	}

	public int calcularConsumoTotal() {
		int total = 0;
		for (Componente componente : componentes) {
			total += componente.getTdpMaximo();
		}
		return total;
	}

	public void mostrarInforme() {
		System.out.println("=== Informe de configuración ===");
		for (Componente componente : componentes) {
			System.out.printf(
					"Modelo: %s | TDP: %d W | Rendimiento: %.2f%n",
					componente.getModelo(),
					componente.getTdpMaximo(),
					componente.calcularPuntuacionRendimiento());
		}
		System.out.println("Consumo total (TDP): " + calcularConsumoTotal() + " W");
	}
}
